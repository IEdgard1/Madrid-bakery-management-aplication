
package bakery;
import javax.swing.JOptionPane;
public class Employees {
    public int id;
    public String name;
    public String surname;
    public String email;
    public String password;
    
    public Employees(){
        
    }
    
     public Employees(int id,String name, String surname,String email, String password ) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Employees(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
     
     
     
     public int getid() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
     
     

    
    @Override
    public String toString() {
       return   "\n" + name + "\n" + surname + "\n"  + "\n"+ email  +"\n" + password  ;
     }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
