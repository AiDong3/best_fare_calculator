public static void main(String[] args) {
        int myRides = 12;
        int myDays = 5;

        TransitCalculator person = new TransitCalculator(myDays, myRides);
        System.out.println(person.getBestFare());
        }