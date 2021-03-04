public class Employee extends Person {
    String workEmail;
    String position;
    long salary;

    Employee() {}

    Employee(String name, String workEmail, String position, long salary) {
        this.name = name;
        this.workEmail = workEmail;
        this.position = position;
        this.salary = salary;
    }
}
