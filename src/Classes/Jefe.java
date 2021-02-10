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
public class Jefe implements Runnable{

    @Override
    public void run() {
        while (true){
            try{
                Window1.semaforoContador.acquire();
            }
            catch(InterruptedException e){
                
            }
            try{
                Thread.sleep(Window1.timeInterval * 6);
                Window1.contador++;
                Window1.semaforoContador.release();
                System.out.println("El Jefe incremento el contador: " + Window1.contador);
            }
            catch(InterruptedException e){
                
            }
            try{
                Thread.sleep(Window1.timeInterval * 18);
            }
            catch(InterruptedException e){
            
            }
        }
    }
}
