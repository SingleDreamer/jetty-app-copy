package org.example.app.api;

public class Task {
	static public int id_counter = 1;
	// what way makes most sense to have id_counter????
	// does it make more sense to have "GET message" in the TaskResource vs Task class???
    private String todo;
    private int id; 
    
    Task () {
    }

    public Task (String taskArg) {
        this.todo = getTask(taskArg);
        //this.id = id_counter; 
        //id_counter++; 
    } 
    public Task (int idArg, String taskArg) {
        this.todo = getTask(taskArg);
        this.id = idArg; 
    } 

    public String getTodo() {
        return todo;
    }

    public void setTodo(String taskArg) {
        this.todo = taskArg;
    }

    private String getTask(String task) {
        return "You just did a GET for the task: " + task;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
