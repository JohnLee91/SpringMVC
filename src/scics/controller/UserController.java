package scics.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scics.pojo.User;
import scics.service.IUserService;
import scics.test.SystemControllerLog;
import scics.test.SystemServiceLog;

@Controller  
@RequestMapping("/user")
public class UserController {  
//    @Resource(name = "userServiceImpl")
	@Resource
    private IUserService userService;
//    @Resource(name = "hahaha")
	@Resource
    private IUserService hahaha;
      
    @RequestMapping("/showUser/old")  
    public String toIndex(HttpServletRequest request,Model model){  
    	System.out.println("id="+request.getParameter("id"));
    	return null;
//        int userId = Integer.parseInt(request.getParameter("id"));  
//        User user = this.userService.getUserById(userId);  
//        model.addAttribute("user", user);  
//        return "admin/user/showUser";  
    }
    
    @SystemControllerLog(moduleName="人员管理",option="添加用户")
    @RequestMapping("/showUser/{userId}")  
    public String toIndex(@PathVariable("userId")Integer userId,Model model){    
        User user = this.hahaha.getUserById(userId);  
        System.out.println(this.hahaha.getClass().getName());
        model.addAttribute("user", user);
        System.out.println(user.toString());
        return "admin/user/showUser";  
    }
    
    @SystemServiceLog(moduleName="人员管理S",option="添加用户S")
    @RequestMapping("/showUser")
    public String toIndex1(@PathParam("userId")Integer userId,Model model){    
        User user = this.userService.getUserById(userId);  
        System.out.println(this.userService.getClass().getName());
        model.addAttribute("user", user);
        System.out.println(user.toString());
        return "admin/user/showUser";  
    }
    
    @RequestMapping("/addUser")
    public String adduser(HttpServletRequest request,Model model){
    	User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        int userId = this.userService.addUser(user);
        System.out.println(userId);
        return null;
//        return "admin/user/showUser";  
    }
    
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request,Model model){
        List<User> list = this.userService.selectAllUser();
        for (User user : list) {
			System.out.println(user.getId()+":"+user.getUserName());
		}
        return "admin/user/userList";
    }
    
    @SystemServiceLog(moduleName="人员管理Service",option="添加用户Service")
    @RequestMapping("/getAge")
    public String getAge(String age){
        System.out.println(age);
        return "admin/user/userList";  
    }
    
    /**
     * <mvc:annotation-driven/> ==> 在 spring-mvc.xml中配置：数据绑定支持，@NumberFormatannotation支持，@DateTimeFormat支持，@Valid支持，读写XML的支持（JAXB），读写JSON的支持（Jackson）。
     * @param 
     * {
		  "userName":"lee",
		  "password":"123456",
		  "age":2
	   }
     * @return
     */
    @RequestMapping("/json")
    public String json(@RequestBody User user){
    	System.out.println(user.toString());
    	return "admin/user/userList"; 
    }
    
    /** 
     * 查询个人信息 
     *  
     * @param id 
     * @return 
     */  
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)  
    public @ResponseBody User porfile(@PathVariable int userId) {  
        return this.userService.getUserById(userId);
    }
    
    /** 
     * 查询个人信息 
     *  
     * @param id 
     * @return 
     */  
    @RequestMapping(value = "/porfileAjax", method = RequestMethod.POST)  
    public @ResponseBody User porfileAjax(@RequestBody User user) {  
        return this.userService.getUserById(user.getId());
    }
    

    @RequestMapping(value = "/viewAll", method = RequestMethod.POST)  
    public ModelAndView viewAll(String userName,String password) {  
    	ModelAndView mv = new ModelAndView();    	
    	System.out.println("userName="+userName+"\npassword="+password);
    	mv.setViewName("/user/showUser");
    	mv.addObject("msg", "从viewAll方法传回视图的数据");
        return mv;
    }
} 