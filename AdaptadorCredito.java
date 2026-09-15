package sistemabancario;

/**
 *
 * @author mater
 */
public class AdaptadorCredito implements OperacionBancaria {

    private SistemaCreditoAntiguo sistemaCredito;

    public AdaptadorCredito(SistemaCreditoAntiguo sistemaCredito) {

        this.sistemaCredito = sistemaCredito;
    }

    @Override
    public void depositar(double monto) {

        sistemaCredito.abonar(monto);
    }

    @Override
    public void retirar(double monto) {

        sistemaCredito.pagar(monto);
    }

    @Override
    public double consultarSaldo() {

        return sistemaCredito.consultarCredito();
    }
}
