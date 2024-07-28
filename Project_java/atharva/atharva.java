package atharva;

import java.util.Scanner;

public class atharva {

    static EmployeeService service = new EmployeeService();
    static boolean ordering = true;

    public static void menu() {
        System.out.println("*****Welcome To Human Resource Management System ****"
                + "\n1. Add Employee "
                + "\n2. View Employee"
                + "\n3. Update Employee"
                + "\n4. Delete Employee"
                + "\n5. View All Employee"
                + "\n6. Employee Attendance"
                + "\n7. Exit ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            do {
                menu();
                System.out.println("Enter your Choice");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Add Employee");
                        service.addEmp();
                        break;
                    case 2:
                        System.out.println("View Employee");
                        service.viewEmp();
                        break;
                    case 3:
                        System.out.println("Update Employee");
                        service.updateEmployee();
                        break;
                    case 4:
                        System.out.println("Delete Employee");
                        service.deleteEmp();
                        break;
                    case 5:
                        System.out.println("View All Employee");
                        service.viewAllEmps();
                        break;
                    case 6:
                        System.out.println("Employee Attendance");
                        service.attendance();
                        break;
                    case 7:
                        System.out.println("Thank you for using the application!!");
                        ordering = false;
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                        break;
                }
            } while (ordering);
        } finally {
            sc.close(); 
        }
    }
}
