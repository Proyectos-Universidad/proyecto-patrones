package ac.cr.ucenfotec.workflowengine.businesslogic;
import java.util.List;
import java.util.function.Supplier;

import ac.cr.ucenfotec.workflowengine.dao.DAO;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public abstract class Service<T,U extends DAO<T, ?>>{
	
	protected U dao;
	
	protected Service(Supplier<U> supplier) {
		dao = supplier.get();
	}
	
	public abstract void create(WFErrors errors,T entity);
	public abstract void update(WFErrors errors,T entity);
	public abstract T get(T entity);
	public abstract void delete(WFErrors errors,T entity);

	public List<T> getAll() {
		dao.openSession();
		List<T> all = dao.findAll();
		dao.closeSession();
		return all;
	}
	
	
	
}
