package sistemabancario;

/**
 *
 * @author mater
 */
public class SistemaCreditoAntiguo {

    private double saldoCredito;

    public SistemaCreditoAntiguo() {
        saldoCredito = 0;
    }

    public void abonar(double cantidad) {

        if (cantidad > 0) {

            saldoCredito += cantidad;

            System.out.println("Sistema de crédito: abono realizado.");
        }
    }

    public void pagar(double cantidad) {

        if (cantidad > 0 && cantidad <= saldoCredito) {

            saldoCredito -= cantidad;

            System.out.println("Sistema de crédito: pago realizado.");

        } else {

            System.out.println("Sistema de crédito: operación no válida.");
        }
    }

    public double consultarCredito() {

        return saldoCredito;
    }
}
