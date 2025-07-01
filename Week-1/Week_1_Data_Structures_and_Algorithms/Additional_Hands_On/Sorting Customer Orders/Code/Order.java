package SortCustomerOrders;

public class Order {
	private int orderid;
    private String customername;
    private double totalprice;

    public void setOrderId(int orderid){
        this.orderid=orderid;
    }

    public void setCustomerName(String customername){
        this.customername=customername;
    }

    public void setTotalPrice(double totalprice){
        this.totalprice=totalprice;
    }

    public int getOrderId(){
        return orderid;
    }

    public String getCustomerName(){
        return customername;
    }

    public double getTotalPrice(){
        return totalprice;
    }

    public void display(){
        System.out.println("Order ID: " + orderid + ", Name: " + customername + ", Total: ₹" + totalprice);
    }
}
