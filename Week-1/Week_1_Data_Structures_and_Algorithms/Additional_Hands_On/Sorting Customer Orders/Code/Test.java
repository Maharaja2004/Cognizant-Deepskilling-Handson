package SortCustomerOrders;

public class Test {
	public static void main(String[] args) {
        Order[] orders=new Order[4];

        Order o1=new Order();
        o1.setOrderId(101);
        o1.setCustomerName("Ravi");
        o1.setTotalPrice(450.0);

        Order o2=new Order();
        o2.setOrderId(102);
        o2.setCustomerName("Anu");
        o2.setTotalPrice(1000.0);

        Order o3=new Order();
        o3.setOrderId(103);
        o3.setCustomerName("Kumar");
        o3.setTotalPrice(200.0);

        Order o4=new Order();
        o4.setOrderId(104);
        o4.setCustomerName("Priya");
        o4.setTotalPrice(700.0);

        orders[0]=o1;
        orders[1]=o2;
        orders[2]=o3;
        orders[3]=o4;

        OrderSorter sorter=new OrderSorter();

        sorter.bubbleSort(orders,4); 

        System.out.println("Sorted using Quick Sort:");
        sorter.quickSort(orders,0,3);
        sorter.displayOrders(orders,4); 
    }
}
