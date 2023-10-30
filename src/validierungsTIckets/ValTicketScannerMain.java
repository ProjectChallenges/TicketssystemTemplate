package validierungsTIckets;

import java.util.*;

public class ValTicketScannerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store tickets
        ArrayList<Ticket> tickets = new ArrayList<>();

        // Create a map to store ticket assignments
        Map<Integer, String> ticketAssignments = new HashMap<>();

        while (true) {
            try {
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
                        if (username != null && !username.isEmpty()) {
                            User newUser = new User(username, department);
                            System.out.println("User created: " + newUser.getUsername());
                        } else {
                            throw new IllegalArgumentException("Invalid username");
                        }
                        break;
                    case 2:
                        System.out.print("Enter ticket description: ");
                        scanner.nextLine(); // Consume the newline character
                        String description = scanner.nextLine();
                        if (description != null && !description.isEmpty()) {
                            Ticket newTicket = new Ticket(tickets.size() + 1, description);
                            tickets.add(newTicket);
                            System.out.println("Ticket created with ID: " + newTicket.getTicketId());
                        } else {
                            throw new IllegalArgumentException("Invalid ticket description");
                        }
                        break;
                    case 3:
                        System.out.print("Enter ticket ID: ");
                        int ticketId = scanner.nextInt();
                        System.out.print("Enter username to assign to: ");
                        scanner.nextLine(); // Consume the newline character
                        String assignedTo = scanner.nextLine();
                        if (ticketId >= 1 && ticketId <= tickets.size() && assignedTo != null && !assignedTo.isEmpty()) {
                            TicketAssignment assignment = new TicketAssignment(ticketId, assignedTo);
                            ticketAssignments.put(ticketId, assignedTo);
                            System.out.println("Ticket " + ticketId + " assigned to " + assignedTo);
                        } else {
                            throw new IllegalArgumentException("Invalid ticket ID or assigned username");
                        }
                        break;
                    case 4:
                        System.out.print("Enter ticket ID: ");
                        int ticketIdToUpdate = scanner.nextInt();
                        if (ticketIdToUpdate >= 1 && ticketIdToUpdate <= tickets.size()) {
                            System.out.print("Enter new status: ");
                            scanner.nextLine(); // Consume the newline character
                            String newStatus = scanner.nextLine();
                            tickets.get(ticketIdToUpdate - 1).setStatus(newStatus);
                            System.out.println("Ticket " + ticketIdToUpdate + " status updated to: " + newStatus);
                        } else {
                            throw new IllegalArgumentException("Invalid ticket ID");
                        }
                        break;
                    case 5:
                        System.out.println("List of users, their tickets, and statuses:");
                        for (Map.Entry<Integer, String> entry : ticketAssignments.entrySet()) {
                            int ticketID = entry.getKey();
                            String assignedUser = entry.getValue();
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
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine(); // clear the invalid input
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

