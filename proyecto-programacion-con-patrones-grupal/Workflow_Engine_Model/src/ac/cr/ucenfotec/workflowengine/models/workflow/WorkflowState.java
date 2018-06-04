package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class WorkflowState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String nextStateMessage;
	private String previousStateMessage;
	private LocalDateTime created;
	private LocalDateTime lastModified;
	private int guide;
	@ManyToOne
	private Workflow workflow;
	@OneToOne
	private FunctionalArea area;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuide() {
		return guide;
	}
	public void setGuide(int index) {
		this.guide = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNextStateMessage() {
		return nextStateMessage;
	}
	public void setNextStateMessage(String nextStateMessage) {
		this.nextStateMessage = nextStateMessage;
	}
	public String getPreviousStateMessage() {
		return previousStateMessage;
	}
	public void setPreviousStateMessage(String previousStateMessage) {
		this.previousStateMessage = previousStateMessage;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getLastModified() {
		return lastModified;
	}
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public FunctionalArea getArea() {
		return area;
	}
	public void setArea(FunctionalArea area) {
		this.area = area;
	}
	
	
}
