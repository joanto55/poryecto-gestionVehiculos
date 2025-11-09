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

    @Override
    public void listarVehiculos(ArrayList<Vehiculo> lista) {
        ordenarVehiculosPorPlaca(lista);
        System.out.println("Listado de vehiculos:");
        for (Vehiculo v : lista) {
            String tipo = (v instanceof VehiculoConConvenio) ? "CON CONVENIO" : "SIN CONVENIO";
            System.out.println("Placa: " + v.getPlaca() +
                    " | Modelo: " + v.getModelo() +
                    " | " + tipo +
                    " | Propietario: " + v.getPropietario().getNombre() +
                    " | % verificadas: " + String.format("%.2f", v.calcularPorcentajeVerificados()) + "%");
        }
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

    /**
     * Buscar vehículo por placa (retorna null si no existe)
     */
    private Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
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
                    System.out.print("Placa: ");
                    String pl = sc.nextLine();
                    System.out.print("Modelo: ");
                    String mod = sc.nextLine();
                    System.out.print("Nombre propietario: ");
                    String nom = sc.nextLine();
                    System.out.print("Cedula (solo numeros): ");
                    int ced = Integer.parseInt(sc.nextLine());
                    System.out.print("Celular (solo numeros): ");
                    int cel = Integer.parseInt(sc.nextLine());
                    System.out.print("¿Con convenio? (s/n): ");
                    String r = sc.nextLine();
                    Propietario nuevoP = new Propietario(nom, ced, cel);
                    if ("s".equalsIgnoreCase(r)) {
                        System.out.print("Fecha afiliación (yyyy-MM-dd): ");
                        String fecha = sc.nextLine();
                        Vehiculo nuevoV = new VehiculoConConvenio(pl, mod, nuevoP, fecha);
                        vehiculos.add(nuevoV);
                    } else {
                        System.out.print("Aseguradora (MAPFRE, SURA, ALLIANZ, SOLIDARIA, LIBERTY): ");
                        String as = sc.nextLine();
                        Vehiculo nuevoV = new VehiculoSinConvenio(pl, mod, nuevoP, as);
                        vehiculos.add(nuevoV);
                    }
                    System.out.println("Vehículo agregado.");
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
        UsaVehiculo app = new UsaVehiculo();
        // Ejecuta la consola para probar
        app.iniciarConsola();
    }
}

