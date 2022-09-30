package com.example.proyecto2;

public class cuestionario {
    private static int correlativo=1;
    public int PinCuestionario, idcuestionario;
    public String nombrecuestionario, descripcioncuestionario, estado;


    public cuestionario(int pinCuestionario, String nombrecuestionario, String descripcioncuestionario , String estado) {
        this.idcuestionario = correlativo;
        PinCuestionario = pinCuestionario;
        this.nombrecuestionario = nombrecuestionario;
        this.descripcioncuestionario = descripcioncuestionario;
        this.estado = estado;
        correlativo++;
    }

    public int getPinCuestionario() {
        return PinCuestionario;
    }

    public void setPinCuestionario(int pinCuestionario) {
        PinCuestionario = pinCuestionario;
    }

    public String getNombrecuestionario() {
        return nombrecuestionario;
    }

    public void setNombrecuestionario(String nombrecuestionario) {
        this.nombrecuestionario = nombrecuestionario;
    }

    public String getDescripcioncuestionario() {
        return descripcioncuestionario;
    }

    public void setDescripcioncuestionario(String descripcioncuestionario) {
        this.descripcioncuestionario = descripcioncuestionario;
    }

    public int getIdcuestionario() {
        return idcuestionario;
    }

    public void setIdcuestionario(int idcuestionario) {
        this.idcuestionario = idcuestionario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
