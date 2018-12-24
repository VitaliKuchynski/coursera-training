package inheritance;


public class TwoDShape {

    private double width;
    private double height;
    private String name;


    // A default constructor
    public TwoDShape() {
        width = height = 0.0;
        name = "none";
    }

   public TwoDShape(double x, String name) {
        width = height = x;
        this.name = name;
    }

    public TwoDShape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;

    }

        // Construct an object from an object.
     public TwoDShape(TwoDShape ob){
          this.width = ob.width;
          this.height = ob.height;
          this.name = ob.name;
     }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    void showDim() {
        System.out.println("Width and height are " +
                width + " and " + height);
    }


    double area() {
        System.out.println("area() must be overridden");
        return 0.0;
    }
}