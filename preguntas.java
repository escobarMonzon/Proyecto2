package com.example.proyecto2;

public class preguntas {
    private static int correlativo=1;
    public int idcuestionario, idPregunta, duracion, puntos;
    public String nombrePregunta;

    public preguntas(int idcuestionario, int duracion, int puntos, String nombrePregunta) {
        this.idPregunta = correlativo;
        this.idcuestionario = idcuestionario;
        this.duracion = duracion;
        this.puntos = puntos;
        this.nombrePregunta = nombrePregunta;
        correlativo++;
    }

    public static int getCorrelativo() {
        return correlativo;
    }

    public static void setCorrelativo(int correlativo) {
        preguntas.correlativo = correlativo;
    }

    public int getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(int idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombrePregunta() {
        return nombrePregunta;
    }

    public void setNombrePregunta(String nombrePregunta) {
        this.nombrePregunta = nombrePregunta;
    }
}
