package ac.cr.ucenfotec.workflowengine.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class UserUI extends GenericUI<User>{

	private FunctionalAreaUI faui;
	private Menu menu;
	private List<FunctionalArea> availableAreas;
	
	public UserUI() {
		menu = new Menu();
		faui = new FunctionalAreaUI();
		
		menu.setConfirm(true);
		menu.addOption("Name", this::getName);
		menu.addOption("Last name", this::getLastName);
		menu.addOption("Email", this::getEmail);
		menu.addOption("Add functional area", this::getArea);
		menu.addOption("Remove functional area", this::removeArea);
		
		availableAreas = new ArrayList<FunctionalArea>();

	}
	
	@Override
	protected String printRow(User obj) {
		return String.format("| %s | %s | %s | %s |",obj.getName(), obj.getLastName(), obj.getEmail(), obj.getAreas().get(0));
	}

	@Override
	protected User get(User obj) {
		temporal = obj;
		
		if(temporal == null) {
			temporal = new User();
		}
				
		menu.setPreOptionsCommand(()-> print(temporal));		
		boolean saved = menu.start();
		availableAreas.clear();
		return  saved ? temporal : null;
	}

	@Override
	public void print(User obj) {
		StringBuilder areas = new StringBuilder("N/A");
		
		System.out.println("Name: " + obj.getName());
		System.out.println("Last name: " + obj.getLastName());
		System.out.println("Email: " + obj.getEmail());
		
		if(!obj.getAreas().isEmpty()) {
			areas.delete(0, areas.length());
			
			for(FunctionalArea area : obj.getAreas()) {
				areas.append(area.getName() + ",");
			}
			
			areas.deleteCharAt(areas.length() - 1);
		}

		System.out.println("Areas: " + areas);

	}
	
	private void getName() {
		try {
			temporal.setName(InputUtil.getString("Input the name of the user", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getLastName() {
		try {
			temporal.setLastName(InputUtil.getString("Input the last name of the user", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getEmail() {
		try {
			temporal.setEmail(InputUtil.getString("Input the email of the user", "", 255, 2));
			//Validate email format and if it is already present in data store.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAvailableAreas(List<FunctionalArea> areas) {
		this.availableAreas = areas;
	}
	
	private void getArea() {
		availableAreas.removeAll(temporal.getAreas());
		FunctionalArea area = faui.choose(availableAreas);
		
		if(area != null) {
			temporal.getAreas().add(area); 
		}
	}
	
	private void removeArea() {
		FunctionalArea area = faui.choose(temporal.getAreas());
		temporal.getAreas().remove(area);
		
		if(area != null) {
			availableAreas.add(area); 
		}
		
	}

}
