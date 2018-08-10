package ac.cr.ucenfotec.workflowengine.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

	@Autowired
	private WorkflowService ws;
	
	@RequestMapping("/")
	public List<Workflow> get(){
		return ws.getAll();
	}
	
	@RequestMapping("/{id}")
	public Workflow get(@PathVariable int id){
		Workflow u = new Workflow();
		u.setId(id);
		System.out.println(u.getId());
		return ws.get(u);
	}
	
}
