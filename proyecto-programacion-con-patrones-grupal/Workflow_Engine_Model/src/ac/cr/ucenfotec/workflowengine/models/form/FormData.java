package ac.cr.ucenfotec.workflowengine.models.form;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

@Entity
public class FormData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(columnDefinition = "NVARCHAR(4000)")
	private String data;
	private LocalDateTime created;
	@OneToOne
	private User author;
	@OneToOne
	private WorkflowStateRecord worflowStateRecord;
	@OneToOne
	private Form form;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	public WorkflowStateRecord getWorflowStateRecord() {
		return worflowStateRecord;
	}
	public void setWorflowState(WorkflowStateRecord worflowStateRecord) {
		this.worflowStateRecord = worflowStateRecord;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
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
