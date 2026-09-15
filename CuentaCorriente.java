package sistemabancario;

/**
 *
 * @author mater
 */
public class CuentaCorriente implements Cuenta {

    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaCorriente(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0;
    }

    @Override
    public void depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado correctamente.");
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }

    @Override
    public boolean retirar(double monto) {

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        // La cuenta corriente permite un sobregiro máximo
        // de $500.000.
        if (monto <= saldo + 500000) {

            saldo -= monto;

            System.out.println("Retiro realizado correctamente.");

            if (saldo < 0) {
                System.out.println("Advertencia: la cuenta está en sobregiro.");
            }

            return true;
        }

        System.out.println("El monto supera el límite de sobregiro.");
        return false;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String getTipoCuenta() {
        return "Cuenta Corriente";
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("--------------------------------");
        System.out.println("Tipo: " + getTipoCuenta());
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("--------------------------------");
    }
}
