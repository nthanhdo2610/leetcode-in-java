import com.github.javafaker.Faker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnection {

    // JDBC URL, username, and password of PostgresSQL server
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "admin";
    private static final String password = "admin12345";
    private static final String SQL_QUERY_INSERT = "INSERT INTO customer (first_name, last_name, email, address) VALUES (?, ?, ?, ?)";
    private static final String SQL_QUERY_SELECT = "SELECT * FROM customer WHERE email = ?";
    private static final String FN_FIND_CUSTOMER_BY_EMAIL = "{CALL fn_find_customer_by_email(?)}";


    public static void main(String[] args) {

//        initCustomerData();
//        List<Customer> customers = findCustomer();
        List<Customer> customers = findCustomerByEmail("christiane.roob@gmail.com");
        System.out.println(customers.size());

    }

    public static List<Customer> findCustomerByEmail(String emailAddress) {
        Connection connection = null;
//        PreparedStatement preparedStatement;
        CallableStatement callableStatement;
        ResultSet resultSet;

        List<Customer> result = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, password);

            // Create a query statement with a condition
            callableStatement = connection.prepareCall(FN_FIND_CUSTOMER_BY_EMAIL);
            callableStatement.setString(1, emailAddress);

//            preparedStatement = connection.prepareStatement(SQL_QUERY_SELECT);
//            preparedStatement.setString(1, emailAddress);

            // Execute the query
            resultSet = callableStatement.executeQuery();
//            resultSet = preparedStatement.executeQuery();

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
            callableStatement.close();
//            preparedStatement.close();
            resultSet.close();

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
    public static List<Customer> findCustomer() {
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        List<Customer> result = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, password);

            // Create a query statement with a condition
            preparedStatement = connection.prepareStatement(SQL_QUERY_SELECT);

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

            // Close the prepared statement
            preparedStatement.close();

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

        insert(customers);
    }

    private static void insert(List<Customer> customers) {

        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            // Open a connection
            connection = DriverManager.getConnection(url, user, password);
            // Disable auto-commit for batch processing
            connection.setAutoCommit(false);

            // Create a query statement with placeholders
            preparedStatement = connection.prepareStatement(SQL_QUERY_INSERT);

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
