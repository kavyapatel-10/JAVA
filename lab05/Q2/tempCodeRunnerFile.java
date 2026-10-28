abstract class Employee {
    protected String name;
    protected int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    private double fixedSalary;

    FullTime(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    @Override
    double monthlySalary() {
        return fixedSalary;
    }
}

class PartTime extends Employee {
    private int hours;
    private double rate;

    PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    private double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Rahul", 101, 50000),
            new PartTime("Amit", 102, 80, 300),
            new Intern("Priya", 103, 15000),
            new FullTime("Neha", 104, 60000)
        };

        double total = 0;

        for (Employee emp : employees) {
            double salary = emp.monthlySalary();

            System.out.println(emp.name + " (ID: " + emp.id + ") Salary: ₹" + salary);

            if (emp instanceof Intern) {
                System.out.println("Note: This employee is an intern.");
            }

            total += salary;
        }

        System.out.println("-------------------------");
        System.out.println("Total Payroll: ₹" + total);
    }
}