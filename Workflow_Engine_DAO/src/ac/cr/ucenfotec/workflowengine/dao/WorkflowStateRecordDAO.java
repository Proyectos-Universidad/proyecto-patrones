package ac.cr.ucenfotec.workflowengine.dao;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

public class WorkflowStateRecordDAO extends DAO<WorkflowStateRecord, Integer>{

	public WorkflowStateRecordDAO() {
		super(WorkflowStateRecord.class);
	}

}
