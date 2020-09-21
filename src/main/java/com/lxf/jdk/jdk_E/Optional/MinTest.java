package com.lxf.jdk.jdk_E.Optional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinTest {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(2.33);
        list.add(2.58);
        list.add(2.69);
        list.add(2.33);
        Optional<Double> minOptional = list.stream().min(Comparator.comparingDouble(Double::longValue));
        if (minOptional.isPresent()) {
            Double aDouble = minOptional.get();
        }

    }
}
