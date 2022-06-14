package Vorlesungen.Serilisation.Colletions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args) {

        long    startTime,
                endTime,
                duration;

        int     test,
                iterations = 500;

        List<Object> list = new ArrayList();
        Set<Object> set = new HashSet<Object>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();


        // LIST
        // add
        startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++)
            list.add(i);

        endTime = System.nanoTime();

        duration = (endTime - startTime) / iterations;
        System.out.println("List.add: " + duration);

        // get
        startTime = System.nanoTime();
        list.get(255);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("List.get: " + duration);

        // SET
        // add
        startTime = System.nanoTime();

        for (int i = 0; i < 500; i++)
            set.add(i);

        endTime = System.nanoTime();

        duration = (endTime - startTime) / iterations;
        System.out.println("Set.add: " + duration);

        // get
        startTime = System.nanoTime();
        set.contains(395);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Set.contains: " + duration);

        // MAP
        // add

        startTime = System.nanoTime();

        for (int k=0; k < iterations; k++)
            map.put(k, k);

        endTime = System.nanoTime();

        duration = (endTime - startTime) / iterations;
        System.out.println("HashMap.add: " + duration);

        // get
        startTime = System.nanoTime();
        test = map.get(255);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("HashMap.contains: " + duration);

        startTime = System.nanoTime();

        for (int k=0; k < iterations; k++)
            queue.add(k);

        endTime = System.nanoTime();

        duration = (endTime - startTime) / iterations;

        System.out.println("Queue.add: " + duration);
        startTime = System.nanoTime();

        while (queue.remove() != 255)
            continue;
        endTime = System.nanoTime();
        duration = (endTime - startTime);

        System.out.println("Queue.contains: " + duration);
    }
}