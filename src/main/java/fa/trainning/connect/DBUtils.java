package fa.trainning.connect;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBUtils implements AutoCloseable {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1434;databasename=PMS";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "123456";
    private Connection connection = null;

  public DBUtils() {}

  public static DBUtils getDBHelper() {
    return DBHelper.dbhelper;
  }

  public Connection getConnection() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      this.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
      return connection;
    } catch(SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void close() {
    try {
      if (connection != null) {
        this.connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static class DBHelper {
    private static final DBUtils dbhelper = new DBUtils();
  }
}
