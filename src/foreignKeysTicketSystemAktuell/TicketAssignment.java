package foreignKeysTicketSystemAktuell;

public class TicketAssignment {

    private int id;
    private int ticketId;
    private int userId;


    public TicketAssignment(int id, int ticketId, int userId) {
        this.id = id;
        this.ticketId = ticketId;
        this.userId = userId;
    }


    // Getter und Setter für ticketId und userId

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }


    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }


}
