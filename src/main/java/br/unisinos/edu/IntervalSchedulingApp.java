package br.unisinos.edu;

import java.util.List;

public class IntervalSchedulingApp {

    public static void main(String[] args) {
        warmUp();

        runTest("Teste 1 - Pequena instância", IntervalInstances.small(), true, true);
        runTest("Teste 2 - Média instância", IntervalInstances.medium(), true, true);
        runTest("Teste 3 - Grande instância (100000 intervalos)",
                IntervalInstances.large(100_000), false, false);
    }

    private static void warmUp() {
        GreedyIntervalScheduler scheduler = new GreedyIntervalScheduler();

        List<Interval> smallData = IntervalInstances.small();
        List<Interval> mediumData = IntervalInstances.medium();
        List<Interval> largeData = IntervalInstances.large(50_000);

        long sink = 0;

        for (int i = 0; i < 20; i++) {
            sink += scheduler.solve(smallData, true).countSelected();
            sink += scheduler.solve(mediumData, true).countSelected();
            sink += scheduler.solve(largeData, false).countSelected();
        }

        if (sink == Long.MIN_VALUE) {
            System.out.println(sink);
        }
    }

    private static void runTest(String title, List<Interval> input, boolean traceDecisions, boolean printInputAll) {
        System.out.println("\n=== " + title + " ===");
        printInput(input, printInputAll);

        GreedyIntervalScheduler scheduler = new GreedyIntervalScheduler();
        Stopwatch sw = new Stopwatch();

        sw.start();
        ScheduleResult result = scheduler.solve(input, traceDecisions);
        double timeMs = sw.elapsedMs();

        if (traceDecisions) {
            System.out.println("\nDecisões do algoritmo (na ordem analisada):");
            for (Decision d : result.getDecisions()) {
                System.out.println(d);
            }
        }

        System.out.println();
        printResult(result, traceDecisions); // no teste passo-a-passo, imprime tudo
        System.out.printf("Tempo de execução: %.3f ms%n", timeMs);
    }

    private static void printInput(List<Interval> input, boolean printAll) {
        System.out.println("Entrada (n=" + input.size() + "):");
        if (!printAll) {
            System.out.println("(omitida; entrada grande)");
            return;
        }
        for (Interval it : input) {
            System.out.println("  " + it);
        }
    }

    private static void printResult(ScheduleResult result, boolean printAllSelected) {
        System.out.println("Solução:");
        System.out.println("Quantidade selecionada = " + result.countSelected());

        if (printAllSelected) {
            for (Interval it : result.getSelected()) {
                System.out.println("  " + it);
            }
        } else {
            int limit = Math.min(10, result.getSelected().size());
            for (int i = 0; i < limit; i++) {
                System.out.println("  " + result.getSelected().get(i));
            }
            if (result.getSelected().size() > limit) {
                System.out.println("  ... (demais omitidos)");
            }
        }
    }
}