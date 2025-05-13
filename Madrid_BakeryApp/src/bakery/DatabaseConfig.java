
package bakery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConfig {
    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3306/madrid_bakery";
    private final String user = "root";
    private final String password = "";
    
   
    public DatabaseConfig(){
        
                try{
                    con = DriverManager.getConnection(url, user, password);
                    System.out.println("connection to DB established");
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
    }
    public Connection getCon(){return con;}
}
