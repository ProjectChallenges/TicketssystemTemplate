package ticketssystem_Scanner;

public class Ticket {
    private int ticketId;
    private String description;
    private String status;

    public Ticket(int ticketId, String description) {
        this.ticketId = ticketId;
        this.description = description;
        this.status = "Offen"; // Der Status eines neuen Tickets ist "Offen" per Default.
    }

    // Getter und Setter für ticketId, description und status

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

