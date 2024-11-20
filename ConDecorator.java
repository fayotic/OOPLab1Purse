public abstract class ConDecorator extends Conversion {
    protected Conversion wrappedConversion; //where value is
    public ConDecorator(Conversion wrappedConversion) {
        this.wrappedConversion = wrappedConversion;
    }
}
