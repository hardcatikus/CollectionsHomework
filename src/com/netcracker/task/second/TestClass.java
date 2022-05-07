package com.netcracker.task.second;

import com.netcracker.task.first.MyPoint;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {

        compareLists();

        compareSets();

        compareMaps();

    }

    public static void compareLists(){
        System.out.println("------------сравнение производительности ArrayList и LinkedList------------");

        List<MyPoint> arrayList = new ArrayList<>();
        List<MyPoint> linkedList = new LinkedList<>();

        fillCollection(arrayList);
        fillCollection(linkedList);

        System.out.println(arrayList);
        System.out.println(linkedList);

        MyPoint point = new MyPoint(99,99);

        long timeElapsed1 = addTest(arrayList,point);
        long timeElapsed2 = addTest(linkedList,point);

        System.out.println("Время осуществления добавления нового элемента:" +
                " \n ArrayList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        timeElapsed1 = searchTest(arrayList,point);
        timeElapsed2 = searchTest(linkedList,point);

        System.out.println("Время осуществления поиска элемента:" +
                " \n ArrayList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        timeElapsed1 = removeTest(arrayList,point);
        timeElapsed2 = removeTest(linkedList,point);

        System.out.println("Время осуществления удаления элемента:" +
                " \n ArrayList - " + timeElapsed1 +
                " \n LinkedList - " + timeElapsed2);

        System.out.println("Вывод:" +
                " \n ArrayList - лучше подходит в тех, случаях, " +
                "когда нужно осуществлять поиск по индексу элемента" +
                " \n LinkedList - лучше подходит в тех, случаях, " +
                "когда нужно осуществлять частое добавление и удаление элементов внутри списка");
    }

    public static void fillCollection(Collection<MyPoint> collection){
        int i=0;
        while(i!=90){
            collection.add(new MyPoint(i,i));
            i++;
        }
    }

    public static long addTest(Collection<MyPoint> collection,MyPoint point){
        long start = System.nanoTime();
        collection.add(point);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static long removeTest(Collection<MyPoint> collection,MyPoint point){
        long start = System.nanoTime();
        collection.remove(point);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static long searchTest(Collection<MyPoint> collection,MyPoint point){
        long start = System.nanoTime();
        boolean bool = collection.contains(point);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static void compareSets(){
        System.out.println("------------сравнение производительности HashSet, LinkedHashSet и TreeSet------------");

        Set<MyPoint> hashSet = new HashSet<>();
        Set<MyPoint> linkedHashSet = new LinkedHashSet<>();
        Set<MyPoint> treeSet = new TreeSet<>();

        fillCollection(hashSet);
        fillCollection(linkedHashSet);
        fillCollection(treeSet);

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);

        MyPoint point = new MyPoint(99,99);

        long timeElapsed1 = addTest(hashSet,point);
        long timeElapsed2 = addTest(linkedHashSet,point);
        long timeElapsed3 = addTest(treeSet,point);

        System.out.println("Время осуществления добавления нового элемента:" +
                " \n HashSet - " + timeElapsed1 +
                " \n LinkedHashSet - " + timeElapsed2 +
                " \n TreeSet - " + timeElapsed3);

        timeElapsed1 = searchTest(hashSet,point);
        timeElapsed2 = searchTest(linkedHashSet,point);
        timeElapsed3 = searchTest(treeSet,point);

        System.out.println("Время осуществления поиска элемента:" +
                " \n HashSet - " + timeElapsed1 +
                " \n LinkedHashSet - " + timeElapsed2 +
                " \n TreeSet - " + timeElapsed3);

        timeElapsed1 = removeTest(hashSet,point);
        timeElapsed2 = removeTest(linkedHashSet,point);
        timeElapsed3 = removeTest(treeSet,point);

        System.out.println("Время осуществления удаления элемента:" +
                " \n HashSet - " + timeElapsed1 +
                " \n LinkedHashSet - " + timeElapsed2 +
                " \n TreeSet - " + timeElapsed3);

        System.out.println("Вывод:" +
                " \n HashSet - лучше подходит в тех, случаях, " +
                "когда последовательность элементов не важна," +
                " добавляет новый элемент быстрее, чем LinkedHashSet, " +
                "удаляет элемент быстрее, чем TreeSet" +
                " \n LinkedHashSet - лучше подходит в тех, случаях, " +
                "когда нужно сохранить последовательность добавления элементов, " +
                "быстрее других наборов осуществляет удаление и поиск элементов" +
                " \n TreeSet - лучше подходит в тех, случаях, " +
                "когда нужно получить отсортированный набор, " +
                "быстрее других наборов осуществляет добавление новых элементов");
    }

    public static void compareMaps(){
        System.out.println("------------сравнение производительности HashMap, LinkedHashMap и TreeMap------------");

        Map<Integer,MyPoint> hashMap = new HashMap<>();
        Map<Integer,MyPoint> linkedHashMap = new LinkedHashMap<>();
        Map<Integer,MyPoint> treeMap = new TreeMap<>();

        fillMap(hashMap);
        fillMap(linkedHashMap);
        fillMap(treeMap);

        System.out.println(hashMap);
        System.out.println(linkedHashMap);
        System.out.println(treeMap);

        MyPoint point = new MyPoint(99,99);

        long timeElapsed1 = addMapTest(hashMap,point);
        long timeElapsed2 = addMapTest(linkedHashMap,point);
        long timeElapsed3 = addMapTest(treeMap,point);

        System.out.println("Время осуществления добавления нового элемента:" +
                " \n HashMap - " + timeElapsed1 +
                " \n LinkedHashMap - " + timeElapsed2 +
                " \n TreeMap - " + timeElapsed3);

        int pointIndex = 55;

        timeElapsed1 = searchMapTest(hashMap,pointIndex);
        timeElapsed2 = searchMapTest(linkedHashMap,pointIndex);
        timeElapsed3 = searchMapTest(treeMap,pointIndex);

        System.out.println("Время осуществления поиска элемента:" +
                " \n HashMap - " + timeElapsed1 +
                " \n LinkedHashMap - " + timeElapsed2 +
                " \n TreeMap - " + timeElapsed3);

        timeElapsed1 = removeMapTest(hashMap,pointIndex);
        timeElapsed2 = removeMapTest(linkedHashMap,pointIndex);
        timeElapsed3 = removeMapTest(treeMap,pointIndex);

        System.out.println("Время осуществления удаления элемента:" +
                " \n HashMap - " + timeElapsed1 +
                " \n LinkedHashMap - " + timeElapsed2 +
                " \n TreeMap - " + timeElapsed3);

        System.out.println("Вывод:" +
                " \n HashMap - лучше подходит в тех, случаях, " +
                "когда последовательность элементов не важна," +
                " быстрее других карт осуществляет добавление новых элементов" +
                " \n LinkedHashMap - лучше подходит в тех, случаях, " +
                "когда нужно сохранить последовательность добавления элементов, " +
                "быстрее других карт осуществляет удаление элементов" +
                " \n TreeMap - лучше подходит в тех, случаях, " +
                "когда нужно получить отсортированный набор, " +
                "быстрее других карт осуществляет поиск элементов");

    }

    public static void fillMap(Map<Integer,MyPoint> map){
        int i=0;
        while(i!=90){
            map.put(i,new MyPoint(i,i));
            i++;
        }
    }

    public static long addMapTest(Map<Integer,MyPoint> map, MyPoint point){
        long start = System.nanoTime();
        map.put(99,point);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static long removeMapTest(Map<Integer,MyPoint> map, int pointIndex){
        long start = System.nanoTime();
        map.remove(pointIndex);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static long searchMapTest(Map<Integer,MyPoint> map, int pointIndex){
        long start = System.nanoTime();
        MyPoint point = map.get(pointIndex);
        long finish = System.nanoTime();
        return finish - start;
    }
}
