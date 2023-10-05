
package ec.espe.edu.contacts.model;

/**
 *
 * @author Christian Novoa
 */
public class Contact {
    private String id;
    private String name;
    private String phoneNumber;
    private String description;

    public Contact(String id, String name, String phoneNumber, String description) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
