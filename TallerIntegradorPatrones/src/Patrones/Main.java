/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import ChainOfResponsibility.ManejadorDinero;
import java.util.ArrayList;
import java.util.Scanner;
import Singleton.AtmEC;


public class Main
{
    public static void main(String[] args)
    {
        
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        ManejadorDinero b20 = null;
        ManejadorDinero b10 = null;
        ManejadorDinero m50 = null;
        ManejadorDinero m25 = null;
        ManejadorDinero m05 = null;
        
        
        b20.Manejador(100, 20);
        b10.Manejador(100, 10);
        m50.Manejador(10, 0.5);
        m25.Manejador(10, 0.25);
        m05.Manejador(1000, 0.05);
        
        AtmEC atm = AtmEC.getInstance();
        atm.addManejador(b20);
        atm.addManejador(b10);
        atm.addManejador(m50);
        atm.addManejador(m25);
        atm.addManejador(m05);
        
        b20.setNext(b10);
        b10.setNext(m50);
        m50.setNext(m25);
        m25.setNext(m05);
        
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        Account c1 = new Account (123456,100);
        Account c2 = new Account (111111,200);
        Account c3 = new Account (232323,300);
        Account c4 = new Account (654321,400);
        Account c5 = new Account (987654,500);
        Account c6 = new Account (456789,600);
        Account c7 = new Account (000111,700);
        Account c8 = new Account (999999,800);
        Account c9 = new Account (201508,900);
        Account c0 = new Account (201904,1000);
        ArrayList<Account> listaCuentas = new ArrayList<Account>();
        listaCuentas.add(c1);
        listaCuentas.add(c2);
        listaCuentas.add(c3);
        listaCuentas.add(c4);
        listaCuentas.add(c5);
        listaCuentas.add(c6);
        listaCuentas.add(c7);
        listaCuentas.add(c8);
        listaCuentas.add(c9);
        listaCuentas.add(c0);
        
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        Scanner scan = new Scanner(System.in);                       
        int cuentaID;
        int transaccion;
        boolean seguirCajero = true;
        boolean seguirCuenta = true;
        Account cuenta = new Account();
        while (seguirCajero) {
            System.out.println("\t\tMENU PRINCIPAL\n\n");
            System.out.println("Escriba su numero de cuenta: ");
            cuentaID = scan.nextInt();
            //BUSCAR LA CUENTA
            for (Account acc:listaCuentas){
                if (acc.getId()==cuentaID){
                    cuenta = acc;
                    break;
                }
            }
            
        // Mostrar el menú para realizar transacciones en el cajero             
            atm.transaction(atm, cuenta);
        }
    }

    
}
