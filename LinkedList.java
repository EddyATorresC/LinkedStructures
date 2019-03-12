/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLinkedList;

/**
 *
 * @author User
 */
public class LinkedList {

    private Nodo head;
    private Nodo tail;
    private int count;

    public class Nodo {

        Object object;
        Nodo next;

        Nodo(Object o) {
            this.object = o;
            next = null;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
    public LinkedList() {
        head = new Nodo(null);
        tail = new Nodo(null);
        count = 0;
    }

    public void pushHead(Object o) {
        if (count == 0) {
            Nodo temp = new Nodo(o);
            temp.next = head;
            head = temp;
            tail = temp;
            count++;
        } else {
            Nodo temp = new Nodo(o);
            temp.next = head;
            head = temp;
            count++;
        }
    }

    public void pushTail(Object o) {
        if (count == 0) {
            Nodo temp = new Nodo(o);
            temp.next = temp;
            tail = temp;
            head = temp;
            count++;
        } else {
            Nodo temp = new Nodo(o);
            tail.next = temp;
            tail = temp;
            count++;
        }
    }

    public Object popHead() {
        Object o = null;
        if (count > 0) {
            o = head.object;
            head = head.next;
            count--;
        }
        return o;
    }
    //Son referencias no copias duplicadas
    public Object popTail() {
        Object o = null;
        if(count > 0){
            Nodo temp = head;
            if (head.next == null) {
                head = null;
            }else{
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                o = temp.next;
                temp.next = null;
                tail = temp;
                count--;
            }
        }
        return o;
    }

    public void showAll() {
        Nodo temp = head;
        if(temp == null){
            System.out.println("No hay elementos en la lista");
        }else{
            while (temp.next != null) {
                System.out.println(Integer.parseInt(temp.object.toString()));
                temp = temp.next;
            }
            System.out.println(temp.object);
        }
        
    }
}
