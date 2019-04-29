package com.indorse.phonebook.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.indorse.phonebook.entity.Friendship;

public interface FriendshipRepository extends CrudRepository<Friendship, Long>,
    QueryByExampleExecutor<Friendship> {

}
