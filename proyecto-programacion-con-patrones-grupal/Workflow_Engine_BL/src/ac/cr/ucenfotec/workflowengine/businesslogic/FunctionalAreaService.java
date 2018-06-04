package ac.cr.ucenfotec.workflowengine.businesslogic;

import java.util.List;

import ac.cr.ucenfotec.workflowengine.dao.FunctionalAreaDAO;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;

public class FunctionalAreaService {
	
	private FunctionalAreaDAO dao;
	
	public FunctionalAreaService() {
		dao = new FunctionalAreaDAO();
	}
	
	public void create(FunctionalArea area) {
		//Logica de validacion del lado del servidor.
		dao.persist(area);
	}
	
	public List<FunctionalArea> getAll() {
		dao.openSession();
		List<FunctionalArea> wfs = dao.findAll();
		dao.closeSession();
		return wfs;
	}
	
}
