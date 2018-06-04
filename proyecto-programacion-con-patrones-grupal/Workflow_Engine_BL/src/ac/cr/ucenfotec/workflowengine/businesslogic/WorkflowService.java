package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.time.LocalDateTime;
import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;

public class WorkflowService {
	
	private WorkflowDAO dao;
	private WorkflowStateService wfs;
	
	public WorkflowService() {
		dao = new WorkflowDAO();
		wfs = new WorkflowStateService();
	}
	
	public void create(Workflow workflow) {
		//Logica de validacion del lado del servidor.
		LocalDateTime created = LocalDateTime.now();
		workflow.setCreated(created);
		workflow.setLastModified(created);
		dao.persist(workflow);
	}
	
	public List<Workflow> getAll() {
		dao.openSession();
		List<Workflow> wfs = dao.findAll();
		dao.closeSession();
		return wfs;
	}
	
	public Workflow get(Workflow workflow) {
		dao.openSession();
		workflow = dao.findById(workflow.getId());
		dao.initialize(workflow.getStates());
		dao.closeSession();
		return workflow;
	}
	
	public void update(Workflow modified) {
		
		dao.openSession();
		Workflow original = dao.findById(modified.getId());
		original.getStates().size();
		
		original.setName(modified.getName());
		original.setDescription(modified.getDescription());
		original.setStates(modified.getStates());
		original.setLastModified(LocalDateTime.now());

		wfs.createOrUpdate(original.getStates());
		
		dao.persist(original);
		dao.closeSession();
	}
}
