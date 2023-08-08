package com.example.TicketOnline.Entities;

public enum Discount {
    NESSUNO(0.0),     // Nessuno sconto
    STUDENTE(0.1),    // Sconto per studenti -> 10%
    ANZIANO(0.25),    // Sconto per anziani -> 25%
    VIP(0.5);         // Sconto VIP -> 50% se acquistato

    private final double value;

    // Costruttore  dell'enum Discount
    private Discount(double value) {
        this.value = value;
    }

    // Metodo per ottenere il valore dello sconto
    public double getValue() {
        return value;
    }
}
