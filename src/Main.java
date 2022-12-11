
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StartTerminal startTerminal = new StartTerminal();//klasa sterująca
        Scanner sc = new Scanner(System.in);

        System.out.println("Witaj ! Wpisz start aby rozpocząć");

        while (sc.hasNextLine()){
            String task = sc.nextLine().trim().toLowerCase();
            startTerminal.start(task, sc);//wywołuje się funkcja odbierająca wartości wpisywane przez użytkownika
        }
    }
}