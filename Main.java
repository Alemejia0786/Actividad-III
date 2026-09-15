package sistemabancario;

/**
 *
 * @author mater
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    crearCuenta();
                    break;

                case 2:
                    depositar();
                    break;

                case 3:
                    retirar();
                    break;

                case 4:
                    consultarSaldo();
                    break;

                case 5:
                    mostrarCuentas();
                    break;

                case 6:
                    probarAdapter();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Gracias por utilizar el sistema bancario.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // MENÚ PRINCIPAL
    // =====================================================
    private static void mostrarMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          SISTEMA BANCARIO");
        System.out.println("========================================");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Mostrar todas las cuentas");
        System.out.println("6. Probar patrón Adapter");
        System.out.println("0. Salir");
        System.out.println("========================================");
    }

    // =====================================================
    // FACTORY METHOD
    // =====================================================
    private static void crearCuenta() {

        System.out.println();
        System.out.println("========== CREAR CUENTA ==========");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Cuenta de Nómina");

        int tipo = leerEntero("Seleccione el tipo de cuenta: ");

        String numero = leerTexto("Ingrese el número de cuenta: ");

        String titular = leerTexto("Ingrese el nombre del titular: ");

        Banco banco;

        switch (tipo) {

            case 1:
                banco = new BancoAhorros();
                break;

            case 2:
                banco = new BancoCorriente();
                break;

            case 3:
                banco = new BancoNomina();
                break;

            default:
                System.out.println("Tipo de cuenta no válido.");
                return;
        }

        /*
         * Factory Method:
         * El Banco decide qué objeto Cuenta crear.
         */
        Cuenta cuenta = banco.crearCuenta(numero, titular);

        cuentas.add(cuenta);

        System.out.println();
        System.out.println("Cuenta creada correctamente.");
        cuenta.mostrarInformacion();
    }

    // =====================================================
    // DEPÓSITO
    // =====================================================
    private static void depositar() {

        if (cuentas.isEmpty()) {

            System.out.println("No existen cuentas registradas.");
            return;
        }

        mostrarNumerosDeCuenta();

        String numero = leerTexto("Ingrese el número de cuenta: ");

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta == null) {

            System.out.println("Cuenta no encontrada.");
            return;
        }

        double monto = leerDouble("Ingrese el monto a depositar: ");

        cuenta.depositar(monto);
    }

    // =====================================================
    // RETIRO
    // =====================================================
    private static void retirar() {

        if (cuentas.isEmpty()) {

            System.out.println("No existen cuentas registradas.");
            return;
        }

        mostrarNumerosDeCuenta();

        String numero = leerTexto("Ingrese el número de cuenta: ");

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta == null) {

            System.out.println("Cuenta no encontrada.");
            return;
        }

        double monto = leerDouble("Ingrese el monto a retirar: ");

        cuenta.retirar(monto);
    }

    // =====================================================
    // CONSULTAR SALDO
    // =====================================================
    private static void consultarSaldo() {

        if (cuentas.isEmpty()) {

            System.out.println("No existen cuentas registradas.");
            return;
        }

        String numero = leerTexto("Ingrese el número de cuenta: ");

        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta == null) {

            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.println();
        System.out.println("Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Tipo: " + cuenta.getTipoCuenta());
        System.out.println("Saldo disponible: $" + cuenta.consultarSaldo());
    }

    // =====================================================
    // MOSTRAR CUENTAS
    // =====================================================
    private static void mostrarCuentas() {

        if (cuentas.isEmpty()) {

            System.out.println("No existen cuentas registradas.");
            return;
        }

        System.out.println();
        System.out.println("========== CUENTAS REGISTRADAS ==========");

        for (Cuenta cuenta : cuentas) {

            cuenta.mostrarInformacion();
        }
    }

    // =====================================================
    // BUSCAR CUENTA
    // =====================================================
    private static Cuenta buscarCuenta(String numero) {

        for (Cuenta cuenta : cuentas) {

            if (cuenta.getNumeroCuenta().equals(numero)) {

                return cuenta;
            }
        }

        return null;
    }

    // =====================================================
    // MOSTRAR NÚMEROS
    // =====================================================
    private static void mostrarNumerosDeCuenta() {

        System.out.println();
        System.out.println("Cuentas disponibles:");

        for (Cuenta cuenta : cuentas) {

            System.out.println(
                    "- " + cuenta.getNumeroCuenta()
                    + " | " + cuenta.getTipoCuenta()
            );
        }

        System.out.println();
    }

    // =====================================================
    // ADAPTER
    // =====================================================
    private static void probarAdapter() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       PRUEBA DEL PATRÓN ADAPTER");
        System.out.println("========================================");

        /*
         * Sistema antiguo de ahorros.
         */
        SistemaAhorrosAntiguo sistemaAhorros
                = new SistemaAhorrosAntiguo();

        /*
         * Lo adaptamos a la interfaz moderna.
         */
        OperacionBancaria adapterAhorros
                = new AdaptadorAhorros(sistemaAhorros);

        System.out.println();
        System.out.println("--- Sistema de Ahorros Antiguo ---");

        adapterAhorros.depositar(1000000);

        System.out.println(
                "Saldo: $" + adapterAhorros.consultarSaldo()
        );

        adapterAhorros.retirar(250000);

        System.out.println(
                "Saldo después del retiro: $"
                + adapterAhorros.consultarSaldo()
        );

        /*
         * Sistema antiguo de crédito.
         */
        SistemaCreditoAntiguo sistemaCredito
                = new SistemaCreditoAntiguo();

        /*
         * Lo adaptamos a la misma interfaz.
         */
        OperacionBancaria adapterCredito
                = new AdaptadorCredito(sistemaCredito);

        System.out.println();
        System.out.println("--- Sistema de Crédito Antiguo ---");

        adapterCredito.depositar(2000000);

        System.out.println(
                "Saldo: $" + adapterCredito.consultarSaldo()
        );

        adapterCredito.retirar(500000);

        System.out.println(
                "Saldo después del pago: $"
                + adapterCredito.consultarSaldo()
        );
    }

    // =====================================================
    // MÉTODOS PARA LEER DATOS
    // =====================================================
    private static String leerTexto(String mensaje) {

        System.out.print(mensaje);

        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Por favor, ingrese un número válido."
                );
            }
        }
    }

    private static double leerDouble(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Por favor, ingrese un valor numérico válido."
                );
            }
        }
    }
}
