package com.distributedlife.pushflashbang.engine.api;

import com.distributedlife.pushflashbang.engine.catalogue.Catalogue;
import com.distributedlife.pushflashbang.engine.db.TheSchedule;

public class Scheduler<T> {
    private Catalogue<T> catalogue;
    private TheSchedule<T> theSchedule;

    public Scheduler(TheSchedule<T> theSchedule, Catalogue<T> catalogue) {
        this.theSchedule = theSchedule;
        this.catalogue = catalogue;

        if (theSchedule.isEmpty()) {
            addNewReviewToSchedule(catalogue.getFirst());
        }
    }

    public Review<T> getCurrentReview() {
        if (theSchedule.getNext() == null) {
            addNewReviewToSchedule(getNextWordToLearn());
        }

        return theSchedule.getNext();
    }

    private void addNewReviewToSchedule(T nextItemToLearn) {
        if (nextItemToLearn == null) {
            return;
        }

        theSchedule.add(new Review<T>(nextItemToLearn));
    }

    public T getNextWordToLearn() {
        for(T item: catalogue.allTheThings()) {
            if (theSchedule.alreadyIncludes(item)) {
                continue;
            }

            return item;
        }

        return null;
    }
}