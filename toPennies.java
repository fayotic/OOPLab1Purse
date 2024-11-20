public class toPennies extends ConDecorator{
    public double pennyConverter = 100.0;
    Conversion convObj;

    public toPennies(Conversion wrappedConversion) {
        super(wrappedConversion);
    }

    @Override
    public double convert() {
        return wrappedConversion.convert() * pennyConverter; //converts value to pennies
    }
}
