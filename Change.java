import java.util.Scanner;
public class Change extends Conversion{

    public Change(double value) {
        this.changeToconvert = value; //gets value
    }

   @Override
    public double convert()
    {
        return this.changeToconvert; //returns value
    }


}
