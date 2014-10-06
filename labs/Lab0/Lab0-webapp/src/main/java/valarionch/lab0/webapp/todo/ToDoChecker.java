package valarionch.lab0.webapp.todo;

public class ToDoChecker {
	protected interface Comparator {
		public boolean compare(int i1, int i2);
	}

	public ToDoChecker(String search) {
		if(search == null || search.isEmpty()){
			return;
		}
		
		String[] fields = search.split(";");
		for (String field : fields) {
			String[] elements = field.split("[:><=]");
			if (elements != null && elements.length >= 2) {
				switch (elements[0].toLowerCase()) {
				case "task":
					task = elements[1];
					break;
				case "context":
					context = elements[1];
					break;
				case "project":
					project = elements[1];
					break;
				case "priority":
					try {
						priority = Integer.parseInt(elements[1]);

						switch (field.charAt(8)) {
						case '<':
							comparator = (int i1, int i2) -> (i1 < i2);
							break;
						case '>':
							comparator = (int i1, int i2) -> (i1 > i2);
							break;
						default:
							comparator = (int i1, int i2) -> (i1 == i2);
							break;
						}

					} catch (NumberFormatException e) {
						incorrectSearch = true;
					}
					break;
				default:
					incorrectSearch = true;
				}
			}
		}
	}
	
	public boolean isValid(ToDo todo){
		return (task == null || todo.task.contains(task)) &&
			   (context == null || todo.context.contains(context)) &&
			   (project == null || todo.project.contains(project)) &&
			   (comparator == null || comparator.compare(priority, todo.priority.ordinal()));
	}
	
	public boolean isSearchCorrect(){
		return !incorrectSearch;
	}

	protected String task=null;
	protected String context=null;
	protected String project=null;
	protected int priority;
	
	protected boolean incorrectSearch = false;
	protected Comparator comparator = null;
}
