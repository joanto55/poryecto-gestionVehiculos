    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Gestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Ivan
 */

public class UsaVehiculo implements ProcesaVehiculo {

    private static Runnable runnable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private ArrayList<Vehiculo> vehiculos;

    public UsaVehiculo() {
        vehiculos = new ArrayList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // Datos iniciales de ejemplo (puedes cambiarlos)
        Propietario p1 = new Propietario("Carlos Perez", 10203040, 300111222);
        Vehiculo v1 = new VehiculoConConvenio("CFT239", "Toyota Corolla", p1, "2023-01-10");
        v1.adicionarReparacion(new Reparacion("Cambio de pastillas", "Diagnostico", 120000));
        v1.adicionarReparacion(new Reparacion("Cambio de aceite", "Verificada", 80000));

        Propietario p2 = new Propietario("Ana Gomez", 20304050, 310222333);
        Vehiculo v2 = new VehiculoSinConvenio("XYZ123", "Chevrolet Spark", p2, "SURA");
        v2.adicionarReparacion(new Reparacion("Revisión frenos", "Reparación", 150000));

        vehiculos.add(v1);
        vehiculos.add(v2);
    }

    @Override
    public void ordenarVehiculosPorPlaca(ArrayList<Vehiculo> lista) {
        Collections.sort(lista, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                return o1.getPlaca().compareToIgnoreCase(o2.getPlaca());
            }
        });
    }

   // EN UsaVehiculo.java (MODIFICAR)
@Override
public String listarVehiculos(ArrayList<Vehiculo> lista) {
    StringBuilder reporte = new StringBuilder(); 
    
    if (lista.isEmpty()) {
        return "--- No hay vehículos registrados ---\n";
    }

    reporte.append("--- REPORTE DE TODOS LOS VEHÍCULOS ---\n\n");
    for (Vehiculo veh : lista) {
        // Usa el método toString() de tu clase Vehiculo para generar un formato legible
        reporte.append(veh.toString()).append("\n==================================\n"); 
    }
    
    return reporte.toString(); 
}
    @Override
    public String mostrarVehiculo(ArrayList<Vehiculo> bd, String placaBuscada) {
        for (Vehiculo v : bd) {
            if (v.getPlaca().equalsIgnoreCase(placaBuscada)) {
                return v.toString();
            }
        }
        return "No se encontró vehículo con placa: " + placaBuscada;
    }
    
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Buscar vehículo por placa (retorna null si no existe)
     */
    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean adicionarVehiculo(Vehiculo veh) {
    if (veh == null) {
        return false;
    }
    // La lista 'vehiculos' es la propiedad ArrayList<Vehiculo>
    return vehiculos.add(veh); 
}
    /**
     * Método de consola simple para probar las funcionalidades.
     */
    public void iniciarConsola() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar vehiulos");
            System.out.println("2. Mostrar vehiulo por placa");
            System.out.println("3. Agregar vehiculo");
            System.out.println("4. Agregar reparacion a vehiculo");
            System.out.println("5. Ordenar por placa");
            System.out.println("6. Salir");
            System.out.print("Seleccione opcion: ");
            String opt = sc.nextLine();
            switch (opt) {
                case "1":
                    listarVehiculos(vehiculos);
                    break;
                case "2":
                    System.out.print("Ingrese placa: ");
                    String placa = sc.nextLine();
                    System.out.println(mostrarVehiculo(vehiculos, placa));
                    break;
                case "3":
                    try{
                        System.out.print("Placa: ");
                        String pl = sc.nextLine();
                        if(pl.matches("^[a-zA-Z]{3}\\d{3}$")){
                        System.out.print("Modelo: ");
                        String mod = sc.nextLine();
                        System.out.print("Nombre propietario: ");
                        String nom = sc.nextLine();
                        if(nom.matches("^[a-zA-Z\\s]+$")){
                        System.out.print("Cedula (solo numeros): ");
                        int ced = Integer.parseInt(sc.nextLine());
                        System.out.print("Celular (solo numeros): ");
                        int cel = Integer.parseInt(sc.nextLine());
                        System.out.print("Con convenio? (si/no): ");
                        String r = sc.nextLine();
                        Propietario nuevoP = new Propietario(nom, ced, cel);
                        if ("si".equalsIgnoreCase(r)) {
                            System.out.print("Fecha afiliacion (yyyy-MM-dd): ");
                            String fecha = sc.nextLine();
                            Vehiculo nuevoV = new VehiculoConConvenio(pl, mod, nuevoP, fecha);
                            vehiculos.add(nuevoV);
                        }if ("no".equalsIgnoreCase(r)){
                            System.out.print("Aseguradora (MAPFRE, SURA, ALLIANZ, SOLIDARIA, LIBERTY): ");
                            String as = sc.nextLine();
                            Vehiculo nuevoV = new VehiculoSinConvenio(pl, mod, nuevoP, as);
                            vehiculos.add(nuevoV);
                        
                        System.out.println("Vehiculo agregado.");
                        }else {
                            System.err.println("ERROR DE ENTRADA: Debe ingresar una respuesta valida (si/no)");
                        }}else{
                           System.err.println("ERROR DE ENTRADA: Debe ingresar solo letras para el nombre");
                        }}else{
                            System.err.println("ERROR DE ENTRADA: La placa debe tener exactamente 3 letras y 3 numeros (ej: ABC123).");
                        }
                    } catch(NumberFormatException e){
                        System.err.println("ERROR DE ENTRADA!!!!");
                        System.err.println("Debe ingresar solo numeros para cedula o numero de celular");
                    } catch(Exception e){
                        System.err.println("ERROR DE REGISTRO!!!!");
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.print("Placa vehículo: ");
                    String pBuscar = sc.nextLine();
                    Vehiculo veh = buscarPorPlaca(pBuscar);
                    if (veh == null) {
                        System.out.println("No existe vehículo con esa placa.");
                    } else {
                        System.out.print("Descripción reparación: ");
                        String desc = sc.nextLine();
                        System.out.print("Estado (Diagnostico / Reparación / Verificada): ");
                        String estado = sc.nextLine();
                        System.out.print("Costo (ej. 450000): ");
                        int costo = Integer.parseInt(sc.nextLine());
                        Reparacion rep = new Reparacion(desc, estado, costo);
                        String resultado = veh.adicionarReparacion(rep);
                        System.out.println("Resultado: " + resultado);
                    }
                    break;
                case "5":
                    ordenarVehiculosPorPlaca(vehiculos);
                    System.out.println("Ordenado por placa.");
                    break;
                case "6":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

   public static void main(String[] args) {
        // Ya no se ejecuta la consola:
        // UsaVehiculo app = new UsaVehiculo();
        // app.iniciarConsola(); 

        // Se lanza la ventana principal usando la Clase Anónima
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    boolean agregarVehiculo(Vehiculo nuevoVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}