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
        double resto = monto / this.denominacion;
        int valor = (int) resto; // cast double to int
        if (valor == 0) {
            next.retirar(monto);
        }
        System.out.println("Se entregan " +valor+" billetes de $"+ this.denominacion);
        monto -= valor*this.denominacion; // se resta el monto
        this.cantidad -= valor; // se resta la cantidad de billete
        this.retirar(monto);
        
        return true;
    }

    @Override
    public boolean depositar(int n, double denominacion) {
        if (n>0 && denominacion > 0){
            double monto = n*denominacion;
            if (this.denominacion == denominacion){
                System.out.println("Se deposito $" + monto);
                return true;
            } else {
                next.depositar(n, denominacion);
            }
            
        }
        return false;
    }
}