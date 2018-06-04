package ac.cr.ucenfotec.workflowengine.ui;

import java.io.IOException;

import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.ui.input.InputUtil;
import ac.cr.ucenfotec.workflowengine.ui.menu.Menu;

public class CommentUI extends GenericUI<Comment> {

	private Menu menu;
	private Ticket tempTk;
	private User tempAu;
	
	public CommentUI() {
		menu = new Menu();
		menu.setConfirm(true);
		menu.addOption("Text", this::getText);
	}
	
	@Override
	protected String printRow(Comment obj) {
		return String.format("| %s | %s |", (obj.getAuthor() == null ? "N/A" : obj.getAuthor().getName()), obj.getCreated());
	}

	@Override
	protected Comment get(Comment obj) {
		temporal = obj;
		
		if(temporal == null) {
			temporal = new Comment();
		}
		
		temporal.setTicket(tempTk);
		temporal.setAuthor(tempAu);
		tempTk = null;
		tempAu = null;
		menu.setPreOptionsCommand(()-> print(temporal));		
		
		return menu.start() ? temporal : null;
	}

	@Override
	public void print(Comment obj) {
		System.out.println("Author: " + (obj.getAuthor() == null ? "N/A" : obj.getAuthor().getName()));
		System.out.println("Created: " + tryGet(obj.getCreated()));
		System.out.println("Text: \n" + tryGet(obj.getText()));
	}
	
	private void getText() {
		try {
			temporal.setText(InputUtil.getString("Input the text of the comment", "", 255, 2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTicket(Ticket ticket) {
		this.tempTk = ticket;
	}
	
	public void setAuthor(User author) {
		this.tempAu = author;
	}
}
