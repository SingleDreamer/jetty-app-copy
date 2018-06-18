package org.example.app.resources;

import org.example.app.api.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/task")
public class TaskResource { 
	
	Task taskA = new Task("task A"); 
	Task taskB = new Task("task B"); 
	
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task taskGet(@PathParam("param") int id) {
        return taskA;
    }
    
    @PUT
    @Path("/{param}") 
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String taskPut(@PathParam("param") int id, Task task) {
    	//taskA.setId(id);
    	taskA.setTodo(task.getTodo());
    	return taskA.getTodo(); 
    }
    
    @DELETE
    @Path("/{param}") 
    @Produces({MediaType.TEXT_PLAIN})
    public String taskDelete(@PathParam("param") int id) {
    	return "deleted " + id; 
    }
    
    @GET 
    @Produces(MediaType.TEXT_PLAIN)
    public String taskGetAll() {
    	return "get all tasks"; 
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String taskPostJson(Task task) {
    	//task.setId(id_counter); 
    	//id_counter = id_counter + 1; 
        return "You just did a POST for the task: " + task.getTodo() + "\n";
    }
    

}