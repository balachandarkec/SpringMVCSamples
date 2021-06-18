package in.stack.taskms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.stack.taskms.model.Task;
import in.stack.taskms.service.TaskService;

@Controller
public class TaskController {
    @Autowired
	private TaskService taskService;
    
    @RequestMapping("/")
    public String homepage(Model model) {
    	model.addAttribute("taskList",taskService.getAllTasks());  	
    	return "home-page";
    }
    
    
    //@PostMapping("/addTask")
    @RequestMapping(value="/addTask",method=RequestMethod.POST)
    public String addNewtask(@RequestParam("taskId") String taskid,
    		                 @RequestParam("taskName") String taskname, 
    	                     @RequestParam("status") String status) {
    	String response="";
    	Task task=new Task(taskid,taskname,status);
    	if(taskService.addTask(task)) {
    		response="redirect:/";
    	}else {
    		return "home-page";
    	}
    	
    	
    	
    	
    	return response;
    }
    
    
    
    @RequestMapping(value="/delete/{taskid}",method=RequestMethod.GET)
    public String deleteTask(@PathVariable("taskid") String taskid) {
    	if(taskService.deleteTask(taskid)) {
    		return "redirect:/";
    	}else {
    		return "home-page";
    	}
    	
    }
    
	
}
