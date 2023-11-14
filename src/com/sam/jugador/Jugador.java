package com.sam.jugador;

public class Jugador {

    private  String posicion;
    private String apellido;
    private Integer numCamiseta;
    private String estado;

    public Jugador( String apellido,String posicion, Integer numCamiseta, String estado) {
        this.posicion = posicion;
        this.apellido = apellido;
        this.numCamiseta = numCamiseta;
        this.estado = estado;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getNumCamiseta() {
        return numCamiseta;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "posicion='" + posicion + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numCamiseta=" + numCamiseta +
                ", estado='" + estado + '\'' +
                '}';
    }
}
