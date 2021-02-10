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
public class ScrProducer implements Runnable{
    protected boolean touch;
    protected boolean execute;
    protected boolean creating;

    @Override
    public void run() {
        while(this.execute){
            this.creating = false;
            if(this.touch){
                try{
                    Window1.companyLimit.maxScr.acquire();
                }
                catch(InterruptedException e){
                    this.execute = false;
                }
                if(this.execute){
                    this.creating = true;
                    try{
                        Thread.sleep(Window1.timeInterval * 48);
                        Window1.companyStorage.currScrTch.release();
                        this.touch = false;
                        System.out.println("Se ha creado una pantalla tactil, llevando el total hasta: " + Window1.companyStorage.currScrTch.availablePermits() + " bajando el limite hasta: " + Window1.companyLimit.maxScr.availablePermits());
                    }
                    catch(InterruptedException e){
                        this.execute = false;
                        Window1.companyLimit.maxScr.release();
                    }
                }
            }
            else{
                try{
                    Window1.companyLimit.maxScr.acquire();
                }
                catch(InterruptedException e){
                    this.execute = false;
                }
                if (this.execute){
                    this.creating = true;
                    try{
                        Thread.sleep(Window1.timeInterval * 24);
                        Window1.companyStorage.currScrNrm.release();
                        this.touch = true;
                        System.out.println("Se ha creado una pantalla normal, llevando el total hasta: " + Window1.companyStorage.currScrNrm.availablePermits() + " bajando el limite: " + Window1.companyLimit.maxScr.availablePermits());
                    }
                    catch(InterruptedException e){
                        this.execute = false;
                        Window1.companyLimit.maxScr.release();
                    }
                }
            }
        }   
    }
    
    public ScrProducer() {
        this.execute = true;
        this.creating = false;
        this.touch = true;
        
    }
    /**
     * @return the touch
     */
    public boolean isTouch() {
        return touch;
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
     * @param touch the touch to set
     */
    public void setTouch(boolean touch) {
        this.touch = touch;
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
