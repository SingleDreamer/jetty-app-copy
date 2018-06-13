package org.example.app.api;

public class Task {

    private String todo;

    Task () {
    }

    public Task (String taskArg) {
        this.todo = getTask(taskArg);
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
}