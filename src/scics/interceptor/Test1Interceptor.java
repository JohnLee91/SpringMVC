package scics.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Test1Interceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}

	//可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle");
		arg3.addObject("msg", "传回拦截器修改之后的消息");
//		arg3.setViewName("/user/error");
	}

	//返回false，请求将被终止
	//返回true，请求将继续运行
	//Object arg2表示的是别拦截的请求目标对象
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
//		arg0.setCharacterEncoding("utf-8");这样也可以解决乱码问题
		//验证用户权限
/*		if(arg0.getSession().getAttribute("userName") == null){
			//如果用户没有登录，就终止请求，并发送到登录页面
			arg0.getRequestDispatcher("/user/login.jsp").forward(arg0, arg1);
			return false;
		}*/
		
		System.out.println("preHandle");
		
		return true;
	}

}
