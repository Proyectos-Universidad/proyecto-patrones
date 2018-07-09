package ac.cr.ucenfotec.workflowengine.models.workflow;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Ticket ticket;
	@ManyToOne
	private User author;
	private LocalDateTime created;
	private String text;
	private int guide;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getGuide() {
		return guide;
	}
	public void setIndex(int index) {
		this.guide = index;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if(!(o instanceof Comment))
			return false;
		
		Comment comment = (Comment) o;
		
		return getId() == comment.getId(); 
	}
	
}
