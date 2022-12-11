import java.math.BigInteger;
import java.util.Objects;

public class Client implements Comparable<Client>{
    public final String id;
    public final String name;
    public final String surname;
    public final BigInteger pesel;
    private final String city;

    public Client(String id, String name, String surname, BigInteger pesel, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigInteger getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compareTo(Client o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Client client = (Client) o;
        return Objects.equals(pesel, client.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
