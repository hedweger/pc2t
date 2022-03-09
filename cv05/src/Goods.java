public abstract class Goods {
    private String Name;
    private double Prize;
    private static double VAT = 0.21;
    public Goods(String Name, double Prize) {
         this.Name = Name;
         this.Prize = Prize;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public double getPrize() {
        return (Prize * (1 + VAT));
    }
    public void setPrize(double Prize) {
        this.Prize = Prize;
    }
    public double getVAT() {
        return VAT;
    }
    public static void setVAT(double VAT) {
        Goods.VAT = VAT;
    }
    public abstract String getUnit();
}
