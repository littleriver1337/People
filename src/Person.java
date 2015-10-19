/**
 * Created by MattBrown on 10/19/15.
 */
public class Person implements Comparable {
    int posNum;
    String firstName;
    String lastName;
    String email;
    String country;
    String iP;

    public Person(int posNum, String firstName, String lastName, String email, String country, String iP){
        this.posNum = posNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.iP = iP;

    }

    @Override
    public int compareTo(Object o) {
        Person c = (Person) o;
        int result = lastName.compareTo(c.lastName);
        return result;
    }
    @Override
    public String toString() {
        return String.format(String.valueOf(posNum), firstName, lastName, email, country, iP);
    }
}
