package ticketssystem_Swing_GUI;

public class User {
    private String username;
    private String department;

    public User(String username, String department) {
        this.username = username;
        this.department = department;
    }

    // Getter und Setter für username und password

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
