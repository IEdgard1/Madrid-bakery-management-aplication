
package bakery;

public class Customers {
    public int id;
    public String name;
    public String phone_number;
    public String email;
    public String adresse;
    
    public Customers(){
    
}
    public Customers(int id,String name,String phone_number,String email,String adresse){
        this.id= id;
        this.name= name;
        this.phone_number= phone_number;
        this.email= email;
        this.adresse= adresse;
    }

    public Customers(String name, String phone_number, String email, String adresse) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.adresse = adresse;
    }
  
    
    
    public int getid()
    {
        return id;
    }
    public String getname(){return name;}
    public String getphone_number(){return phone_number;}
    public String getemail(){return email;}
    public String getadresse(){return adresse;} 
    
     @Override
    public String toString() {
       return id + "\n" + name + "\n" + phone_number + "\n" + email + "\n" +adresse ;
     }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
