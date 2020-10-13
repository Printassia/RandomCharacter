package Horsy.com.company.Ch06;

import java.util.Scanner;

public class Calendar {

    /** Get the name of the months */
    public static String getMonthName(int month){
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
        }
        return monthName;
    }

    /** Determine if it is a Leap Year */
    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /** Get the number of days in each month */
    public static int getNumberOfDaysInEachMonth(int year, int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }

    /** Get the total number of days since Jan. 1st 1800 */
    public static int getTotalNumbersOfDays(int year, int month){
        int total = 0;

        for (int counter = 1800; counter < year; counter++)
            if (isLeapYear(counter))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int counter = 1; counter < month; counter++)
            total = total + getNumberOfDaysInEachMonth(year, counter);

        return total;
    }

    /** Get the start day of the month */
    public static int getStartDay(int year, int month){
        final int START_DAY_FOR_JAN_1_1800 = 3;

        int totalNumberOfDays = getTotalNumbersOfDays(year, month);

        //Return the start day for Jan 1st 1800
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /** Month Body */
    public static void monthBody(int year, int month){

        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        //Get the number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInEachMonth(year, month);

        //Pad space before the first day of the month
        int counter = 0;
        for (counter = 0; counter < startDay; counter++)
            System.out.print("    ");

        for (counter = 1; counter <= numberOfDaysInMonth; counter++){
            System.out.printf("%4d", counter);

            if ((counter + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    /** Month title:
     * Month, Year, Dashed Lines and the days of the week*/
    public static void monthTitle(int year, int month){
        System.out.println("        " + getMonthName(month) + " " + year);
        System.out.println("------------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /** Print month body */
    public static void printMonth(int year, int month){
        //Print the headings of the calendar
        monthTitle(year, month);

        //Print the body of the calendar
        monthBody(year, month);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Prompt user to enter the year
        System.out.print("Enter full year (e.g., 2012): ");
        int year = input.nextInt();

        //Prompt user to enter the month using 1 - 12
        System.out.print("Enter month as a number between 1 & 12: ");
        int month = input.nextInt();

        //Check if input month is between 1 - 12 and year is after 1800
        if (month > 12 || year < 1800){
            System.out.println("\nEnter a month between 1 and 12 " +
                    "or a year after 1800");
        }

        System.out.println();
        printMonth(year, month);

    }
}
