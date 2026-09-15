
package sistemabancario;

/**
 *
 * @author mater
 */
public class BancoCorriente extends Banco{

    @Override
    public Cuenta crearCuenta(String numeroCuenta, String titular) {
        return new CuentaCorriente(numeroCuenta, titular);
    }
    
}
