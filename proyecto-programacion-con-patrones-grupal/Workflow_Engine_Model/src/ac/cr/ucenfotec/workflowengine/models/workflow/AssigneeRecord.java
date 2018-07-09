package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ac.cr.ucenfotec.workflowengine.models.form.Form;
@Entity
public class AssigneeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int guide;
	@ManyToOne
	private User user;
	private LocalDateTime assigned;
	private LocalDateTime unassigned;
	@ManyToOne
	private Ticket ticket;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getAssigned() {
		return assigned;
	}
	public void setAssigned(LocalDateTime assigned) {
		this.assigned = assigned;
	}
	public LocalDateTime getUnassigned() {
		return unassigned;
	}
	public void setUnassigned(LocalDateTime unassigned) {
		this.unassigned = unassigned;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getGuide() {
		return guide;
	}
	public void setGuide(int index) {
		this.guide = index;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof AssigneeRecord))
			return false;
		
		AssigneeRecord assigneeRecord = (AssigneeRecord) o;
		
		return getId() == assigneeRecord.getId(); 
	}
}
