import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String dbUserName="root";
    private String dbPassword="";
    private String dbUrl="jdbc:mysql://localhost:3306/sirket";

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
    }
    public void showErrorMessage(SQLException sqlException){
        System.out.println(sqlException.getMessage());
        System.out.println(sqlException.getErrorCode());
    }

}
