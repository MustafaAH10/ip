package app.tasks;

import java.util.ArrayList;

public class Task {
    public static final String line = ("─".repeat(50));
    protected String taskDescription;
    protected boolean isDone;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); //Marks a task done with an X
    }

    public static void taskStatusHandler(ArrayList<Task>tasks, String commandWord, String commandDescriptor) {
        System.out.println(line);
        int taskNumber = Integer.parseInt(commandDescriptor);
        if (commandWord.equals("mark")) {
            tasks.get(taskNumber - 1).setDone(true);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks.get(taskNumber - 1));
        } else {
            tasks.get(taskNumber - 1).setDone(false);
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(tasks.get(taskNumber - 1));
        }
        System.out.println(line);
    }

    public static void printTasks(ArrayList<Task> tasks) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print((i + 1) + ".");
            System.out.println(tasks.get(i));
        }
        System.out.println(line);
    }
}