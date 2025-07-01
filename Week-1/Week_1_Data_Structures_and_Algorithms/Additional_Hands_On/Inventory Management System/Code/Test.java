package InventoryManagementSystem;

public class Test {
	public static void main(String[] args) {
        InventoryManager manager=new InventoryManager();

        manager.addProduct(101,"Mouse",20,250.0);
        manager.addProduct(102,"Keyboard",15,450.0);
        manager.addProduct(103,"Monitor",10,7500.0);

        System.out.println("All Products:");
        manager.displayAll();

        System.out.println("Search Product ID 102:");
        manager.searchProduct(102);

        System.out.println("Update Product ID 103:");
        manager.updateProduct(103,"LED Monitor",8,8500.0);

        System.out.println("All Products After Update:");
        manager.displayAll();

        System.out.println("Delete Product ID 101:");
        manager.deleteProduct(101);

        System.out.println("All Products After Deletion:");
        manager.displayAll();
    }
}
