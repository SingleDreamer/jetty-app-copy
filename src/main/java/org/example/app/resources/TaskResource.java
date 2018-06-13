package org.example.app.resources;

import org.example.app.api.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/task")
public class TaskResource {

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task taskGet(@PathParam("param") String todo) {
        return new Task(todo);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String taskPostJson(Task task) {
        return "You just did a POST for the task: " + task.getTodo() + "\n";
    }

}