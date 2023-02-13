package com.epam.rd.autotasks;
import java.util.*;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    public CarouselRun run(){
        
        if (getFlagRun() == 1) {
            return null;
        }
        setFlagRun((byte) 1);
        return new CarouselRun(getContainer(), getI(), 2);
    }
}
