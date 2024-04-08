package com.ejournal.group.group.repository.impl;

import com.ejournal.group.group.entity.Group;
import com.ejournal.group.group.repository.GroupRepository;
import com.ejournal.group.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaGroupRepositoryImpl extends JpaRepository<Group, Long>, GroupRepository {

    @Override
    default List<Group> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Group> fetchInstanceById(Long groupId){
        return findById(groupId);
    }

    @Override
    default Group createInstance(Group group){
        return save(group);
    }

    @Override
    default Group updateInstance(Group group){
        return save(group);
    }

    @Override
    default void deleteInstance(Group group){
        delete(group);
    }


}
