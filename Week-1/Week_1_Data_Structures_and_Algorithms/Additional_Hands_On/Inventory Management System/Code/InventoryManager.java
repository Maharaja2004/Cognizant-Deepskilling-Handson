package InventoryManagementSystem;

import java.util.ArrayList;
public class InventoryManager{
	ArrayList<Products> products = new ArrayList<>();

    public void addProduct(int id,String name,int quantity,double price){
        Products p = new Products();
        p.productid = id;
        p.productname = name;
        p.quantity = quantity;
        p.price = price;
        products.add(p);
        System.out.println("Product added.");
    }

    public void updateProduct(int id,String name,int quantity,double price){
        boolean f=false;
        for(Products p:products){
            if(p.productid==id){
                p.productname=name;
                p.quantity=quantity;
                p.price=price;
                System.out.println("Product updated.");
                f=true;
                break;
            }
        }
        if(!f){
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id){
        boolean f=false;
        for(int i=0;i<products.size();i++){
            if(products.get(i).productid==id){
                products.remove(i);
                System.out.println("Product deleted.");
                f=true;
                break;
            }
        }
        if(!f){
            System.out.println("Product not found.");
        }
    }

    public void searchProduct(int id){
        boolean f=false;
        for(Products p:products){
            if (p.productid==id){
                p.display();
                f=true;
                break;
            }
        }
        if(!f){
            System.out.println("Product not found.");
        }
    }

    public void displayAll(){
        if(products.size()==0){
            System.out.println("Inventory is empty.");
            return;
        }
        for(Products p:products){
            p.display();
        }
    }
}
