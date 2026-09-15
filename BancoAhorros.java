package sistemabancario;

/**
 *
 * @author mater
 */
public class BancoAhorros extends Banco {

    @Override
    public Cuenta crearCuenta(String numeroCuenta, String titular) {
        return new CuentaAhorros(numeroCuenta, titular);
    }

}
