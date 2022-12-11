

public class pakietFirst extends Level {

    //ten pakiet z racji na krótkie odpowiedzi ma funkcje wyświetlenia wszystkich tasków
    private final String clientCounter = Task1();
    private final String blikCounter = Task2();
    private final String cardCounter = Task3();
    private final String euroCounter = Task4();
    private final String uniqueEuro = Task5();
    private final String alls = getAll();


    public String getAlls() {
        return alls;
    }

    public String getClientCounter() {
        return clientCounter;
    }

    public String getBlikCounter() {
        return blikCounter;
    }

    public String getCardCounter() {
        return cardCounter;
    }

    public String getEuroCounter() {
        return euroCounter;
    }

    public String getUniqueEuro() {
        return uniqueEuro;
    }

    private String Task1() {
        return "Ilość unikalnych klientów sklepu: "+produce.stream()
                .map(Purchase::getBuyer)
                .distinct()
                .count();
    }

    private String Task2() {
        return "Ilość klientów płącących za zakupy blikiem: "+ produce.stream()
                .filter(p-> Purchase.Payment.BLIK.equals(p.getPayment()))
                .map(Purchase::getBuyer)
                .distinct()
                .count();
    }

    private String Task3() {
        return "Ilość klientów płącących za zakupy kartą kredytową: "+ produce.stream()
                .filter(p-> Purchase.Payment.CREDIT_CARD.equals(p.getPayment()))
                .map(Purchase::getBuyer)
                .distinct()
                .count();
    }
    private String Task4() {
        return "Ilość zakupów opłaconych walutą Euro: "+ produce.stream()
                .map(Purchase::getProduct)
                .map(Product::getPrice)
                .filter(p-> Money.Currency.EUR.equals(p.getCurrency()))
                .count();
    }
    private String Task5() {
        return "Ilość unikalnych transakcji w walucie euro: "+produce.stream()
                .map(Purchase::getProduct)
                .distinct()
                .map(Product::getPrice)
                .filter(p-> Money.Currency.EUR.equals(p.getCurrency()))
                .count();
    }
    
    public String getAll(){
        return clientCounter +"\n"+ blikCounter
                +"\n"+cardCounter
                +"\n"+euroCounter
                +"\n"+uniqueEuro;
    }
    }



