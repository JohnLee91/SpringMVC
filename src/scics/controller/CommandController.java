package scics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scics.pojo.Command;
import scics.service.ICommandService;

@Controller  
@RequestMapping("/command")
public class CommandController {
	@Resource
	private ICommandService commandService;
	
    @RequestMapping("/listCommand")
    public ModelAndView listCommand(String command,String description){
    	ModelAndView mv = new ModelAndView();
    	System.out.println("command="+command+"\ndescription="+description);
    	Command myCommand = new Command();
    	myCommand.setCommand(command);
    	myCommand.setDescription(description);
    	
    	List<Command> list = commandService.queryCommandList(myCommand);
    	
    	mv.setViewName("admin/message/listMessage");
    	mv.addObject("commandList", list);
    	Map<String,String> modelMap = new HashMap<String,String>();
    	modelMap.put("command", command);
    	modelMap.put("description", description);
    	mv.addAllObjects(modelMap);
    	
        return mv;
    }
    
    @RequestMapping("/initCommand")
    public String initCommand(HttpServletRequest request,Model model){
    	
        return "home/message/talk";
    }
    
    @RequestMapping(value = "/autoReply", produces = "text/html;charset=UTF-8")
    public @ResponseBody String autoReply(String content){
    	Command command = new Command();
    	command.setCommand(content);
    	
    	return commandService.queryByCommand(command);
    }
    
}
