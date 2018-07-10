package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.User;

public class ModelsUserTest {
	
	User userI = new User();
	User userII = new User();
	
	@Test
	public void testUserEqualsTrue() {
		
		userI.setId(1);
		userI.setEmail("mymail@mail.com");
		
		userII.setId(1);
		userII.setEmail("mymail@mail.com");
		
		assertTrue(userI.equals(userII));
	}
	
	@Test
	public void testUserEqualsFalse() {
		
		userI.setId(1);
		userI.setEmail("mymail@mail.com");
		
		userII.setId(2);
		userII.setEmail("mymail@mail.com");
		
		assertFalse(userI.equals(userII));
		
		userII.setId(1);
		userII.setEmail("yourmail@mail.com");
		
		assertFalse(userI.equals(userII));
	}

}
