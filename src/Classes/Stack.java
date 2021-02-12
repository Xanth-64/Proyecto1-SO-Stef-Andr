/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Stefani
 */
public class Stack {
    private Nodo head;
    private int size;
    
    public Stack(){
        this.head = null;
        this.size = 0;
    }
    
    public boolean is_empty(){
        return getHead() == null;
    }
    
    public void push(Nodo nodo){
        if (this.is_empty()) {
            setHead(nodo);
        }else{
            nodo.setNext(getHead());
            setHead(nodo);
        }
        setSize(getSize() + 1);
    }
    
    public void pop(){
        if (this.is_empty()) {
            JOptionPane.showMessageDialog(null, "The stack is empty.");
        }else{
            setHead(getHead().getNext());
            setSize(getSize() - 1);
        }
    }
    
    public String print(Stack stack, String full_stack, int counter){
        if (this.is_empty()) {
            
        }else{
            Nodo temporary = getHead();
            stack.pop();
            full_stack += "Nodo " + counter + ": " + temporary.getThread() + "\n";
            counter++;
            full_stack = print(stack, full_stack, counter);
            stack.push(temporary);
        }
        return full_stack;
    }

    /**
     * @return the head
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
