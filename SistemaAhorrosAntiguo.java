package sistemabancario;

/**
 *
 * @author mater
 */
public class SistemaAhorrosAntiguo {

    private double saldo;

    public SistemaAhorrosAntiguo() {
        saldo = 0;
    }

    public void ingresarDinero(double cantidad) {

        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Sistema antiguo: dinero ingresado.");
        }
    }

    public void sacarDinero(double cantidad) {

        if (cantidad > 0 && cantidad <= saldo) {

            saldo -= cantidad;

            System.out.println("Sistema antiguo: dinero retirado.");

        } else {

            System.out.println("Sistema antiguo: fondos insuficientes.");
        }
    }

    public double obtenerSaldo() {

        return saldo;
    }
}
