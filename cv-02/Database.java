

public class Database {
    private final String Name;
    private final int Birth;
    private float Pay;
    static float MaximumPay = 1;

    public Database(String Name, int Birth)
    {
        this.Name = Name;
        this.Birth = Birth;
    }

    public String getName()
    {
        return Name;
    }

    public int getBirth()
    {
        return Birth;
    }

    public float getPay()
    {
        return Pay;
    }

    public float getMaximumPay() { return MaximumPay; }

    public static void SetMaxPay(float MaxPay) { MaximumPay = MaxPay;}

    public boolean PayAdd(float Pay)
    {
        if (this.Pay + Pay < MaximumPay)
        {
            this.Pay += Pay;
            return true;
        }
        else
        {
            return false;
        }
    }
}
