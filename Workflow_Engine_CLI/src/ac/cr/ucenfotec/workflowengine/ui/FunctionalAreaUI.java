package ac.cr.ucenfotec.workflowengine.ui;

import java.io.IOException;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class FunctionalAreaUI extends GenericUI<FunctionalArea>{
	
	private Menu menu;
	
	public FunctionalAreaUI() {
		menu = new Menu();
		menu.setConfirm(true);
		menu.addOption("Name", ()-> getName());
	}
	
	public String printRow(FunctionalArea functionalArea) {
		return String.format("%s", functionalArea.getName());
	}
	
	public void print(FunctionalArea obj) {
		System.out.println("Name:" + tryGet(temporal.getName()));
	}
	
	protected FunctionalArea get(FunctionalArea functionalArea) {
		
		temporal = functionalArea;
		
		if(temporal == null) {
			temporal = new FunctionalArea();
		}
		menu.setPreOptionsCommand(()-> print(temporal));
		menu.start();
		return temporal;
		
	}
	
	private void getName() {
		try {
			temporal.setName(InputUtil.getString("New functional area name:", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
