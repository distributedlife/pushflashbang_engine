package com.distributedlife.pushflashbang.engine.db;

import com.distributedlife.pushflashbang.engine.api.Review;
import org.joda.time.DateTime;

public interface TheSchedule<T> {
    void update(Review<T> review);

    boolean alreadyIncludes(T item);

    void add(Review<T> review);

    Review<T> getNext();

    boolean isEmpty();

    DateTime getTimeOfNextReview();
}
