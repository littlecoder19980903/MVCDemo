package westos.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("findUser" + connection);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id<?");
        preparedStatement.setInt(1, 5);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()) {
            System.out.print(resultSet1.getInt("id" + ""));
            System.out.print("  ");
            System.out.println(resultSet1.getString("name"));
        }
        resultSet1.close();
        preparedStatement.close();
    }
}
