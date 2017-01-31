package net.thoughtforge.model;

public class UserToken extends PersistentEntity {

	private static final long serialVersionUID = 530610082542538384L;

	private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
