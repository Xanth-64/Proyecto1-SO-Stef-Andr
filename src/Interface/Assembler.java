/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Xanth
 */
public class Assembler implements Runnable {
   public boolean execute;
   public String name;
    
    @Override
    public void run(){
        
        while (execute){
            try{
               Window1.companyStorage.getCurrButt().acquire(5);
               Window1.companyStorage.getCurrJoy().acquire(2);
               Window1.companyStorage.getCurrScrNrm().acquire();
               Window1.companyStorage.getCurrScrTch().acquire();
               Window1.companyStorage.getCurrRd().acquire();
            }
            catch(InterruptedException e){
                this.execute = false;
            }
            try{
                Thread.sleep(Window1.timeInterval * 24);
                Window1.companyStorage.consoles.release();
                System.out.println(this.name + Window1.companyStorage.consoles.availablePermits());
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
