package net.catosplace.pojo;

import java.io.Serializable;

/**
 * Customer POJO
 * 
 * @author ps1336
 */
public final class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor for persistence service loading.
     */
    public Customer() {

    }

    /**
     * Minimal business constructor
     *
     * @param firstName
     */
    public Customer(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Full Constructor
     *
     * @param id
     * @param firstName
     */
    public Customer(final String id, final String firstName) {
        this(firstName);
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
