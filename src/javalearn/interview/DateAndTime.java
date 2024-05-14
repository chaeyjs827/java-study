package javalearn.interview;

import java.util.Calendar;
import java.util.Scanner;

public class DateAndTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int year = sc.nextInt();

        Integer dayOfWeek = getDayOfWeek(month, day, year);
        if (dayOfWeek != null) {
            printDayOfWeek(dayOfWeek);
        }
    }

    private static Integer getDayOfWeek(int month, int day, int year) {
        if (year > 2000 && year < 3000) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day); // month는 0부터 시작하므로 1을 빼줌
            return calendar.get(Calendar.DAY_OF_WEEK);
        }
        return null;
    }

    private static String printDayOfWeek(Integer dayOfWeek) {
        if (dayOfWeek == 2) {
            return "MONDAY";
        } else if (dayOfWeek == 3) {
            return "TUESDAY";
        } else if (dayOfWeek == 4) {
            return "WEDNESDAY";
        } else if (dayOfWeek == 5) {
            return "THURSDAY";
        } else if (dayOfWeek == 6) {
            return "FRIDAY";
        } else if (dayOfWeek == 7) {
            return "SATURDAY";
        }
        return "SUNDAY";
    }

}
