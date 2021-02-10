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
public class Assembler implements Runnable {
   protected boolean execute;
   protected boolean creating;
   
   public Assembler(){
       this.execute = true;
       this.creating = false;
   }

    public boolean isExecute() {
        return execute;
    }

    public boolean isCreating() {
        return creating;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public void setCreating(boolean creating) {
        this.creating = creating;
    }
   
   
    @Override
    public void run(){
        
        while (execute){
            this.creating = false;
            try{
                Window1.companyStorage.getCurrButt().acquire(5);
                System.out.println("Se asignaron 5 botones a un ensamblador");
               
            }
            catch(InterruptedException e){
                this.execute = false;
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrJoy().acquire(2);
                    System.out.println("Se Asignaron 2 joysticks a un ensamblador");
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5);
                }
            }
            if(this.execute){
                try{
                   Window1.companyStorage.getCurrScrNrm().acquire();
                   System.out.println("Se Asigno una pantalla normal a un ensamblador");
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5);
                    Window1.companyStorage.getCurrJoy().release(2);
                }
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrScrTch().acquire();
                    System.out.println("Se Asigno una pantalla tactil a un ensamblador");
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5);
                    Window1.companyStorage.getCurrJoy().release(2);
                }
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrRd().acquire();
                    System.out.println("Se Asigno un lector de tarjetas a un ensamblador");
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5);
                    Window1.companyStorage.getCurrJoy().release(2);
                }
            }
            
            if(this.execute){
                this.creating = true;
                try{
                    Thread.sleep(Window1.timeInterval * 24);
                    Window1.companyStorage.getConsoles().release();
                    Window1.companyLimit.getMaxButt().release(5);
                    Window1.companyLimit.getMaxJoy().release(2);
                    Window1.companyLimit.getMaxScr().release(2);
                    Window1.companyLimit.getMaxRd().release();
                    
                    System.out.println("Consola Ensamblada! aqui los datos: Consolas: " + Window1.companyStorage.consoles.availablePermits() + " Botones: " + Window1.companyStorage.currButt.availablePermits() + " Palancas: " + Window1.companyStorage.currJoy.availablePermits() + " Lectoras: " + Window1.companyStorage.currRd.availablePermits() + " Pantallas Tactiles: " + Window1.companyStorage.currScrTch.availablePermits() + " Pantallas Normales: " + Window1.companyStorage.currScrNrm.availablePermits() + "\nLimites: Botones: " + Window1.companyLimit.maxButt.availablePermits() + " Pantallas: " + Window1.companyLimit.maxScr.availablePermits() + " Lectoras: " + Window1.companyLimit.maxRd.availablePermits() + " Palancas: " + Window1.companyLimit.maxJoy.availablePermits());
                    
                }
                catch(InterruptedException e){
                   this.execute = false;
                   Window1.companyStorage.getCurrButt().release(5);
                   Window1.companyStorage.getCurrJoy().release(2);
                   Window1.companyStorage.getCurrScrNrm().release();
                   Window1.companyStorage.getCurrScrTch().release();
                   Window1.companyStorage.getCurrRd().release();
                }
            }    
        }  
    }  
}
