package com.netcracker.task.first;

import java.util.LinkedList;

public class MainClass {

    public static void main(String[] args) {

        testMethods();

        compareListsDuration();

    }

    public static void testMethods(){
        System.out.println("------------проверка методов------------");

        MyLInkedList <MyPoint> myLInkedList = new MyLInkedList<>();

        System.out.println(myLInkedList);

        myLInkedList.add(new MyPoint());
        myLInkedList.add(new MyPoint(8,9));
        myLInkedList.add(new MyPoint(12,4));

        System.out.println(myLInkedList);

        myLInkedList.add(1,new MyPoint(5,5));
        myLInkedList.add(0,new MyPoint(50,50));
        myLInkedList.add(5,new MyPoint(500,500));

        System.out.println(myLInkedList);

        System.out.println(myLInkedList.get(0));
        System.out.println(myLInkedList.get(1));
        System.out.println(myLInkedList.get(5));

        MyPoint point1 = new MyPoint(77,77);
        MyPoint point2 = new MyPoint(50,50);
        myLInkedList.add(point2);

        System.out.println(myLInkedList.indexOf(point1));
        System.out.println(myLInkedList.indexOf(point2));

        myLInkedList.remove(0);
        myLInkedList.remove(3);
        myLInkedList.remove(4);

        System.out.println(myLInkedList);

        myLInkedList.set(2,point1);

        System.out.println(myLInkedList);

        System.out.println(myLInkedList.size());


        MyPoint[] points = myLInkedList.toArray(new MyPoint[0]);
        for(MyPoint point : points){
            System.out.print(point);
        }
        System.out.println();

        MyLInkedList<MyPoint>.MyIterator<MyPoint> iterator = myLInkedList.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(myLInkedList);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

        myLInkedList.clear();

        System.out.println(myLInkedList);
    }

    public static void compareListsDuration(){
        System.out.println("------------сравнение производительности MyLinkedList и java.util.LinkedList------------");

        MyLInkedList<MyPoint> myLInkedList2 = new MyLInkedList<>();

        java.util.LinkedList<MyPoint> linkedList = new LinkedList<>();

        int i=0;
        while(i!=90){
            myLInkedList2.add(new MyPoint(i,i));
            linkedList.add(new MyPoint(i,i));
            i++;
        }

        System.out.println(myLInkedList2);
        System.out.println(linkedList);

        int pointIndex = 55;
        MyPoint point = new MyPoint(99,99);

        long start = System.nanoTime();
        myLInkedList2.add(point);
        long finish = System.nanoTime();
        long timeElapsed1 = finish - start;

        start = System.nanoTime();
        linkedList.add(point);
        finish = System.nanoTime();
        long timeElapsed2 = finish - start;

        System.out.println("Время осуществления добавления нового элемента:" +
                " \n MyLinkedList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        start = System.nanoTime();
        MyPoint point01 = myLInkedList2.get(pointIndex);
        finish = System.nanoTime();
        timeElapsed1 = finish - start;

        start = System.nanoTime();
        MyPoint point02 = linkedList.get(pointIndex);
        finish = System.nanoTime();
        timeElapsed2 = finish - start;

        System.out.println("Время осуществления поиска элемента:" +
                " \n MyLinkedList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        start = System.nanoTime();
        myLInkedList2.remove(pointIndex);
        finish = System.nanoTime();
        timeElapsed1 = finish - start;

        start = System.nanoTime();
        linkedList.remove(pointIndex);
        finish = System.nanoTime();
        timeElapsed2 = finish - start;

        System.out.println("Время осуществления удаления элемента:" +
                " \n MyLinkedList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        System.out.println("Вывод:" +
                        "\n MyLinkedList выполняет операции удаления," +
                        " поиска и добавления быстрее, чем LinkedList");
    }
}
