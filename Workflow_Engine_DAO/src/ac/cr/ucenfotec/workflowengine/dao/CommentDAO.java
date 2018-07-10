package ac.cr.ucenfotec.workflowengine.dao;

import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;

public class CommentDAO extends DAO<Comment, Integer>{

	public CommentDAO() {
		super(Comment.class);
	}

}