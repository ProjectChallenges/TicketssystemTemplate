package ticketssystem_Swing_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ticketssystem_Swing_GUI_Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ticket Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        ArrayList<Ticket> tickets = new ArrayList<>();
        Map<Integer, String> ticketAssignments = new HashMap<>();
        ArrayList<User> users = new ArrayList<>(); // Added to store users

        JButton createUserButton = new JButton("Create a new user"); // New user creation button
        JButton createButton = new JButton("Create a new ticket");
        JButton assignButton = new JButton("Assign a ticket to a user");
        JButton changeStatusButton = new JButton("Change ticket status");
        JButton listButton = new JButton("List users, their tickets, and statuses");
        JButton exitButton = new JButton("Exit");

        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter username:");
                String password = JOptionPane.showInputDialog("Enter department:");
                User newUser = new User(username, password);
                users.add(newUser);
                JOptionPane.showMessageDialog(frame, "User created: " + newUser.getUsername());
            }
        });

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String description = JOptionPane.showInputDialog("Enter ticket description:");
                Ticket newTicket = new Ticket(tickets.size() + 1, description);
                tickets.add(newTicket);
                JOptionPane.showMessageDialog(frame, "Ticket created with ID: " + newTicket.getTicketId());
            }
        });

        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ticketIdStr = JOptionPane.showInputDialog("Enter ticket ID:");
                int ticketId = Integer.parseInt(ticketIdStr);
                String assignedTo = JOptionPane.showInputDialog("Enter username to assign to:");
                if (ticketId >= 1 && ticketId <= tickets.size()) {
                    ticketAssignments.put(ticketId, assignedTo);
                    JOptionPane.showMessageDialog(frame, "Ticket " + ticketId + " assigned to " + assignedTo);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid ticket ID.");
                }
            }
        });

        changeStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ticketIdStr = JOptionPane.showInputDialog("Enter ticket ID:");
                int ticketIdToUpdate = Integer.parseInt(ticketIdStr);
                if (ticketIdToUpdate >= 1 && ticketIdToUpdate <= tickets.size()) {
                    String newStatus = JOptionPane.showInputDialog("Enter new status:");
                    tickets.get(ticketIdToUpdate - 1).setStatus(newStatus);
                    JOptionPane.showMessageDialog(frame, "Ticket " + ticketIdToUpdate + " status updated to: " + newStatus);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid ticket ID.");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder listText = new StringBuilder("List of users, their tickets, and statuses:\n");
                for (Map.Entry<Integer, String> entry : ticketAssignments.entrySet()) {
                    int ticketID = entry.getKey();
                    String assignedUser = entry.getValue();
                    String ticketStatus = tickets.get(ticketID - 1).getStatus();
                    listText.append("User: ").append(assignedUser).append(", Ticket ID: ").append(ticketID).append(", Status: ").append(ticketStatus).append("\n");
                }
                JOptionPane.showMessageDialog(frame, listText.toString());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(createUserButton);
        panel.add(createButton);
        panel.add(assignButton);
        panel.add(changeStatusButton);
        panel.add(listButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
