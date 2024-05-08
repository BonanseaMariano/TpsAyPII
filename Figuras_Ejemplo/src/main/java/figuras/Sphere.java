package figuras;

public class Sphere extends ThreeDimensionalShape
{
    public Sphere(double len)
    {
        super(len);
    }
    
    @Override
    public double getArea()
    {
        return 4 * Math.PI * super.getLength() * super.getLength();
    }
    
    @Override
    public double getVolume()
    {
        return 4.0/3.0 * Math.PI * super.getLength()
            * super.getLength() * super.getLength();
    }
    
    @Override
    public String toString()
    {
        return String.format("Esfera\nRadio: %.2f\n", super.getLength());
    }
}
