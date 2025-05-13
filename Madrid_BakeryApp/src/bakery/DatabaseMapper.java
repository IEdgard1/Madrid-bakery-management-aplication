

package bakery;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMapper {
    

    //private DatabaseConfig dbc = null;
    private DatabaseConfig dbc=null;
    private Connection con=null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
  
    
    public DatabaseMapper(){
        dbc= new DatabaseConfig();
        con=dbc.getCon();    
    }
    
    public int signup(Employees employee){
        String req = "INSERT INTO employees (name, surname,email,password) values (?,?,?,?)";
        try{
            pstmt = con.prepareStatement(req);
           
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getSurname());
            pstmt.setString(3, employee.getEmail()); 
            pstmt.setString(4, employee.getPassword());
            
            int k=pstmt.executeUpdate();
            return k;
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return 0;
    }
    
    
    public  boolean login(int id,String name, String surname, String email,String password)
    {
        String sql = "SELECT * FROM employees WHERE name = '"+name+""+"'and surname = '"+surname+"' and email='"+email+"'and password='"+password+"'";
        boolean s = false;
        
        try
        {
          stmt = con.createStatement();
          rs = stmt.executeQuery(sql);
          while (rs.next())
          {
              s = true;
          }
          
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }return s;
    }
 
    
    
    public List<Employees> getEmployee()
    {
       List<Employees> employee = new ArrayList<>();
       String req = "SELECT * FROM employees";
       
       try
       {
           stmt = con.createStatement();
           rs = stmt.executeQuery(req);
        
        while(rs.next())
        {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email= rs.getString("email");
            String password = rs.getString("password");
            Employees e = new Employees(id,name,surname,email,password);
            employee.add(e);
        }
       }
       catch (SQLException ex)
       {
           System.err.println(ex.getMessage());
       }
       return employee;
    }
    
    public List<Customers>getCustomer()
    {
         List<Customers> customer = new ArrayList<>();
       String req = "SELECT * FROM customers";
       
       try
       {
           stmt = con.createStatement();
           rs = stmt.executeQuery(req);
        
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phone_number = rs.getString("phone_number");
            String email = rs.getString("email");
            String adresse = rs.getString("adresse");
            Customers c = new Customers(id,name,phone_number,email,adresse);
            customer.add(c);           
        }
       }
       catch (SQLException ex)
       {
           System.err.println(ex.getMessage());
       }
       return customer;
    }
    
    public List<Products>getProduct() 
    {
        List<Products> product = new ArrayList<>();
       String req = "SELECT * FROM products";
       
       try
       {
           stmt = con.createStatement();
           rs = stmt.executeQuery(req);
           
           while(rs.next())
           {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String price = rs.getString("price");
               String quantity = rs.getString("quantity");
               Products p = new Products(id,name,price,quantity);
               product.add(p);
           }
        } 
       catch (SQLException ex)
       {
          System.err.println(ex.getMessage());
       }
       return product;
    }
    
    public List<Orders>getOrder()
    {
        List<Orders> order = new ArrayList<>();
        String req = "SELECT * FROM orders";
        
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery(req);
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String customer_id= rs.getString("customer_id");
                String order_date = rs.getString("order_date");
                int product_id = rs.getInt("product_id");
                int unit_price =rs.getInt("unit_price");
                String total_amount = rs.getString("total_amount");
                String payment_method = rs.getString("payment_method");
                
                Orders o = new Orders(id,customer_id,order_date,product_id,unit_price,total_amount, payment_method);
                order.add(o);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return order;
    }
    
    /**
     *
     * @param c
     * @return
     */
    public int saveEmployee(Employees e)
            {
               String req ="INSERT INTO Employees(name,surname,email,password) values (?,?,?,?)";
               try
               {
                  pstmt=con.prepareStatement(req);
                  
                  pstmt.setString(1,e.getName());
                  pstmt.setString(2,e.getSurname());
                  pstmt.setString(3,e.getEmail());
                  pstmt.setString(4, e.getPassword());
                  int b=pstmt.executeUpdate();
                  return b;
               }catch(SQLException ex)
               {
                  System.err.println(ex.getMessage());
               }
                 return 0;                       
            }
    
    public int updateEmployee(Employees e)
    {
       String sql = "Update Employees SET name=?,surname=?,email=?,pasword=? WHERE id=?";
       try
       {
        
           pstmt =con.prepareStatement(sql);
           pstmt.setString(1,e.getName());
           pstmt.setString(2,e.getSurname());
           pstmt.setString(3,e.getEmail());
           pstmt.setString(4,e.getPassword());
           pstmt.setInt(5,e.getid());
           return pstmt.executeUpdate();
       }catch(SQLException ex)
       
           {
              System.err.println();
           }
           return 0;
    
    }
     
    
   public int deleteEmployees ( int id)
    {
        String sql = "DELETE FROM Employees WHERE id=?";
        try
        {
             pstmt=con.prepareStatement(sql);
             pstmt.setInt(1,id);
             int nlm=pstmt.executeUpdate();
             return nlm;
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }      
    
    public int saveCustomer( Customers c)
    {
        String req = "INSERT INTO Customers (name,phone_number,email,adresse)VALUE (?,?,?,?)";
        
        try{
            pstmt=con.prepareStatement(req);
           
            pstmt.setString(1,c.getname());
            pstmt.setString(2,c.getphone_number());
            pstmt.setString(3, c.getemail());
            pstmt.setString(4,c.getadresse());
            int b= pstmt.executeUpdate();
            return b;
        }
        catch(SQLException ex)
        {
              System.err.println(ex.getMessage());
        }
        return 0;
    }
    
    public int updateCustomer( Customers c)
    {
        String sql = "Update Customers SET name=?,phone_number=?,email=?,adresse=? WHERE  id=?";
        try
        {
           pstmt=con.prepareStatement(sql);
           
            pstmt.setString(1,c.getname());
            pstmt.setString(2,c.getphone_number());
            pstmt.setString(3, c.getemail());
            pstmt.setString(4,c.getadresse());
             pstmt.setInt(5,c.getid());
            return pstmt.executeUpdate();   
            
        }catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteCustomers ( int id)
    {
        String sql = "DELETE FROM Customers WHERE id=?";
        try
        {
             pstmt=con.prepareStatement(sql);
             pstmt.setInt(1,id);
             int nlm=pstmt.executeUpdate();
             return nlm;
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    
    
     public int saveOrder( Orders o )
    {
        String req = "INSERT INTO Orders (customer_id,order_date,product_id,unit_price,total_amount,payment_method)VALUE (?,?,?,?,?,?)";
        
        try{
            pstmt=con.prepareStatement(req);    
            pstmt.setString(1,o.getcustomer_id());
            pstmt.setString(2, o.getorder_date());
            pstmt.setInt(3,o.getproduct_id());
            pstmt.setInt(4,o.getunit_price());
            pstmt.setString(5,o.gettotal_amount());
            pstmt.setString(6,o.getpayment_method());
            
            int b= pstmt.executeUpdate();
            return b;
        }
        catch(SQLException ex)
        {
              System.err.println(ex.getMessage());
        }
        return 0;
    }
     
     
     
    public int updateOrders( Orders  o)
    {
        String sql ="UPDATE Orders SET customer_id =?,order_date=?,product_id=?,unit_price=?,total_amount=?,payment_method=? WHERE id=?" ;
        try
        {
            pstmt=con.prepareStatement(sql);    
            pstmt.setString(1,o.getcustomer_id());
            pstmt.setString(2, o.getorder_date());
            pstmt.setInt(3,o.getproduct_id());
            pstmt.setInt(4,o.getunit_price());
            pstmt.setString(5,o.gettotal_amount());
            pstmt.setString(6,o.getpayment_method());
             pstmt.setInt(7,o.getid()); 
            return pstmt.executeUpdate();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
        
    }
    
    public int deleteOrders ( int id)
    {
        String sql = "DELETE FROM Orders WHERE id=?";
        try
        {
            pstmt=con.prepareStatement(sql);
             pstmt.setInt(1,id);
             int nlm=pstmt.executeUpdate();
             return nlm; 
        }catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        return 0;
    }
    
     public int saveProducts( Products p )
    {
        String req  = "INSERT INTO Products (name,price,quantity)VALUE (?,?,?)";
        
        try{
            pstmt=con.prepareStatement(req);
            
            
            pstmt.setString(1,p.getname());
            pstmt.setString(2, p.getprice());
            pstmt.setString(3,p.getquantity());
            int b= pstmt.executeUpdate();
            return b;
        }
        catch(SQLException ex)
        {
              System.err.println(ex.getMessage());
        }
        return 0;
    }
     
     public int updateProducts( Products  p)
    {
        String req ="UPDATE Products SET name=?,price=?,quantity=? WHERE id=?" ;
        try{
            pstmt=con.prepareStatement(req);
            pstmt.setString(1,p.getname());
            pstmt.setString(2, p.getprice());
            pstmt.setString(3,p.getquantity());
            pstmt.setInt(4,p.getid()); 
            return pstmt.executeUpdate();
        }catch(SQLException e)           
        {
            System.err.println(e.getMessage());
        }
        return 0;
        }      
     public int deleteProducts (int id)
    {
        String sql = "DELETE FROM Products WHERE id=?";
        try
        {
            pstmt=con.prepareStatement(sql);
             pstmt.setInt(1,id);
             int nlm=pstmt.executeUpdate();
             return nlm; 
        }catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        return 0;
    }
}
     
     
     



 

