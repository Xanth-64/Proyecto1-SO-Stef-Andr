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
public class ButtProducer implements Runnable {
    
    protected boolean execute;
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
                Window1.companyLimit.maxButt.acquire(2);
            }
            catch (InterruptedException e){
                this.execute = false;
            }
            if(this.execute){
                this.creating = true;
                try{
                    Thread.sleep(Window1.timeInterval * 24);
                    Window1.companyStorage.currButt.release(2);
                    System.out.println("Se acaban de producir 2 botones para llegar a un total de: " + Window1.companyStorage.currButt.availablePermits() + " Límite actual: " + Window1.companyLimit.maxButt.availablePermits());
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyLimit.maxButt.release(2);
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
