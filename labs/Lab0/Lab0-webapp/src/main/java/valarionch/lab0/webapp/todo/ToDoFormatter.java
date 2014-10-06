package valarionch.lab0.webapp.todo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

public class ToDoFormatter {
	protected static Gson gson = new Gson();
	
	public static void parse(InputStream ToDoFile, PrintWriter out, String search) {
		ToDoChecker checker = new ToDoChecker(search);
		if(!checker.isSearchCorrect()){
			out.println("Búsqueda inválida");
		}
		out.print("<table style=\"width:100%\" border=\"1\">\n"+
				  "	<tr>\n"+
				  "		<th>Task</th>\n"+
				  "		<th>Context</th>\n"+	
				  "		<th>Project</th>\n"+
				  "		<th>Priority</th>\n"+
				  "	</tr>\n");
		
		
		if(ToDoFile != null) {
			ToDoList todolist = (ToDoList) gson.fromJson(new InputStreamReader(ToDoFile),
					ToDoList.class);
			
			for(ToDo todo : todolist.getToDoList()){
				if(checker.isValid(todo)){
					out.print(
							  "	<tr>\n"+
							  "		<td>"+todo.task+"</td>\n"+
							  "		<td>"+todo.context+"</td>\n"+	
							  "		<td>"+todo.project+"</td>\n"+
							  "		<td>"+todo.priority.ordinal()+"</td>\n"+
							  "	</tr>\n");
				}
			}
		}
		out.println("</table>");
	}
}
