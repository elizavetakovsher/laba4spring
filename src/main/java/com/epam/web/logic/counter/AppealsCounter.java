package com.epam.web.logic.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppealsCounter implements Runnable{

    private int counter;
    private Logger logger = LoggerFactory.getLogger(AppealsCounter.class);

    public AppealsCounter() {
        this.counter = 0;
    }

    public void addAppeals() {
        counter++;
        logger.info("Appeals: " + counter);
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        addAppeals();
    }
}
