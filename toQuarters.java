public class toQuarters extends ConDecorator{
    public double quarterConversion = 4.00;
    Conversion convObj;

    public toQuarters(Conversion wrappedConversion) {
        super(wrappedConversion);
    }

    @Override
    public double convert() {
        return wrappedConversion.convert() * quarterConversion; //converts value to quarters
    }
}
