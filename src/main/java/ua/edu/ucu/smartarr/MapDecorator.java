package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        newSmartArray = map();
    }

    private Object[] map() {
        Object[] tempArray =
                Arrays.copyOf(smartArray.toArray(), smartArray.size());
        ArrayList<Object> res = new ArrayList<>();
        for (int i = 0; i < tempArray.length; i++) {
            res.add(function.apply(tempArray[i]));
        }
        return res.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applied specific function to "
                + smartArray.operationDescription();
    }
}
