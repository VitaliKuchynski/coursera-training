package restAssured;

/**
 * Created by vitalikuchynski on 1/22/20.
 */
public class Rest {

        public static void main(String[] args) {

          Object [][] objects =  createData();

            System.out.println(objects[0][1] + " " + objects[1][1]);
            //System.out.println(objects[1][0]);

        }


        public  static Object[][] createData() {


            return new Object[][] { { "one", "tree", "m" },
                                    { "home ","test"},
                                    { "woo" }};

            }
        }



