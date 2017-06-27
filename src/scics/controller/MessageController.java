package scics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scics.pojo.Message;
import scics.pojo.Page;
import scics.service.IMessageService;

@Controller  
@RequestMapping("/message")
public class MessageController {
	@Resource
	private IMessageService messageService;
	
    @RequestMapping("/listMessage")
    public ModelAndView listMessage(String command,String description){
    	ModelAndView mv = new ModelAndView();
    	System.out.println("command="+command+"\ndescription="+description);
    	Message message = new Message();
    	message.setCommand(command);
    	message.setDescription(description);
    	
    	List<Message> list = messageService.queryMessageList(message);
    	
    	mv.setViewName("admin/message/listMessage");
    	mv.addObject("messageList", list);
    	Map<String,String> modelMap = new HashMap<String,String>();
    	modelMap.put("command", command);
    	modelMap.put("description", description);
    	mv.addAllObjects(modelMap);
    	
        return mv;
    }
    
    @RequestMapping("/listMessageByPage")
    public String listMessageByPage(HttpServletRequest req,Model model){
        // 接受页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String currentPage = req.getParameter("currentPage");
		
    	System.out.println("command="+command+"\ndescription="+description);
    	Message message = new Message();
    	message.setCommand(command);
    	message.setDescription(description);
		
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		// 查询消息列表并传给页面
    	List<Message> list = messageService.queryMessageListByPage(message, page);
    	//向页面传值
    	model.addAttribute("messageList", list);
    	model.addAttribute("page", page);
    	Map<String,String> modelMap = new HashMap<String,String>();
    	modelMap.put("command", command);
    	modelMap.put("description", description);
    	model.addAllAttributes(modelMap);
		// 向页面跳转
		return "admin/message/listMessage";
    }
    
    @RequestMapping("/deleteById")
    public String deleteMessage(HttpServletRequest request,Model model){
    	messageService.deleteById(Integer.valueOf(request.getParameter("id")));
    	
        return listMessageByPage(request, model);
    }
    
    @RequestMapping("/deleteByIds")
    public String deleteByIds(HttpServletRequest request,Model model){
    	String[] ids = request.getParameterValues("id");
    	messageService.deleteByIds(ids);
    	
        return listMessageByPage(request, model);
    }
    
    @RequestMapping("/initMessage")
    public String initMessage(HttpServletRequest request,Model model){
    	
        return "home/message/talk";
    }
    
    @RequestMapping(value = "/autoReply", produces = "text/html;charset=UTF-8")
    public @ResponseBody String autoReply(String content){
    	Message message = new Message();
    	message.setCommand(content);
    	
    	return messageService.queryByCommand(message);
    }
    
}
