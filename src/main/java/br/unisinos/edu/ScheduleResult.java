package br.unisinos.edu;

import java.util.List;

final class ScheduleResult {
    private final List<Interval> selected;
    private final List<Decision> decisions;

    public ScheduleResult(List<Interval> selected, List<Decision> decisions) {
        this.selected = selected;
        this.decisions = decisions;
    }

    public List<Interval> getSelected() {
        return selected;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public int countSelected() {
        return selected.size();
    }
}