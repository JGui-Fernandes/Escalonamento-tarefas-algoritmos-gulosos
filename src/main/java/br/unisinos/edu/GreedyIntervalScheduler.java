package br.unisinos.edu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

final class GreedyIntervalScheduler {

    public ScheduleResult solve(List<Interval> input, boolean traceDecisions) {
        if (input == null || input.isEmpty()) {
            return new ScheduleResult(List.of(), List.of());
        }

        List<Interval> sorted = new ArrayList<>(input);
        sorted.sort(Comparator
                .comparingInt(Interval::getEnd)
                .thenComparingInt(Interval::getStart));

        List<Interval> selected = new ArrayList<>();
        List<Decision> decisions = traceDecisions ? new ArrayList<>() : List.of();

        int lastEnd = Integer.MIN_VALUE;

        for (Interval current : sorted) {
            int before = lastEnd;

            if (current.getStart() >= lastEnd) {
                selected.add(current);
                lastEnd = current.getEnd();

                if (traceDecisions) {
                    decisions.add(new Decision(Decision.Type.ACCEPTED, current, before, lastEnd));
                }
            } else {
                if (traceDecisions) {
                    decisions.add(new Decision(Decision.Type.DISCARDED, current, before, lastEnd));
                }
            }
        }

        return new ScheduleResult(selected, decisions);
    }
}
