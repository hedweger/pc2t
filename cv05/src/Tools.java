public class Tools extends Goods {

    private int Warranty;

    public Tools(String Name, double Prize, int Warranty) {
        super(Name, Prize);
        this.Warranty = Warranty;
    }
    public int getWarranty() {
        return Warranty;
    }
    public void setWarranty(int Warranty) {
        this.Warranty = Warranty;
    }
    public String getUnit() {
        return "měsíců";
    }
}

