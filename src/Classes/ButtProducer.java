
package Classes;

import Interface.Window1;

public class ButtProducer extends Thread {
    
    protected boolean execute; //True: con vida. False: muerto
    protected boolean creating;
    public ButtProducer(){
        this.execute = true;
        this.creating = false;
    }
    
    @Override
    public void run() {
        while(this.execute){
            this.creating = false;
            try{
                Window1.companyLimit.maxButt.acquire(2); //Pedir permiso para crear
            }
            catch (InterruptedException e){
                this.execute = false; //Si lo interrumpen mientras esta en la cola
            }
            if(this.execute){
                this.creating = true;
                try{
                    Thread.sleep((long) (Window1.timeInterval * 24)); //Produciendo
                    Window1.companyStorage.currButt.release(2); //Libera los permisos
                    Window1.getButtons().setText(Integer.toString(Window1.companyStorage.currButt.availablePermits()));
                    //System.out.println("Se acaban de producir 2 botones para llegar a un total de: " + Window1.companyStorage.currButt.availablePermits() + " Límite actual: " + Window1.companyLimit.maxButt.availablePermits());
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyLimit.maxButt.release(2); //Libera los permisos
                }
            }
        }
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
