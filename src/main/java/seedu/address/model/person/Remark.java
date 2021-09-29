package seedu.address.model.person;

public class Remark {

    public final String text;

    public Remark(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && text.equals(((Remark) other).text)); // state check
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

}
