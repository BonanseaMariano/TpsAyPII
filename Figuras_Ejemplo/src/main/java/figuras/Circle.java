package figuras;

public class Circle extends BidimentionalShape
{
    public Circle(double len)
    {
        super(len);
    }
    
    @Override
    public double getArea()
    {
        return Math.PI * super.getLength() * super.getLength();
    }
    
    @Override
    public String toString()
    {
        return String.format("Circulo\nRadio: %.2f\n", 
            super.getLength());
    }

}
