package inheritance;


public class Rectangle extends TwoDShape {

    // A default constructor.
    public Rectangle() {
        super();
    }

    // Constructor for Rectangle.
   public Rectangle(double w, double h) {
        super(w, h, "rectangle"); // call superclass constructor
    }

    // Construct a square.
    public Rectangle(double x) {
        super(x, "rectangle"); // call superclass constructor
    }

    // Construct an object from an object.
   public Rectangle(Rectangle ob) {
        super(ob); // pass object to TwoDShape constructor
    }

    public boolean isSquare() {
        if(getWidth() == getHeight()) return true;
        return false;
    }


    // Override area() for Rectangle.
    @Override
    double area() {
        return getWidth() * getHeight();
    }
}

