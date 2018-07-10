package ac.cr.ucenfotec.workflowengine.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;


public class TicketDAO extends DAO<Ticket, Integer>{

	public TicketDAO(){
		super(Ticket.class);
	}

	public List<Ticket> findOpenByFunctionalArea(FunctionalArea functionalArea){
		//TODO
		//Buscar alternativa a usar native query? 
		//En este caso me vi forzado a utilizar native que debido "HQL subqueries can occur only in the select or where clauses."
		TypedQuery<Ticket> q = session.createNativeQuery("SELECT T.id, T.created, T.description, T.status, T.summary, T.author_id, T.workflow_id FROM Ticket as T INNER JOIN WorkflowStateRecord AS WSR ON T.id = WSR.ticket_id INNER JOIN (SELECT ticket_id, MAX(guide) AS maxGuide FROM WorkflowStateRecord GROUP BY WorkflowStateRecord.ticket_id) AS SUB on SUB.ticket_id = WSR.ticket_id INNER JOIN WorkflowState as WS ON WSR.workflowState_id = WS.id WHERE WS.area_id = ? AND WSR.guide = maxGuide AND T.status = ? ", Ticket.class);
		q.setParameter(1, functionalArea.getId());
		q.setParameter(2, "Open");
		return q.getResultList();
	}
}