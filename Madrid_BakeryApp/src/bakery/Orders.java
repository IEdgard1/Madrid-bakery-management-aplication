
package bakery;

import javax.swing.JOptionPane;

public class Orders {
    public int id;
    public String customer_id;
    public String order_date;
    public int product_id;
    public int unit_price;
    public String total_amount;
    public String payment_method;
    
    public Orders()
    {
        
    }
    
    public Orders (int id,String customer_id,String order_date,int product_id,int unit_price,String total_amount,String payment_method)
    {
        this.id= id;
        this.customer_id= customer_id;
        this.order_date= order_date;
        this.product_id= product_id;
        this.unit_price= unit_price;
        this.total_amount= total_amount;
        this.payment_method= payment_method;
    }
    
    public Orders (String customer_id,String order_date,int product_id,int unit_price,String total_amount,String payment_method)
    {
        this.customer_id= customer_id;
        this.order_date= order_date;
        this.product_id= product_id;
        this.unit_price= unit_price;
        this.total_amount= total_amount;
        this.payment_method= payment_method;
    }
    public Orders (int id){
        this.id= id;
    }
    
    public int getid(){return id;}
    public String getcustomer_id(){return customer_id;}
    public String getorder_date(){return order_date;}
    public int getproduct_id (){return product_id;}
    public int getunit_price (){return unit_price;}
    public String gettotal_amount(){return total_amount;}
    public String getpayment_method(){return payment_method;}
    
    
    
     @Override
    public String toString() {
       return id + "\n" + customer_id + "\n" +order_date + "\n"+product_id+"\n"+unit_price+"\n" + total_amount + "\n +is_paid" + "\n" +payment_method ;
     }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
