package org.example.app.api;

import org.example.app.api.Task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TaskTest extends TestCase {

	Task taskA;
	Task taskB; 
	
	public void setUp() {
		taskA = new Task(1, "task one"); 
		taskB = new Task(2, "task two"); 
	}
	
	public void testTasks() {
		assertTrue(taskA.getTodo() == "task one"); 
		assertTrue(taskA.getId() == 1); 
		assertTrue(taskB.getTodo() == "task two");
		assertTrue(taskB.getId() == 2); 
	}
	
}
