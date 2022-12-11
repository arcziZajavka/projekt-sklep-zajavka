import java.time.LocalDate;

public class Purchase {
    private final Client buyer;
    private final Product product;
    private final long quanity;
    private final Delivery delivery;
    private final Payment payment;
    private final LocalDate when;
    private final Status status;

    public Purchase(Client buyer, Product product, long quanity, Delivery delivery, Payment payment, LocalDate when) {
        this.buyer = buyer;
        this.product = product;
        this.quanity = quanity;
        this.delivery = delivery;
        this.payment = payment;
        this.when = when;
        this.status = Status.OPŁACONO;
    }


    public Purchase(Purchase purchase, Status status) {
        this.buyer = purchase.buyer;
        this.product = purchase.product;
        this.quanity = purchase.quanity;
        this.delivery = purchase.delivery;
        this.payment = purchase.payment;
        this.when = purchase.when;
        this.status = status;
    }

    public Client getBuyer() {
        return buyer;
    }
    public Product getProduct() {
        return product;
    }
    public long getQuanity() {
        return quanity;
    }
    public Payment getPayment() {
        return payment;
    }
    public Status getStatus() {
        return status;
    }


    public enum Delivery{
        IN_POST,
        UPS,
        DHL
    }
    public enum Payment{
        CASH,
        BLIK,
        CREDIT_CARD
    }
    public enum Status{
        OPŁACONO,
        WYSŁANO,
        WYKONANO
    }

    @Override
    public String toString() {
        return "" + product;
    }
}
