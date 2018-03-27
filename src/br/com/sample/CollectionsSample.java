package br.com.sample;

public class CollectionsSample {

    public static void main (final String... args) {
        // Convenience Factory Methods
        //        final Map<Integer, String> weekDays = Map.of(
        //                1, "Segunda",
        //                2, "Terça",
        //                3, "Quarta",
        //                4, "Quinta",
        //                5, "Sexta",
        //                6, "Sábado",
        //                7, "Domingo"
        //        );
        //        System.out.println(weekDays);

        //        final Map<Integer, String> weekendDays = Map.ofEntries(
        //                Map.entry(1, "Sab"),
        //                Map.entry(2, "Dom")
        //        );
        //        System.out.println(weekendDays);

        //        final List<String> daysList = List.of("Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom");
        //        System.out.println(daysList);

        //        final Set<String> daysSet = Set.of("Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom");
        //        System.out.println(daysSet);

        // Stream.ofNullable
        //        final Map<Integer, String> weekDays = new HashMap<>();
        //        weekDays.put(1, "Segunda");
        //        weekDays.put(2, "Terça");
        //        weekDays.put(3, "Quarta");
        //        weekDays.put(4, "Quinta");
        //        weekDays.put(5, "Sexta");
        //        weekDays.put(6, "Sábado");
        //        weekDays.put(7, "Domingo");
        //        weekDays.put(8, null);
        //        final List<String> simpleDays = weekDays.entrySet()
        //                .stream()
        //                .flatMap(e -> Stream.ofNullable(e.getValue()))
        //                .map(v -> v.substring(0, 3))
        //                .collect(Collectors.toList());
        //        System.out.println(simpleDays);

        // IntStream.dropWhile
        //        IntStream.range(0, 10)
        //                .dropWhile(n -> n < 5)
        //                .forEach(System.out::println);

        // IntStream.takeWhile
        //        IntStream.range(0, 10)
        //                .takeWhile(n -> n < 5)
        //                .forEach(System.out::println);

        // Stream.iterate
        //        Stream.iterate(0, n -> n < 10, n -> n + 1)
        //                .forEach(System.out::println);
    }
}
