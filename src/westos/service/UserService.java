package westos.service;

import westos.bean.User;
import westos.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    public boolean addUser(User user) throws SQLException {
        //组织业务逻辑
        UserDao userDao = new UserDao();
        boolean b = userDao.findUser(user);
        if (b) {
            //b==true
            //数据库中不存在该用户，可以进行注册
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            userDao.addUser(user);
        }
        System.out.println(b);
        return b;
    }
}
