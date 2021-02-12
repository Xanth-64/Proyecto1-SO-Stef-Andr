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
                Window1.getBoss_status().setText("Working");
                Window1.semaforoContador.acquire(); //Revisando si puede acceder al contador. Porque gerente puede estar alli. Adquieres un permiso. Semaforo Escritor-lector. Pides permisos.
            }
            catch(InterruptedException e){
                
            }
            try{
                Thread.sleep(Window1.timeInterval * 6); //Cambiando el contador
                Window1.contador++;
                Window1.getDays_passed().setText(Integer.toString(Window1.contador));
                Window1.getRemaining_days().setText(Integer.toString(Window1.limiteContador - Window1.contador));
                Window1.semaforoContador.release(); //Libera los permisos
                System.out.println("El Jefe incremento el contador: " + Window1.contador);
            }
            catch(InterruptedException e){
                
            }
            try{
                Window1.getBoss_status().setText("Sleeping");
                Thread.sleep(Window1.timeInterval * 18); // A mimir
            }
            catch(InterruptedException e){
            
            }
        }
    }
}
