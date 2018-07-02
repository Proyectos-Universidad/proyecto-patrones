package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.time.LocalDateTime;
import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.TicketDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class TicketService extends Service<Ticket,TicketDAO>{
	
	private WorkflowStateRecordService wsrs;
	private WorkflowService ws;
	
	public TicketService() {
		super(TicketDAO::new);
		wsrs = new WorkflowStateRecordService();
		ws = new WorkflowService();
	}
	
	public Ticket get(Ticket ticket) {
		dao.openSession();
		ticket = dao.findById(ticket.getId());
		dao.initialize(ticket.getAssignees());
		dao.initialize(ticket.getProgress());
		dao.initialize(ticket.getComments());
		dao.closeSession();
		return ticket;
	}
	
	public void create(WFErrors errors,Ticket ticket) {
		//TODO 
		//Logica de validacion del lado del servidor.
		
		LocalDateTime created = LocalDateTime.now();
		Workflow workflow = ws.get(ticket.getWorkflow());
		
		if(workflow.getStates().isEmpty()) {
			//TODO
			//De alguna manera comunicar a la capa de presentacion que la operacion fallo.
			return;
		}
		
		ticket.setStatus("Open");
		ticket.setCreated(created);
		dao.persist(ticket);
		
		WorkflowStateRecord stateRecord = new WorkflowStateRecord();
		stateRecord.setStarted(created);
		stateRecord.setWorkflow(workflow);
		stateRecord.setWorkflowState(workflow.getStates().get(0));
		stateRecord.setTicket(ticket);
		wsrs.createOrUpdate(stateRecord);
	}
	
	public void nextState(WFErrors errors, Ticket ticket) {
		
		ticket = get(ticket);
		Workflow workflow = ws.get(ticket.getWorkflow());
		
		LocalDateTime now = LocalDateTime.now();
		
		WorkflowStateRecord currentRecord = ticket.getProgress().get((ticket.getProgress().size() - 1));
		WorkflowState currentState = workflow.getStates().stream().filter(o -> o.getId() == currentRecord.getWorkflowState().getId()).findFirst().get();
		
		int index = workflow.getStates().indexOf(currentState);
		boolean last = ( index == (workflow.getStates().size() - 1));
		
		currentRecord.setFinished(now);
		
		if(last) {
			
			ticket.setStatus("Closed");
			currentRecord.setFinished(now);
			
		}else{
			
			WorkflowState nextState = workflow.getStates().get(index + 1);
			WorkflowStateRecord nextRecord = new WorkflowStateRecord();
			nextRecord.setTicket(ticket);
			nextRecord.setWorkflow(workflow);
			nextRecord.setWorkflowState(nextState);
			nextRecord.setPrev(currentRecord);
			nextRecord.setStarted(now);
			currentRecord.setNext(nextRecord);
			currentRecord.setFinished(now);
			ticket.getProgress().add(nextRecord);
		}
		
		wsrs.createOrUpdate(errors,ticket.getProgress());
		dao.persist(ticket);

	}
	
	public List<Ticket> getByFunctionalArea(FunctionalArea functionalArea){
		
		dao.openSession();
		List<Ticket> tickets = dao.findOpenByFunctionalArea(functionalArea);
		dao.closeSession();
		return tickets;
	}
	
	public void close() {
		//TODO
	}

	@Override
	public void update(WFErrors errors, Ticket entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(WFErrors errors, Ticket entity) {
		throw new UnsupportedOperationException();
	}
}
