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
public class TCircLinkedList {

    private Nodo first;
    private Nodo last;
    private int count;

    public class Nodo {

        Object object;
        Nodo next;

        Nodo(Object o) {
            this.object = o;
            next = null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public TCircLinkedList() {
        first = null;
        last = null;
        count = 0;
    }

    public void pushFirst(Object o) {
        if (count == 0) {
            Nodo temp = new Nodo(o);
            first = temp;
            last = temp;
            last.next = first;
            count++;
        } else {
            Nodo temp = new Nodo(o);
            temp.next = first;
            first = temp;
            last.next = first;
            count++;
        }
    }

    public void pushLast(Object o) {
        if (isEmpty()) {
            Nodo temp = new Nodo(o);
            first = temp;
            last = temp;
            last.next = first;
            count++;
        } else {
            Nodo temp = new Nodo(o);
            last.next = temp;
            last = temp;
            last.next = first;
            count++;
        }
    }

    public void pushAt(Object o, int pos) {
        if (isEmpty()) {
            pushFirst(o);
        } else {
            if (pos >= 0) {
                if (pos < count) {
                    if (pos == 0) {
                        pushFirst(o);
                    } else if (pos + 1 == count) {
                        pushLast(o);
                    } else {
                        Nodo nuevo = new Nodo(o);
                        Nodo temp = first;
                        int conteo = 0;

                        while (conteo < pos - 1) {
                            temp = temp.next;
                            conteo++;
                        }

                        nuevo.next = temp.next;
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

    public Object popFirst() {
        Object o = null;
        if (!isEmpty()) {
            o = first.object;
            first = first.next;
            last = first;
            count--;
        } else {
            System.out.println("Lista vacía.");
        }
        return o;
    }

    //Son referencias no copias duplicadas
    public Object popLast() {
        Object o = null;
        int pos = 0;
        if (!isEmpty()) {
            Nodo temp = first;
            if (first.next == null) {
                first = null;
                last = first;
            } else {
                while (pos < count - 2) {
                    temp = temp.next;
                    pos++;
                }
                o = temp.next;
                last = temp;
                last.next = first;
                count--;
            }
        } else {
            System.out.println("Lista vacía.");
        }
        return o;
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
                        Nodo temp = first;
                        int conteo = 0;
                        while (conteo < pos-1) {
                            temp = temp.next;
                            conteo++;
                        }
                        o = temp.next.object;
                        temp.next = temp.next.next; 
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
        Nodo temp = first;
        int idx = 0;
        if (temp == null) {
            System.out.println("No hay elementos en la lista");
        } else {
            while (idx < count) {
                System.out.println(temp.object);
                temp = temp.next;
                idx++;
            }
        }

    }
}
