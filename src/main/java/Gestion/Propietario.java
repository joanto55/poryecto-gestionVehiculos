/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author Ivan
 */
public class Propietario {
    private String nombre;
    private int cedula;
    private int numCel;

    public Propietario(String nombre, int cedula, int numCel) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numCel = numCel;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumCel() {
        return numCel;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumCel(int numCel) {
        this.numCel = numCel;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", numCel=" + numCel +
                '}';
    }
    }

