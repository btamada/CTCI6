import java.util.*;

public class EnumSet {

    private enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    public static void main(String[] args) {
        java.util.EnumSet<WeekDay> weekdaySet = java.util.EnumSet.range(WeekDay.MONDAY,WeekDay.FRIDAY);
        java.util.EnumSet<WeekDay> weekendSet = java.util.EnumSet.complementOf(weekdaySet);

        for(WeekDay d : weekdaySet) System.out.println(d);

        for(WeekDay e : weekendSet) System.out.println(e);

        Iterator<WeekDay> itr = weekdaySet.iterator();

        while(itr.hasNext()) System.out.println(itr.next());

        Iterator<WeekDay> itr2 = weekendSet.iterator();
        while(itr2.hasNext()) System.out.println(itr2.next());
    }

}
