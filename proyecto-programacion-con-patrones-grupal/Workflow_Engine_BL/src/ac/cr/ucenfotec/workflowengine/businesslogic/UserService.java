package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.UserDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;

public class UserService {
	private UserDAO dao;
	
	public UserService() {
		dao = new UserDAO();
	}
	
	public void create(User user) {
		dao.persist(user);
	}
	
	public List<User> getAll(){
		dao.openSession();
		List<User> users = dao.findAll();
		dao.closeSession();
		return users;
	}
}
