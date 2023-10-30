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
