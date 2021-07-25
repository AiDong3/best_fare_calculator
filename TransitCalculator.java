public class TransitCalculator {
    //transit days only UP TO 30 days!
    int transitDays;
    int numRides;
    String[] options = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] prices = {2.75, 33.0, 127.0};


    public TransitCalculator(int transitDays, int numRides) {
        this.transitDays = transitDays;
        this.numRides = numRides;
    }

    // returns the overall price per ride of using 7 day unlimited option
    public double unlimited7Price() {
        double totalPrice = Math.ceil(transitDays / 7.0) * prices[1];
        return totalPrice / numRides;
    }
    // returns an array of doubles of price per ride for the three fair options
    public double[] getRidePrices() {

        double payPerRide = prices[0];
        double sevenDayRide = unlimited7Price();
        double thirtyDays = prices[2] / numRides;

        double[] ridePrices = {payPerRide, sevenDayRide, thirtyDays};
        return ridePrices;
    }

    public String getBestFare() {
        double[] allRides = getRidePrices();
        int lowestIndex = 0;
        // Can start at one because we init at 0
        for(int i = 1; i < allRides.length; i++) {
            if(allRides[i] < allRides[lowestIndex]) {
                lowestIndex = i;
            }
        }
        //I wonder if there's a better way to format the string, I don't want the line to be too big
        String partOne = "You should get the " + options[lowestIndex];
        String partTwo = " option at $" + allRides[lowestIndex];
        return partOne + partTwo + " per ride.";
    }

    public String toString(){
        return "Days " + transitDays + " " + numRides;
    }