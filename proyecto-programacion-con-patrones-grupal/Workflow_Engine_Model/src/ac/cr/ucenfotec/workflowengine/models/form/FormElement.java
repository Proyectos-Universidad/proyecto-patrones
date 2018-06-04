package ac.cr.ucenfotec.workflowengine.models.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class FormElement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int guide;
	@ManyToOne
	private Form form;
	private String caption;
	@ManyToOne
	private FormElementType type;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public FormElementType getType() {
		return type;
	}
	public void setType(FormElementType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getGuide() {
		return guide;
	}
	public void setGuide(int guide) {
		this.guide = guide;
	}
	/*TODO
	Posiblemente una collecion de ValidationRules? 
	Para poder agregarle validacion definida por el usuario a este campo
	*/
	
	
}
