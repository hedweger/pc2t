package Animals;

public class Cat extends AbstractAnimal{
    @Override
    public String sound() {
        return String.format("meow");
    }
}
