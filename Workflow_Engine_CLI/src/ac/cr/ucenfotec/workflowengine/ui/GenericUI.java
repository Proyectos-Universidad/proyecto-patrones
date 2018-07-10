package ac.cr.ucenfotec.workflowengine.ui;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import ac.cr.ucenfotec.workflowengine.ui.menu.GenericMenu;

public abstract class GenericUI<T>{

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy|hh:mma");
	protected T temporal;
	
	protected abstract String printRow(T obj);
	protected abstract T get(T obj);
	public abstract void print(T obj);
	
	public T create() {
		return get(null);
	}
	
	public void update(T obj) {
		get(obj);
	}
	
	public T choose(List<T> list) {
		GenericMenu<T> m = new GenericMenu<T>(this::printRow, list);
		return m.start();	
	}
	
	public void list(List<T> list, String listName){

		System.out.format("----%s----\n", ((listName == null || listName.isEmpty()) ? "" : listName));
		for (T item : list) {
		  print(item);
		  System.out.println("-");
		}	
	}
	
	protected String tryGet(Object attr) {
		return attr == null ? "N/A" : (attr.getClass() == LocalDateTime.class ? formatter.format((TemporalAccessor) attr) : attr.toString());
	}

}

