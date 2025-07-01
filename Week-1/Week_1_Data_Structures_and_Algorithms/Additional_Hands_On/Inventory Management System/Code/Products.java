package InventoryManagementSystem;

public class Products {
	int productid;
    String productname;
    int quantity;
    double price;

    public void display(){
        System.out.println("ID: " + productid + ", Name: " + productname +
                ", Quantity: " + quantity + ", Price: ₹" + price);
    }
}
