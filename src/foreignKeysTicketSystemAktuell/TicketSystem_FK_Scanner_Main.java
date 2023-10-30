package foreignKeysTicketSystemAktuell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketSystem_FK_Scanner_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store tickets
        ArrayList<Ticket> tickets = new ArrayList<>();

        // Create a map to store ticket assignments
        Map<Integer, Integer> ticketAssignments = new HashMap<>();

        // Create a list to store users
        ArrayList<User> users = new ArrayList<>();

        while (true) {
            System.out.println("Ticket Management System Menu:");
            System.out.println("1. Create a new user");
            System.out.println("2. Create a new ticket");
            System.out.println("3. Assign a ticket to a user");
            System.out.println("4. Change ticket status");
            System.out.println("5. List users, their tickets, and statuses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    scanner.nextLine(); // Consume the newline character
                    String username = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    User newUser = new User(users.size() + 1, username, department);
                    users.add(newUser);
                    System.out.println("User created: " + newUser.getUsername());
                    break;
                case 2:
                    System.out.print("Enter ticket description: ");
                    scanner.nextLine(); // Consume the newline character
                    String description = scanner.nextLine();
                    Ticket newTicket = new Ticket(tickets.size() + 1, description);
                    tickets.add(newTicket);
                    System.out.println("Ticket created with ID: " + newTicket.getTicketId());
                    break;
                case 3:
                    System.out.print("Enter ticket ID: ");
                    int ticketId = scanner.nextInt();
                    System.out.print("Enter user ID to assign to: ");
                    int userId = scanner.nextInt();
                    TicketAssignment assignment = new TicketAssignment(ticketAssignments.size() + 1, ticketId, userId);
                    // Check if the ticket ID is valid
                    if (ticketId >= 1 && ticketId <= tickets.size() && userId >= 1 && userId <= users.size()) {
                        ticketAssignments.put(ticketId, userId);
                        System.out.println("Ticket " + ticketId + " assigned to User ID " + userId);
                    } else {
                        System.out.println("Invalid ticket ID or user ID.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ticket ID: ");
                    int ticketIdToUpdate = scanner.nextInt();
                    // Check if the ticket ID is valid
                    if (ticketIdToUpdate >= 1 && ticketIdToUpdate <= tickets.size()) {
                        System.out.print("Enter new status: ");
                        scanner.nextLine(); // Consume the newline character
                        String newStatus = scanner.nextLine();
                        tickets.get(ticketIdToUpdate - 1).setStatus(newStatus);
                        System.out.println("Ticket " + ticketIdToUpdate + " status updated to: " + newStatus);
                    } else {
                        System.out.println("Invalid ticket ID.");
                    }
                    break;
                case 5:
                    System.out.println("List of users, their tickets, and statuses:");
                    for (Map.Entry<Integer, Integer> entry : ticketAssignments.entrySet()) {
                        int ticketID = entry.getKey();
                        int assignedUserId = entry.getValue();
                        String assignedUser = users.get(assignedUserId - 1).getUsername();
                        String ticketStatus = tickets.get(ticketID - 1).getStatus();
                        System.out.println("User: " + assignedUser + ", Ticket ID: " + ticketID + ", Status: " + ticketStatus);
                    }
                    break;
                case 6:
                    System.out.println("Exiting Ticket Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
