package ru.aston.stage1.hw3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        printDelimiter("1");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        printDelimiter("2");
        Set<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(collect);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        printDelimiter("3");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        printDelimiter("4");
        String stringOfNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(stringOfNames);

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        printDelimiter("5");
        boolean milan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        if (milan) {
            System.out.println("There is a Trader from Milan");
        } else {
            System.out.println("A Trader from Milan has not been found");
        }

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        printDelimiter("6");
        System.out.println(transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue).sum());

        //7. Какова максимальная сумма среди всех транзакций?
        printDelimiter("7");
        System.out.println(transactions.stream()
                .mapToInt(Transaction::getValue).max());

        //8. Найти транзакцию с минимальной суммой.
        printDelimiter("8");
        System.out.println(transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue)));
    }

    public static void printDelimiter(String delimiter) {
        System.out.println("\n========= " + delimiter + " ===========");
    }
}
