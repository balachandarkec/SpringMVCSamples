package in.stack.taskms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Task {
    @Id
    @Column(length=100,name="taskid")
	private String taskid;
    @Column(length=100,name="taskname")
	private String taskName;
    @Column(length=100,name="status")
	private String status;
    
	public Task() {
		super();
	}

	public Task(String taskid, String taskName, String status) {
		super();
		this.taskid = taskid;
		this.taskName = taskName;
		this.status = status;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskName=" + taskName + ", status=" + status + "]";
	}
    	
	
	
}
