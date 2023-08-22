/**
 * 
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Sanaz Shaik(906399883)
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * @author sanazshaik
 * @version 2022.10.17
 * @param <T>
 *            type T
 */
public class LinkedStack<T> implements StackInterface<T> {
    // ~ Fields ................................................................
    private Node<T> topNode;
    private int size;

    // Constructor ..........................................................
    /**
     * sets topNode to null, so topNode can be used throughout this class
     */
    public LinkedStack() {
        topNode = null;
    }


    // ~ Methods .......................................................
    // ----------------------------------------------------------
    /**
     * 
     * @return size
     *         how many objects are in linked stack
     */
    public int size() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * the size is 0 when the stack is cleared
     */
    @Override
    public void clear() {
        size = 0;

    }


    // ----------------------------------------------------------
    /**
     * @return boolean value
     *         when size is 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * @return "[,]"
     *         the string version of the linked stack
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Node<T> node = topNode;

        while (node != null) {
            builder.append(node.getData());
            node = node.getNextNode();
            if (node != null) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    // ----------------------------------------------------------
    /**
     * @return topNode's data
     *         i.e, what's on top of the stack
     *         else if empty, exception is thrown
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    // ----------------------------------------------------------
    /**
     * removes Node from the top of the stack
     * 
     * @return value
     *         the value of that node
     *         decrements size
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return value;

    }


    // ----------------------------------------------------------
    /**
     * @param anEntry
     *            entry
     *            creates a new node and updates that new entry to topNode
     *            increments the size accordingly
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }

    @SuppressWarnings("hiding")
    private class Node<T> {
        // ~ Fields
        // ................................................................
        private T data;
        private Node<T> next;

        // ----------------------------------------------------------
        /**
         * @param entry
         *            type T
         * @param node
         *            type node
         */
        public Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }


        // ----------------------------------------------------------
        /**
         * @param node
         *            type node
         */
        public void setNextNode(Node<T> node) {
            next = node;
        }


        // ----------------------------------------------------------
        /**
         * @param data
         *            type t
         */
        public Node(T data) {
            this.data = data;
        }


        // ----------------------------------------------------------
        /**
         * @return next
         *         next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        // ----------------------------------------------------------
        /**
         * @return data
         *         the data retrieved from the node
         */
        public T getData() {
            return data;
        }

    }

}
