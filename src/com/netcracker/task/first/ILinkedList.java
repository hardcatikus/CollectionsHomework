package com.netcracker.task.first;

public interface ILinkedList <E> extends java.lang.Iterable<E> {

    void add(E element);
    void add(int index, E element);
    void clear();
    E get(int index);
    int indexOf(E element);
    E remove(int index);
    E set(int index, E element);
    int size();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    String toString();

}
