package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
        newSmartArray = sort();
    }

    private Object[] sort() {
        Object[] tempArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        Arrays.sort(tempArray, comparator);
        return tempArray;
    }

    @Override
    public String operationDescription() {
        return "Sorted by specific comparator " + smartArray.operationDescription();
    }
}
