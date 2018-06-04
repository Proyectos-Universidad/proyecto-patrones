package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDateTime created;
	@ManyToOne
	private User author;
	@OneToMany(mappedBy="ticket")
	@OrderColumn(name="guide")
	private List<AssigneeRecord> assignees;
	@OneToOne
	private Workflow workflow;
	@OneToMany(mappedBy="ticket")
	@OrderColumn(name="guide")
	private List<WorkflowStateRecord> progress;
	@OneToMany(mappedBy="ticket")
	@OrderColumn(name="guide")
	private List<Comment> comments;
	private String summary;
	private String description;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List<AssigneeRecord> getAssignees() {
		return assignees;
	}
	public void setAssignees(List<AssigneeRecord> assignees) {
		this.assignees = assignees;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public List<WorkflowStateRecord> getProgress() {
		return progress;
	}
	public void setProgress(List<WorkflowStateRecord> progress) {
		this.progress = progress;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

	

}
