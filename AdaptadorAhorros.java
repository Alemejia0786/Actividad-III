package sistemabancario;

/**
 *
 * @author mater
 */
public class AdaptadorAhorros implements OperacionBancaria {

    private SistemaAhorrosAntiguo sistemaAntiguo;

    public AdaptadorAhorros(SistemaAhorrosAntiguo sistemaAntiguo) {

        this.sistemaAntiguo = sistemaAntiguo;
    }

    @Override
    public void depositar(double monto) {

        sistemaAntiguo.ingresarDinero(monto);
    }

    @Override
    public void retirar(double monto) {

        sistemaAntiguo.sacarDinero(monto);
    }

    @Override
    public double consultarSaldo() {

        return sistemaAntiguo.obtenerSaldo();
    }
}
