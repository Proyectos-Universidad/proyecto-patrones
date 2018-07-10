package ac.cr.ucenfotec.workflowengine.models.form;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;

@Entity
public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private WorkflowState state;
	private String name;
	private String description;
	@OneToMany(mappedBy="form")
	private List<FormElement> elements;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WorkflowState getState() {
		return state;
	}
	public void setState(WorkflowState state) {
		this.state = state;
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
	public List<FormElement> getElements() {
		return elements;
	}
	public void setElements(List<FormElement> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof Form))
			return false;
		
		Form form = (Form) o;
		
		return getId() == form.getId(); 
	}
}
