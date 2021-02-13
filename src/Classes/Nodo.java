
package Classes;

public class Nodo {
    private ButtProducer Butt;
    private Assembler Assemble;
    private JoyProducer Joy;
    private RdProducer Rd;
    private ScrProducer Scr;
    private Nodo next;
    
    public Nodo(ButtProducer Butt){
        this.Butt = Butt;
        this.next = null;
    }
    
    public Nodo(Assembler Assemble){
        this.Assemble = Assemble;
        this.next = null;
    }
    
    public Nodo(JoyProducer Joy){
        this.Joy = Joy;
        this.next = null;
    }
    
    public Nodo(RdProducer Rd){
        this.Rd = Rd;
        this.next = null;
    }
    
    public Nodo(ScrProducer Scr){
        this.Scr = Scr;
        this.next = null;
    }
    
    
    
    
    
    
    /**
     * @return the thread
     */
    

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return the Butt
     */
    public ButtProducer getButt() {
        return Butt;
    }

    /**
     * @return the Assemble
     */
    public Assembler getAssemble() {
        return Assemble;
    }

    /**
     * @return the Joy
     */
    public JoyProducer getJoy() {
        return Joy;
    }

    /**
     * @return the Rd
     */
    public RdProducer getRd() {
        return Rd;
    }

    /**
     * @return the Scr
     */
    public ScrProducer getScr() {
        return Scr;
    }

    /**
     * @param Butt the Butt to set
     */
    public void setButt(ButtProducer Butt) {
        this.Butt = Butt;
    }

    /**
     * @param Assemble the Assemble to set
     */
    public void setAssemble(Assembler Assemble) {
        this.Assemble = Assemble;
    }

    /**
     * @param Joy the Joy to set
     */
    public void setJoy(JoyProducer Joy) {
        this.Joy = Joy;
    }

    /**
     * @param Rd the Rd to set
     */
    public void setRd(RdProducer Rd) {
        this.Rd = Rd;
    }

    /**
     * @param Scr the Scr to set
     */
    public void setScr(ScrProducer Scr) {
        this.Scr = Scr;
    }
}
