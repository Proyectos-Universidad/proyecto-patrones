package ac.cr.ucenfotec.workflowengine.ui;

import ac.cr.ucenfotec.workflowengine.businesslogic.CommentService;
import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.businesslogic.TicketService;
import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class MainUI {

	private WFErrors errors;
	
	private Menu menu;
	private Menu ticketMenu;
	private Menu confirmMenu;
	
	private WorkflowUI workflowUI;
	private WorkflowStateUI workflowStateUI;
	private FunctionalAreaUI functionalAreaUI;
	private TicketUI ticketUI;
	private CommentUI commentUI;
	private WorkflowStateRecordUI workflowStateRecordUI;
	private UserUI userUI;
	private WorkflowService workflowService;
	private FunctionalAreaService functionalAreaService;
	private TicketService ticketService;
	private CommentService commentService;
	private UserService userService;
	
	private Ticket selected;
	
	public MainUI() {
		workflowUI = new WorkflowUI();
		workflowStateUI = new WorkflowStateUI();
		functionalAreaUI = new FunctionalAreaUI();
		ticketUI = new TicketUI();
		commentUI = new CommentUI();
		userUI = new UserUI();
		workflowStateRecordUI = new WorkflowStateRecordUI();
		workflowService = new WorkflowService();
		functionalAreaService = new FunctionalAreaService();
		ticketService = new TicketService();
		commentService = new CommentService();
		userService = new UserService();
		
		menu = new Menu();
		menu.addOption("Create user", this::createUser);
		menu.addOption("See users", this::seeUsers);
		menu.addOption("Create workflow", this::createWorkflow);
		menu.addOption("See existing workflows", this::seeWorkflowsStates);
		menu.addOption("Create functional area", this::createFunctionalArea);
		menu.addOption("Add states to workflow", this::addStatesToWorkflow);
		menu.addOption("Create ticket", this::createTicket);
		menu.addOption("See open tickets", this::seeOpenTickets);
		
		ticketMenu = new Menu();
		ticketMenu.setConfirm(true,"Move ticket");
		ticketMenu.addOption("Add comment", this::addTicketComment);
		ticketMenu.addOption("See comments", this::seeTicketComments);
		ticketMenu.addOption("See history", this::seeTicketHistory);
		
		confirmMenu = new Menu();
		confirmMenu.setCloseText("No");
		confirmMenu.setConfirm(true, "Yes");

	}
	
	public void startTheParty(){
		menu.start();
		System.exit(0);
	}
	
	private void printErrors() {
		System.out.print(errors.getMessage() + "\n");
	}
	
	private void clearErrors() {
		errors = new WFErrors();
	}
	
	private void createUser() {
		userUI.setAvailableAreas(functionalAreaService.getAll());
		User tempUser = userUI.create();
		
		if(tempUser == null) {
			return;
		}
		clearErrors();
		userService.create(errors,tempUser);
		printErrors();
	}
	
	private void seeUsers() {
		userUI.list(userService.getAll(), "Registered users");
	}
	
	private void createWorkflow() {
		
		Workflow tempWf = workflowUI.create();
		
		if(tempWf == null) {
			return;
		}
		clearErrors();
		workflowService.create(errors,tempWf);
		printErrors();
	}
	
	private void seeWorkflowsStates() {
		Workflow tempWf = workflowUI.choose(workflowService.getAll());
		if(tempWf == null) {
			return;
		}
		tempWf = workflowService.get(tempWf);
		workflowUI.print(tempWf);
		workflowStateUI.list(tempWf.getStates(), String.format("%s's states", tempWf.getName()));
	}
	
	private void addStatesToWorkflow() {
		Workflow tempWf = workflowUI.choose(workflowService.getAll());
		
		if(tempWf == null) {
			return;
		}
		
		tempWf = workflowService.get(tempWf);
		workflowStateUI.setWorkflow(tempWf);
		WorkflowState tempState = workflowStateUI.create();
		
		if(tempState == null) {
			return;
		}
		
		tempWf.addState(tempState);
		clearErrors();
		workflowService.update(errors,tempWf);
		printErrors();
	}
	
	private void createFunctionalArea() {
		FunctionalArea tempFa = functionalAreaUI.create();
		if(tempFa == null) {
			return;
		}
		clearErrors();
		functionalAreaService.create(errors,tempFa);
		printErrors();
	}
	
	private void createTicket() {
		Workflow tempWf = workflowUI.choose(workflowService.getAll());
		
		if(tempWf == null) {
			return;
		}
		
		ticketUI.setWorkflow(tempWf);
		Ticket ticket = ticketUI.create();
		
		if(ticket == null) {
			return;
		}
		
		clearErrors();
		ticketService.create(errors,ticket);
		printErrors();
		
	}
	
	private void seeOpenTickets() {
		
		FunctionalArea tempFa = functionalAreaUI.choose(functionalAreaService.getAll());
		
		if(tempFa == null) {
			return;
		}
		
		Ticket tempTk = ticketUI.choose(ticketService.getByFunctionalArea(tempFa));
		
		if(tempTk == null) {
			return;
		}
		
		operateOnTicket(tempTk);
	}
	
	private void operateOnTicket(Ticket ticket) {
		selected = ticketService.get(ticket);
		if(ticketMenu.start()) {
			moveTicket();
		}
		selected = null;
	}
	
	private void addTicketComment() {
		
		commentUI.setTicket(selected);
		Comment tempCm = commentUI.create();
		
		if(tempCm == null) {
			return;
		}
		
		clearErrors();
		commentService.create(errors,tempCm);
		printErrors();
		selected.addComment(tempCm);
	}
	
	private void seeTicketComments() {
		commentUI.list(selected.getComments(), "Ticket's comments");
	}
	
	private void seeTicketHistory() {
		workflowStateRecordUI.list(selected.getProgress(), "Ticket's states");
	}
	
	private void moveTicket() {
		Workflow workflow = workflowService.get(selected.getWorkflow());
		WorkflowStateRecord currentRecord = selected.getProgress().get((selected.getProgress().size() - 1));
		WorkflowState currentState = workflow.getStates().stream().filter(o -> o.getId() == currentRecord.getWorkflowState().getId()).findFirst().get();
		WorkflowState nextState;
		int index = workflow.getStates().indexOf(currentState);
		boolean last = ( index == (workflow.getStates().size() - 1));
		String nextStateName;
		
		if(last) {
			nextStateName = "CLOSED";
		}else{
			nextState = workflow.getStates().get(index + 1);
			nextStateName = nextState.getName();
		}
		
		System.out.format("Ticket %s will be moved from %s to %s state.\nAre you sure you want to proceed?\n", selected.getSummary(),currentState.getName(),nextStateName);
		
		if(confirmMenu.start()) {
			clearErrors();
			ticketService.nextState(errors,selected);
			printErrors();
		}
	}
	

	
	
}
