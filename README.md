# TicketssystemTemplate

This Java application, created using IntelliJ, demonstrates a basic ticket management system with JDBC integration. The system allows users to create new users, tickets, and assign tickets to users, among other functionalities. It leverages a MySQL database for data storage and retrieval.

You will find the Main App from the Ticket System in this Java Class : [src/foreignKeysTicketSystemAktuell](https://github.com/ProjectChallenges/TicketssystemTemplate/blob/7feeb5c557d8ca9ebc7acb2028a5a6ee63375bb2/src/foreignKeysTicketSystemAktuell/TicketAssignment_FK_JDBC_FehlerBehandlung.java)

## Features

- Create new users with their respective departments
- Generate new tickets with descriptions
- Assign tickets to specific users
- Update ticket statuses
- List users along with their assigned tickets and statuses

## Requirements

- Java Development Kit (JDK)
- IntelliJ IDEA
- MySQL Database

## Getting Started

To run this ticket management system, follow these steps:

1. Clone the repository or download the source code.
2. Set up a MySQL database named `ticket_management` and ensure that it is running on `localhost:3306`.
3. Update the database connection settings in the `main` method with your MySQL credentials.
4. Run the `TicketAssignment_FK_JDBC_FehlerBehandlung` class to start the application.
5. Follow the on-screen menu options to utilize the various functionalities of the ticket system.

## Usage

The application provides a simple command-line interface (CLI) for interacting with the ticket management system. Users can create new users, tickets, assign tickets, update ticket statuses, and list users along with their tickets and statuses.

## Exception Handling

The application employs basic exception handling to manage errors related to invalid input, SQL query execution, and database connection issues. It utilizes Java's logging framework to record and display error messages during runtime.

## Contributors

- https://github.com/GallonSchimmer - Initial work






## Handbook for Implementing the Ticket Management System

### Overview

The Ticket Management System is designed to streamline the process of managing and tracking tickets within the organization. It allows for the creation of new users, generation of new tickets, assignment of tickets to users, updating ticket statuses, and listing users along with their assigned tickets and statuses.

### Setup

To implement the Ticket Management System, follow the steps outlined below:

1. Ensure that the Java Development Kit (JDK), IntelliJ IDEA, and a MySQL database are installed on the system.
2. Clone the repository or download the source code of the Ticket Management System.
3. Set up a MySQL database named `ticket_management` on `localhost:3306` or modify the database connection settings within the code to match the appropriate database credentials.
4. Compile and run the `TicketAssignment_FK_JDBC_FehlerBehandlung` class to launch the application.

### Usage Guide

1. Creating a New User:
   - Provide the username and department details for the new user as prompted by the system.

2. Creating a New Ticket:
   - Enter the ticket description to create a new ticket within the system.

3. Assigning a Ticket to a User:
   - Input the ticket ID and user ID to assign a specific ticket to a user.

4. Changing Ticket Status:
   - Enter the ticket ID and the new status to update the status of a specific ticket.

5. Listing Users, Their Tickets, and Statuses:
   - Retrieve and display a list of all users, their assigned tickets, and the corresponding statuses.

### Exception Handling

The system incorporates robust exception handling to manage various errors, including invalid input, SQL query execution failures, and database connectivity issues. It utilizes Java's logging framework to capture and display detailed error messages, ensuring effective error resolution and system stability.

### Customization

The Ticket Management System's source code can be customized and extended to meet the specific requirements of your organization. You can enhance the functionality, incorporate additional features, or refine the error handling mechanism based on your unique business needs.

