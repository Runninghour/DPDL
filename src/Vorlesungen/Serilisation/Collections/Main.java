package Vorlesungen.Serilisation.Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // An ordered collection (also known as a sequence) Access by index
        List<Object> list = new ArrayList();

        // A collection that contains no duplicate elements
        Set<Object> set = new HashSet<Object>();

        long startTime = System.nanoTime();

        for (int i = 0; i < 500; i++) {

            list.add(i);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("List .add: " + duration);

        startTime = System.nanoTime();

        list.get(395);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("List .get: " + duration);



        startTime = System.nanoTime();

        list.contains(395);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("List .contains: " + duration);

        startTime = System.nanoTime();

        for (int i = 0; i < 500; i++) {

            set.add(i);
        }
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Set .add: " + duration);

        startTime = System.nanoTime();

        set.contains(395);
        endTime = System.nanoTime();

        duration = (endTime - startTime);

        System.out.println("Set .contains: " + duration);

    }


}
