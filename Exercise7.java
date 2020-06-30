import java.util.Scanner;
class Main {
    static void monthInput() {
        System.out.println("Input a month (num): ");
    }
    static void yearInput() {
        System.out.println("Input a year: ");
    }
    static void invalid() {
        System.out.println("Invalid month! Please only input from 1-12!");
    }

    private static Scanner monthInput;
    private static Scanner yearInput;
    static int month;
    static int dayCount;
    static String monthName;
    static int year;


    public static void main(String[] args) {
        monthInput();
        try {
            monthInput = new Scanner(System.in);
        }
        finally {
            month = monthInput.nextInt();
        }

        yearInput();
        try {
            yearInput = new Scanner(System.in);
        }
        finally {
            year = yearInput.nextInt();
        }

        switch (month) {
            case 1:
                monthName = "January";
                dayCount = 31;
                break;
            case 2:
                monthName = "Febuary";
                if(!(year % 4 == 0))
                {
                    dayCount = 28;
            }
                else {
                    dayCount = 29;
                }
                break;
            case 3:
                monthName = "March";
                dayCount = 31;
                break;
            case 4:
                monthName = "April";
                dayCount = 30;
                break;
            case 5:
                monthName = "May";
                dayCount = 31;
                break;
            case 6:
                monthName = "June";
                dayCount = 30;
                break;
            case 7:
                monthName = "July";
                dayCount = 31;
                break;
            case 8:
                monthName = "August";
                dayCount = 31;
                break;
            case 9:
                monthName = "September";
                dayCount = 30;
                break;
            case 10:
                monthName = "October";
                dayCount = 31;
                break;
            case 11:
                monthName = "November";
                dayCount = 30;
                break;
            case 12:
                monthName = "December";
                dayCount = 31;
                break;
            default:
                invalid();
                break;

        }

        System.out.println(monthName + " " + year + " has " + dayCount + " days!");
        System.exit(0);
    }
}
