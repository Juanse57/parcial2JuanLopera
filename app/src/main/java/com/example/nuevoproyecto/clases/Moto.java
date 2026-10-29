package com.example.nuevoproyecto.clases;

import java.io.Serializable; // <- 1. Importar Serializable

public class Moto implements Serializable { // <- 2. Implementar la interfaz
    private String imagenUrl;
    private int imagenResId; // Recurso local de respaldo (drawable)
    private String nombre;
    private String detalles;

    public Moto(String imagenUrl, int imagenResId, String nombre, String detalles) {
        this.imagenUrl = imagenUrl;
        this.imagenResId = imagenResId;
        this.nombre = nombre;
        this.detalles = detalles;
    }

    public String getImagenUrl() { return imagenUrl; }
    public int getImagenResId() { return imagenResId; }
    public String getNombre() { return nombre; }
    public String getDetalles() { return detalles; }
}