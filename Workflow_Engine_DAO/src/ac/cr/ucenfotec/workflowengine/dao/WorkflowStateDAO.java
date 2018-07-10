package ac.cr.ucenfotec.workflowengine.dao;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;

public class WorkflowStateDAO extends DAO<WorkflowState, Integer>{

	public WorkflowStateDAO() {
		super(WorkflowState.class);
	}

}