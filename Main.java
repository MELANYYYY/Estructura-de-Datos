public class Main {
    private static int testCount = 0;
    private static int passCount = 0;
    private static int failCount = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRUEBAS DE ARRAYLIST Y LINKEDLIST                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("PRUEBAS: ARRAYLIST<STRING>");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        pruebasArrayList();

        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("PRUEBAS: LINKEDLIST<STRING>");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        pruebasLinkedList();

        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("RESUMEN DE PRUEBAS");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("Total de pruebas: " + testCount);
        System.out.println("✅ Pasadas: " + passCount);
        System.out.println("❌ Fallidas: " + failCount);
        System.out.println("═══════════════════════════════════════════════════════════\n");
    }

    public static void pruebasArrayList() {
        ArrayList<String> lista = new ArrayList<>();

        System.out.println("✅ CASOS POSITIVOS:\n");

        test("ArrayList - Agregar al final", () -> {
            lista.add("Elemento 1");
            lista.add("Elemento 2");
            lista.add("Elemento 3");
            return lista.size() == 3;
        });

        test("ArrayList - Obtener elemento", () -> {
            return lista.get(0).equals("Elemento 1");
        });

        test("ArrayList - Verificar tamaño", () -> {
            return lista.size() == 3;
        });

        test("ArrayList - No está vacía", () -> {
            return !lista.isEmpty();
        });

        test("ArrayList - Insertar en posición media", () -> {
            lista.add("Inserción", 1);
            return lista.get(1).equals("Inserción") && lista.size() == 4;
        });

        test("ArrayList - Insertar al principio", () -> {
            lista.add("Principio", 0);
            return lista.get(0).equals("Principio") && lista.size() == 5;
        });

        test("ArrayList - Eliminar elemento", () -> {
            String eliminado = lista.remove(0);
            return eliminado.equals("Principio") && lista.size() == 4;
        });

        ArrayList<String> listaGrande = new ArrayList<>();
        test("ArrayList - Expansión automática", () -> {
            for (int i = 0; i < 25; i++) {
                listaGrande.add("Item " + i);
            }
            return listaGrande.size() == 25;
        });

        test("ArrayList - Limpiar lista", () -> {
            ArrayList<String> listaTemporal = new ArrayList<>();
            listaTemporal.add("A");
            listaTemporal.add("B");
            listaTemporal.clear();
            return listaTemporal.isEmpty() && listaTemporal.size() == 0;
        });

        test("ArrayList - Representación en String", () -> {
            ArrayList<Integer> listaNums = new ArrayList<>();
            listaNums.add(1);
            listaNums.add(2);
            listaNums.add(3);
            return listaNums.toString().contains("1") && listaNums.toString().contains("3");
        });

        System.out.println("\n❌ CASOS DE ERROR:\n");

        test("ArrayList - Acceder a índice negativo (ERROR)", () -> {
            try {
                lista.get(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("ArrayList - Acceder a índice fuera de rango (ERROR)", () -> {
            try {
                lista.get(100);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("ArrayList - Eliminar de índice inválido (ERROR)", () -> {
            try {
                lista.remove(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("ArrayList - Insertar en posición negativa (ERROR)", () -> {
            try {
                lista.add("Elemento", -5);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

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

    public static void pruebasLinkedList() {
        LinkedList<String> lista = new LinkedList<>();

        System.out.println("✅ CASOS POSITIVOS:\n");

        test("LinkedList - Agregar al final", () -> {
            lista.add("Nodo A");
            lista.add("Nodo B");
            lista.add("Nodo C");
            return lista.size() == 3;
        });

        test("LinkedList - Obtener elemento", () -> {
            return lista.get(0).equals("Nodo A");
        });

        test("LinkedList - Obtener elemento del medio", () -> {
            return lista.get(1).equals("Nodo B");
        });

        test("LinkedList - Obtener último elemento", () -> {
            return lista.get(2).equals("Nodo C");
        });

        test("LinkedList - Verificar tamaño", () -> {
            return lista.size() == 3;
        });

        test("LinkedList - No está vacía", () -> {
            return !lista.isEmpty();
        });

        test("LinkedList - Insertar al principio", () -> {
            lista.add("Inicio", 0);
            return lista.get(0).equals("Inicio") && lista.size() == 4;
        });

        test("LinkedList - Insertar en posición media", () -> {
            lista.add("Medio", 2);
            return lista.get(2).equals("Medio") && lista.size() == 5;
        });

        test("LinkedList - Eliminar del principio", () -> {
            String eliminado = lista.remove(0);
            return eliminado.equals("Inicio") && lista.size() == 4;
        });

        test("LinkedList - Eliminar del final", () -> {
            String eliminado = lista.remove(lista.size() - 1);
            return eliminado.equals("Nodo C") && lista.size() == 3;
        });

        test("LinkedList - Eliminar del medio", () -> {
            String eliminado = lista.remove(1);
            return eliminado.equals("Medio") && lista.size() == 2;
        });

        test("LinkedList - Limpiar lista", () -> {
            LinkedList<String> listaTemporal = new LinkedList<>();
            listaTemporal.add("X");
            listaTemporal.add("Y");
            listaTemporal.clear();
            return listaTemporal.isEmpty() && listaTemporal.size() == 0;
        });

        test("LinkedList - Representación en String", () -> {
            LinkedList<Integer> listaNums = new LinkedList<>();
            listaNums.add(10);
            listaNums.add(20);
            listaNums.add(30);
            return listaNums.toString().contains("10") && listaNums.toString().contains("30");
        });

        test("LinkedList - Agregar muchos elementos", () -> {
            LinkedList<String> listaGrande = new LinkedList<>();
            for (int i = 0; i < 50; i++) {
                listaGrande.add("Item " + i);
            }
            return listaGrande.size() == 50;
        });

        System.out.println("\n❌ CASOS DE ERROR:\n");

        test("LinkedList - Acceder a índice negativo (ERROR)", () -> {
            try {
                lista.get(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("LinkedList - Acceder a índice fuera de rango (ERROR)", () -> {
            try {
                lista.get(100);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("LinkedList - Eliminar con índice negativo (ERROR)", () -> {
            try {
                lista.remove(-1);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("LinkedList - Eliminar con índice fuera de rango (ERROR)", () -> {
            try {
                lista.remove(999);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

        test("LinkedList - Insertar en posición negativa (ERROR)", () -> {
            try {
                lista.add("Elemento", -3);
                return false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("   └─ Excepción capturada: " + e.getMessage());
                return true;
            }
        });

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

    @FunctionalInterface
    interface TestCase {
        boolean ejecutar() throws Exception;
    }
}
