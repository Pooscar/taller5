/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

public class ManejadorDinero implements Manejador
{
    private Manejador next; 
    protected int cantidad;
    protected double denominacion;

    @Override
    public void Manejador(int n, double denominacion) {
        this.cantidad = n; // Total de billetes
        this.denominacion = denominacion; // Valor de cada billete
    }

    @Override
    public void setNext(ChainOfResponsibility.Manejador manejador) {
        this.next = manejador;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto < 0 || this.cantidad == 0){
            return false;
        }
        double resto = monto % this.denominacion;
        if (resto == 0) {
            next.retirar(monto);
        }
        System.out.println("Se entregan " +resto+" billetes de $"+ this.denominacion);
        monto -= resto*this.denominacion;
        this.cantidad -= resto;
        this.retirar(monto);
        return true;
    }

    @Override
    public boolean depositar(int n, double denominacion) {
        // que la denominacion cumpla tengo que hacer next hasta que encuentre el billete que es
        //manejadro de dinero usa accout
        double monto = n*denominacion;
        System.out.println("Se deposito $" + monto);
        return true;
    }
}