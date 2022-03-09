public class Food extends Goods {

    private int Durability;

    public Food(String Name, double Prize, int Durability) {
        super(Name, Prize);
        this.Durability = Durability;
    }

    public int getDurability() {
        return Durability;
    }
    public void setDurability(int Durability) {
        this.Durability = Durability;
    }
    public String getUnit() {
        return "dnů";
    }
}
