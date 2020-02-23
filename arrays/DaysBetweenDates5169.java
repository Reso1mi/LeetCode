import java.time.*;
import java.time.temporal.ChronoUnit;
public class DaysBetweenDates5169{
    public static void main(String[] args) {

    }

    /*public int daysBetweenDates(String date1, String date2) {
        String[] d1=date1.split("-");
        String[] d2=date2.split("-");
        LocalDate one= LocalDate.of(Integer.valueOf(d1[0]),Integer.valueOf(d1[1]),Integer.valueOf(d1[2]));
        LocalDate two = LocalDate.of(Integer.valueOf(d2[0]),Integer.valueOf(d2[1]),Integer.valueOf(d2[2]));
        return (int)Math.abs(one.until(two,ChronoUnit.DAYS));
    }*/
    public int daysBetweenDates(String date1, String date2) {
        return (int)Math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2),ChronoUnit.DAYS));
    }
}