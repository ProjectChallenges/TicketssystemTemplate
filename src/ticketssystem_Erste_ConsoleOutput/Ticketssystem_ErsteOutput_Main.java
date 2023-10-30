package ticketssystem_Erste_ConsoleOutput;
import java.util.ArrayList;

public class Ticketssystem_ErsteOutput_Main {

        public static void main(String[] args) {
            // Erstellen von Benutzern
            User user1 = new User("user1", "department1");
            User user2 = new User("user2", "department2");

            // Erstellen einer Liste von Tickets
            ArrayList<Ticket> tickets = new ArrayList<>();
            Ticket ticket1 = new Ticket(1, "Problem mit Drucker");
            Ticket ticket2 = new Ticket(2, "Software-Installation benötigt");
            tickets.add(ticket1);
            tickets.add(ticket2);

            // Zuweisen von Tickets an Benutzer
            TicketAssignment assignment1 = new TicketAssignment(1, "user1");
            TicketAssignment assignment2 = new TicketAssignment(2, "user2");

            // Ändern des Ticketstatus
            ticket1.setStatus("In Bearbeitung");
            ticket2.setStatus("Geschlossen");

            // Beispiel-Ausgabe
            System.out.println("Benutzer: " + user1.getUsername());
            System.out.println("Ticket 1 - Beschreibung: " + ticket1.getDescription());
            System.out.println("Ticket 1 - Status: " + ticket1.getStatus());
            System.out.println("Ticket 2 - Beschreibung: " + ticket2.getDescription());
            System.out.println("Ticket 2 - Status: " + ticket2.getStatus());
            System.out.println("Ticket 1 zugewiesen an: " + assignment1.getAssignedTo());
            System.out.println("Ticket 2 zugewiesen an: " + assignment2.getAssignedTo());
        }
    }


