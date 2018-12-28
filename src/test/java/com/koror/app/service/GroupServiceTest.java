package com.koror.app.service;

import com.koror.app.entity.Group;
import com.koror.app.error.WrongInputException;
import com.koror.app.repository.GroupRepository;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupServiceTest {

    @Test(expected = WrongInputException.class)
    public void testAddGroupNegative() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        groupService.addGroup(null);
    }

    @Test
    public void testAddGroupPositive() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        final Group group = new Group("test group");
        groupService.addGroup(group);
    }

    @Test(expected = WrongInputException.class)
    public void testUpdateGroupNegative() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        groupService.updateGroup(null);
    }

    @Test
    public void testUpdateGroupPositive() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        final Group group = new Group("test group");
        groupService.addGroup(group);
        group.setName("new test group");
        assertNotNull(groupService.updateGroup(group));
    }

    @Test(expected = WrongInputException.class)
    public void testDeleteGroupNegative() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        groupService.deleteGroup("undefined group id");
    }

    @Test
    public void testDeleteGroupPositive() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        final Group group = new Group();
        groupService.addGroup(group);
        groupService.deleteGroup(group.getId());
    }

    @Test(expected = WrongInputException.class)
    public void testGetGroupNegative() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        groupService.getGroup(null);
    }

    @Test
    public void testGetGroupPositive() {
        final GroupRepository groupRepository = new GroupRepository();
        final GroupService groupService = new GroupService(groupRepository);
        final Group group = new Group("test group");
        groupService.addGroup(group);
        groupService.getGroup(0);
    }

}