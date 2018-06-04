package ac.cr.ucenfotec.workflowengine.ui;
import java.io.IOException;

import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class WorkflowUI extends GenericUI<Workflow>{

	private Menu menu;
	
	public WorkflowUI() {
		menu = new Menu();
		menu.setConfirm(true);
		menu.addOption("Name", this::getName);
		menu.addOption("Description", this::getDescription);
		menu.addOption("Id prefix", this::getIdPrefix);
	}
	
	@Override
	protected String printRow(Workflow obj) {
		return String.format("%s", obj.getName());
	}

	@Override
	protected Workflow get(Workflow obj) {
		temporal = obj;
		
		if(temporal == null) {
			temporal = new Workflow();
		}
		
		menu.setPreOptionsCommand(()-> print(temporal));		
		
		return menu.start() ? temporal : null;
	}

	@Override
	public void print(Workflow obj) {
		StringBuilder states = new StringBuilder("N/A");
		
		System.out.println("Name: " + tryGet(obj.getName()));
		System.out.println("Id prefix: " + tryGet(obj.getIdPrefix()));
		System.out.println("Created: " + tryGet(obj.getCreated()));
		System.out.println("Last modified: " + tryGet(obj.getLastModified()));

		if(obj.getStates() != null && (!obj.getStates().isEmpty())) {
			
			states.delete(0, states.length());
			
			for(WorkflowState state : obj.getStates()) {
				states.append(state.getName() + ",");
			}
			states.deleteCharAt(states.length() - 1);
		}
		System.out.println("Description: \n" + tryGet(obj.getDescription()));
		System.out.println("States: " + states);


	}
	
	private void getName() {
		try {
			temporal.setName(InputUtil.getString("Input the name of the workflow", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getDescription() {
		try {
			temporal.setDescription(InputUtil.getString("Input the description of the workflow", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getIdPrefix() {
		try {
			temporal.setIdPrefix(InputUtil.getString("Input the id prefix for tickets in this workflow", "", 200, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}