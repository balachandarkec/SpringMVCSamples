package in.stack.taskms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.stack.taskms.model.Task;



@Repository
@Transactional
public class TaskRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession(); 
	}
	
	
	
	public boolean addtask(Task task) {
		boolean status=false;
		
		if (getCurrentSession().save(task)!=null) {
			status=true;
		}
		
		return status;
	}
	
	
	public List<Task> getAllTasks(){
		
	Criteria cr=	getCurrentSession().createCriteria(Task.class);
	List<Task> allTasks=cr.list();
	
	return allTasks;
		
	}
	
	
	public boolean deleteTask(String taskId) {
		
	Task targetTask=getCurrentSession().find(Task.class, taskId);
	try {
	getCurrentSession().remove(targetTask);
	   return true;
	}catch(Exception e) {
		return false;
	}
	
		
		
	
	}
	
	

}
