package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ac.cr.ucenfotec.workflowengine.models.form.Form;

@Entity
@Table(name="Wf_Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String email;
	private String name;
	private String lastName;
	private boolean isAdmin;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<FunctionalArea> areas = new ArrayList<FunctionalArea>();
	
	public User() {
		
	}
	
	public User(int id, String email, String name, String lastName, List<FunctionalArea> areas) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.areas = areas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<FunctionalArea> getAreas() {
		return areas;
	}

	public void setAreas(List<FunctionalArea> areas) {
		this.areas = areas;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof User))
			return false;
		
		User user = (User) o;
		
		return getId() == user.getId() && getEmail() == user.getEmail(); 
	}
	
}
