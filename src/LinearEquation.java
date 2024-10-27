public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;




    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }




    public double distance() {
        double firstPart = Math.pow((x2 - x1), 2);
        double secondPart = Math.pow((y2 - y1), 2);
        double distance = Math.sqrt(firstPart + secondPart);
        return roundedToHundredth(distance);
    }




    public double yIntercept() {
        double yIntercept = y1 - (slope() * x1);
        return yIntercept;
    }




    public double slope() {
        double firstPart = y2 - y1;
        double secondPart = x2 - x1;
        return firstPart / secondPart;
    }


    // need to work on extra credit


    public String equation() {
        if (y1 == y2) {
            return "y = " + (int) yIntercept();
        }
        String firstPart = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x ";
        String secondPart = "+ " + roundedToHundredth(yIntercept());


        if (slope() > 0) {
            if (Math.floor(slope()) == slope() || Math.ceil(slope()) == slope()) {
                if (slope() == 1.0) {
                    firstPart = "y = x";
                } else {
                    firstPart = "y = " + (int) slope() + "x";
                }
            } else {
                if ((y2 - y1) < 0 && (x2 - x1) < 0) {
                    firstPart = "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
                }
            }
        } else {
            if (Math.floor(slope()) == slope() || Math.ceil(slope()) == slope()) {
                if (slope() == -1.0) {
                    firstPart = "y = -x";
                } else {
                    firstPart = "y = " + (int) slope() + "x";
                }
            } else {
                firstPart = "y = -" + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x ";
            }
        }

        if (yIntercept() == 0) {
            secondPart = "";
        }
        if (yIntercept() < 0) {
            secondPart = " - " + roundedToHundredth(Math.abs(yIntercept()));
        }

        return firstPart + secondPart;
    }




    public String coordinateForX(double x) {
        double newSlopeResult = slope() * x;
        double yCoordinate = newSlopeResult + yIntercept();
        return "(" + x + ", " + yCoordinate + ")";
    }




    public String lineInfo() {
        String firstStatement = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String secondStatement = "The equation of the line between these points is: " + equation();
        String thirdStatement = "The y-intercept of this line is: " + roundedToHundredth(yIntercept());
        String fourthStatement = "The slope of this line is: " + roundedToHundredth(slope());
        String fifthStatement = "The distance between these points is: " + distance();
        return firstStatement + "\n" + secondStatement + "\n" + thirdStatement + "\n" + fourthStatement + "\n" + fifthStatement;
    }




    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }


}

