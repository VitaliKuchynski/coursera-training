package inheritance;


public class ColorTriangle extends Triangle {

     private String color;

     public ColorTriangle(String color, String style, double width, double height){

         super(style, width, height);
         this.color = color;

     }
    public String getColor() {
        return color;
    }


    void showColor() {
        System.out.println("Color is " + color);
    }
}

