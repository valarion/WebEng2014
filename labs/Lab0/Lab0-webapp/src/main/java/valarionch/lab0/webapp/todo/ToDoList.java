package valarionch.lab0.webapp.todo;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	private List<ToDo> todolist;

	public ToDoList() {
		todolist = new ArrayList<ToDo>();
	}

	public List<ToDo> getToDoList() {
		return todolist;
	}

	public void setPersonList(List<ToDo> todolist) {
		this.todolist = todolist;
	}

	public void addPerson(ToDo todo) {
		todolist.add(todo);
	}
}
