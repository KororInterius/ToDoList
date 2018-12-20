package com.koror.app.entity;

import java.util.ArrayList;

public class Group {

    private final ArrayList<Task> taskList = new ArrayList<>();

    private final String name;

    public Group(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    @Override
    public String toString() {
        return name;
    }
}
