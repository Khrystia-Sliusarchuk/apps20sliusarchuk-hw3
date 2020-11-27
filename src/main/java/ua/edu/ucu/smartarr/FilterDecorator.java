package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
        newSmartArray = satisfyCond();
    }

    private Object[] satisfyCond() {
        Object[] tempArray =
                Arrays.copyOf(smartArray.toArray(), smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (int i = 0; i < tempArray.length; i++) {
            if (predicate.test(tempArray[i])) {
                res.add(tempArray[i]);
            }
        }
        return res.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filtered by specific conditions "
                + smartArray.operationDescription();
    }
}
