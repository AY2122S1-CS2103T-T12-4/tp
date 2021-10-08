package seedu.address.model.tuition;

import static java.util.Objects.requireNonNull;

/**
 * Represents the time slot the tuition class takes
 */
public class Timeslot {
    public final String time;

    /**
     * Constructor for time slot.
     *
     * @param time
     */
    public Timeslot(String time) {
        requireNonNull(time);
        this.time = time;
    }


    /**
     * check whether the format of timeslot is correct
     * @return
     */
    public boolean isFormatCorrect() {
        String[] splitTime = this.time.split(" ");
        String weekDay = splitTime[0];
        String timeRange = splitTime[1];
        if (weekDay.equals("Mon") || weekDay.equals("Tue") || weekDay.equals("Wed")
                || weekDay.equals("Thu") || weekDay.equals("Fri")
                || weekDay.equals("Sat") || weekDay.equals("Sun")) {

            return isTimeFormatCorrect(timeRange);
        }
        return false;
    }

    /**
     * Check the time format, should be hh:mm-hh:mm
     * @param mytime
     * @return
     */
    public boolean isTimeFormatCorrect(String mytime) {

        String[] timeRange = mytime.split("-");
        String first = timeRange[0];
        String second = timeRange[1];
        System.out.println(first + "  " + second);
        if (first.length() != 5 || second.length() != 5) {
            return false;
        }
        if (first.charAt(2) != ':' || second.charAt(2) != ':') {
            return false;
        }
        if (Integer.valueOf(first.substring(0, 2)) > Integer.valueOf(second.substring(0, 2))) {
            return false;
        } else if (Integer.valueOf(first.substring(0, 2)) == Integer.valueOf(second.substring(0, 2))) {
            return Integer.valueOf(first.substring(3, 5)) < Integer.valueOf(second.substring(3, 5));
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return time;
    }


    /**
     * compare two time slot to detect any conflict
     * @param otherTime
     * @return
     */
    public boolean compareTime(String otherTime) {
        //exactly the same
        if (time.equals(otherTime)) {
            return true;
        }
        String[] time1 = time.split(" ");
        String[] time2 = otherTime.split(" ");

        //day is not the same,return false
        if (!time1[0].equals(time2[0])) {
            return false;
        }

        //day is the same, compare time
        int time1Start = Integer.parseInt(time1[1].substring(0, 2));
        int time1End = Integer.parseInt(time1[1].substring(6, 8));
        int time2Start = Integer.parseInt(time2[1].substring(0, 2));
        int time2End = Integer.parseInt(time2[1].substring(6, 8));
        if (time1Start == time2Start || time1End == time2End) {
            return true;
        }
        if (time1Start > time2Start) {
            return time1Start < time2End;
        } else {
            return time1End > time2Start;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Timeslot) {
            return compareTime(((Timeslot) other).getTime());
        }
        return false;
    }

    public String getTime() {
        return time;
    }
}
