import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String nickname;
    private String email;
    private char[] password;
    private EmployeeType employeeType;
    public Employee(String nickname, String email, char[] password, EmployeeType employeeType) {
        super();
        this.email = email;
        this.nickname = nickname;
        this.password =  password;
        this.employeeType = employeeType;
    }

    public enum EmployeeType {
        ACTIVE,
        INACTIVE,
        DELETED
    }
    public String getNickname() { return nickname;}
    public String getEmail() {return email;}
    public char[] getPassword() {return password;}
    public EmployeeType getEmployeeType() { return employeeType;}
    @Override
    public String toString() {
        return "Employee: nickname: " + nickname + ", email: " + email + ", password: " + new String(password) + ", employeeType: " + employeeType;
    }

}
