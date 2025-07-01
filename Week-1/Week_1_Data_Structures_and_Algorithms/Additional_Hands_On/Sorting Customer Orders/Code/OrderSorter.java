package SortCustomerOrders;

public class OrderSorter{
	public void bubbleSort(Order[] orders, int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(orders[j].getTotalPrice()>orders[j+1].getTotalPrice()){
                    Order temp=orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;
                }
            }
        }
        System.out.println("Sorted using Bubble Sort:");
        displayOrders(orders,n);
    }


    public void quickSort(Order[] orders,int low,int high){
        if(low<high){
            int pivotIndex=partition(orders,low,high);
            quickSort(orders,low,pivotIndex-1);
            quickSort(orders,pivotIndex+1,high);
        }
    }

    private int partition(Order[] orders, int low, int high){
        double pivot=orders[high].getTotalPrice();
        int i =low-1;

        for(int j=low;j<high;j++){
            if(orders[j].getTotalPrice()<pivot){
                i++;
                Order temp=orders[i];
                orders[i]=orders[j];
                orders[j]=temp;
            }
        }

        Order temp=orders[i+1];
        orders[i+1]=orders[high];
        orders[high]=temp;

        return i+1;
    }

    public void displayOrders(Order[] orders,int n) {
        for(int i=0;i<n;i++){
            orders[i].display();
        }
    }

}
