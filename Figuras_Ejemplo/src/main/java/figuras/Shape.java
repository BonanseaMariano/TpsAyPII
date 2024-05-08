package figuras;

public abstract class Shape
{
    private double length;
    private double width;
    
    public Shape()
    {
        length = 0;
        width = 0;
    }
    
    public Shape(double len)
    {
        setLength(len);
    }
    
    public Shape(double len, double wid)
    {
        setLength(len);
        setWidth(wid);
    }
    
    public void setLength(double len)
    {
        length = len > 0? len : 0;
    }
        
    public double getLength()
    {
        return length;
    }

    public void setWidth(double wid)
    {
        width = wid > 0? wid : 0;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public abstract double getArea();
}