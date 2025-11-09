/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author Ivan
 */
public class VehiculoSinConvenio extends Vehiculo {
    private String aseguradora; // MAPFRE, SURA, ALLIANZ, SOLIDARIA, LIBERTY

    public VehiculoSinConvenio(String placa, String modelo, Propietario propietario, String aseguradora) {
        super(placa, modelo, propietario);
        this.aseguradora = aseguradora;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    @Override
    public String adicionarReparacion(Reparacion nvaReparacion) {
        // insertar al inicio
        reparaciones.add(0, nvaReparacion);
        double costoAPagar = nvaReparacion.getCosto(); // sin descuento
        String garantia = nvaReparacion.calcularGarantia();
        return "Costo a pagar: " + String.format("%.0f", costoAPagar) + " | Garantía: " + garantia;
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo: SIN CONVENIO\nAseguradora: " + aseguradora + "\n";
    }
}

