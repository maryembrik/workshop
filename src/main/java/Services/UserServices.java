package Services;

import Models.User;
import Utiles.MyDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServices implements CRUD<User> {
    Connection con;

    public UserServices() {
        this.con = MyDb.getInstance().getCon();
    }

    @Override
    public void insert(User obj) throws Exception {
        String query = "INSERT user(firstname,lastename,age) VALUES('" + obj.getFirstName() + "','" + obj.getLastName() + "','" + obj.getAge() +"')";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }

    @Override
    public void update(User obj) throws Exception {
        String query = "update user set firstname=?, lastName = ?, age = ? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, obj.getFirstName());
        stmt.setString(2, obj.getLastName());
        stmt.setInt(3, obj.getAge());
        stmt.setInt(4, obj.getId());
        stmt.executeUpdate();
    }

    @Override
    public List<User> find() throws SQLException {
        String query = "Select * FROM user";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setAge(rs.getInt("age"));
            user.setId(rs.getInt("id"));
            users.add(user);

        }
        return users;

    }

    @Override
    public void delete(User obj) throws SQLException {

    }
}
