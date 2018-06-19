package org.example.app.resources;

import org.skife.jdbi.v2.DBI;

import junit.framework.TestCase;

public class MyDAOTest extends TestCase {

	DBI dbi = new DBI(MyDAO.TASK_DB_URL,
            MyDAO.TASK_DB_USER, MyDAO.TASK_DB_PASS);
	MyDAO dao = dbi.onDemand(MyDAO.class);
	
	public void setup() {
		//dao.deleteTaskTable();
		//System.out.println("setup");
		dao.createTaskTable();
	} 
	
	public void testDAO() {
		setup(); 
		
		dao.insert("testing MyDAO");
		int i = dao.getLatestId(); 
		String result = dao.findById(i);
		System.out.println(""+i);
		assertTrue(result.equals("testing MyDAO")); 
		
		dao.update(i, "testing update");
		result = dao.findById(i);
		assertTrue(result.equals("testing update")); 
		
		dao.delete(i); 
		result = dao.findById(i); 
		assertTrue(result == null);
		// need to test getAll??*/
	}
	
	
	
}
