package Ecommerce;

import java.util.Scanner;

public class ProductSearch {
      
	public static Product linearSearch(Product[] products,int id) {
		for(int i=0;i<products.length;i++) {
			if(products[i].productId==id) {
				return products[i];
			}
		}
		return null;
	}
	
	public static Product binarySearch(Product[] products, int id) {
		int l=0;
		int r=products.length-1;
		
		while(l<=r) {
			int mid=(l+r)/2;
			
			if(products[mid].productId==id) {
				return products[mid];
			}
			else if(products[mid].productId<id){
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		return null;
	}
	
	public static void sorting(Product[] products) {
		int n=products.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(products[j].productId>products[j+1].productId) {
					Product temp=products[j];
					products[j]=products[j+1];
					products[j+1]=temp;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of products:");
			int n=sc.nextInt();
			sc.nextLine();
			
			Product[] products=new Product[n];
			
			for(int i=0;i<n;i++) {
				products[i]=new Product();
				 System.out.println("Enter details for Product " + (i + 1));
				 
				 System.out.print("Product ID: ");
		         products[i].productId = sc.nextInt();
		         sc.nextLine();
		         
		         System.out.print("Product Name: ");
		         products[i].productName = sc.nextLine();

		         System.out.print("Category: ");
		         products[i].category = sc.nextLine();
		         
		         
			}
			System.out.println("Enter your id to search");
	         int sid=sc.nextInt();
	         
	         System.out.println("By using Linear Search");
	         Product Linear= linearSearch(products,sid);
	         if(Linear!=null) {
	        	 System.out.println("Linear Search: Found - " +Linear.productId+" "+Linear.productName);
	         }
	         else {
	        	 System.out.println("Product Not Found");
	         }
	         
	         
	         System.out.println("By using Binary Search");
	         sorting(products);
	         
	         Product Binary=binarySearch(products,sid);
	         if(Binary!=null) {
	        	 System.out.println("Binary Search: Found - "+Binary.productId+" "+Binary.productName);
	         }
	         else {
	        	 System.out.println("Product Not Found");
	         }
		}
	}

