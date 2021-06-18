package in.stack.taskms.service;

import java.util.List;

import in.stack.taskms.model.Task;

public interface TaskService {
	
	public List<Task> getAllTasks();
	public boolean addTask(Task task);
	public boolean deleteTask(String taskId);
	

}
