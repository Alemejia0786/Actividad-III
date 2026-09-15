package sistemabancario;

/**
 *
 * @author mater
 */
public abstract class Banco {

    /*
     * Factory Method.
     * Las clases hijas decidirán qué tipo de cuenta crear.
     */
    public abstract Cuenta crearCuenta(String numeroCuenta, String titular);

    /*
     * Método que utiliza la cuenta creada.
     */
    public void registrarCuenta(String numeroCuenta, String titular) {

        Cuenta cuenta = crearCuenta(numeroCuenta, titular);

        System.out.println();
        System.out.println("Cuenta creada correctamente.");
        cuenta.mostrarInformacion();
    }
}
