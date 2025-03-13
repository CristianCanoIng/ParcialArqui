package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cabina {
    private int id;
    private List<Object[]> llamadas;

    public Cabina(int id) {
        this.id = id;
        this.llamadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void registrarLlamada(String tipo, int duracion) {
        double costo = calcularCosto(tipo, duracion);
        llamadas.add(new Object[]{tipo, duracion, costo});
    }

    private double calcularCosto(String tipo, int duracion) {
        switch (tipo.toLowerCase()) {
            case "local": return duracion * 50;
            case "larga distancia": return duracion * 350;
            case "celular": return duracion * 150;
            default: return 0;
        }
    }

    public int getTotalLlamadas() {
        return llamadas.size();
    }

    public int getDuracionTotal() {
        return llamadas.stream().mapToInt(l -> (int) l[1]).sum();
    }

    public double getCostoTotal() {
        return llamadas.stream().mapToDouble(l -> (double) l[2]).sum();
    }

    public void mostrarDetalles() {
        System.out.println("Cabina #" + id);
        System.out.println("Total llamadas: " + getTotalLlamadas());
        System.out.println("Duración total: " + getDuracionTotal() + " min");
        System.out.println("Costo total: $" + getCostoTotal());
    }
}