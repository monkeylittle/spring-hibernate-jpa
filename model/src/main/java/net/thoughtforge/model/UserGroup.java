package net.thoughtforge.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserGroup extends UserTokenHolder {

	private static final long serialVersionUID = -1447883421397150475L;

	private Set<UserGroup> children;

    private String name;

    private UserGroup parent;
    
    private Set<User> users;
    
    public void addChild(UserGroup child) {
        if (child.getParent() == null || !child.getParent().equals(this)) {
            child.setParent(this);
        }
        
        if (children == null) {
            children = new HashSet<UserGroup>();
        }
        
        children.add(child);
    }

    public void removeChild(UserGroup child) {
        if (child.getParent() != null && child.getParent().equals(this)) {
            child.setParent(null);
        }
        
        if (children != null) {
            children.remove(child);
        }
    }
    
    public Set<UserGroup> getChildren() {
        return Collections.unmodifiableSet(children);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserGroup getParent() {
		return parent;
	}

	public void setParent(UserGroup parent) {
		this.parent = parent;
	}

	public void addUser(User user) {
        if (users == null) {
            users = new HashSet<User>();
        }
        
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        if (users != null) {
        	users.remove(user);
        }
    }
    
    public Set<User> getUsers() {
        if (users == null) {
        	users = new HashSet<User>();
        }
        
        return Collections.unmodifiableSet(users);
    }
}
