import java.util.Scanner;

public class Main {
    private static int testCount = 0;
    private static int passCount = 0;
    private static int failCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("1. Correr casos de prueba automatizados (Requisito)");
        System.out.println("2. Probar listas de forma interactiva (Gestión de Vehículos)");
        System.out.print("Elige una opción: ");
        
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Se maneja el error si el usuario no teclea un número
        }

        if (opcion == 1) {
            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║  PRUEBAS DE ARRAYLIST Y LINKEDLIST                         ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝\n");

            // Pruebas ArrayList
            System.out.println("\n═══════════════════════════════════════════════════════════");
            System.out.println("PRUEBAS: ARRAYLIST<STRING>");
            System.out.println("═══════════════════════════════════════════════════════════\n");
            pruebasArrayList();

            // Pruebas LinkedList
            System.out.println("\n═══════════════════════════════════════════════════════════");
            System.out.println("PRUEBAS: LINKEDLIST<STRING>");
            System.out.println("═══════════════════════════════════════════════════════════\n");
            pruebasLinkedList();

            // Resumen
            System.out.println("\n═══════════════════════════════════════════════════════════");
            System.out.println("RESUMEN DE PRUEBAS");
            System.out.println("═══════════════════════════════════════════════════════════");
            System.out.println("Total de pruebas: " + testCount);
            System.out.println("✅ Pasadas: " + passCount);
            System.out.println("❌ Fallidas: " + failCount);
            System.out.println("═══════════════════════════════════════════════════════════\n");
            
        } else if (opcion == 2) {
            menuInteractivo();
        } else {
            System.out.println("❌ Opción no válida. Por favor, ejecuta el programa nuevamente.");
        }
    }

    // ╔════════════════════════════════════════════════════════════╗
    // ║           MODO INTERACTIVO                                 ║
    // ╚════════════════════════════════════════════════════════════╝

    public static void menuInteractivo() {
        Scanner scanner = new Scanner(System.in);
        // Usamos tu implementación de ArrayList para el inventario
        ArrayList<String> inventario = new ArrayList<>();
        boolean salir = false;

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA INTERACTIVO - GESTIÓN DE VEHÍCULOS       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar un vehículo (Marca, Año, Color)");
            System.out.println("2. Eliminar un vehículo por su índice");
            System.out.println("3. Ver inventario completo");
            System.out.println("4. Volver / Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa los datos del vehículo (ej. Toyota 2022 Rojo): ");
                    String datosVehiculo = scanner.nextLine();
                    inventario.add(datosVehiculo);
                    System.out.println("✅ Vehículo guardado en el índice " + (inventario.size() - 1) + ".");
                    
                    // Pequeño recordatorio teórico de tu infografía
                    if (inventario.size() > 10) {
                        System.out.println("💡 Nota: El ArrayList acaba de realizar una expansión dinámica de capacidad (+10 espacios).");
                    }
                    break;
                    
                case 2:
                    if (inventario.isEmpty()) {
                        System.out.println("⚠️ El inventario está vacío.");
                        break;
                    }
                    System.out.print("Ingresa el índice del vehículo a eliminar (0 a " + (inventario.size() - 1) + "): ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        String eliminado = inventario.remove(indice);
                        System.out.println("🗑️ Vehículo eliminado exitosamente: " + eliminado);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Debes ingresar un número entero.");
                    } catch (IndexOutOfBoundsException e) {
                        // Demostramos el caso de error en vivo
                        System.out.println("❌ Error: Índice fuera de rango. Recuerda que el acceso es directo por índice.");
                    }
                    break;
                    
                case 3:
                    System.out.println("\n--- INVENTARIO ACTUAL (" + inventario.size() + " vehículos) ---");
                    if (inventario.isEmpty()) {
                        System.out.println("No hay vehículos registrados.");
                    } else {
                        System.out.println(inventario.toString());
                    }
                    break;
                    
                case 4:
                    salir = true;
                    System.out.println("Saliendo del modo interactivo...");
                    break;
                    
                default:
                    System.out.println("❌ Opción no válida. Intenta de nuevo.");
            }
        }
    }

    // ╔════════════════════════════════════════════════════════════╗
    // ║           PRUEBAS ARRAYLIST                                ║
    // ╚════════════════════════════════════════════════════════════╝

    public static void pruebasArrayList() {
        ArrayList<String> lista = new ArrayList<>();

        // ✅ CASOS POSITIVOS
        System.out.println("✅ CASOS POSITIVOS:\n");

        // Prueba 1: Agregar elementos al final
        test("ArrayList - Agregar al final", () -> {
            lista.add("Elemento 1");
            lista.add("Elemento 2");
            lista.add("Elemento 3");
            return lista.size() == 3;
        });

        // Prueba 2: Obtener elemento
        test("ArrayList - Obtener elemento", () -> {
            return lista.get(0).equals("Elemento 1");
        });

        // Prueba 3: Verificar tamaño
        test("ArrayList - Verificar tamaño", () -> {
            return lista.size() == 3;
        });

        // Prueba 4: Verificar no está vacía
        test("ArrayList - No está vacía", () -> {
            return !lista.isEmpty();
        });

        // Prueba 5: Agregar en posición específica
        test("ArrayList - Insertar en posición media", () -> {
            lista.add("Inserción", 1);
            return lista.get(1).equals("Inserción") && lista.size() == 4;
        });

        // Prueba 6: Agregar al principio
        test("ArrayList - Insertar al principio", () -> {
            lista.add("Principio", 0);
            return lista.get(0).equals("Principio") && lista.size() == 5;
        });

        // Prueba 7: Eliminar elemento
        test("ArrayList - Eliminar elemento", () -> {
            String eliminado = lista.remove(0);
            return eliminado.equals("Principio") && lista.size() == 4;
        });

        // Prueba 8: Expansión automática (agregar muchos elementos)
        ArrayList<String> listaGrande = new ArrayList<>();
        test("ArrayList - Expansión automática", () -> {
            for (int i = 0; i < 25; i++) {
                listaGrande.add("Item " + i);
            }
            return listaGrande.size() == 25;
        });

        // Prueba 9: Clear (limpiar lista)
        test("ArrayList - Limpiar lista", () -> {
            ArrayList<String> listaTemporal = new ArrayList<>();
            listaTemporal.add("A");
            listaTemporal.add("B");
            listaTemporal.clear();
            return listaTemporal.isEmpty() && listaTemporal.size() == 0;
        });

        // Prueba 10: toString
        test("ArrayList - Representación en String", () -> {
            ArrayList<Integer> listaNums = new ArrayList<>();
            listaNums.add(1);
            listaNums.add(2);
            listaNums.add(3);
            return listaNums.toString().contains("1") && listaNums.toString().contains("3");
        });

        // ❌ CASOS DE ERROR
        System.out.println("\n❌ CASOS DE ERROR:\n");

        // Prueba 11: Acceder a índice negativo
        test("ArrayList - Acceder a índice negativo (ERROR)", () -> {
            try {
                lista.get(-1);
                return false; // No debería llegar aquí
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 12: Acceder a índice fuera de rango
        test("ArrayList - Acceder a índice fuera de rango (ERROR)", () -> {
            try {
                lista.get(100);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 13: Eliminar de índice inválido
        test("ArrayList - Eliminar de índice inválido (ERROR)", () -> {
            try {
                lista.remove(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 14: Insertar en posición inválida (negativa)
        test("ArrayList - Insertar en posición negativa (ERROR)", () -> {
            try {
                lista.add("Elemento", -5);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 15: Insertar en posición mayor que size
        test("ArrayList - Insertar en posición > size (ERROR)", () -> {
            try {
                ArrayList<String> listaTemp = new ArrayList<>();
                listaTemp.add("A");
                listaTemp.add("Elemento", 5);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 16: Eliminar de lista vacía
        test("ArrayList - Eliminar de lista vacía (ERROR)", () -> {
            try {
                ArrayList<String> listaVacia = new ArrayList<>();
                listaVacia.remove(0);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });
    }

    // ╔════════════════════════════════════════════════════════════╗
    // ║           PRUEBAS LINKEDLIST                               ║
    // ╚════════════════════════════════════════════════════════════╝

    public static void pruebasLinkedList() {
        LinkedList<String> lista = new LinkedList<>();

        // ✅ CASOS POSITIVOS
        System.out.println("✅ CASOS POSITIVOS:\n");

        // Prueba 1: Agregar elementos al final
        test("LinkedList - Agregar al final", () -> {
            lista.add("Nodo A");
            lista.add("Nodo B");
            lista.add("Nodo C");
            return lista.size() == 3;
        });

        // Prueba 2: Obtener elemento
        test("LinkedList - Obtener elemento", () -> {
            return lista.get(0).equals("Nodo A");
        });

        // Prueba 3: Obtener elemento en medio
        test("LinkedList - Obtener elemento del medio", () -> {
            return lista.get(1).equals("Nodo B");
        });

        // Prueba 4: Obtener último elemento
        test("LinkedList - Obtener último elemento", () -> {
            return lista.get(2).equals("Nodo C");
        });

        // Prueba 5: Verificar tamaño
        test("LinkedList - Verificar tamaño", () -> {
            return lista.size() == 3;
        });

        // Prueba 6: Verificar no está vacía
        test("LinkedList - No está vacía", () -> {
            return !lista.isEmpty();
        });

        // Prueba 7: Insertar al principio
        test("LinkedList - Insertar al principio", () -> {
            lista.add("Inicio", 0);
            return lista.get(0).equals("Inicio") && lista.size() == 4;
        });

        // Prueba 8: Insertar en posición media
        test("LinkedList - Insertar en posición media", () -> {
            lista.add("Medio", 2);
            return lista.get(2).equals("Medio") && lista.size() == 5;
        });

        // Prueba 9: Eliminar del principio
        test("LinkedList - Eliminar del principio", () -> {
            String eliminado = lista.remove(0);
            return eliminado.equals("Inicio") && lista.size() == 4;
        });

        // Prueba 10: Eliminar del final
        test("LinkedList - Eliminar del final", () -> {
            String eliminado = lista.remove(lista.size() - 1);
            return eliminado.equals("Nodo C") && lista.size() == 3;
        });

        // Prueba 11: Eliminar del medio
        test("LinkedList - Eliminar del medio", () -> {
            String eliminado = lista.remove(1);
            return eliminado.equals("Medio") && lista.size() == 2;
        });

        // Prueba 12: Clear (limpiar lista)
        test("LinkedList - Limpiar lista", () -> {
            LinkedList<String> listaTemporal = new LinkedList<>();
            listaTemporal.add("X");
            listaTemporal.add("Y");
            listaTemporal.clear();
            return listaTemporal.isEmpty() && listaTemporal.size() == 0;
        });

        // Prueba 13: toString
        test("LinkedList - Representación en String", () -> {
            LinkedList<Integer> listaNums = new LinkedList<>();
            listaNums.add(10);
            listaNums.add(20);
            listaNums.add(30);
            return listaNums.toString().contains("10") && listaNums.toString().contains("30");
        });

        // Prueba 14: Agregar muchos elementos
        test("LinkedList - Agregar muchos elementos", () -> {
            LinkedList<String> listaGrande = new LinkedList<>();
            for (int i = 0; i < 50; i++) {
                listaGrande.add("Item " + i);
            }
            return listaGrande.size() == 50;
        });

        // ❌ CASOS DE ERROR
        System.out.println("\n❌ CASOS DE ERROR:\n");

        // Prueba 15: Acceder a índice negativo
        test("LinkedList - Acceder a índice negativo (ERROR)", () -> {
            try {
                lista.get(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 16: Acceder a índice fuera de rango
        test("LinkedList - Acceder a índice fuera de rango (ERROR)", () -> {
            try {
                lista.get(100);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 17: Eliminar con índice negativo
        test("LinkedList - Eliminar con índice negativo (ERROR)", () -> {
            try {
                lista.remove(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 18: Eliminar con índice fuera de rango
        test("LinkedList - Eliminar con índice fuera de rango (ERROR)", () -> {
            try {
                lista.remove(999);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 19: Insertar en posición negativa
        test("LinkedList - Insertar en posición negativa (ERROR)", () -> {
            try {
                lista.add("Elemento", -3);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 20: Insertar en posición mayor que size
        test("LinkedList - Insertar en posición > size (ERROR)", () -> {
            try {
                LinkedList<String> listaTemp = new LinkedList<>();
                listaTemp.add("A");
                listaTemp.add("Elemento", 10);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 21: Eliminar de lista vacía
        test("LinkedList - Eliminar de lista vacía (ERROR)", () -> {
            try {
                LinkedList<String> listaVacia = new LinkedList<>();
                listaVacia.remove(0);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        // Prueba 22: Obtener de lista vacía
        test("LinkedList - Obtener de lista vacía (ERROR)", () -> {
            try {
                LinkedList<String> listaVacia = new LinkedList<>();
                listaVacia.get(0);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });
    }

    // ╔════════════════════════════════════════════════════════════╗
    // ║           MÉTODO AUXILIAR PARA PRUEBAS                     ║
    // ╚════════════════════════════════════════════════════════════╝

    private static void test(String descripcion, TestCase testCase) {
        testCount++;
        try {
            boolean resultado = testCase.ejecutar();
            if (resultado) {
                System.out.println("✅ " + descripcion);
                passCount++;
            } else {
                System.out.println("❌ " + descripcion + " - Falló la condición");
                failCount++;
            }
        } catch (Exception e) {
            System.out.println("❌ " + descripcion + " - Excepción inesperada: " + e.getMessage());
            failCount++;
        }
    }

    // Interfaz funcional para pruebas
    @FunctionalInterface
    interface TestCase {
        boolean ejecutar() throws Exception;
    }
}