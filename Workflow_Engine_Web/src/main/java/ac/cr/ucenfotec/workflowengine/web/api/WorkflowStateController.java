package ac.cr.ucenfotec.workflowengine.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowStateService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;

@RestController
@RequestMapping("/api/workflow-state")
public class WorkflowStateController {
	
	@Autowired
	private WorkflowService ws;
	@Autowired
	private WorkflowStateService wss;
	
	@RequestMapping("/")
	public List<WorkflowState> get(){
		return wss.getAll();
	}
	
	@RequestMapping("/get-workflow-states/{id}")
	public List<WorkflowState> get(@PathVariable int id){
		Workflow u = new Workflow();
		u.setId(id);
		return ws.get(u).getStates();
	}
	
}
