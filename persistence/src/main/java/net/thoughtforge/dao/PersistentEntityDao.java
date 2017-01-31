package net.thoughtforge.dao;

import java.util.List;

import net.thoughtforge.model.PersistentEntity;

public interface PersistentEntityDao<Entity extends PersistentEntity> {

    Entity findByIndexId(Integer indexId);
    
    List<Entity> findByNamedQuery(String queryName);
    
    List<Entity> findByNamedQueryAndParams(String queryName, Object ...params);
    
    Entity findUniqueByNamedQuery(String queryName);
    
    Entity findUniqueByNamedQueryAndParams(String queryName, Object ...params);
    
    Entity merge(Entity persistentEntity);
    
    void refresh(Entity persistentEntity);
    
    void remove(Entity persistentEntity);
    
    void save(Entity persistentEntity);
}
