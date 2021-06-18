package in.stack.taskms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stack.taskms.model.Task;
import in.stack.taskms.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService  {
	@Autowired
	private TaskRepository repo;

	@Override
	public List<Task> getAllTasks() {
		
		return repo.getAllTasks();
	}

	@Override
	public boolean addTask(Task task) {
		
		return repo.addtask(task);
	}

	@Override
	public boolean deleteTask(String taskId) {
		// TODO Auto-generated method stub
		return repo.deleteTask(taskId);
	}

}
