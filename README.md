# Sklep_internetowy_Zajavka
fikcyjny sklep z fikcyjnymi danymi, użytkownik używając terminalu wybiera pakiety o trzech poziomach trudności po czym wybiera taski będące odpowiedziami na dostępne zapytania.
obliczenia jakie wykonują poszczególne taski:
pakiet 1:
1. Oblicz jaka ilość klientów dokonała zakupu w naszym sklepie.
2. Oblicz jaka ilość klientów płaciła Blikiem.
3. Oblicz jaka ilość klientów płaciła kartą kredytową.
4. Oblicz jaka ilość zakupów została wykonana w walucie EUR.
5. Oblicz ile unikalnych kupionych produktów zostało zakupionych w EUR.

pakiet 2:
1. Oblicz ile PLN wydała w sklepie każda z osób, które dokonały u nas zakupu. Uwzględnij tylko zakupy
dokonane w PLN.

2. Przygotuj metodę, która przyjmie konkretną kategorię i dla tej kategorii zwróci mapę, gdzie kluczem
będzie id klienta, a wartością ilość kupionych przez niego produktów z podanej kategorii (weź pod
uwagę tylko te transakcje, w których ilość kupionych produktów jest większa niż 1).
3. Każde zamówienie początkowo ma status PAID. oblicz ile zamówień zostało przetworzonych, czyli mają
status DONE.

4. Oblicz ilu unikalnych klientów kupiło produkt wyceniony w EUR (klienci nie mogą się powtarzać,
pamiętaj, że jeden mógł kupić kilka produktów). Dodatkowo stwórz mapę w której kluczem jest id
klienta, a wartością lista zakupów produktów tego klienta w EUR.

5. Przygotuj mapę, gdzie kluczem będzie rocznik klienta, a wartościami, lista wszystkich produktów
jakie klient z danego rocznika kupił. Rocznik weź z numeru PESEL, nie musi być to pełne 1987, może
być przykładowo 87. Posortuj mapę po kluczu rosnąco.

6. Stwórz mapę, gdzie kluczem będą roczniki, a wartością unikalny zestaw kategorii produktów
kupionych przez dany rocznik.

7. Jaki jest drugi najczęściej kupowany produkt? Jeżeli kilka produktów jest kupionych w takiej samej
ilości, posortuj je alfabetycznie po id, i nadal weź drugi. Czyli sortujesz najpierw po największej
ilości wystąpień danego produktu, a potem po id.

pakiet 3:
1. Dla ludzi starszych niż 50 lat stwórz strukturę, w której zawrzesz informacje: rocznik, najmniej
popularna kategoria dla danego rocznika, ilość transakcji dla danego rocznika w obrębie danej
kategorii. 
2. Który rocznik kupił najwięcej produktów?
