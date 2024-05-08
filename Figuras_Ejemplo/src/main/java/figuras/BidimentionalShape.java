package figuras;

public abstract class BidimentionalShape extends Shape
{
    
    public BidimentionalShape()
    {}
    
    public BidimentionalShape(double len)
    {
        super(len);
    }
    
    public BidimentionalShape(double len, double wid)
    {
        super(len, wid);
    }
    
    public abstract double getArea();
}
