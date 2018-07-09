package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class WorkflowStateRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDateTime started;
	private LocalDateTime finished;
	private int guide;
	@OneToOne
	private Workflow workflow;
	@OneToOne
	private WorkflowState workflowState;
	@OneToOne
	private WorkflowStateRecord next;
	@OneToOne
	private WorkflowStateRecord prev;
	@OneToOne
	private Ticket ticket;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuide() {
		return guide;
	}
	public void setGuide(int guide) {
		this.guide = guide;
	}
	public LocalDateTime getStarted() {
		return started;
	}
	public void setStarted(LocalDateTime started) {
		this.started = started;
	}
	public LocalDateTime getFinished() {
		return finished;
	}
	public void setFinished(LocalDateTime finished) {
		this.finished = finished;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public WorkflowState getWorkflowState() {
		return workflowState;
	}
	public void setWorkflowState(WorkflowState workflowState) {
		this.workflowState = workflowState;
	}
	public WorkflowStateRecord getNext() {
		return next;
	}
	public void setNext(WorkflowStateRecord next) {
		this.next = next;
	}
	public WorkflowStateRecord getPrev() {
		return prev;
	}
	public void setPrev(WorkflowStateRecord prev) {
		this.prev = prev;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof WorkflowStateRecord))
			return false;
		
		WorkflowStateRecord workflowStateRecord = (WorkflowStateRecord) o;
		
		return getId() == workflowStateRecord.getId(); 
	}
}
