package ac.cr.ucenfotec.workflowengine.dao;

import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;

public class WorkflowDAO extends DAO<Workflow, Integer>{

	public WorkflowDAO() {
		super(Workflow.class);
	}

}
