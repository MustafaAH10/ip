package app.commands;

import app.exceptions.DukeException;
import app.parser.AddTaskParser;
import app.save.Storage;
import app.tasks.Task;
import app.tasks.TaskList;
import app.ui.Ui;

/**
 * Represents a new Todo command.
 */
public class AddTodo extends Command {
    private Task newTask;

    /**
     * Constructor to add a new todo.
     * @param commandWord First word of user input.
     * @param commandDescriptor Remaining user input.
     * @throws DukeException If error in parsing the input.
     */
    public AddTodo(String commandWord, String commandDescriptor) throws DukeException {
        this.newTask = AddTaskParser.parseCommand(commandWord, commandDescriptor);
    }

    /**
     * Method to execute the AddTodo command.
     * @param tasks Task-list containing the existing tasks.
     * @param ui User interface to print message.
     * @param storage Saving of tasks to memory.
     * @throws DukeException If error in saving task.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(newTask);
        ui.newTaskAddedMessage(newTask, tasks.getTasksCount());
        storage.write(tasks);
    }
}
