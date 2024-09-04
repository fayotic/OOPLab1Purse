import java.util.*;

public class Register {
    private static final List<Denomination> denoms = new ArrayList<>();

    static{
        denoms.add(new Denomination("Hundred Dollar Note", 100.0, "bill", "hundred_note.png"));
        denoms.add(new Denomination("Fifty Dollar Note", 50.0, "bill", "fifty_note.png"));
        denoms.add(new Denomination("Twenty Dollar Note", 20.0, "bill", "twenty_note.png"));
        denoms.add(new Denomination("Ten Dollar Note", 10.0, "bill", "ten_note.png"));
        denoms.add(new Denomination("Five Dollar Note", 5.0, "bill", "five_note.png"));
        denoms.add(new Denomination("One Dollar Note", 1.0, "bill", "one_note.png"));
        denoms.add(new Denomination("Quarter", .25, "coin", "quarter.png"));
        denoms.add(new Denomination("Dime", .1, "coin", "dime.png"));
        denoms.add(new Denomination("Nickel", .05, "coin", "nickel.png"));
        denoms.add(new Denomination("Penny", .01, "coin", "penny.png"));
    }

    public Purse makeChange(double amt)
    {
        Purse purse = new Purse();
        double remaining = amt;

        for(Denomination d : denoms)
        {
            int count = (int) (remaining /d.amt());

            if(count > 0)
            {
                purse.add(d,count);
                remaining -= d.amt() * count;
                remaining = Math.round(remaining * 100.0) / 100.0;
            }

            if(remaining <= 0)
            {
                break;
            }


        }

        return purse;
    }


}
