package foreignKeysTicketSystemAktuell;

public class User {
    private int id;
    private String username;
    private String department;

    public User(int id, String username, String department) {
        this.id = id;
        this.username = username;
        this.department = department;
    }

    // Getter und Setter für id, username und department

    public void setUserId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }


}

