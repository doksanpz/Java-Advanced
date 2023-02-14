package generics.demoInterface;

import generics.demoInterface.Mathematics;

public class PowerOf implements Mathematics {


    @Override
    public int multiplyBy2(Number number) {
        return number.intValue() * 2;
    }
}

