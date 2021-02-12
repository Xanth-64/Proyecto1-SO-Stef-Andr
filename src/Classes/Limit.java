
package Classes;

import java.util.concurrent.Semaphore;

public class Limit {
    protected Semaphore maxScr;
    protected Semaphore maxButt;
    protected Semaphore maxJoy;
    protected Semaphore maxRd;

    public Limit(int maxScrStart, int maxButtStart, int maxJoyStart, int maxRdStart) {
        this.maxScr = new Semaphore(maxScrStart,true);
        this.maxButt = new Semaphore(maxButtStart,true);
        this.maxJoy = new Semaphore(maxJoyStart,true);
        this.maxRd = new Semaphore(maxRdStart,true);
        
    }

   
    
    /**
     * @return the maxScr
     */
    public Semaphore getMaxScr() {
        return maxScr;
    }

    /**
     * @return the maxButt
     */
    public Semaphore getMaxButt() {
        return maxButt;
    }

    /**
     * @return the maxJoy
     */
    public Semaphore getMaxJoy() {
        return maxJoy;
    }

    /**
     * @return the maxRd
     */
    public Semaphore getMaxRd() {
        return maxRd;
    }
}
