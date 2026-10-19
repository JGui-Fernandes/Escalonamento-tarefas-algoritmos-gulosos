package br.unisinos.edu;

final class Decision {
    enum Type {
        ACCEPTED, DISCARDED
    }

    private final Type type;
    private final Interval interval;
    private final int lastEndBefore;
    private final int lastEndAfter;

    public Decision(Type type, Interval interval, int lastEndBefore, int lastEndAfter) {
        this.type = type;
        this.interval = interval;
        this.lastEndBefore = lastEndBefore;
        this.lastEndAfter = lastEndAfter;
    }

    public Type getType() {
        return type;
    }

    public Interval getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        if (type == Type.ACCEPTED) {
            return String.format("ACEITA   %-12s (lastEnd: %d -> %d)",
                    interval, lastEndBefore, lastEndAfter);
        }
        return String.format("DESCARTA %-12s (motivo: start=%d < lastEnd=%d)",
                interval, interval.getStart(), lastEndBefore);
    }
}