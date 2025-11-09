/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected Propietario propietario;
    protected ArrayList<Reparacion> reparaciones;

    public Vehiculo(String placa, String modelo, Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.reparaciones = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Adiciona una reparación (implementado por las subclases)
     * Debe almacenar la reparación al inicio de la lista y retornar una cadena
     * con el costo a pagar y la garantía.
     */
    public abstract String adicionarReparacion(Reparacion nvaReparacion);

    /**
     * Calcula el porcentaje de reparaciones verificadas (0.0 si no tiene reparaciones).
     * Retorna un número en rango 0.0 - 100.0
     */
    public final double calcularPorcentajeVerificados() {
        if (reparaciones == null || reparaciones.isEmpty()) {
            return 0.0;
        }
        int total = reparaciones.size();
        int verificados = 0;
        for (Reparacion r : reparaciones) {
            if ("Verificada".equalsIgnoreCase(r.getEstado())) {
                verificados++;
            }
        }
        return (verificados * 100.0) / total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa: ").append(placa).append("\n");
        sb.append("Modelo: ").append(modelo).append("\n");
        sb.append("Propietario: ").append(propietario.getNombre()).append(" (").append(propietario.getCedula()).append(")\n");
        sb.append("Porcentaje reparaciones verificadas: ").append(String.format("%.2f", calcularPorcentajeVerificados())).append("%\n");
        sb.append("Reparaciones:\n");
        for (Reparacion r : reparaciones) {
            sb.append("  - ").append(r.toString()).append("\n");
        }
        return sb.toString();
    }
}

