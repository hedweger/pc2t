package Animals;

public class Pig extends AbstractAnimal {
    @Override
    public String sound() {
        return String.format("oink");
    }
}
