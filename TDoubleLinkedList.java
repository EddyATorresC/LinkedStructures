/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLinkedList;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TDoubleLinkedList {

    private NodoDoble first;
    private NodoDoble last;
    private int count;

    public class NodoDoble {

        NodoDoble next;
        NodoDoble prev;
        Object o;

        //Para un solo elemento
        NodoDoble(Object o) {
            this.o = o;
            next = null;
            prev = null;
        }

        //Para más de un elemento
        NodoDoble(Object o, NodoDoble next, NodoDoble prev) {
            this.o = o;
            this.next = next;
            this.prev = prev;
        }
    }

    public TDoubleLinkedList() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void pushFirst(Object o) {
        if (isEmpty()) {
            NodoDoble nuevo = new NodoDoble(o);
            first = last = nuevo;
            count++;
        } else {
            if (count == 1) {
                NodoDoble nuevo = new NodoDoble(o, first, null);
                nuevo.next = first;
                first = nuevo;
                last.prev = nuevo;
                count++;
            } else {
                NodoDoble nuevo = new NodoDoble(o, first, null);
                first.prev = nuevo;
                first = nuevo;
                count++;
            }

        }
    }

    public Object popFirst() {
        Object o = null;
        if (!isEmpty()) {
            o = first.o;
            first = first.next;
            first.prev = null;
            count--;
        } else {
            System.out.println("Lista vacía.");
        }
        return o;
    }

    public void pushLast(Object o) {
        if (isEmpty()) {
            NodoDoble nuevo = new NodoDoble(o);
            first = last = nuevo;
            count++;
        } else {
            if (count == 1) {
                NodoDoble nuevo = new NodoDoble(o,null,last);
                last = nuevo;
                first.next = nuevo;
                count++;
            } else {
                NodoDoble nuevo = new NodoDoble(o,null,last);
                last.next = nuevo;
                last = nuevo;
                count++;
                //System.out.println(count);
            }

        }
    }

    public Object popLast() {
        Object o = null;
        if (!isEmpty()) {
            o = last.o;
            last = last.prev;
            last.next = null;
            count--;
        } else {
            System.out.println("Lista vacía.");
        }
        return o;
    }

    public void pushAt(Object o, int pos) {
        if (isEmpty()) {
            NodoDoble nuevo = new NodoDoble(o);
            first = last = nuevo;
            count++;
        } else {
            if (pos >= 0) {
                if (pos < count) {
                    if (pos == 0) {
                        pushFirst(o);
                    } else if (pos + 1 == count) {
                        pushLast(o);
                    } else {
                        NodoDoble nuevo = new NodoDoble(o);
                        NodoDoble temp = first;
                        int conteo = 0;

                        while (conteo <= pos) {
                            temp = temp.next;
                            conteo++;
                        }

                        nuevo.prev = temp;
                        nuevo.next = temp.next;
                        temp.next.prev = nuevo;
                        temp.next = nuevo;

                        count++;
                    }
                } else {
                    System.out.println("Error. El índice excede los valores existentes.");
                }
            } else {
                System.out.println("Error, no existen posiciciones negativas.");
            }
        }
    }

    public Object popAt(int pos) {
        Object o = null;
        if (isEmpty()) {
            System.out.println("Lista vacía.");
        } else {
            if (pos >= 0) {
                if (pos < count) {
                    if (pos == 0) {
                        popFirst();
                    } else if (pos + 1 == count) {
                        popLast();
                    } else {
                        NodoDoble temp = first;
                        int conteo = 0;
                        while (conteo <= pos) {
                            temp = temp.next;
                            conteo++;
                        }
                        o = temp.o;
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;

                        count--;
                    }
                } else {
                    System.out.println("Error. El índice excede los valores existentes.");
                }
            } else {
                System.out.println("Error. No existen posiciciones negativas.");
            }
        }

        return o;
    }

    public void showAll() {
        NodoDoble temp = last;
        while (temp != null) {
            System.out.println(temp.o);
            temp = temp.prev;
        }
    }
}
