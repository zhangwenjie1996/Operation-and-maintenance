package ig.zeus.intercept;

import org.aspectj.lang.ProceedingJoinPoint;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.Logger;

/**
 * * @author wxf:
 * 
 * @date 创建时间：2016年10月28日 下午12:27:47
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class AopException {

	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

	/**
	 * @param processJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object doAround(ProceedingJoinPoint processJoinPoint) throws Throwable {
		// 调用核心逻辑
		Object retVal = null;
		try {
			retVal = processJoinPoint.proceed();
		} catch (Exception e) {
			retVal = new StateData<Object>(State.Failure, e.getMessage());
			String className = processJoinPoint.getSignature().getClass().getName();
			String methodName = processJoinPoint.getSignature().getName();
			logger.error(String.format("执行类[%s]下方法[%s]出现错误.", className, methodName), e);
		}
		return retVal;
	}

}
