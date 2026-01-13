package com.code.entity;

public class Todo {
	
	private String task;
	private boolean done;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Todo(String task, Boolean done) {
		super();
		this.task = task;
		this.done = done;
	}
	public Todo() {
		super();
	}
	

}
