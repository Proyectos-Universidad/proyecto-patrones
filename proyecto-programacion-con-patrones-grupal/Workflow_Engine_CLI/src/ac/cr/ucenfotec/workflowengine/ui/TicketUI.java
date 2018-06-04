package ac.cr.ucenfotec.workflowengine.ui;

import java.io.IOException;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class TicketUI extends GenericUI<Ticket>{

	private Menu cMenu;
	private User tempUser;
	private Workflow tempWf;
	
	public TicketUI(){
		cMenu = new Menu();
		cMenu.setConfirm(true);
		cMenu.addOption("Summary", this::getSummary);
		cMenu.addOption("Description", this::getDescription);
	}
	
	@Override
	protected String printRow(Ticket obj) {
		return String.format("| %s | %s | %s | %s |", obj.getSummary(),obj.getWorkflow().getName(),tryGet(obj.getCreated()), obj.getWorkflow().getName());
	}

	@Override
	protected Ticket get(Ticket obj) {
		temporal = obj;
		
		if(temporal == null) {
			temporal = new Ticket();
		}
		
		temporal.setAuthor(tempUser);
		temporal.setWorkflow(tempWf);
		
		tempUser = null;
		tempWf = null;
		
		cMenu.setPreOptionsCommand(()-> print(temporal));		
		
		return cMenu.start() ? temporal : null;
	}

	@Override
	public void print(Ticket obj) {
		System.out.println("Summary: " + tryGet(obj.getSummary()));
		System.out.println("Created: " + tryGet(((obj.getCreated() == null) ? "N/A" : obj.toString())));
		System.out.println("Workflow: " + ((obj.getWorkflow() != null) ? tryGet(obj.getWorkflow().getName()): "N/A"));
		System.out.println("Description: " + tryGet(obj.getDescription()));
	}
	

	public void setUser(User user) {
		tempUser = user;
	}
	
	public void setWorkflow(Workflow workflow) {
		tempWf = workflow;
	}
	
	private void getDescription() {
		try {
			temporal.setDescription(InputUtil.getString("Input the description of the ticket", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getSummary() {
		try {
			temporal.setSummary(InputUtil.getString("Input the summary of the ticket", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}