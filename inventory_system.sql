-- Create schema
CREATE SCHEMA IF NOT EXISTS inventory_system;

-- Use the schema
USE inventory_system;

-- Create Inventory table
CREATE TABLE Inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    location VARCHAR(20) NOT NULL,
    capacity INT NOT NULL,
    pincode INT NOT NULL
);

-- Create product table
CREATE TABLE product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20) NOT NULL,
    product_description VARCHAR(100) NOT NULL,
    category VARCHAR(15) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

-- Create Inventory_clerk table
CREATE TABLE Inventory_clerk (
    clerk_id INT PRIMARY KEY AUTO_INCREMENT,
    clerk_name VARCHAR(25) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    c_password VARCHAR(20) NOT NULL,
    lastmod VARCHAR(20) NOT NULL
);

-- Insert demo values into product table
INSERT INTO product (product_name, product_description, category, quantity, price) VALUES
('Product 1', 'Description 1', 'Category A', 10, 20.00),
('Product 2', 'Description 2', 'Category B', 15, 25.50),
('Product 3', 'Description 3', 'Category C', 20, 30.75),
('Product 4', 'Description 4', 'Category A', 5, 15.25),
('Product 5', 'Description 5', 'Category B', 12, 22.80),
('Product 6', 'Description 6', 'Category C', 18, 35.00),
('Product 7', 'Description 7', 'Category A', 8, 18.90),
('Product 8', 'Description 8', 'Category B', 25, 28.60),
('Product 9', 'Description 9', 'Category C', 30, 40.00),
('Product 10', 'Description 10', 'Category A', 13, 17.50),
('Product 11', 'Description 11', 'Category B', 17, 24.75),
('Product 12', 'Description 12', 'Category C', 22, 32.00),
('Product 13', 'Description 13', 'Category A', 9, 21.30),
('Product 14', 'Description 14', 'Category B', 20, 26.50),
('Product 15', 'Description 15', 'Category C', 28, 38.25);

-- Insert demo values into Inventory table
INSERT INTO Inventory (location, capacity, pincode) VALUES
('Location 1', 100, 12345),
('Location 2', 150, 23456),
('Location 3', 200, 34567);

-- Insert demo values into Inventory_clerk table
INSERT INTO Inventory_clerk (clerk_name, email, c_password, lastmod) VALUES
('Clerk 1', 'clerk1@example.com', 'password1', '2024-04-02'),
('Clerk 2', 'clerk2@example.com', 'password2', '2024-04-02'),
('Clerk 3', 'clerk3@example.com', 'password3', '2024-04-02');

COMMIT;
