package validierungsTIckets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ValTicketMySQL_JDBC {
    private static final Logger logger = Logger.getLogger(ValTicketMySQL_JDBC.class.getName());

    public static void main(String[] args) {

        // JDBC database connection settings

        try (Scanner scanner = new Scanner(System.in)) {
            String url = "jdbc:mysql://localhost:3306/ticket_management";
            String username = "root";
            String password = "root";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                while (true) {
                    System.out.println("Ticket Management System Menu:");
                    System.out.println("1. Create a new user");
                    System.out.println("2. Create a new ticket");
                    System.out.println("3. Assign a ticket to a user");
                    System.out.println("4. Change ticket status");
                    System.out.println("5. List users, their tickets, and statuses");
                    System.out.println("6. Exit");
                    System.out.print("Enter your choice: ");

                    int choice;
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option.");
                        scanner.next(); // Consume the invalid input
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            createUser(connection, scanner);
                            break;
                        case 2:
                            createTicket(connection, scanner);
                            break;
                        case 3:
                            assignTicket(connection, scanner);
                            break;
                        case 4:
                            updateTicketStatus(connection, scanner);
                            break;
                        case 5:
                            listUsersTicketsAndStatus(connection);
                            break;
                        case 6:
                            System.out.println("Exiting Ticket Management System.");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
            } finally {
                scanner.close();
            }
        }
    }


    private static void createUser(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        if (username != null && !username.isEmpty()) {
            String insertUserSQL = "INSERT INTO users (username, department) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, department);
                preparedStatement.executeUpdate();
            }
            System.out.println("User created: " + username);
        } else {
            throw new IllegalArgumentException("Invalid username");
        }
    }

    private static void createTicket(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ticket description: ");
        String description = scanner.nextLine();

        if (description != null && !description.isEmpty()) {
            String insertTicketSQL = "INSERT INTO tickets (description) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertTicketSQL)) {
                preparedStatement.setString(1, description);
                preparedStatement.executeUpdate();
            }
            System.out.println("Ticket created.");
        } else {
            throw new IllegalArgumentException("Invalid ticket description");
        }
    }

    private static void assignTicket(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ticket ID: ");
        if (scanner.hasNextInt()) {
            int ticketId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter username to assign to: ");
            String assignedTo = scanner.nextLine();

            if (ticketId >= 1 && assignedTo != null && !assignedTo.isEmpty()) {
                String assignTicketSQL = "INSERT INTO ticket_assignments (ticket_id, assigned_to) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(assignTicketSQL)) {
                    preparedStatement.setInt(1, ticketId);
                    preparedStatement.setString(2, assignedTo);
                    preparedStatement.executeUpdate();
                }
                System.out.println("Ticket assigned.");
            } else {
                throw new IllegalArgumentException("Invalid ticket ID or assigned username");
            }
        } else {
            System.out.println("Invalid input for ticket ID. Please enter a valid integer.");
            scanner.next(); // Consume the invalid input
        }
    }

    private static void updateTicketStatus(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ticket ID: ");
        if (scanner.hasNextInt()) {
            int ticketIdToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new status: ");
            String newStatus = scanner.nextLine();

            if (ticketIdToUpdate >= 1 && newStatus != null && !newStatus.isEmpty()) {
                String updateStatusSQL = "UPDATE tickets SET status = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateStatusSQL)) {
                    preparedStatement.setString(1, newStatus);
                    preparedStatement.setInt(2, ticketIdToUpdate);
                    preparedStatement.executeUpdate();
                }
                System.out.println("Ticket status updated.");
            } else {
                throw new IllegalArgumentException("Invalid ticket ID or new status");
            }
        } else {
            System.out.println("Invalid input for ticket ID. Please enter a valid integer.");
            scanner.next(); // Consume the invalid input
        }
    }

    private static void listUsersTicketsAndStatus(Connection connection) throws SQLException {
        String listSQL = "SELECT ta.assigned_to, t.description, t.id, t.status FROM ticket_assignments ta " +
                "JOIN tickets t ON ta.ticket_id = t.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(listSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("List of users, their tickets, and statuses:");
            while (resultSet.next()) {
                String assignedUser = resultSet.getString("assigned_to");
                String ticketDescription = resultSet.getString("description");
                int ticketID = resultSet.getInt("id");
                String ticketStatus = resultSet.getString("status");
                System.out.println("User: " + assignedUser + ", Ticket ID: " + ticketID + ", TicketDescription: " + ticketDescription + ", Status: " + ticketStatus);
            }
        }
    }
}
