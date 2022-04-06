import java.util.*;

public class Manager<T> extends Employee {
    private List<Employee> EList = new ArrayList<>();
    private List<T> RList = new ArrayList<>();
    public Manager(String nickname, String email, char[] password, EmployeeType employeeType) {
        super(nickname, email, password, employeeType);
    }
    public void addRelationship(T t) {
        this.RList.add(t);
    }
    public void addListOfEmployees(List<Employee> listOfEmployees) {
        this.EList = listOfEmployees;
    }
    public void printAllEmployeesAndRelationships() {
        System.out.println("List of manager employees:");
        EList.forEach(System.out::println);
        System.out.println(System.lineSeparator() + "List of manager relationships:");
        RList.forEach(System.out::println);
    }
    public List<Employee> sortList(List<Employee> EList) {
        Collections.sort(EList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getEmail().compareTo(e2.getEmail());

            }
        });
        return EList;
    }
}
