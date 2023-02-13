package com.epam.rd.autotasks;
import java.util.*;

public class CarouselRun {

    private final int[] container;
    private int i = 0;
    private int sum = 0;
    private final int flag;
    private int decrement = 1;

    public CarouselRun (int[] container, int counter) {
        this.container = Arrays.copyOf(container, container.length);
        //i = counter;
        flag = 0;
        for (int elem : container ) {
            sum += elem;
        }
    }

    public CarouselRun (int[] container, int counter, int flag) {
        this.container = Arrays.copyOf(container, container.length);
        //i = counter;
        this.flag = flag;
        for (int elem : container ) {
            sum += elem;
        }
    }

    public int next() {
       
       int tempElem;
        if (isFinished()) {     
            return -1;
        }
        if (i == container.length) {
            i = 0;
            decrement++;
        }
        while (container[i] <= 0) {
            i++;
            if (i == container.length) {
                i = 0;
                decrement++;
            }
        }
        if (flag == 0) {
            sum--;
            return container[i++]--;
        } else if (flag == 1) {
            tempElem = container[i];
            container[i] /= 2;
            sum = sum - container[i] - tempElem % 2;
            i++;
            return tempElem;
        } else {
            tempElem = container[i];
            container[i] -= decrement;
            System.out.println("decrement = " + decrement + " temp container = " + tempElem + " container = " + container[i]);
            i++;
            return tempElem;
        }

    }

    public boolean isFinished() {
        if (flag == 2) {
            for (int elem : container) {
                if (elem > 0) {
                    return false;
                }
            }
            return true;
        } else {
            return sum == 0;
        }

    }

}
