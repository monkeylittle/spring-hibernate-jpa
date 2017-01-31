package net.thoughtforge.dao.jpa;

import net.thoughtforge.dao.UserDao;
import net.thoughtforge.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends PersistentEntityDaoImpl<User> implements UserDao {

    @Autowired
    public UserDaoImpl(JpaTemplate jpaTemplate) {
        super(jpaTemplate);
    }
    
    public User findByUsername(String username) {
        return findUniqueByNamedQueryAndParams("user.findByUsername", username);
    }
}
