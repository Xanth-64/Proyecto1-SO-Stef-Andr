
package Classes;

import Interface.Window1;

public class Gerente extends Thread {

    @Override
    public void run() {
        while(true){
            try{
                Window1.getManager_status().setText("Working");
                Window1.semaforoContador.acquire(); //Revisando si puede acceder al contador. Porque jefe puede estar alli. Adquieres un permiso. Semaforo Escritor-lector. Pides permisos.
            }
            catch(InterruptedException e){

            }
            if(Window1.contador == Window1.limiteContador){
                Window1.contador = 0; //Reinicializa el contador
                Window1.getDays_passed().setText(Integer.toString(Window1.contador));
                Window1.getRemaining_days().setText(Integer.toString(Window1.limiteContador - Window1.contador));
                System.out.println("Dia Final!!!. Consolas producidas para hoy => " + Window1.companyStorage.consoles.availablePermits());
                Window1.companyStorage.consoles.drainPermits(); // Vacias el nro de consolas (permisos)
                Window1.getSDXL().setText(Integer.toString(Window1.companyStorage.consoles.availablePermits()));

            }
            else{
                Window1.getManager_status().setText("Sleeping");
                System.out.println("No es el dia de salida. Hora de mandar al gerente a Mimir 2 horas");
            }
            try{
                Window1.semaforoContador.release(); //Libera los permisos pedidos
                Thread.sleep(Window1.timeInterval * 2); // A mimir
            }
            catch(InterruptedException e){

            }  
        }
    }
    
}
