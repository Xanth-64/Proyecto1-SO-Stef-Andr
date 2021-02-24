
package Classes;

import Interface.Window1;

public class Assembler extends Thread {
   protected boolean execute;
   protected boolean assembled;
   
   public Assembler(){
       this.execute = true;
       this.assembled = false;
   }

    public boolean isExecute() {
        return execute;
    }

    public boolean isAssembled() {
        return assembled;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public void setAssembled(boolean assembled) {
        this.assembled = assembled;
    }
   
   
    @Override
    public void run(){
        
        while (execute){
            this.assembled = false;
            try{
                Window1.companyStorage.getCurrButt().acquire(5); //Pide 5 botones
                //System.out.println("Se asignaron 5 botones a un ensamblador");
                
                Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
            }
            catch(InterruptedException e){
                this.execute = false;
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrJoy().acquire(2); //Pide 2 joysticks
                    //System.out.println("Se Asignaron 2 joysticks a un ensamblador");
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5); //Liberas 5 botones
                    
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                }
            }
            if(this.execute){
                try{
                   Window1.companyStorage.getCurrScrNrm().acquire(); //Pide 1 pantalla normal
                   //System.out.println("Se Asigno una pantalla normal a un ensamblador");
                   Window1.getScreens().setText(Integer.toString(Window1.companyStorage.currScrNrm.availablePermits()));
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5); //Liberas 5 botones
                    Window1.companyStorage.getCurrJoy().release(2); //Liberas 2 joysticks
                    
                    
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                }
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrScrTch().acquire(); //Pide 1 pantalla tactil
                    //System.out.println("Se Asigno una pantalla tactil a un ensamblador");
                    Window1.getTouch().setText(Integer.toString(Window1.companyStorage.currScrTch.availablePermits()));
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5); //Liberas 5 botones
                    Window1.companyStorage.getCurrJoy().release(2); //Liberas 2 joysticks
                    Window1.companyStorage.getCurrScrNrm().release(); //Liberas 1 pantalla normal
                    
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                    Window1.getScreens().setText(Integer.toString(Window1.companyStorage.currScrNrm.availablePermits()));
                }
            }
            if(this.execute){
                try{
                    Window1.companyStorage.getCurrRd().acquire(); //Pide 1 SD Reader
                    //System.out.println("Se Asigno un lector de tarjetas a un ensamblador");
                    Window1.getSD_readers().setText(Integer.toString(Window1.companyStorage.currRd.availablePermits()));
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyStorage.getCurrButt().release(5); //Liberas 5 botones
                    Window1.companyStorage.getCurrJoy().release(2); //Liberas 2 joysticks
                    Window1.companyStorage.getCurrScrNrm().release(); //Liberas 1 pantalla normal
                    Window1.companyStorage.getCurrScrTch().release(); //Liberas 1 pantalla tactil
                    
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                    Window1.getScreens().setText(Integer.toString(Window1.companyStorage.currScrNrm.availablePermits()));
                    Window1.getTouch().setText(Integer.toString(Window1.companyStorage.currScrTch.availablePermits()));
                }
            }
            
            if(this.execute){
                this.assembled = true;
                try{
                    Thread.sleep((long) (Window1.timeInterval * 24)); //Ensamblar
                    Window1.companyStorage.getConsoles().release(); //Agregar 1 consola
                    //Liberar espacio en el almacen
                    Window1.companyLimit.getMaxButt().release(5);
                    Window1.companyLimit.getMaxJoy().release(2);
                    Window1.companyLimit.getMaxScr().release(2);
                    Window1.companyLimit.getMaxRd().release();
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                    Window1.getSD_readers().setText(Integer.toString(Window1.companyStorage.currRd.availablePermits()));
                    Window1.getTouch().setText(Integer.toString(Window1.companyStorage.currScrTch.availablePermits()));
                    Window1.getScreens().setText(Integer.toString(Window1.companyStorage.currScrNrm.availablePermits()));
                    Window1.getSDXL().setText(Integer.toString(Window1.companyStorage.consoles.availablePermits()));
                    //System.out.println("Consola Ensamblada! aqui los datos: Consolas: " + Window1.companyStorage.consoles.availablePermits() + " Botones: " + Window1.companyStorage.currButt.availablePermits() + " Palancas: " + Window1.companyStorage.currJoy.availablePermits() + " Lectoras: " + Window1.companyStorage.currRd.availablePermits() + " Pantallas Tactiles: " + Window1.companyStorage.currScrTch.availablePermits() + " Pantallas Normales: " + Window1.companyStorage.currScrNrm.availablePermits() + "\nLimites: Botones: " + Window1.companyLimit.maxButt.availablePermits() + " Pantallas: " + Window1.companyLimit.maxScr.availablePermits() + " Lectoras: " + Window1.companyLimit.maxRd.availablePermits() + " Palancas: " + Window1.companyLimit.maxJoy.availablePermits());
                    
                }
                catch(InterruptedException e){
                   this.execute = false;
                   Window1.companyStorage.getCurrButt().release(5);
                   Window1.companyStorage.getCurrJoy().release(2);
                   Window1.companyStorage.getCurrScrNrm().release();
                   Window1.companyStorage.getCurrScrTch().release();
                   Window1.companyStorage.getCurrRd().release();
                   Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                   Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                   Window1.getSD_readers().setText(Integer.toString(Window1.companyStorage.currRd.availablePermits()));
                   Window1.getTouch().setText(Integer.toString(Window1.companyStorage.currScrTch.availablePermits()));
                   Window1.getScreens().setText(Integer.toString(Window1.companyStorage.currScrNrm.availablePermits()));
                }
            }    
        }  
    }  
}
