package DependencyInjectionExample;

public class Test {
   public static void main(String args[]) {
	   CustomerRepository repo=new CustomerRepositoryImpl();
	   CustomerService ser=new CustomerService(repo);
	   
	   ser.getCustomerDetails(" C101 ");
   }
}