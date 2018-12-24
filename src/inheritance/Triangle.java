package inheritance;


public class Triangle  extends  TwoDShape {

    private String style;

    public Triangle(String style, double width, double height) {
        super(width, height,"triangle");
        this.style = style;
    }

    public Triangle() {
        super();
        style = "none";
    }

    public Triangle(double x) {
        super(x,"triangle");
        style = "field";
    }

    public Triangle(Triangle ob){
        super(ob);

        style = ob.style;

    }

    @Override
    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}