import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProblem {

    // JDBC URL, username, and password of PostgresSQL server
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "admin";
    private static final String password = "admin12345";


    public static void main(String[] args) {

//        initCustomerData();
        findCustomer();

    }

    public static List<Customer> findCustomer() {
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        List<Customer> result = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, password);

            // Create a query statement with a condition
            String sqlQuery = "SELECT * FROM customer WHERE email LIKE '%@gmail.com'";
            preparedStatement = connection.prepareStatement(sqlQuery);

            // Execute the query
            resultSet = preparedStatement.executeQuery();
            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("customer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                result.add(new Customer(id, firstName, lastName, email, address));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void initCustomerData() {
        // Use Faker to generate sample data
        Faker faker = new Faker();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // Generate random data
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = faker.internet().emailAddress();
            String address = faker.address().fullAddress();
            customers.add(new Customer(firstName, lastName, email, address));
        }

        insertSampleCustomers(customers);
    }

    private static void insertSampleCustomers(List<Customer> customers) {

        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            // Open a connection
            connection = DriverManager.getConnection(url, user, password);
            // Disable auto-commit for batch processing
            connection.setAutoCommit(false);

            // Create a query statement with placeholders
            String sqlQuery = "INSERT INTO customer (first_name, last_name, email, address) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);

            // Insert 100 sample customer records
            for (Customer customer : customers) {
                // Set values for the prepared statement
                preparedStatement.setString(1, customer.firstName);
                preparedStatement.setString(2, customer.lastName);
                preparedStatement.setString(3, customer.email);
                preparedStatement.setString(4, customer.address);

                // Add the statement to the batch
                preparedStatement.addBatch();

                // Execute the query
                // preparedStatement.executeUpdate();
            }
            // Execute the batch
            int[] batchResult = preparedStatement.executeBatch();

            // Commit the transaction
            connection.commit();

            // Close the prepared statement
            preparedStatement.close();
            System.out.println("Sample customer records inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
