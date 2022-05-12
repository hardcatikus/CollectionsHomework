package com.netcracker.task.first;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLInkedList<E> implements ILinkedList<E> {

    public static class Node<E> {

        private E element;
        private Node<E> nextNode;

        public Node(E element) {
            this.element = element;
            this.nextNode = null;
        }

    }

    private Node<E> firstNode;
    private Node<E> lastNode;
    public static int sizeOfList;

    @Override
    public void add(E element) {
        if (firstNode == null) {
            addFirstNode(element);
        } else {
            addLastNode(element);
        }
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == 0) {
            addFirstNode(element);
        } else if (index == sizeOfList) {
            addLastNode(element);
        } else {
            Node<E> currentNode = firstNode;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            Node<E> tempNode = currentNode.nextNode;
            currentNode.nextNode = new Node<>(element);
            currentNode.nextNode.nextNode = tempNode;
            sizeOfList++;
        }
    }

    //добавление элемента в начало коллекции
    private void addFirstNode(E element) {
        Node<E> node = new Node<>(element);
        node.nextNode = firstNode;
        firstNode = node;
        if (lastNode == null) {
            lastNode = firstNode;
        }
        sizeOfList++;
    }

    //добавление элемента в конец коллекции
    private void addLastNode(E element) {
        lastNode.nextNode = new Node<>(element);
        lastNode = lastNode.nextNode;
        sizeOfList++;
    }

    //возвращает, входит ли введенный index
    // в границы коллекции
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= sizeOfList;
    }

    //формирует сообщение о несоответствии индекса размеру коллекции
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + sizeOfList;
    }

    //проверяется, подходит ли введенный index
    // для дальнейшего выполнения методов
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    @Override
    public void clear() {
        for (Node<E> currentNode = firstNode; currentNode != null; ) {
            Node<E> next = currentNode.nextNode;
            currentNode.element = null;
            currentNode.nextNode = null;
            currentNode = next;
        }
        firstNode = lastNode = null;
        sizeOfList = 0;
    }

    @Override
    public int size() {
        return sizeOfList;
    }

    @Override
    public E get(int index) {
        checkPositionIndex(index);
        if (index == 0) {
            return firstNode.element;
        } else if (index == sizeOfList - 1) {
            return lastNode.element;
        } else {
            Node<E> currentNode = firstNode.nextNode;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            return currentNode.element;
        }
    }

    @Override
    public int indexOf(E element) {
        if (firstNode.element == element) {
            return 0;
        } else if (lastNode.element == element) {
            return sizeOfList - 1;
        } else {
            Node<E> currentNode = firstNode.nextNode;
            int currentIndex = 1;
            while (currentNode != null) {
                if (currentNode.element == element) {
                    return currentIndex;
                } else {
                    currentNode = currentNode.nextNode;
                    currentIndex++;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = firstNode;
        for (int i = 0; i < sizeOfList; i++) {
            result.append(currentNode.element);
            currentNode = currentNode.nextNode;
            if (currentNode != null) {
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }

    @Override
    public E set(int index, E element) {
        checkPositionIndex(index);
        if (index < 0 || index >= sizeOfList) {
            return null;
        } else {
            Node<E> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            currentNode.element = element;
            return currentNode.element;
        }
    }

    @Override
    public E remove(int index) {
        checkPositionIndex(index);
        E tempElement = get(index);
        if (index == 0) {
            firstNode = firstNode.nextNode;
        } else if (index == sizeOfList - 1) {
            if (sizeOfList == 1) {
                firstNode = lastNode = null;
            } else {
                Node<E> currentNode = firstNode;
                for (int i = 0; i < sizeOfList - 2; i++) {
                    currentNode = currentNode.nextNode;
                }
                lastNode = currentNode;
                lastNode.nextNode = null;
            }
        } else {
            Node<E> previousNode = firstNode;
            for (int i = 1; i < index; i++) {
                previousNode = previousNode.nextNode;
            }
            previousNode.nextNode = previousNode.nextNode.nextNode;
        }
        sizeOfList--;
        return tempElement;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[sizeOfList];
        int i = 0;
        for (Node<E> tempNode = firstNode; tempNode != null; tempNode = tempNode.nextNode)
            result[i++] = tempNode.element;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < sizeOfList)
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), sizeOfList);
        int i = 0;
        Object[] result = a;
        for (Node<E> tempNode = firstNode; tempNode != null; tempNode = tempNode.nextNode)
            result[i++] = tempNode.element;
        if (a.length > sizeOfList)
            a[sizeOfList] = null;
        return a;
    }

    @Override
    public MyIterator<E> iterator(){
        return new MyIterator();

    }

    public class MyIterator<E> implements java.util.Iterator<E> {

        public Node<E> currentNode, previousNode;

        public MyIterator(){
            currentNode = new Node<E>(null);
            currentNode.nextNode = (Node<E>) firstNode;
        }

        @Override
        public boolean hasNext(){
            return currentNode.nextNode != null;
        }

        @Override
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            return currentNode.element;
        }

        @Override
        public void remove(){
            if(currentNode == null || currentNode.element == null){
                throw new IllegalStateException();
            }
            else {
                previousNode.nextNode = currentNode.nextNode;
            }
            currentNode = previousNode;
            sizeOfList--;
        }

    }
}
