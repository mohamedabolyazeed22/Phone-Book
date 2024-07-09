
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import raven.toast.Notifications;


public class databaseConnection {
    public static Connection con;
 
    public databaseConnection() {
        connect();
    }
    
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookDB","root","PHW#84#jeor");
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING,"There is no Connection With Database!");
        }
    }
}
