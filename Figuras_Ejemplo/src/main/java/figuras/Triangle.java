package figuras;

public class Triangle extends BidimentionalShape
{
    public Triangle(double len, double wid)
    {
        super(len, wid);
    }
    
    @Override
    public double getArea()
    {
        return 0.5 * super.getLength() * super.getWidth();
    }
    
    @Override
    public String toString()
    {
        return String.format("Triangulo\nAltura: %.2f\nBase: %.2f\n", 
            super.getLength(), super.getWidth());
    }

}
