/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestion;
import java.util.ArrayList;
/**
 *
 * @author Ivan
 */

public interface ProcesaVehiculo {
    void ordenarVehiculosPorPlaca(ArrayList<Vehiculo> lista);
    void listarVehiculos(ArrayList<Vehiculo> lista);
    String mostrarVehiculo(ArrayList<Vehiculo> bd, String placaBuscada);
}
