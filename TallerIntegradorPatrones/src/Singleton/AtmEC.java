/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import ChainOfResponsibility.Manejador;
import ChainOfResponsibility.ManejadorDinero;
import Patrones.Account;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class AtmEC {
    private static AtmEC INSTANCE = null;
    private final Currency currency = Currency.getInstance(Locale.US);
    private double dinero = 0;
    private ArrayList<ManejadorDinero> manejadores; // Cada manejador puede entregar dinero de una sola denominación

    // -----------------
    private AtmEC() { 
        manejadores = new ArrayList<ManejadorDinero>();
    }
    
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new AtmEC();
        }
    }

    public static AtmEC getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
        
    
    // -----------------
    public double getTotal() {
        return this.dinero;
    }

    // -----------------
    public void sacarDinero(double dinero) {
        this.dinero -= dinero;
        // Todo: realizar el proceso de sacar de cada manejador la cantidad requerida
    }

    // -----------------
    public void ingresarDinero(double dinero) {
        
        this.dinero += dinero;
        // Todo: Sólo se puede depositar billetes de una sola denominación y agregarse al manejador correspondiente
    }

    public void addManejador(ManejadorDinero m){
        manejadores.add(m);
    }
    public Manejador removeManejador(int i){
        return manejadores.remove(i);
    }

    //Dentro de las transacciones se debe llamar al ATM para hacer el retiro o deposito de la cuenta correspondiente
    public void transaction(AtmEC atm, Account cuenta){
        // here is where most of the work is
        int choice; 
        System.out.println("Porfavor selecciona una opcion"); 
        System.out.println("1. Retiro");
        System.out.println("2. Deposito");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Ingrese la cantidad que desea retirar: "); 
                amount = in.nextFloat();
                if(amount > cuenta.getAmount() || amount <= 0){
                    System.out.println("No tiene suficientes fondos\n\n"); 
                    anotherTransaction(atm, cuenta); // ask if they want another transaction
                } else {
                    // Todo: verificar que se puede realizar el retiro del atm
                    System.out.println("***PROCESANDO TRANSACCION***");                                       
                    // Todo: actualizar tanto la cuenta como el atm y de los manejadores
                    cuenta.withdraw(amount);
                    atm.sacarDinero(amount);
                    //manejador.retirar(amount);

                    // Todo: Mostrar resumen de transacción o error
                    System.out.println("Usted ha retirado "+amount+" y su nuevo balance es "+cuenta.getAmount()); 
                    anotherTransaction(atm,cuenta); 
                }
            break; 
            case 2:
                    // option number 2 is depositing 
                    float deposit; 
                    System.out.println("Ingrese la cantidad que desee depositar: "); 
                    deposit = in.nextFloat();
                    // Todo: actualizar tanto la cuenta como el atm
                    cuenta.deposit(deposit);
                    atm.ingresarDinero(deposit);
                    //manejador.depositar(deposit);
                    // Todo: Mostrar resumen de transacción o error
                    System.out.println("Usted ha depositado "+deposit+" y su nuevo balance es "+cuenta.getAmount());                   
                    anotherTransaction(atm,cuenta);
            break; 
            case 3:
                    // Todo: mostrar el balance de la cuenta
                    System.out.println("Su balance es "+cuenta.getAmount());
                    // "Your balance is "+balance
                    anotherTransaction(atm,cuenta); 
            break;
            case 4:
                    System.out.println("El balance del atm es "+atm.getTotal());
                    // Todo: mostrar el balance del ATM con los billetes en cada manejador
                    anotherTransaction(atm,cuenta); 
            break;
            default:
                    System.out.println("Invalid option:\n\n"); 
                    anotherTransaction(atm,cuenta);
            break;
        }
    }
    public void anotherTransaction(AtmEC atm, Account cuenta){
        System.out.println("¿Desea realizar alguna otra transaccion?\n\n1 Si\n2 No");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice == 1){
            transaction(atm, cuenta); // call transaction method
        } else if(choice == 2){
            System.out.println("Gracias por elegirnos, tenga buen dia");
        } else {
            System.out.println("Opcion incorrecta, intente de nuevo\n\n");
            anotherTransaction(atm, cuenta);
        }
    }

    
}
