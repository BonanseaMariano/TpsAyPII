package figuras;

public class Square extends BidimentionalShape
{
    public Square(double len)
    {
        super(len);
    }
    
    @Override
    public double getArea()
    {
        return super.getLength() * super.getLength();
    }
    
    @Override
    public String toString()
    {
        return String.format("Cuadrado\nLado: %.2f\n", 
            super.getLength());
    }
}