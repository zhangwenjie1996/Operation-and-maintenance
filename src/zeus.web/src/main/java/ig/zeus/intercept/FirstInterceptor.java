package ig.zeus.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ig.archer.infrastructure.log.ILogger;

/**
 * 用户未登录前，访问任何url都跳转到login页面，登录成功后跳转到先前的url
 * 
 * @author Administrator
 * 
 */
public class FirstInterceptor implements HandlerInterceptor {
	@Autowired
	private ILogger logger;
	public static final String LAST_PAGE = "com.matrix.intercept";

	/**
	 * 进行资源的申请，配置文件的加载；做预处理用的
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("------执行顺序：1、preHandle------");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		logger.info("request:" + request);
		logger.info("contextPath::" + contextPath);
		logger.info("url:" + url);
//		StateMessage msg = new StateMessage(State.Failure, "无权访问该功能! ");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().print(msg.toString());

		return true;
	}

	/**
	 * 业务处理器请求完成之后，生成的视图之前执行的动作 可以在modelAndView中加入数据，比如当前的时间
	 * 
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * afterCompletion相当于try...cath里面的finally;用来释放资源的
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("-------执行顺序：3、afterCompletion------");

	}
}
