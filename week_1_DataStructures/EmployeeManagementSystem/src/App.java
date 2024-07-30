public class App {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee("1", "Alice", "Developer", 60000));
        ems.addEmployee(new Employee("2", "Bob", "Manager", 80000));
        ems.addEmployee(new Employee("3", "Charlie", "Analyst", 50000));

        // Traverse employees
        System.out.println("Employees List:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for employee with ID 2:");
        System.out.println(ems.searchEmployeeById("2"));

        // Delete an employee
        ems.deleteEmployeeById("2");
        System.out.println("\nEmployees List after deletion:");
        ems.traverseEmployees();
    }
}
