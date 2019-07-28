/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Patrones.Account;
import java.util.Currency;
import java.util.Locale;


/**
 *
 * @author coloma
 */
public class CuentaAdapter implements Cuenta {
   protected Account cuenta;
   protected Currency moneda;

    public CuentaAdapter(int id, double monto) {
        cuenta = new Account(id,monto);
        moneda = Currency.getInstance(Locale.US);
    }

    @Override
    public double Balance() {
        return cuenta.getAmount();
    }

    @Override
    public boolean Retirar(double monto) {
        String res = cuenta.withdraw(monto);
        return !res.contains("Error");
    }

    @Override
    public boolean Depositar(int cantidad, double tipoBillete) {
        String res= cuenta.deposit(cantidad);
        return true;
    }
   
   
}
