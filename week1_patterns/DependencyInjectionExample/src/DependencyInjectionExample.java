public class DependencyInjectionExample {

    // Repository Interface
    public interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Concrete Repository
    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            // Simulating database interaction
            return "Customer with ID: " + id;
        }
    }

    // Service Class
    public static class CustomerService {
        private CustomerRepository customerRepository;

        // Constructor injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String getCustomer(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Test Class
    public static void main(String[] args) {
        // Create the repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        String customer = customerService.getCustomer(1);
        System.out.println(customer);
    }
}
