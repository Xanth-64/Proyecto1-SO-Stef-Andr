/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.Window1;

/**
 *
 * @author Xanth
 */
public class Gerente implements Runnable {

    @Override
    public void run() {
            while(true){
            try{
                Window1.semaforoContador.acquire();
            }
            catch(InterruptedException e){

            }
            if(Window1.contador == Window1.limiteContador){
                Window1.contador = 0;
                System.out.println("Dia Final!!!. Consolas producidas para hoy => " + Window1.companyStorage.consoles.availablePermits());
                Window1.companyStorage.consoles.drainPermits();

            }
            else{
                System.out.println("No es el dia de salida. Hora de mandar al gerente a Mimir 2 horas");
            }
            try{
                Window1.semaforoContador.release();
                Thread.sleep(Window1.timeInterval * 2);
            }
            catch(InterruptedException e){

            }  
        }
    }
    
}
