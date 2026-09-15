package sistemabancario;

/**
 *
 * @author mater
 */
public interface OperacionBancaria {

    void depositar(double monto);

    void retirar(double monto);

    double consultarSaldo();
}
