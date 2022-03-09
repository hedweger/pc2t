public class Test {

    public static void main(String[] args) {
	Goods[] field = new Goods[4];
    field[0] =  new Food("Rohlík", 1.5, 1);
    field[1] = new Tools("Kleště", 278.0, 24);
    field[2] = new Food("Chleba", 20.8, 6);
    field[3] = new Food("Jablko", 51.0, 20);

    for (int i = 0; i < field.length; i++) {
        if (field[i] instanceof Food) {
            System.out.println(field[i].getName() + ", Cena: " + field[i].getPrize() + ", Trvanlivost: " + ((Food)field[i]).getDurability() + " " + field[i].getUnit());
        }
        else if (field[i] instanceof Tools) {
            System.out.println(field[i].getName() + ", Cena: " + field[i].getPrize());
        }
        else {
            System.out.println("Nevím co s tím");
        }
    }
    }
}
