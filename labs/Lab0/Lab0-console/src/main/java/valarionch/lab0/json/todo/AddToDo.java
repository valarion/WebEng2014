package valarionch.lab0.json.todo;

import com.google.gson.Gson;
import java.io.*;

public class AddToDo {
	public static final String DEFAULT_FILE_NAME = "ToDoList.ToDo";

	static ToDo PromptForToDo(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		ToDo todo = new ToDo();
		stdout.print("Enter ToDo task: ");
		todo.setTask(stdin.readLine());
		stdout.print("Enter ToDo context: ");
		todo.setContext(stdin.readLine());
		stdout.print("Enter ToDo project: ");
		todo.setProject(stdin.readLine());
		int priority = -1;
		do {
			stdout.print("Enter ToDo priority (0-IMMEDIATE,1-HIGH,2-MEDIUM,3/blank-LOW): ");
			String line = stdin.readLine();
			if (line == null || line.length() == 0)
				priority = 3;
			else
				try {
					priority = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					stdout.println("Invalid input.");
				}
		} while (priority == -1);
		todo.setPriority(ToDoPriority.values()[priority]);
		return todo;
	}

	public static void main(String args[]) throws Exception {
		String filename = "ToDoList.json";
		if (args.length > 0)
			filename = args[0];
		ToDoList todolist = new ToDoList();
		Gson gson = new Gson();
		try {
			todolist = (ToDoList) gson.fromJson(new FileReader(filename),
					ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println((new StringBuilder()).append(filename)
					.append(": File not found.  Creating a new file.")
					.toString());
		}
		todolist.addPerson(PromptForToDo(new BufferedReader(
				new InputStreamReader(System.in)), System.out));
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(todolist));
		output.close();
	}
}
