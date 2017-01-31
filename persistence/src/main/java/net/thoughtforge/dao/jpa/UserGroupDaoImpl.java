package net.thoughtforge.dao.jpa;

import net.thoughtforge.dao.UserGroupDao;
import net.thoughtforge.model.UserGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserGroupDaoImpl extends PersistentEntityDaoImpl<UserGroup>
        implements UserGroupDao {

    @Autowired
    public UserGroupDaoImpl(JpaTemplate jpaTemplate) {
        super(jpaTemplate);
    }
    
    public UserGroup findByName(String name) {
        return findUniqueByNamedQueryAndParams("userGroup.findByName", name);
    }
}
