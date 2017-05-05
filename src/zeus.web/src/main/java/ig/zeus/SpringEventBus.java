package ig.zeus;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import ig.archer.infrastructure.bus.IBus;
import ig.archer.infrastructure.bus.IMessage;
import ig.archer.infrastructure.bus.ISubscriber;
import ig.archer.infrastructure.bus.ISubscriberFactory;
import ig.archer.infrastructure.bus.event.SingletonFactory;
import ig.archer.infrastructure.bus.event.SubscriberFactory;

/**
 * @author reize
 * @version 0.0.1
 * @since 2016年10月9日 下午2:43:49
 */
public class SpringEventBus implements IBus, ApplicationContextAware {

    /**
     * 上下文对象
     */
    ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 获取Bean工厂。
     *
     * @return Bean工厂。
     */
    public DefaultListableBeanFactory getBeanFactory() {
        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;

        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableApplicationContext
                .getBeanFactory();
        return beanFactory;
    }

    public SpringEventBus() {
    }

    /**
     * 线程池，多线程执行引擎。
     */
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public <TMessage extends IMessage, TSubscriber extends ISubscriber<?>> void register(Class<TMessage> messageType,
            Class<TSubscriber> subscriberType) {
        this.register(messageType, new SubscriberFactory<TSubscriber>(subscriberType));
    }

    public <TMessage extends IMessage> void register(Class<TMessage> messageType, ISubscriber<?> subscriber) {
        this.register(messageType, new SingletonFactory(subscriber));

    }

    public <TMessage extends IMessage> void register(Class<TMessage> messageType, ISubscriberFactory factory) {
        List<ISubscriberFactory> subscriberFactories = getSubscriberFactories(messageType).getFactories();
        subscriberFactories.add(factory);// 添加当前订阅对象。
    }

    public <TMessage extends IMessage, TSubscriber extends ISubscriber<?>> void unregister(Class<TMessage> messageType,
            Class<TSubscriber> subscriberType) {
        SubscriberFactoryDefinition subscriberFactories = this.getSubscriberFactories(messageType);

        ListIterator<ISubscriberFactory> listIterator = subscriberFactories.getFactories().listIterator();
        while (listIterator.hasNext()) {
            ISubscriberFactory iSubscriberFactory = listIterator.next();
            if (iSubscriberFactory instanceof SubscriberFactory && subscriberType == iSubscriberFactory.getType()) {
                iSubscriberFactory.dispose();
                subscriberFactories.getFactories().remove(iSubscriberFactory);
            }
        }
    }

    public <TMessage extends IMessage> void unregister(Class<TMessage> messageType, ISubscriber<?> subscriber) {
        SubscriberFactoryDefinition subscriberFactories = this.getSubscriberFactories(messageType);

        ListIterator<ISubscriberFactory> listIterator = subscriberFactories.getFactories().listIterator();

        while (listIterator.hasNext()) {
            ISubscriberFactory iSubscriberFactory = listIterator.next();
            if (iSubscriberFactory instanceof SingletonFactory
                    && subscriber.getClass() == iSubscriberFactory.getType()) {
                iSubscriberFactory.dispose();
                subscriberFactories.getFactories().remove(iSubscriberFactory);
            }
        }
    }

    public <TMessage extends IMessage> void unregister(Class<TMessage> messageType, ISubscriberFactory factory) {
        SubscriberFactoryDefinition subscriberFactories = this.getSubscriberFactories(messageType);

        ListIterator<ISubscriberFactory> listIterator = subscriberFactories.getFactories().listIterator();

        while (listIterator.hasNext()) {
            ISubscriberFactory iSubscriberFactory = listIterator.next();
            if (iSubscriberFactory.getClass() == factory.getClass()) {
                iSubscriberFactory.dispose();
                subscriberFactories.getFactories().remove(iSubscriberFactory);
            }
        }
    }

    public <TMessage extends IMessage> void unregisterAll(Class<TMessage> messageType) {
        this.getBeanFactory().removeBeanDefinition(this.getKey(messageType));
    }

    public void publish(IMessage message) throws Exception {
        this.publish(message.getClass(), null, message);
    }

    public <TMessage extends IMessage> void publish(Class<TMessage> messageType, IMessage message) throws Exception {
        this.publish(messageType, null, message);
    }

    public void publish(Object eventSource, IMessage message) throws Exception {
        this.publish(message.getClass(), eventSource, message);
    }

    public synchronized <TMessage extends IMessage> void publish(Class<TMessage> messageType, Object eventSource,
            IMessage message) throws Exception {
        message.setMessageSource(eventSource);

        ISubscriber<?> subscriber;

        SubscriberFactoryDefinition subscriberFactories = this.getSubscriberFactories(messageType);
        for (ISubscriberFactory item : subscriberFactories.getFactories()) {
            subscriber = item.create();
            if (subscriber == null)
                throw new Exception(String.format("事件%s注册的订阅者未继承于ISubscriber", messageType.getName()));

            try {
                if (subscriber instanceof ISubscriber<?>) {
                    @SuppressWarnings("unchecked")
                    ISubscriber<IMessage> real = (ISubscriber<IMessage>) subscriber;
                    real.handle(message);
                } else {
                    throw new Exception(String.format("事件%s注册的订阅者未继承于ISubscriber", messageType.getName()));
                }
            } catch (Exception ex) {
                throw new Exception(String.format("消费事件%s出错，错误信息：{1}", messageType.getName(), ex.getMessage()));
            }
        }
    }

    public void publishAsync(IMessage message) throws Exception {
        this.publishAsync(message.getClass(), message);
    }

    public <TMessage extends IMessage> void publishAsync(Class<TMessage> messageType, IMessage message)
            throws Exception {
        this.publishAsync(messageType, null, message);
    }

    public void publishAsync(Object eventSource, IMessage message) throws Exception {
        this.publishAsync(message.getClass(), eventSource, message);
    }

    public synchronized <TMessage extends IMessage> void publishAsync(Class<TMessage> messageType, Object eventSource,
            IMessage message) throws Exception {
        PublishTask<TMessage> task = new PublishTask<TMessage>(messageType, eventSource, message);
        Future<String> submit = cachedThreadPool.submit(task);
        try {
            String error = submit.get();
            if (error != null)
                throw new Exception(error);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

	/*
     * Private Methods
	 */

    /**
     * 获取类对应的Key.
     *
     * @param cls
     * @return
     */
    private <TMessage extends IMessage> String getKey(Class<TMessage> cls) {
        return String.format("@%s$%s", this.getClass().getSimpleName(), cls.getSimpleName());
    }

    /**
     * 获取订阅者工厂列表，没有则创建。
     *
     * @param messageType 消息類型。
     * @return 该消息的订阅者。
     */
    private <TMessage extends IMessage> SubscriberFactoryDefinition getSubscriberFactories(Class<TMessage> messageType) {
        String key = getKey(messageType);
        if (!context.containsBeanDefinition(key)) {
            DefaultListableBeanFactory beanFactory = getBeanFactory();
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SubscriberFactoryDefinition.class);
            beanDefinitionBuilder.addPropertyValue("name", messageType.getSimpleName());
            beanDefinitionBuilder.addPropertyValue("factories", new LinkedList<ISubscriberFactory>());
            beanDefinitionBuilder.setScope("singleton");
            beanFactory.registerBeanDefinition(key, beanDefinitionBuilder.getBeanDefinition());
        }
        SubscriberFactoryDefinition obj = (SubscriberFactoryDefinition) context.getBean(key);
        return obj;
    }

    /**
     * 订阅东厂的定义
     * 包含消息的名称和订阅工厂列表。
     */
    @SuppressWarnings("unused")
    private class SubscriberFactoryDefinition {
        private String name;
        private List<ISubscriberFactory> factories;

        public String getName() {
            return name;
        }

		public void setName(String name) {
            this.name = name;
        }

        public List<ISubscriberFactory> getFactories() {
            return factories;
        }

        public void setFactories(List<ISubscriberFactory> factories) {
            this.factories = factories;
        }
    }

    /*
     * 发布任务类型，负责异步发布事件实现。<br/>
     * 实现了返回值异步方法。
     */
    private class PublishTask<TMessage extends IMessage> implements Callable<String> {

        Class<TMessage> messageType;//消息类型
        Object eventSource;//消息源
        IMessage message;//消息对象

        public PublishTask(Class<TMessage> messageType, Object eventSource, IMessage message) {
            this.messageType = messageType;
            this.eventSource = eventSource;
            this.message = message;
        }

        /**
         * 实际调用方法。
         * @return
         * @throws Exception
         */
        public String call() throws Exception {
            List<ISubscriberFactory> subscriberFactories = getSubscriberFactories(messageType).getFactories();
            for (ISubscriberFactory item : subscriberFactories) {
                message.setMessageSource(eventSource);
                ISubscriber<?> subscriber = item.create();
                if (subscriber == null)
                    return String.format("事件%s注册的订阅者未继承于ISubscriber", messageType.getName());

                try {
                    if (subscriber instanceof ISubscriber<?>) {
                        @SuppressWarnings("unchecked")
                        ISubscriber<IMessage> real = (ISubscriber<IMessage>) subscriber;
                        real.handle(message);
                    } else {
                        return String.format("事件%s注册的订阅者未继承于ISubscriber", messageType.getName());
                    }
                } catch (Exception ex) {
                    return String.format("消费事件%s出错，错误信息：%s", messageType.getName(), ex.getMessage());
                }
            }

            return null;
        }

    }
}
