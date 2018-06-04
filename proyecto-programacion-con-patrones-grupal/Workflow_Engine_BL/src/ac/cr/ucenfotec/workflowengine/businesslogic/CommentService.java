package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.time.LocalDateTime;

import ac.cr.ucenfotec.workflowengine.dao.CommentDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;

public class CommentService {

	private CommentDAO dao;
	
	public CommentService() {
		dao = new CommentDAO();
	}
	
	public void create(Comment comment) {
		//Logica de validacion del lado del servidor.
		LocalDateTime created = LocalDateTime.now();
		//Falta agregar el author
		comment.setCreated(created);
		dao.persist(comment);
	}
}
