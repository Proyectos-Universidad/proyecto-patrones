package ac.cr.ucenfotec.workflowengine.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping("/")
	public List<User> get(){
		return us.getAll();
	}
	
	@RequestMapping("/{id}")
	public User get(@PathVariable int id){
		User u = new User();
		u.setId(id);
		System.out.println(u.getId());
		return us.get(u);
	}
}
