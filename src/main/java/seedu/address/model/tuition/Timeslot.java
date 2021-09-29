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

    @Override
    public String toString() {
        return time;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassLimit // instanceof handles nulls
                && time == ((Timeslot) other).time); // state check
    }

    public String getTime() {
        return time;
    }
}
