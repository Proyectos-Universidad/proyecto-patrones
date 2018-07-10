package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Workflow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String name;
	private String description;
	private String idPrefix;
	private LocalDateTime created;
	private LocalDateTime lastModified;
	@OneToMany(mappedBy="workflow")
	@OrderColumn(name="guide")
	private List<WorkflowState> states = new ArrayList<WorkflowState>();
	
	
	public int getId() {
		return id;
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
	public List<WorkflowState> getStates() {
		return states;
	}
	public void setStates(List<WorkflowState> states) {
		this.states = states;
	}
	public void addState(WorkflowState state) {
		state.setWorkflow(this);
		this.states.add(state);
	}
	public String getIdPrefix() {
		return idPrefix;
	}
	public void setIdPrefix(String idPrefix) {
		this.idPrefix = idPrefix;
	}
		
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof Workflow))
			return false;
		
		Workflow workflow = (Workflow) o;
		
		return getId() == workflow.getId(); 
	}
	
}
