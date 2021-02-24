
package Classes;

import Interface.Window1;

public class Jefe extends Thread{

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
                Thread.sleep((long) (Window1.timeInterval * 6)); //Cambiando el contador
                Window1.contador++;
                Window1.getDays_passed().setText(Integer.toString(Window1.contador));
                Window1.getRemaining_days().setText(Integer.toString(Window1.limiteContador - Window1.contador));
                Window1.semaforoContador.release(); //Libera los permisos
                //System.out.println("El Jefe incremento el contador: " + Window1.contador);
            }
            catch(InterruptedException e){
                
            }
            try{
                Window1.getBoss_status().setText("Sleeping");
                Thread.sleep((long) (Window1.timeInterval * 18)); // A mimir
            }
            catch(InterruptedException e){
            
            }
        }
    }
}
