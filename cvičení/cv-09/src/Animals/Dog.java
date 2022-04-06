package Animals;

public class Dog extends AbstractAnimal {
    @Override
    public String sound() {
        return String.format("bark");
    }
}
