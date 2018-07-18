package ac.cr.ucenfotec.workflowengine.businesslogic;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowStateDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.validation.WorkflowStateValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

import java.time.LocalDateTime;
import java.util.List;

public class WorkflowStateService extends Service<WorkflowState,WorkflowStateDAO>{
	
	public WorkflowStateService() {
		super(WorkflowStateDAO::new);
	}
	
	public void createOrUpdate(WFErrors errors,List<WorkflowState> states) {
		
		for(WorkflowState s : states) {
			//Todo, prodia ser mejor.
			WorkflowStateValidator.validate(errors, s);
		}
		
		LocalDateTime now = LocalDateTime.now();
		
		dao.openSession();
		dao.beginTransaction();
		
		for(WorkflowState state : states) {
			
			if(state.getId() == 0) {
				state.setCreated(now);
			}
			state.setLastModified(now);
			dao.addPersist(state);
		}
		
		dao.commitTransaction();
		dao.closeSession();
	}
	
	@Override
	public WorkflowState get(WorkflowState state) {
		dao.openSession();
		state = dao.findById(state.getId());
		dao.initialize(state.getWorkflow());
		dao.initialize(state.getArea());
		dao.closeSession();
		return state;
	}

	@Override
	public void create(WFErrors errors, WorkflowState entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(WFErrors errors, WorkflowState entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(WFErrors errors, WorkflowState entity) {
		throw new UnsupportedOperationException();
	}
}
