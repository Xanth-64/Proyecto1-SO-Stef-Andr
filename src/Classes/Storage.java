
package Classes;

import java.util.concurrent.Semaphore;

public class Storage {
    protected Semaphore currJoy;
    protected Semaphore currButt;
    protected Semaphore currScrTch;
    protected Semaphore currScrNrm;
    protected Semaphore currRd;
    protected Semaphore consoles;
    
    
    public Storage(int currJoyStart, int currButtStart, int currScrTchStart, int currRdStart, int currScrNrmStart, int startingConsoles) {
        this.currJoy = new Semaphore(currJoyStart,true);
        this.currButt = new Semaphore(currButtStart,true);
        this.currScrTch = new Semaphore(currScrTchStart,true);
        this.currRd = new Semaphore(currRdStart,true);
        this.currScrNrm = new Semaphore(currScrNrmStart,true);
        this.consoles = new Semaphore(startingConsoles,true);
    }

    /**
     * @return the currJoy
     */
    public Semaphore getCurrJoy() {
        return currJoy;
    }

    /**
     * @return the currButt
     */
    public Semaphore getCurrButt() {
        return currButt;
    }

    /**
     * @return the currScrTch
     */
    public Semaphore getCurrScrTch() {
        return currScrTch;
    }

    /**
     * @return the currScrNrm
     */
    public Semaphore getCurrScrNrm() {
        return currScrNrm;
    }

    /**
     * @return the currRd
     */
    public Semaphore getCurrRd() {
        return currRd;
    }

    public Semaphore getConsoles() {
        return consoles;
    }
    
}
