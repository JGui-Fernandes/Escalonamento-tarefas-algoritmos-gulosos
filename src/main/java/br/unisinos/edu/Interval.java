package br.unisinos.edu;

final class Interval {
    private final int id;
    private final int start;
    private final int end;

    public Interval(int id, int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Intervalo inválido: o valor de Início deve ser menor que o final");
        }
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "J" + id + "[" + start + "," + end + ")";
    }
}