import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Locale;

import static java.util.Calendar.JANUARY;
import static java.util.GregorianCalendar.AD;
import static java.util.GregorianCalendar.BC;

public class Main {
    public static void main(String[] args) {
        //Calendar
        Calendar calendar = new GregorianCalendar();
        System.out.println("\n\t*Calendar*");
        System.out.println("Era: " + calendar.get(GregorianCalendar.ERA) +
                "\nYear: " + calendar.get(Calendar.YEAR) +
                "\nMonth: " + (int)(calendar.get(Calendar.MONTH) + 1));
        calendar.set(Calendar.ERA, BC);
        //calendar.add(Calendar.ERA, AD);
        calendar.set(Calendar.YEAR, 2018);
        //calendar.add(Calendar.YEAR, 2);
        calendar.set(Calendar.MONTH, 6);
        //calendar.add(Calendar.MONTH, 4);
        System.out.println("\n\t*Change Calendar values*");
        System.out.println("New era: " + calendar.get(GregorianCalendar.ERA) +
                "\nNew year: " + calendar.get(Calendar.YEAR) +
                "\nNew month: " + calendar.get(Calendar.MONTH));

        //SimpleDateFormat
        System.out.println("\n\t*SimpleDateFormat*");
        calendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy");
        System.out.println("Year: " + format.format(calendar.getTime()));
        format.applyPattern("M");
        System.out.println("Month(without leading zeros): " + format.format(calendar.getTime()));
        format.applyPattern("DDD");
        System.out.println("Day in a year: " + format.format(calendar.getTime()));
        format.applyPattern("FF (dd/MM/yyyy)");
        System.out.println("Weekday: " + format.format(calendar.getTime()));
        format.applyPattern("k");
        System.out.println("Hours in 24-h format without leading zeros: " + format.format(calendar.getTime()));
        format.applyPattern("h:mm");
        System.out.println("Time in am/pm (1-12) format without leading zeros: " + format.format(calendar.getTime()));

        //Formatter
        System.out.println("\n\t*Formatter*");
        Formatter fullMonthName = new Formatter(Locale.US);
        System.out.println(fullMonthName.format("Full month name: %tB", calendar.getTime()));
        Formatter time = new Formatter();
        System.out.println(time.format("Time(from 00 to 23): %tk", calendar.getTime()));
        Formatter dayNumber = new Formatter();
        System.out.println(dayNumber.format("Day number per year as a decimal whole (001 to 366) : %Tj",
                calendar.getTime()));
        Formatter time2 = new Formatter();
        System.out.println(time2.format("Time formatted for the 24-hour clock : %TR",
                calendar.getTime()));

        //Calendar to String
        Calendar c = new GregorianCalendar(2001, JANUARY,13,15,15);
        String s = String.format("\n\t*Calendar to String*\n %1$te/%1$tm/%1$tY %1$TR",c);
        System.out.println(s);
    }
}
