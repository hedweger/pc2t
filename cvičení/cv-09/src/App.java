import Animals.*;
import ImplAnimals.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    /*
    * 9. abstraktní třída je pro definování vlstností které obecně objekt má a v každém specifickém
    * objektu je můžeme přepisovat na něco jiného, nemusíme ale.
    * interface definuje vlastnosti které každý objekt který interface implementuje musí mít,
    * definuje je pouze obecně.
    * 10. enum je užitečné když má vlastnost několik daných vlastnosti (aktivní, neaktivní)
    * je to jednodušši než použít string a srovnávat ho s tím co chceme
     */
    public static void main(String[] args) {
        // company
        Employee E1 = new Employee("first","1@first.com", "f1irst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Employee E2 = new Employee("second","3first.com", "f2irst".toCharArray(), Employee.EmployeeType.INACTIVE );
        Employee E3 = new Employee("third","2@first.com", "fi3rst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Employee E4 = new Employee("fourth","4@first.com", "f4irst".toCharArray(), Employee.EmployeeType.INACTIVE );
        Employee E5 = new Employee("fifth","5@first.com", "f5irst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Secretarian S1 = new Secretarian("firstS", "1@second.com", "se1cond".toCharArray(), Employee.EmployeeType.ACTIVE, 43);
        Secretarian S2 = new Secretarian("secondS", "2@second.com", "se2cond".toCharArray(), Employee.EmployeeType.INACTIVE, 56);
        List<Employee> EList = Arrays.asList(E1,E2,E3,E4,E5);
        Manager<Secretarian> M = new Manager<>("manager","1@manager.com", "manager".toCharArray(), Employee.EmployeeType.ACTIVE);
        M.sortList(EList);
        M.addListOfEmployees(EList);
        M.addRelationship(S1);
        M.printAllEmployeesAndRelationships();

    // abstract class
        System.out.println("");
        AbstractAnimal cat = new Cat();
        AbstractAnimal dog = new Dog();
        AbstractAnimal pig = new Pig();
        AbstractAnimal cow = new Cow();
        AbstractAnimal goat = new Goat();
        System.out.println("Absract class: ");
        System.out.println("Cat: " + cat.sound());
        System.out.println("Dog: " + dog.sound());
        System.out.println("Pig: " + pig.sound());
        System.out.println("Cow: " + cow.sound());
        System.out.println("Goat: " + goat.sound());
        System.out.println("");
    // interface
        Animal catimpl = new CatImpl();
        Animal dogimpl = new DogImpl();
        Animal pigimpl = new PigImpl();
        Animal cowimpl = new CowImpl();
        Animal goatimpl = new GoatImpl();
        System.out.println("Interface:");
        System.out.println("Cat: " + catimpl.sound());
        System.out.println("Dog: " + dogimpl.sound());
        System.out.println("Pig: " + pigimpl.sound());
        System.out.println("Cow: " + cowimpl.sound());
        System.out.println("Goat: " + goatimpl.sound());
    }
}
