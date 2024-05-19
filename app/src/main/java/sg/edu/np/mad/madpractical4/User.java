package sg.edu.np.mad.madpractical4;

public class User {
    // Fields
    public String name;
    public String description;
    public int id;
    public boolean followed;

    // Constructor
    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String newDesc) {
        this.description = newDesc;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    // Getter and Setter for followed
    public boolean getFollowed() {
        return followed;
    }

    public void setFollowed(boolean newFollowed) {
        this.followed = newFollowed;
    }
}
