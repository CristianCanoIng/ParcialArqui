package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Cabina> cabinas = new ArrayList<>();
            int opcion;

            do {
                System.out.println("\n[1] Crear cabina telefonica");
                System.out.println("[2] Registrar una llamada");
                System.out.println("[3] Mostrar detalles de una cabina");
                System.out.println("[4] Mostrar total de todas las cabinas");
                System.out.println("[5] Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Cree un Id para la cabina: ");
                        int id = scanner.nextInt();
                        cabinas.add(new Cabina(id));
                        System.out.println("Nueva cabina creada");
                        break;

                    case 2:

                        System.out.print("Ingrese el ID de la cabina: ");
                        int idCabina = scanner.nextInt();
                        Cabina cabinaSeleccionada = cabinas.stream()
                                .filter(c -> c.getId() == idCabina)
                                .findFirst()
                                .orElse(null);

                        if (cabinaSeleccionada == null) {
                            System.out.println("Esta cabina no existe");
                            break;
                        }

                        System.out.println("Tipo de llamada (local, larga distancia, celular): ");
                        scanner.nextLine();
                        String tipo = scanner.nextLine();
                        System.out.print("Duracion en minutos: ");
                        int duracion = scanner.nextInt();

                        cabinaSeleccionada.registrarLlamada(tipo, duracion);
                        System.out.println("Llamada registrada con exito");
                        break;

                    case 3:
                        System.out.print("Ingrese el ID de la cabina: ");
                        int idMostrar = scanner.nextInt();
                        Cabina cabinaMostrar = cabinas.stream()
                                .filter(c -> c.getId() == idMostrar)
                                .findFirst()
                                .orElse(null);

                        if (cabinaMostrar != null) {
                            cabinaMostrar.mostrarDetalles();
                        } else {
                            System.out.println("no existe esta cabina");
                        }
                        break;

                    case 4:
                        int totalLlamadas = cabinas.stream().mapToInt(Cabina::getTotalLlamadas).sum();
                        int duracionTotal = cabinas.stream().mapToInt(Cabina::getDuracionTotal).sum();
                        double costoTotal = cabinas.stream().mapToDouble(Cabina::getCostoTotal).sum();

                        System.out.println("\n Total:");
                        System.out.println("Número total de llamadas: " + totalLlamadas);
                        System.out.println("Duración total: " + duracionTotal + " min");
                        System.out.println("Costo total: $" + costoTotal);
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 6);

            scanner.close();
        }
    }