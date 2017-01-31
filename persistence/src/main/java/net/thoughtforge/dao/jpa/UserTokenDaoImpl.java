package net.thoughtforge.dao.jpa;

import net.thoughtforge.dao.UserTokenDao;
import net.thoughtforge.model.UserToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserTokenDaoImpl extends PersistentEntityDaoImpl<UserToken> implements UserTokenDao {

    @Autowired
    public UserTokenDaoImpl(JpaTemplate jpaTemplate) {
        super(jpaTemplate);
    }
    
    public UserToken findByName(String name) {
        return findUniqueByNamedQueryAndParams("userToken.findByName", name);
    }
}