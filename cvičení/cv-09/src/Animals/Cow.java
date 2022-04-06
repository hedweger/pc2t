package Animals;

public class Cow extends AbstractAnimal {
    @Override
    public String sound() {
        return String.format("moo");
    }
}
