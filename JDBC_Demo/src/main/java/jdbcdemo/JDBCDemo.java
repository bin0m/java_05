package jdbcdemo;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Driver driver = new org.postgresql.Driver();
        Class.forName("org.postgresql.Driver");

        // Соединение с БД
        String userName = "postgres";
        String password = "123";
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", userName, password);
        // Создаём SQL-оператор
        Statement query = con.createStatement();
        // Получаем результаты
        ResultSet resultSet = query.executeQuery("SELECT * FROM \"user\" ORDER BY NAME");
        while (resultSet.next()) { // Пока есть результаты
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();

        resultSet = query.executeQuery("SELECT * FROM \"user\" ORDER BY NAME");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + " = " + resultSet.getString(i));
            }
        }
        resultSet.close();


    }
}
