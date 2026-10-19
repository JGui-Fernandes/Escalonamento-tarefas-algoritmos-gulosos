package br.unisinos.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class IntervalInstances {

    private IntervalInstances() { }

    public static List<Interval> small() {
        return Arrays.asList(
                new Interval(1, 1, 3),
                new Interval(2, 2, 4),
                new Interval(3, 3, 5),
                new Interval(4, 0, 7),
                new Interval(5, 5, 9),
                new Interval(6, 5, 7),
                new Interval(7, 8, 9)
        );
    }

    public static List<Interval> medium() {
        return Arrays.asList(
                new Interval(1, 4, 7),
                new Interval(2, 1, 3),
                new Interval(3, 3, 4),
                new Interval(4, 0, 6),
                new Interval(5, 5, 9),
                new Interval(6, 5, 7),
                new Interval(7, 8, 11),
                new Interval(8, 8, 12),
                new Interval(9, 2, 14),
                new Interval(10, 12, 16),
                new Interval(11, 13, 15),
                new Interval(12, 15, 18),
                new Interval(13, 16, 19),
                new Interval(14, 18, 20),
                new Interval(15, 6, 10),
                new Interval(16, 10, 13),
                new Interval(17, 11, 14),
                new Interval(18, 14, 17),
                new Interval(19, 17, 21),
                new Interval(20, 19, 22)
        );
    }

    public static List<Interval> large(int n) {
        Random rnd = new Random();
        List<Interval> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            int start = rnd.nextInt(1_000_000);
            int duration = 1 + rnd.nextInt(1000);
            int end = start + duration;
            list.add(new Interval(i, start, end));
        }
        return list;
    }
}