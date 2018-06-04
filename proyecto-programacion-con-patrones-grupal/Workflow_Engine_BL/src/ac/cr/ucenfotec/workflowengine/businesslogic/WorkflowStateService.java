package ac.cr.ucenfotec.workflowengine.businesslogic;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowStateDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;

import java.time.LocalDateTime;
import java.util.List;

public class WorkflowStateService {
	private WorkflowStateDAO dao;
	
	public WorkflowStateService() {
		dao = new WorkflowStateDAO();
	}
	
	public void createOrUpdate(List<WorkflowState> states) {
		
		LocalDateTime now = LocalDateTime.now();
		
		dao.openSession();
		dao.beginTransaction();
		
		for(WorkflowState state : states) {
			
			if(state.getId() != 0) {
				state.setCreated(now);
			}
			state.setLastModified(now);
			dao.addPersist(state);
		}
		
		dao.commitTransaction();
		dao.closeSession();
	}
}
