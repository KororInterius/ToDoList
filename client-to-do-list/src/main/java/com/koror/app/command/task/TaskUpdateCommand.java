package com.koror.app.command.task;

import com.koror.app.command.AbstractCommand;
import com.koror.app.endpoint.Priority;
import com.koror.app.endpoint.Result;
import com.koror.app.endpoint.Task;

import java.util.List;

public final class TaskUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        final List<Task> taskList = bootstrap.getTaskService().getTaskList(bootstrap.getSession());
        final Task task = bootstrap.getTaskByList(taskList);
        System.out.println("Input task name and priority{LOW MEDIUM HIGH}");
        task.setName(bootstrap.nextLine());
        task.setPriority(Priority.valueOf(bootstrap.nextLine()));
        Result result = bootstrap.getTaskService().updateTask(task, bootstrap.getSession());
        System.out.println(result.getResult());
        System.out.println("Task update");
    }

    @Override
    public String command() {
        return "UpdateTask";
    }

    @Override
    public String description() {
        return "Update task";
    }

}