package ac.cr.ucenfotec.workflowengine.ui;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

public class WorkflowStateRecordUI extends GenericUI<WorkflowStateRecord>{

	@Override
	protected String printRow(WorkflowStateRecord obj) {
		return String.format("| %s | %s | %s |", obj.getWorkflowState().getName(), tryGet(obj.getStarted()), tryGet(obj.getFinished()));
	}

	@Override
	protected WorkflowStateRecord get(WorkflowStateRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print(WorkflowStateRecord obj) {

		System.out.println("State: " + obj.getWorkflowState().getName());
		System.out.println("Started: " + tryGet(obj.getStarted()));
		System.out.println("Finished: " + tryGet(obj.getFinished()));
		
	}
}
