public class toNickels extends ConDecorator{
    public double nickelConverter = 20.0;
    Conversion convObj;

    public toNickels(Conversion wrappedConversion) {
        super(wrappedConversion);
    }


    @Override
    public double convert() {
        return wrappedConversion.convert() * nickelConverter; //converts value to nickels
    }
}
