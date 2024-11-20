public class toDimes extends ConDecorator {
    public double dimeConverter = 10.0;

    public toDimes(Conversion wrappedConversion) {
        super(wrappedConversion);
    }


    @Override
    public double convert() {
        return wrappedConversion.convert() * dimeConverter; //converts value to dimes
    }
}
