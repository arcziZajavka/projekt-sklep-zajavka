import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class pakietThird extends Level{
final Integer CURRENT_YEAR = 2020;
private final String answerTask2 = task2();

    public String getAnswerTask2() {
        return answerTask2;
    }

    private int getAnInt(Purchase p) {
        //metoda do wyciągania rocznika z peselu
        return Integer.parseInt(p.getBuyer().getPesel().toString().substring(0, 2));
    }
    public void task1() {
        Map<String, Map<Product.Category, Long>> yearWithCategoriesWithoutZeros = produce.stream()
                .filter(p -> CURRENT_YEAR - (1900 + getAnInt(p)) > 50)
                .collect(Collectors.groupingBy(
                        p -> p.getBuyer().getPesel().toString().substring(0, 2),
                        Collectors.groupingBy(
                                p -> p.getProduct().getCategory(),
                                Collectors.counting()
                        )
                ));
        var yearWithCatgerioesWithZeros = yearWithCategoriesWithoutZeros.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Arrays.stream(Product.Category.values())
                                .collect(Collectors.toMap(
                                        //kluczem jest kategoria
                                        categoryKey -> e.getValue().getOrDefault(categoryKey, 0L),
                                        List::of,
                                        (currentList, nextList) -> Stream.concat(currentList.stream(), nextList.stream())
                                                .collect(Collectors.toList()),
                                        TreeMap::new
                                ))
                ));
        Map<String, Map.Entry<Long, List<Product.Category>>> yearWithMinimumCategoryEntry = yearWithCatgerioesWithZeros.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .min(Comparator.comparing((Map.Entry<Long, List<Product.Category>> entry) -> e.getKey()))
                                .get(),
                        (e1, e2) -> e2,
                        TreeMap::new
                ));

        for (Map.Entry<String, Map.Entry<Long, List<Product.Category>>> entry : yearWithMinimumCategoryEntry.entrySet()) {
            String k = entry.getKey();
            Map.Entry<Long, List<Product.Category>> v = entry.getValue();
            System.out.println("rocznik: " + k + " | popularność kategorii: " + v);
        }

    }

    public String task2(){

        Map<Integer, Long> quantityByYear = produce.stream()
                .collect(Collectors.groupingBy(
                        this::getAnInt,
                        Collectors.mapping(
                                Purchase::getQuanity,
                                Collectors.reducing(0L, Long::sum)
                        )
                ));

        Map<Long, Set<Integer>> yearByQuantity = quantityByYear.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,
                        e -> Set.of(e.getKey()),
                        (currentList, nextList) -> Stream.concat(currentList.stream(), nextList.stream())
                                .collect(Collectors.toSet()),
                        TreeMap::new
                ));

        Map.Entry<Long, Set<Integer>> mostQuantityByYear = yearByQuantity.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .orElseThrow(() -> new RuntimeException("no purchases in the shop"));

        return "najwięcej produktów - "
                + mostQuantityByYear.getKey()
                +" zakupił rocznik: "+ mostQuantityByYear.getValue();
    }
}
