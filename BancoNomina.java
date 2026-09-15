
package sistemabancario;

/**
 *
 * @author mater
 */
public class BancoNomina extends Banco {

    @Override
    public Cuenta crearCuenta(String numeroCuenta, String titular) {

        return new CuentaNomina(numeroCuenta, titular);
    }
}
