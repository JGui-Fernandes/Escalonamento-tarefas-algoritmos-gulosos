package br.unisinos.edu;

final class Stopwatch {
    private long startNs;

    public void start() {
        startNs = System.nanoTime();
    }

    public long elapsedNs() {
        return System.nanoTime() - startNs;
    }

    public double elapsedMs() {
        return elapsedNs() / 1_000_000.0;
    }
}
