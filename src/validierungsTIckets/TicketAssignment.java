package validierungsTIckets;

public class TicketAssignment {
    private int ticketId;
    private String assignedTo;

    public TicketAssignment(int ticketId, String assignedTo) {
        this.ticketId = ticketId;
        this.assignedTo = assignedTo;
    }

    // Getter und Setter für ticketId und assignedTo

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
