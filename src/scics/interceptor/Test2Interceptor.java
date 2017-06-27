package scics.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class Test2Interceptor implements WebRequestInterceptor{

	@Override
	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		System.out.println("afterCompletion2");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("postHandle2");
		
	}

	//这个preHandle没有返回值，无法终止请求
	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("preHandle2");
		
	}

}
