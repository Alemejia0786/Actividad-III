package sistemabancario;

/**
 *
 * @author mater
 */
public interface Cuenta {

    void depositar(double monto);

    boolean retirar(double monto);

    double consultarSaldo();

    String getNumeroCuenta();

    String getTipoCuenta();

    void mostrarInformacion();
}
