package net.thoughtforge.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import net.thoughtforge.dao.PersistentEntityDao;
import net.thoughtforge.model.PersistentEntity;

import org.springframework.orm.jpa.JpaTemplate;

public abstract class PersistentEntityDaoImpl<Entity extends PersistentEntity>
        implements PersistentEntityDao<Entity> {

    private Class<Entity> entityClass;
    
    private JpaTemplate jpaTemplate;
    
    @SuppressWarnings(value="unchecked")
    public PersistentEntityDaoImpl(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
        
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<Entity>) genericSuperclass.getActualTypeArguments()[0];
    }

    public final Entity findByIndexId(Integer indexId) {
        return (Entity) jpaTemplate.find(entityClass, indexId);
    }
    
    @SuppressWarnings("unchecked")
    public final List<Entity> findByNamedQuery(String queryName) {
        return (List<Entity>) jpaTemplate.findByNamedQuery(queryName);
    }
    
    @SuppressWarnings("unchecked")
    public final List<Entity> findByNamedQueryAndParams(String queryName, Object ...params) {
        return (List<Entity>) jpaTemplate.findByNamedQuery(queryName, params);
    }
    
    public final Entity findUniqueByNamedQuery(String queryName) {
        List<Entity> results = findByNamedQuery(queryName);
        
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public final Entity findUniqueByNamedQueryAndParams(String queryName, Object ...params) {
        List<Entity> results = findByNamedQueryAndParams(queryName, params);
        
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public final Entity merge(Entity persistentEntity) {
        return (Entity) jpaTemplate.merge(persistentEntity);
    }

    public final void refresh(Entity persistentEntity) {
        jpaTemplate.refresh(persistentEntity);
    }
    
    public final void remove(Entity persistentEntity) {
        jpaTemplate.remove(persistentEntity);
    }
    
    public final void save(Entity persistentEntity) {
        jpaTemplate.persist(persistentEntity);
    }
}
