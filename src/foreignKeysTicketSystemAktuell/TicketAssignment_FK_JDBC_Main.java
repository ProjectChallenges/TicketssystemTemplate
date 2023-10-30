package foreignKeysTicketSystemAktuell;

import java.sql.*;
import java.util.Scanner;

public class TicketAssignment_FK_JDBC_Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // JDBC database connection settings
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

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createUser(connection);
                        break;
                    case 2:
                        System.out.print("Enter ticket description: ");
                        scanner.nextLine(); // Consume the newline character
                        String description = scanner.nextLine();
                        insertNewTicket(connection, description);
                        System.out.println("Ticket created.");
                        break;
                    case 3:
                        System.out.print("Enter ticket ID: ");
                        int ticketId = scanner.nextInt();
                        System.out.print("Enter user ID to assign to: ");
                        scanner.nextInt(); // Consume the newline character
                        int userId = scanner.nextInt();
                        assignTicketToUser(connection, ticketId, userId);
                        System.out.println("Ticket assigned.");
                        break;
                    case 4:
                        System.out.print("Enter ticket ID: ");
                        int ticketIdToUpdate = scanner.nextInt();
                        System.out.print("Enter new status: ");
                        scanner.nextLine(); // Consume the newline character
                        String newStatus = scanner.nextLine();
                        updateTicketStatus(connection, ticketIdToUpdate, newStatus);
                        System.out.println("Ticket status updated.");
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
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void createUser(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        String insertUserSQL = "INSERT INTO users (username, department) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, department);
            preparedStatement.executeUpdate();
        }
        System.out.println("User created: " + username);
    }

    private static void insertNewTicket(Connection connection, String description) throws SQLException {
        String insertTicketSQL = "INSERT INTO tickets (description) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTicketSQL)) {
            preparedStatement.setString(1, description);
            preparedStatement.executeUpdate();
        }
    }

    private static void assignTicketToUser(Connection connection, int ticketId, int userId) throws SQLException {
        String assignTicketSQL = "INSERT INTO ticket_assignments (ticket_id, user_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(assignTicketSQL)) {
            preparedStatement.setInt(1, ticketId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        }
    }

    private static void updateTicketStatus(Connection connection, int ticketId, String newStatus) throws SQLException {
        String updateStatusSQL = "UPDATE tickets SET status = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateStatusSQL)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, ticketId);
            preparedStatement.executeUpdate();
        }
    }

    private static void listUsersTicketsAndStatus(Connection connection) throws SQLException {
        String listSQL = "SELECT u.username, ta.user_id, t.id, t.status " +
                "FROM ticket_assignments ta " +
                "JOIN tickets t ON ta.ticket_id = t.id " +
                "JOIN users u ON ta.user_id = u.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(listSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("List of users, their tickets, and statuses:");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int assignedUserID = resultSet.getInt("user_id");
                int ticketID = resultSet.getInt("id");
                String ticketStatus = resultSet.getString("status");
                System.out.println("Username: " + username + ", UserID: " + assignedUserID + ", Ticket ID: " + ticketID + ", Status: " + ticketStatus);
            }
        }
    }

}