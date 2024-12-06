package Materia.Queues;
import java.util.NoSuchElementException;

import Materia.Models.Node;

public class Queue {
    private Node front; // Nodo frente de la cola
    private Node rear; // Nodo al final de la cola
    
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Metodo encolar nodos
    public void enqueue(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Desencolar 
    public Node dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia :/");
        }
        Node node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return node;
    }

    public Node peek(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }        
        return front;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int getSize(){
        int cont = 0;
        Node current = front;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }
}
