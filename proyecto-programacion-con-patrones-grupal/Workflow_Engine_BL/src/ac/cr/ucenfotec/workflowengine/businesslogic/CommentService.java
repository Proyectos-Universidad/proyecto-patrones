package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.time.LocalDateTime;

import ac.cr.ucenfotec.workflowengine.dao.CommentDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.validation.CommentValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class CommentService extends Service<Comment,CommentDAO>{

	public CommentService() {
		super(CommentDAO::new);
	}
	
	public void create(WFErrors errors,Comment comment) {
		CommentValidator.validate(errors, comment);
		
		if(errors.hasErrors()) {
			return;
		}
		
		LocalDateTime created = LocalDateTime.now();
		//Falta agregar el author
		comment.setCreated(created);
		dao.persist(comment);
	}

	@Override
	public void update(WFErrors errors, Comment entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Comment get(Comment entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(WFErrors errors, Comment entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
