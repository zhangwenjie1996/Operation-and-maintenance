package ig.zeus;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import ig.archer.application.IApplication;
import ig.archer.domain.repository.IRepository;
import ig.archer.domain.service.IService;
import ig.archer.infrastructure.io.classprocess.ClassScanner;
import ig.archer.infrastructure.io.classprocess.IClassFilter;

/**
 * @author reize
 * @version 0.0.1
 * @since 2016/11/16 15:14
 */
public class DomainRegister implements ApplicationContextAware {
	private DefaultListableBeanFactory contextBeanFactory; // Spring上下文Bean工厂，负责Bean注册
	private ClassScanner scanner; // 类扫描器
	private String packageName; // 使用逗号分隔的扫描路径，如果为空则扫描全部路径

	/**
	 * 构造方法，需要扫描路径字段。
	 *
	 * @param packageName
	 */
	public DomainRegister(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * 上下文注入方法
	 *
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 将applicationContext转换为ConfigurableApplicationContext
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

		// 获取bean工厂并转换为DefaultListableBeanFactory
		contextBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

		this.scan();// 开始扫面注册
		this.packageName = "";
	}

	private void scan() {
		this.scanner = new ClassScanner();
		// 设置Filter
		IClassFilter repositoryFilter = new IClassFilter() {
			public boolean accept(Class<?> clazz) {
				if (IRepository.class.isAssignableFrom(clazz))
					return true;
				return false;
			}
		};

		IClassFilter serviceFilter = new IClassFilter() {
			public boolean accept(Class<?> clazz) {
				if (IService.class.isAssignableFrom(clazz))
					return true;
				return false;
			}
		};

		IClassFilter applicationFilter = new IClassFilter() {
			public boolean accept(Class<?> clazz) {
				if (IApplication.class.isAssignableFrom(clazz))
					return true;
				return false;
			}
		};
		this.scanner.setClassFilter(repositoryFilter, serviceFilter, applicationFilter);

		Collection<Class<?>> scan = new LinkedList<Class<?>>();
		if (this.packageName == null || this.packageName == "") {
			scan.addAll(this.scanner.scan());
		} else {
			String[] paths = this.packageName.split(",");
			for (String path : paths) {
				this.scanner.setPackageName(path);
				scan.addAll(this.scanner.scan());
			}
		}
		for (Class<?> cls : scan) {
			this.register(cls);
		}
	}

	/**
	 * 注册当前class到Spring上下文中。
	 *
	 * @param cls
	 */
	private void register(Class<?> cls) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(cls);
		String key = cls.getSimpleName();
		String firstLower = key.substring(0, 1).toLowerCase();
		key = firstLower + key.substring(1, key.length());

		contextBeanFactory.registerBeanDefinition(key, beanDefinitionBuilder.getBeanDefinition());
	}
}
