import java.util.HashMap;
import java.util.Map;

public class Purse {
    public final Map <Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num){
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num){
        int current = cash.getOrDefault(type, 0);
        if(num > current){
            num = current;
        }
        cash.put(type, current-num);

        return type.amt() * num;

    }

    public double getValue(){
        double total = 0;

        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            total += entry.getKey().amt() * entry.getValue();
        }

        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination den = entry.getKey();
            int value = entry.getValue();
            sb.append(String.format("%d x %s\n", value, den.name() ));
        }

        return sb.toString();
    }


}
