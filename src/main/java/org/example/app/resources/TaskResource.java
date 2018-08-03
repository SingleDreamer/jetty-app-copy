 package org.example.app.resources;

import org.example.app.api.Task;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.util.Iterator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/task")
public class TaskResource {

	DBI dbi = new DBI(MyDAO.TASK_DB_URL,
            MyDAO.TASK_DB_USER, MyDAO.TASK_DB_PASS);
	//Handle h = dbi.open();
	//MyDAO dao = h.attach(MyDAO.class);
	MyDAO dao = dbi.onDemand(MyDAO.class);


    @GET
    @Path("/{param}")
    @Produces({MediaType.TEXT_PLAIN})
    public String taskGet(@PathParam("param") int id) {
        return dao.findById(id);
    }
		//@Produces(MediaType.APPLICATION_JSON)
    /*public Task taskGet(@PathParam("param") int id) {
        return new Task(id, dao.findById(id));
    }*/

    @PUT
    @Path("/{param}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String taskPut(@PathParam("param") int id, Task task) {
    	dao.update(id, task.getTodo());
    	return task.getTodo();
    }

    @DELETE
    @Path("/{param}")
    @Produces({MediaType.TEXT_PLAIN})
    public String taskDelete(@PathParam("param") int id) {
    	dao.delete(id);
    	return "deleted " + id;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String taskGetAll() {
    	Iterator<Task> i = dao.getAll();
    	String s = "";
    	Task i_next;
    	while (i.hasNext()) {
    		i_next = i.next();
    		System.out.println(i_next.getId() + " " + i_next.getTodo());
    		s = s + i_next.getId() + " " + i_next.getTodo() + "\n";
    	}
    	return s;
    }

    @POST
		@Consumes({MediaType.APPLICATION_JSON})
		//@Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String taskPostJson(Task task) {
//    	dao.insert(Task.id_counter, task.getTodo());
			System.out.println("POST was done");
    	dao.insert(task.getTodo());
        return "You just did a POST for the task: " + task.getTodo() + "\n";
    }
	/*	public Task taskPostJson(Task task) {
			String result = "You just did a POST for the task: " + task.getTodo() + "\n";
			return Response.status(201).entity(result).build();
		}*/


    //h.close();

}
