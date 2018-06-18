package org.example.app.resources;

import org.skife.jdbi.v2.DBI;

import junit.framework.TestCase;

public class MyDAOTest extends TestCase {

	DBI dbi = new DBI(MyDAO.TASK_DB_URL,
            MyDAO.TASK_DB_USER, MyDAO.TASK_DB_PASS);
	MyDAO dao = dbi.onDemand(MyDAO.class);
	
	public void setup() {
		//dao.deleteTaskTable();
		dao.createTaskTable();
	} 
	
	public void testDAO() {
		/*int i = dao.getLatestId() + 1;
		
		dao.insert("testing MyDAO");
		String result = dao.findById(i);
		assertTrue(result == "testing MyDAO"); 
		
		dao.update(i, "testing update");
		result = dao.findById(i);
		assertTrue(result == "testing update"); 
		
		dao.delete(i); 
		result = dao.findById(i); 
		assertTrue(result == ""); 
		// need to test getAll??*/
	}
	
	
	
}
