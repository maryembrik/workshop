package Utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class MyDb {
    String URL="jdbc:mysql://localhost:3306/workshop";
    String user="root";
    String password=" ";
    private Connection con;
    static MyDb instance;

    private MyDb() {
        try {
            this.con = DriverManager.getConnection(URL, user, password);
            System.out.println("connection established ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public static MyDb getInstance() {
        if (instance==null){
            instance=new MyDb();
        }
        return instance;
    }

    public void setInstance(MyDb instance) {
        this.instance = instance;
    }
    public Connection getCon() {
        return con;
    }

}
