package ac.cr.ucenfotec.workflowengine.dao;

import ac.cr.ucenfotec.workflowengine.models.workflow.User;

public class UserDAO extends DAO<User, Integer>{

	public UserDAO() {
		super(User.class);
	}

}
