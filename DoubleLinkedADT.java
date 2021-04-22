   //**************************************************************************
   //**************************************************************************
   //    DoubleLinkedADT.java                       Author: Eric Lavoie
   //                                                       100122593
   // Creates alist that can add values to the front or back of the list and
   //  can iterate the list from front to back or back to front.
   // and reset or remove values from the front or back of the list.
   //**************************************************************************

import java.util.NoSuchElementException;
 
public class DoubleLinkedADT<E> {
    // initializes global variables first node, last node and list size
    private DLLNode first;
    private DLLNode last;
    private int size;
     
    public DoubleLinkedADT() {
        // sets the list size to 0
        size = 0;
    }
    // creates a class that will use nodes to track the list values
    private class DLLNode {
      
        E value;
        // gets the first value added to the list 
        DLLNode next;
        // gets the Last value added to the list 
        DLLNode prev;
 
        public DLLNode(E value, DLLNode next, DLLNode prev) {
            //sets the global values to be called
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    // Returns the size of the list 
    public int size() { return size; }
     
    // catches case were list size is 0
    public boolean isEmpty() { return size == 0; }
     
    // Gets a value and inputs it to the front of the list
    public void getFirst(E value) {
        
        DLLNode list = new DLLNode(value, first, null);
        //if there is a first value set the new value previous to on the list
        if(first != null ) {first.prev = list;}
        first = list;
        // if the last is empty set the new value last to on list
        if(last == null) { last = list;}
        // increase list size
        size++;
        // out puts the value added to the list
        System.out.println("add: "+value);
    }
    
     
    // Gets a value and inputs it to the back of the list
    public void getPrevious(E value) {
        
        DLLNode list = new DLLNode(value, null, last);
        //if there is a last value set the new value to last on the list
        if(last != null) {last.next = list;}
        last = list;
        // if the first is empty set the new value first to on list
        if(first == null) { first = list;}
        //increases the size of the list
        size++;
        // out puts the value added to the list
        System.out.println("add: "+value);
    }
     
    // when called this method will main the list from thr front to back
    public void iterateForward(){
         
        System.out.println("iterating forward");
        DLLNode list = first;
        // lists the values in the list from front to back
        while(list != null){
            System.out.println(list.value);
            // finds the next number in the list
            list = list.next;
        }
    }
    
    // when called this method will main the list from thr back to front
    public void iterateBackward(){
         
        System.out.println("iterating backward");
        DLLNode list = last;
        // lists the values in the list from back to front
        while(list != null){
            System.out.println(list.value);
            //finds the previous number in the list
            list = list.prev;
        }
    }
     
    //This method will reset the number at the front of the list
    public E resetFront() {
        // catches case were list size is 0
        if (size == 0) throw new NoSuchElementException();
        // finds the first value in list and sets it to first in list
        DLLNode list = first;
        first = first.next;
        //Sets the first value in the list to null and changes the size of list
        first.prev = null;
        size--;
        // mains the reset value from list and the new size of the list
        System.out.println(list.value + " has been reset, new list size is  "
                             + size);
        return list.value;
    }
     
    //This method will reset the number at the back of the list
    public E resetBack() {
        // catches case were list size is 0
        if (size == 0) throw new NoSuchElementException();
        // finds the last value in list and sets it to last in list
        DLLNode list = last;
        last = last.prev;
        // Sets the last value in the list to null and changes the size of list
        last.next = null;
        size--;
        // mains the reset value from list and the new size of the list
        System.out.println(list.value + " has been reset, new list size is "
                             + size);
        return list.value;
    }
    

    // The testing method that will allow you to call other methods and input
    // data into the list, iterate and reset data.
    public static void main(String a[]){
        //sets  DoubleLinkedADT<Integer> = DLL
        DoubleLinkedADT<Integer> DLL = new DoubleLinkedADT<Integer>();
        //call a method if getting a value add a interger aswell
        DLL.getFirst(60);
        DLL.getFirst(469);
        DLL.getFirst(22);
        DLL.getFirst(33);
        DLL.getPrevious(90);
        DLL.getPrevious(22);
        DLL.getPrevious(563);
        DLL.iterateForward();
        DLL.iterateBackward();
        DLL.resetFront();
        DLL.resetBack();
        DLL.iterateBackward();
        DLL.iterateForward();
    }
}