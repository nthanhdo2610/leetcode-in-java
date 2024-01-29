-- Create the customer table
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
                          customer_id SERIAL PRIMARY KEY,
                          first_name VARCHAR(50),
                          last_name VARCHAR(50),
                          email VARCHAR(100),
                          address VARCHAR(255)
);