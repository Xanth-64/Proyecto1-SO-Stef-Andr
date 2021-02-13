
package Classes;

import Interface.Window1;

public class RdProducer extends Thread{
    protected boolean execute;
    protected boolean creating;

    public RdProducer() {
        this.execute = true;
        this.creating = false;
    }

    @Override
    public void run() {
        while(execute){
            this.creating = false;
            try{
                Window1.companyLimit.maxRd.acquire(); //Pedir permiso para crear
            }
            catch (InterruptedException e){
                this.execute = false;
            }
            if (this.execute){
                this.creating = true;
                try{
                    Thread.sleep(Window1.timeInterval * 72); //Crear
                    Window1.companyStorage.currRd.release(); //Liberar
                    Window1.getSD_readers().setText(Integer.toString(Window1.companyStorage.currRd.availablePermits()));
                    //System.out.println("Se ha creado 1 lector de tarjetas: " + Window1.companyStorage.currRd.availablePermits() + " Bajando el limite hasta: " + Window1.companyLimit.maxRd.availablePermits());
                }
                catch(InterruptedException e){
                    this.execute = false;
                    Window1.companyLimit.maxRd.release();
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
