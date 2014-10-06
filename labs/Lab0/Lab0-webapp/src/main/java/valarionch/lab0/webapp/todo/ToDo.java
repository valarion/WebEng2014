package valarionch.lab0.webapp.todo;

public class ToDo
{

    public ToDo()
    {
        priority = ToDoPriority.LOW;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public String getProject()
    {
        return project;
    }

    public void setProject(String project)
    {
        this.project = project;
    }

    public ToDoPriority getPriority()
    {
        return priority;
    }

    public void setPriority(ToDoPriority priority)
    {
        this.priority = priority;
    }

    public String task;
    public String context;
    public String project;
    public ToDoPriority priority;
}
