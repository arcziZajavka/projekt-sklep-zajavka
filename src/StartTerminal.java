import java.util.Scanner;

public class StartTerminal {
    private final pakietFirst pakietFirst = new pakietFirst();
    private final pakietSecond pakietSecond = new pakietSecond();
    private final pakietThird pakietThird =  new pakietThird();
    public void start(String task, Scanner sc){
        //jeśli uzykownik wpisze start otrzymuje możliwości wyboru poziomu z taskami

        if(task.equals("start")){
            letsStart(sc);
        } else {
            System.out.println("nie rozumiem");
        }
    }

    private void letsStart(Scanner sc) {
        //użytkownik wybiera pakiet tasków

        System.out.println("Wybierz pakiet");
        System.out.println("pakiet 1");
        System.out.println("pakiet 2");
        System.out.println("pakiet 3");
        pakietValidator(sc); //funkcja sprawdzająca który pakiet został wybrany
    }

    private void pakietValidator(Scanner sc) {
        //w zależności od wybranego poziomu wywołuje się funckja dla odpowiedniego pakietu
        while (sc.hasNextLine()){
            String pakiet = sc.nextLine();

            switch (pakiet){
                case "pakiet 1"
                        -> startPakiet1(sc);
                case "pakiet 2"
                        -> startPakiet2(sc);
                case "pakiet 3"
                    -> startPakiet3(sc);
                default
                        -> System.out.println("nie rozumiem");
            }
        }
    }



    private void startPakiet1(Scanner sc) {
        System.out.println("wpisz task 1 aby wyświetlić ilość osób która dokonała zakupów w sklepie");
        System.out.println("wpisz task 2 aby wyświetlić jaka ilość klientów płaciła Blikiem");
        System.out.println("wpisz task 3 aby wyświetlić jaka ilość klientów płaciła kartą kredytową.");
        System.out.println("wpisz task 4 aby wyświetlić jaka ilość zakupów została wykonana w walucie EUR.");
        System.out.println("wpisz task 5 aby wyświetlić ile unikalnych kupionych produktów zostało zakupionych w EUR");
        System.out.println("Wpisz \"wszystko\" aby zobaczyć wszystkie wyniki");
        System.out.println("wpisz \"powrót\" aby wrócić do menu wyboru poziomów");

        taskCheckerForPakietFirst(sc); //funkcja sprawdzająca, który task ma zostać wywołany
    }

    private void taskCheckerForPakietFirst(Scanner sc) {
        //w zależności od wybranego tasku wywołuje się odpowiednia funkcja z klasy levelFirst

        while (sc.hasNextLine()){
            String taskForPakietOne = sc.nextLine().trim();
            switch (taskForPakietOne) {
                case "task 1"
                        -> System.out.println(pakietFirst.getClientCounter());
                case "task 2"
                        -> System.out.println(pakietFirst.getBlikCounter());
                case "task 3"
                        -> System.out.println(pakietFirst.getCardCounter());
                case "task 4"
                        -> System.out.println(pakietFirst.getEuroCounter());
                case "task 5"
                        -> System.out.println(pakietFirst.getUniqueEuro());
                case "wszystko"
                        -> System.out.println(pakietFirst.getAlls());
                case "powrót"
                    ->letsStart(sc);
                default -> System.out.println("nie rozumiem");
            }

        }
    }

    private void startPakiet2(Scanner sc) {
        System.out.println("wpisz task 1 aby zobaczyć ile PLN wydała każda z osób");
        System.out.println
                ("wpisz task 2 aby zobaczyć ilość kupionych przedmiotów z danej kategorii przez poszczególne osoby");
        System.out.println("wpisz task 3 aby zobaczyć ilość zamówień wykonanych oraz tablice statusów dla przedmiotów");
        System.out.println("wpisz task 4 aby zobaczyć listę zakupów poszczególnych klientów opłaconych Euro");
        System.out.println("wpisz task 5 aby zobaczyć listę produktów jakie zakupił klient z danego rocznika");
        System.out.println("wpisz task 6 aby zobaczyć listę kategorii kupowanych przez poszczególne roczniki");
        System.out.println("wpisz task 7 aby zobaczyć listę najczęściej sprzedawanych prosuktów");
        System.out.println("wpisz \"powrót\"  aby wrócić do menu wyboru poziomów");
        TaskCheckerForPakietSecond(sc); //wywołuje funkcję do sprawdzania, który task ma zostać wywołany
    }

    private void TaskCheckerForPakietSecond(Scanner sc) {
        //w zależności od wybranego tasku wywołuje się odpowiednia funkcja z klasy levelSecond
        while (sc.hasNextLine()){
            String taskForPakietTwo = sc.nextLine();

            switch (taskForPakietTwo){
                case "task 1"->
                        pakietSecond.Task1();
                case "task 2" -> {
                    System.out.println
                            ("""
                                    wybierz kategorie (wpisz cyfre):
                                    1: Ogród
                                    2: motoryzacja
                                    3: moda
                                    4: hobby
                                    5: powrót""");
                    EnumValidator(sc); //funkcja która przekazuje do metody kategorię wybraną przez użytkowanika
                }
                case "task 3"
                    -> pakietSecond.Task3();
                case "task 4"
                    -> pakietSecond.Task4();
                case "task 5"
                    -> pakietSecond.Task5();
                case "task 6"
                    -> pakietSecond.Task6();
                case "task 7"
                    -> pakietSecond.task7();
                case "powrót"
                    ->letsStart(sc);
                default -> System.out.println("nie rozumiem");

            }
        }
    }

    private void EnumValidator(Scanner sc) {
        //użytkownik wybiera, jaką kategorie chce sprawdzić i zostaje ona przekazana do funkcji
        while (sc.hasNextLine()){
            String category = sc.nextLine();
            Product.Category kategoria;
            if(category.equals("5")){
                startPakiet2(sc);
            }

            switch (category){
                case "1"
                        -> kategoria=Product.Category.GARDEN;
                case "2"
                        -> kategoria=Product.Category.AUTOMOTIVE;
                case "3"
                        ->kategoria=Product.Category.CLOTHES;
                case "4"
                        ->kategoria=Product.Category.HOBBY;
                default -> {
                    System.out.println("nie rozumiem. Wybierz kategorie od 1 - 4" );
                    continue;
                }

            }
            pakietSecond.Task2(kategoria);
        }
    }

    private void startPakiet3(Scanner sc) {
        System.out.println("wpisz task 1 aby wyświetlić tabele z informacjami: \n" +
                "rocznik klientów (pod uwagę brani są starsi niż 50 lat) " +
                "| najmniej popularna kategoria dla danego rocznika " +
                "| ilość transakcji dla danego rocznika w obrębie danej kategorii");

        System.out.println();

        System.out.println("wpisz task 2 aby zobaczyć który rocznik zakupił najwięcej produktów");

        taskCheckerForPakietThird(sc); //wywołuje funkcje do sprawdzania, który task ma zostać wywołany
    }

    private void taskCheckerForPakietThird(Scanner sc) {
        //w zależności od wybranego tasku wywołuje się odpowiednia funkcja z klasy levelThird

        while (sc.hasNextLine()){
            String taskPakietForLevelThree = sc.nextLine();

            switch (taskPakietForLevelThree){
                case "task 1"
                        -> pakietThird.task1();
                case "task 2"
                        -> System.out.println(pakietThird.getAnswerTask2());
                case "powrót"
                        ->letsStart(sc);
                default -> System.out.println("nie rozumiem");
            }
        }
    }
}
