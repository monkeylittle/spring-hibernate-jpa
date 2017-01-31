package net.thoughtforge.dao;

import net.thoughtforge.model.User;

public interface UserDao extends PersistentEntityDao<User> {

    User findByUsername(String username);
}