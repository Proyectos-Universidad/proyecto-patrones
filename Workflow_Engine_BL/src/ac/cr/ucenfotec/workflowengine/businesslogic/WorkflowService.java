package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.time.LocalDateTime;
import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.validation.WorkflowValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowService extends Service<Workflow,WorkflowDAO>{
	
	private WorkflowStateService wfs;
	
	public WorkflowService() {
		super(WorkflowDAO::new);
		wfs = new WorkflowStateService();
	}
	
	@Override
	public void create(WFErrors error,Workflow workflow) {
		WorkflowValidator.validate(error,workflow);
		
		if(error.hasErrors()) {
			return;
		}
		
		LocalDateTime created = LocalDateTime.now();
		workflow.setCreated(created);
		workflow.setLastModified(created);
		dao.persist(workflow);
	}
	
	@Override
	public Workflow get(Workflow workflow) {
		dao.openSession();
		workflow = dao.findById(workflow.getId());
		dao.initialize(workflow.getStates());
		dao.closeSession();
		return workflow;
	}
	
	@Override
	public List<Workflow> getAll() {
		dao.openSession();
		List<Workflow> all = dao.findAll();
		for(Workflow w : all) {
			dao.initialize(w.getStates());
		}
		dao.closeSession();
		return all;
	}
	
	@Override
	public void update(WFErrors error,Workflow modified) {
		
		dao.openSession();
		Workflow original = dao.findById(modified.getId());
		original.getStates().size();
		
		original.setName(modified.getName());
		original.setDescription(modified.getDescription());
		original.setStates(modified.getStates());
		original.setLastModified(LocalDateTime.now());
		original.setIdPrefix(modified.getIdPrefix());

		wfs.createOrUpdate(error,original.getStates());
		
		dao.persist(original);
		dao.closeSession();
	}

	@Override
	public void delete(WFErrors error, Workflow entity) {
		throw new UnsupportedOperationException();
	}
}
