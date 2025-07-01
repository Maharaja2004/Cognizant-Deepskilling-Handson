package DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
	public String findCustomerById(String id) {
		return "Customer name for id"+id+"is raja";
	}

}
