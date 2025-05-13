
package bakery;

public class Products {
    public int id;
    public String name;
    public String price;
    public String quantity;
    
    public Products(){
        
    }
    
    public Products (int id,String name,String price,String quantity){
        this.id= id;
        this.name= name;
        this.price= price;
        this.quantity= quantity;
    } 
    
    public Products (String name,String price,String quantity){
        this.name= name;
        this.price= price;
        this.quantity= quantity;
    } 
    
  
    
    public int getid(){return id;}
    public String getname(){return name;}
    public String getprice(){return price;}
    public String getquantity(){return quantity;}
    
     @Override
    public String toString() {
       return id + "\n" + name + "\n" + price + "\n" + quantity ;
     }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

