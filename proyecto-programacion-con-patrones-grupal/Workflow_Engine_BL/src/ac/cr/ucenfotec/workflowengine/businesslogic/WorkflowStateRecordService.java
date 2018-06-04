package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowStateRecordDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

public class WorkflowStateRecordService {

	private WorkflowStateRecordDAO dao;
	
	public WorkflowStateRecordService() {
		dao = new WorkflowStateRecordDAO();
	}
	
	public void createOrUpdate(List<WorkflowStateRecord> stateRecords) {
		
		if(stateRecords.isEmpty()) {
			return;
		}
		
		dao.openSession();
		dao.beginTransaction();
		
		for(int i = (stateRecords.size() - 1); i >= 0;i--) {
			dao.addPersist(stateRecords.get(i));
		}
		
		dao.commitTransaction();
		dao.closeSession();
	}
	
	public void createOrUpdate(WorkflowStateRecord stateRecord) {
		
		dao.persist(stateRecord);
		
	}
}
