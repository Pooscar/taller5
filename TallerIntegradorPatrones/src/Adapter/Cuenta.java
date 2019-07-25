/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

/**
 *
 * @author coloma
 */
public interface Cuenta {
    double Balance();
    boolean Retirar(double monto);
    boolean Depositar(int cantidad,double tipoBillete);
}
