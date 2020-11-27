package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        newSmartArray = removeDuplicates();
    }

    private Object[] removeDuplicates() {
        Object[] tempArray =
                Arrays.copyOf(smartArray.toArray(), smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (int i = 0; i < tempArray.length; i++) {
            for (int k = i + 1; k < tempArray.length; k++) {
                if (!res.contains(tempArray[i])
                        && !tempArray[i].equals(tempArray[k])) {
                    res.add(tempArray[i]);
                }
            }
        }
        return res.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removed repetitions from " + smartArray.operationDescription();
    }
}
