package ac.cr.ucenfotec.workflowengine.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;

public abstract class DAO<T,U extends Serializable> {
	
	protected Session session;
    protected Class<T> type;
    protected String className;
    
    public DAO(Class<T> type){
    	this.type = type;
    	className = type.getSimpleName();
    }

	public void persist(T entity) {
		Session s = HUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.saveOrUpdate(entity);
		s.getTransaction().commit();
		s.close();
	}
	
	public void persist(List<T> entities) {
		
		if(entities.isEmpty()) {
			return;
		}
		
		Session s = HUtil.getSessionFactory().openSession();
		s.beginTransaction();
		for(T entity : entities) {
			s.saveOrUpdate(entity);
		}
		s.getTransaction().commit();
		s.close();
	}
	
	public void addPersist(T entity) {
		session.saveOrUpdate(entity);
	}
	
	public T findById(U id) {
		return (T)session.get(type, id);
	}
	
	public void initialize(Object entity) {
		Hibernate.initialize(entity);
	}
	
	public List<T> findAll() {
		TypedQuery<T> q = session.createQuery("from " + className, type);
		return q.getResultList();
	}
	
	public void openSession() {
		session = HUtil.getSessionFactory().openSession();
	}
	
	public void closeSession() {
		session.close();
	}
	
	public void beginTransaction() {
		session.beginTransaction();
	}
	
	public void commitTransaction() {
		session.getTransaction().commit();
	}
}
