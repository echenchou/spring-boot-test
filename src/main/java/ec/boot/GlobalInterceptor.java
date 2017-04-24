package ec.boot;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ec.util.HttpUtil;



public class GlobalInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);
	
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
	@Override
	public boolean preHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse,
			Object paramObject) throws Exception {
		// TODO Auto-generated method stub
		startTimeThreadLocal.set(System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse,
			Object paramObject, ModelAndView paramModelAndView) throws Exception {
		// TODO Auto-generated method stub
		if("/error".equals(paramHttpServletRequest.getRequestURI())){
			logger.error("错误信息："+String.valueOf(paramModelAndView));
		}
		if (null == paramModelAndView) {
			return;
		}
		String basePath = HttpUtil.getBasePath(paramHttpServletRequest);
		paramModelAndView.addObject("BASE_PATH", basePath);
	}

	@Override
	public void afterCompletion(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException)
					throws Exception {
		// TODO Auto-generated method stub
		long startTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
		long endTime = System.currentTimeMillis(); 	//结束时间  
		if(endTime-startTime>500)
			logger.info("响应计时: {} 耗时：{}毫秒 ",paramHttpServletRequest.getRequestURI(), endTime-startTime);
	}

}
