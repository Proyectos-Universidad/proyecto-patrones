package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.WorkflowStateRecordDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowStateRecordService extends Service<WorkflowStateRecord,WorkflowStateRecordDAO>{
	
	public WorkflowStateRecordService() {
		super(WorkflowStateRecordDAO::new);
	}
	
	public void createOrUpdate(WFErrors errors,List<WorkflowStateRecord> stateRecords) {
		
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

	@Override
	public void create(WFErrors errors, WorkflowStateRecord entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(WFErrors errors, WorkflowStateRecord entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkflowStateRecord get(WorkflowStateRecord entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(WFErrors errors, WorkflowStateRecord entity) {
		// TODO Auto-generated method stub
		
	}
}
