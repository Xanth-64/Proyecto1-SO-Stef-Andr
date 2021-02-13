
package Classes;

import Interface.Window1;

public class JoyProducer extends Thread {
    
    protected boolean execute;
    protected boolean creating;

    @Override
    public void run() {
        while(execute){
            try{
                Window1.companyLimit.maxJoy.acquire(); //Pedir permiso para crear
            }
            catch(InterruptedException e){
                this.execute = false;
            }
            if(this.execute){
                this.creating = true;
                try{
                    Thread.sleep(Window1.timeInterval * 48); //Crear
                    Window1.companyStorage.currJoy.release(); //Liberar
                    Window1.getJoysticks().setText(Integer.toString(Window1.companyStorage.currJoy.availablePermits()));
                    System.out.println("Se ha creado un Joystick: " + Window1.companyStorage.currJoy.availablePermits() + " Bajando el limite a: " + Window1.companyLimit.maxJoy.availablePermits());
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyLimit.maxJoy.release();
                }
            }
        
        }
    }
    
    public JoyProducer(){
        this.execute = true;
        this.creating = false;
    }
    
    
    /**
     * @return the execute
     */
    public boolean isExecute() {
        return execute;
    }

    /**
     * @return the creating
     */
    public boolean isCreating() {
        return creating;
    }

    /**
     * @param execute the execute to set
     */
    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    /**
     * @param creating the creating to set
     */
    public void setCreating(boolean creating) {
        this.creating = creating;
    }

    
    
    
}
