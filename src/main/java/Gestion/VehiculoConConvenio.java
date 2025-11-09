/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import java.time.LocalDate;

/**
 *
 * @author Ivan
 */
public class VehiculoConConvenio extends Vehiculo {
    private LocalDate fechaAfiliacion;
    private final double porcentajeDescuento = 0.8; // se paga el 80% (descuento del 20%)

    /**
     * Constructor recibe fechaAfiliacion como String en formato ISO yyyy-MM-dd
     */
    public VehiculoConConvenio(String placa, String modelo, Propietario propietario, String fechaAfiliacionStr) {
        super(placa, modelo, propietario);
        try {
            this.fechaAfiliacion = LocalDate.parse(fechaAfiliacionStr);
        } catch (Exception e) {
            // Si el parse falla, usamos la fecha actual como fallback
            this.fechaAfiliacion = LocalDate.now();
        }
    }

    public String getFechaAfiliacion() {
        return fechaAfiliacion.toString();
    }

    public void setFechaAfiliacion(String fechaAfiliacionStr) {
        try {
            this.fechaAfiliacion = LocalDate.parse(fechaAfiliacionStr);
        } catch (Exception e) {
            // ignorar o dejar la anterior
        }
    }

    @Override
    public String adicionarReparacion(Reparacion nvaReparacion) {
        // insertar al inicio
        reparaciones.add(0, nvaReparacion);
        double costoAPagar = nvaReparacion.getCosto() * porcentajeDescuento;
        String garantia = nvaReparacion.calcularGarantia();
        return "Costo a pagar: " + String.format("%.0f", costoAPagar) + " | Garantía: " + garantia;
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo: CON CONVENIO\nFecha afiliación: " + fechaAfiliacion + "\n";
    }
}

