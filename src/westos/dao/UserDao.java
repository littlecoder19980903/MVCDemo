package westos.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import westos.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean findUser(User user) throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("findUser" + connection);
        String sql = "select * from users where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean b = resultSet.next();
        if (b) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
        comboPooledDataSource.close();
        return !b;

    }

    public void addUser(User user) throws SQLException {
        System.out.println("添加用户");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        String sql = "insert into users(username,password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        comboPooledDataSource.close();
        System.out.println("添加完毕");
    }
}
