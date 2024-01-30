-- Create the customer table
DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    customer_id SERIAL PRIMARY KEY,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    email       VARCHAR(100),
    address     VARCHAR(255)
);

-- Create the stored procedure to find a customer by email
CREATE OR REPLACE FUNCTION find_customer_by_email(pEmail VARCHAR)
RETURNS SETOF customer AS
$$
BEGIN
    RETURN QUERY SELECT * FROM customer WHERE email = pEmail;
END;
$$
LANGUAGE PLPGSQL;