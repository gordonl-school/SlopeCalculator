import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner myScanner;
    private LinearEquation linearEquation;




    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
        linearEquation = null;
    }




    public void start() {
        introduction();
        repeat();
    }


    private void introduction() {
        System.out.println("Hi! This is a linear equation calculator.");
        System.out.print("Please enter your first ordered pair: ");
        String firstCoordinate = myScanner.nextLine();
        System.out.print("Please enter your second ordered pair: ");
        String secondCoordinate = myScanner.nextLine();




        int x1 = Integer.parseInt(firstCoordinate.substring(1, firstCoordinate.indexOf(",")));
        int y1 = Integer.parseInt(firstCoordinate.substring(firstCoordinate.indexOf(",") + 2, firstCoordinate.indexOf(")")));
        int x2 = Integer.parseInt(secondCoordinate.substring(1, secondCoordinate.indexOf(",")));
        int y2 = Integer.parseInt(secondCoordinate.substring(secondCoordinate.indexOf(",") + 2, secondCoordinate.indexOf(")")));


        if (x1 == x2) {
            System.out.println();
            System.out.println("These points are on a vertical line: x = " + x1);
            System.out.println();
        } else {
            linearEquation = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            System.out.println(linearEquation.lineInfo());
            System.out.println();
            System.out.print("Enter an x value: ");
            double xValue = myScanner.nextDouble();
            myScanner.nextLine();
            System.out.println();
            System.out.println("The point on the line is " + linearEquation.coordinateForX(xValue));
            System.out.println();
        }


    }


    private void repeat() {
        System.out.print("Would you like to enter another pair of coordinates? (y/n) ");
        String answer = myScanner.nextLine();
        while (answer.toLowerCase().equals("y")) {
            System.out.print("Please enter your first ordered pair: ");
            String firstCoordinate = myScanner.nextLine();
            System.out.print("Please enter your second ordered pair: ");
            String secondCoordinate = myScanner.nextLine();




            int x1 = Integer.parseInt(firstCoordinate.substring(1, firstCoordinate.indexOf(",")));
            int y1 = Integer.parseInt(firstCoordinate.substring(firstCoordinate.indexOf(",") + 2, firstCoordinate.indexOf(")")));
            int x2 = Integer.parseInt(secondCoordinate.substring(1, secondCoordinate.indexOf(",")));
            int y2 = Integer.parseInt(secondCoordinate.substring(secondCoordinate.indexOf(",") + 2, secondCoordinate.indexOf(")")));


            if (x1 == x2) {
                System.out.println();
                System.out.println("These points are on a vertical line: x = " + x1);
                System.out.println();
                System.out.print("Would you like to enter another pair of coordinates? (y/n) ");
                answer = myScanner.nextLine();
            } else {
                linearEquation = new LinearEquation(x1, y1, x2, y2);
                System.out.println();
                System.out.println(linearEquation.lineInfo());
                System.out.println();
                System.out.print("Enter an x value: ");
                double xValue = myScanner.nextDouble();
                myScanner.nextLine();
                System.out.println();
                System.out.println("The point on the line is " + linearEquation.coordinateForX(xValue));
                System.out.println();
                System.out.print("Would you like to enter another pair of coordinates? (y/n) ");
                answer = myScanner.nextLine();
            }


        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }


}
