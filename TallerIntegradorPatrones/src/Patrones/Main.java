/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import ChainOfResponsibility.ManejadorDinero;
import java.util.Scanner;


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
        
        b20.setNext(b10);
        b10.setNext(m50);
        m50.setNext(m25);
        m25.setNext(m05);

        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        
        // Mostrar el menú para realizar transacciones en el cajero automático
        
        Scanner scan = new Scanner(System.in);
        int cuenta;
        int transaccion;
        boolean seguirCajero = true;
        boolean seguirCuenta = true;
        
        while (seguirCajero) {
            System.out.println("\t\tMENU PRINCIPAL\n\n");
            System.out.println("Escriba su numero de cuenta: ");
            cuenta = scan.nextInt();
            //BUSCAR LA CUENTA
            
            while(seguirCuenta){
                System.out.println("\t\tMENU\n");
                System.out.println("Realizar una transaccion:\n\n"
                        + "1. Ver estado actual de la cuenta"
                        + "2. Depositar dinero"
                        + "3. Retirar dinero"
                        + "4. Salir");
                
                transaccion = scan.nextInt();
                
                switch (transaccion) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    default:
                        System.out.println("Error! Escoga una opcion correcta");;
                }
                
            }
        }
    }

    
}
