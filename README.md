# Model Exercise Series

This repository contains a series of model exercises, adapted from technical interviews. While the "content" has been modified in some cases, the essence of the exercises remains the same.

## Contents

1. **Exercise 1** - Seat Reservation System for an Amphitheater
2. **Exercise 2** - Logical Database for Ticket Management
3. **Exercise 3** - Library Management System

## Exercise Details

### Exercise 1: Seat Reservation System for an Amphitheater

**Instructions:**

1. Load the seating map with rows and seats, marking occupied seats with an "X" and available seats with an "L". Initially, all seats should be free.
2. Manage seat reservations ensuring a seat can only be reserved if it is marked as "L". If it's marked as "X", the buyer should choose another seat. Upon reservation, the seat status changes to "X".
3. The program should allow an undefined number of executions until a specific exit value is entered.
4. Only 10 rows and 10 seats exist, no overbooking is allowed.

**Considerations:**
- No GUI or database implementation needed. The focus is on logical data handling.
- Extra: If a client requests to view available seats, the system should display a graphical seating map using console output only.

### Exercise 2: Logical Database for Ticket Management

**Instructions:**

1. Create a template to store ticket data: number, row, seat, purchase date, validity date, price.
2. Use a logical database (data structure) to store an indefinite number of tickets and populate it with several tickets.
3. Create a method to iterate through the data structure and sum the prices of all tickets, displaying the total on the screen.
4. Prompt the user to enter a row number and display the ticket details for that row.

**Considerations:**
- No GUI or database implementation needed. The focus is on logical data handling.
- Extra: Implement a customer template with id, dni, name, and surname. How would it be related to the ticket so that it contains the customer’s data?

### Exercise 3: Library Management System

**Instructions:**

1. Initialization: The library has a set of available books, each with a title, author, ISBN, and status (available or loaned).
2. Member Management: The library can register members, each with an ID, name, and email.
3. Book Loans: Allow members to borrow books if available, changing the book's status to "loaned" and registering the loan date and the estimated return date (14 days from the loan).
4. Book Returns: Allow members to return books, changing the book's status back to "available".
5. Operations: Display the current status of the books (available and loaned) and the books loaned by a specific member.

**Considerations:**
- No GUI or database implementation needed. The focus is on logical data handling.
