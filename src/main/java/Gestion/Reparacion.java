/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author Ivan
 */
public class Reparacion {
    private String descripcion;
    private String estado; // "Diagnostico", "Reparación", "Verificada"
    private int costo; // entero, ejemplo 450000

    public Reparacion(String descripcion, String estado, int costo) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public int getCosto() {
        return costo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Calcula el tiempo de garantía según el estado:
     * - Diagnostico -> "Sin Garantía hasta finalizar"
     * - Reparación -> "Garantía de 15 días"
     * - Verificada (u otros) -> "Garantía de 45 días"
     */
    public String calcularGarantia() {
        if ("Diagnostico".equalsIgnoreCase(estado)) {
            return "Sin Garantía hasta finalizar";
        } else if ("Reparación".equalsIgnoreCase(estado) || "Reparacion".equalsIgnoreCase(estado)) {
            return "Garantía de 15 días";
        } else {
            return "Garantía de 45 días";
        }
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", costo=" + costo +
                '}';
    }
}

