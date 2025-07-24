-- USERS table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    `role` VARCHAR(50)
);
-- FINES table
CREATE TABLE Fines (
    fine_id INT PRIMARY KEY,
    loan_id INT,
    amount DECIMAL(5,2),
    paid VARCHAR(10),
    FOREIGN KEY (loan_id) REFERENCES Loans(loan_id)
);
-- AUTHORS table
CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    name VARCHAR(100)
);

-- CATEGORIES table
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(100)
);


-- BOOKS table
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255),
    author_id INT,
    category_id INT,
    total_copies INT,
    available_copies INT,
    FOREIGN KEY (author_id) REFERENCES Authors(author_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);


-- LOANS table
CREATE TABLE Loans (
    loan_id INT PRIMARY KEY,
    user_id INT,
    book_id INT,
    borrow_date DATE,
    return_date DATE,
    actual_return DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

