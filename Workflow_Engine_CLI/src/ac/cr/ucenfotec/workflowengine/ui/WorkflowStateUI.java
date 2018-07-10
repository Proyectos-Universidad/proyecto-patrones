package ac.cr.ucenfotec.workflowengine.ui;

import java.io.IOException;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class WorkflowStateUI extends GenericUI<WorkflowState> {

	private Menu menu;
	private Workflow tempWf;
	private FunctionalAreaService fas;
	
	public WorkflowStateUI() {
		fas = new FunctionalAreaService();
		menu = new Menu();
		menu.setConfirm(true);
		menu.addOption("Name", this::getName);
		menu.addOption("Descripcion", this::getDescription);
		menu.addOption("Next message", this::getNextStateMessage);
		//menu.addOption("Back message", this::getPreviousStateMessage);
		menu.addOption("Functional area", this::getFunctionalArea);
		
	}

	@Override
	protected String printRow(WorkflowState obj) {
		return String.format("| %s | %s |",obj.getName(), obj.getArea().getName());
	}

	@Override
	protected WorkflowState get(WorkflowState obj) {
		temporal = obj;
		
		if(temporal == null) {
			temporal = new WorkflowState();
		}
		
		temporal.setWorkflow(tempWf);
		tempWf = null;
		
		menu.setPreOptionsCommand(()-> print(temporal));
		
		return menu.start() ? temporal : null;
	}

	@Override
	public void print(WorkflowState obj) {
		System.out.println("Name: " +tryGet(obj.getName()));
		System.out.println("Created: " +tryGet(obj.getCreated()));
		System.out.println("Last modified: " +tryGet(obj.getLastModified()));
		System.out.println("Next message: " + tryGet(obj.getNextStateMessage()));
		System.out.println("Back message: " + tryGet(obj.getPreviousStateMessage()));
		System.out.println("Workflow: " + (obj.getWorkflow() == null ? "N/A" : tryGet(obj.getWorkflow().getName())));
		System.out.println("Functional area: " + (obj.getArea() == null ? "N/A" : obj.getArea().getName()));
		System.out.println("Description: \n" +tryGet(obj.getDescription()));
	}
	
	private void getName() {
		try {
			temporal.setName(InputUtil.getString("Input the name of the workflow state", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getNextStateMessage() {
		try {
			temporal.setNextStateMessage(InputUtil.getString("Input the next state message", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*private void getPreviousStateMessage() {
		try {
			temporal.setPreviousStateMessage(InputUtil.getString("Input the previous state message", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	private void getDescription() {
		try {
			temporal.setDescription(InputUtil.getString("Input the description of the workflow state", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getFunctionalArea() {
		//TODO
		//Sacar la llamada de el servicio afuera.
		temporal.setArea(new FunctionalAreaUI().choose(fas.getAll()));
	}
	
	public void setWorkflow(Workflow workflow) {
		tempWf = workflow;
	}
}