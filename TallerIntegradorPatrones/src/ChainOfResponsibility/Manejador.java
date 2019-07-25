/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

/**
 *
 * @author allisonbarrezueta
 */
public interface Manejador {
    
    public void Manejador(int n, double denominacion);
    public void setNext(Manejador manejador);
    public boolean retirar(double monto);
    public boolean depositar(int n, double denominacion);
    
}
