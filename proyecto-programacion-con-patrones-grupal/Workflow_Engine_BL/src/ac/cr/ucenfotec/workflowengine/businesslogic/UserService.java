package ac.cr.ucenfotec.workflowengine.businesslogic;

import ac.cr.ucenfotec.workflowengine.dao.UserDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.UserValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class UserService extends Service<User,UserDAO>{
	
	public UserService() {
		super(UserDAO::new);
	}
	
	public void create(WFErrors errors,User user) {
		UserValidator.validate(errors, user);
		
		if(errors.hasErrors()) {
			return;
		}
		
		dao.persist(user);
	}

	@Override
	public void update(WFErrors errors, User entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	@Override
	public User get(User entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	@Override
	public void delete(WFErrors errors, User entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}
	
}
