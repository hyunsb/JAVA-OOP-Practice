package smartStore_FastCampus.service;

import smartStore_FastCampus.domain.group.Group;
import smartStore_FastCampus.domain.group.GroupType;
import smartStore_FastCampus.domain.group.Groups;
import smartStore_FastCampus.exception.ArrayEmptyException;
import smartStore_FastCampus.exception.GroupNotFoundException;
import smartStore_FastCampus.exception.GroupSetAlreadyException;
import smartStore_FastCampus.util.view.Message;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GroupService {

    private final Groups groups;

    public GroupService(Groups groups) {
        this.groups = groups;
    }

    public void checkInvalidGroup(GroupType groupType) throws GroupSetAlreadyException {
        if (groups.size() != 0 && groups.find(groupType) != null)
            throw new GroupSetAlreadyException(groupType.toString());
    }

    public Group selectGroupByGroupType(GroupType groupType) throws ArrayEmptyException, GroupNotFoundException {
        checkGroupEmpty();
        Group group = groups.find(groupType);
        if (Objects.isNull(group)) throw new GroupNotFoundException();
        return group;
    }

    public void insertGroup(Group group) {
        groups.add(group);
    }

    public Groups selectAllGroup() throws ArrayEmptyException {
        checkGroupEmpty();
        return groups;
    }

    public void checkGroupEmpty() {
        if (groups.size() == 0) throw new ArrayEmptyException(Message.ERR_MSG_GROUP_ARR_EMPTY);
    }

    public List<Group> sortGroup(){
        List<Group> list = groups.toList();
        list.sort(Comparator.comparingInt(group -> group.getGroupType().getRank()));
        return list;
    }
}
