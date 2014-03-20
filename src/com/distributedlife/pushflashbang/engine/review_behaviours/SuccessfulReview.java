package com.distributedlife.pushflashbang.engine.review_behaviours;

import com.distributedlife.pushflashbang.engine.api.Review;
import com.distributedlife.pushflashbang.engine.api.Intervals;
import com.distributedlife.pushflashbang.engine.db.TheSchedule;
import org.joda.time.DateTime;

public class SuccessfulReview<T> {
    private static final Integer SECONDS_TO_MILLIS = 1000;

    public SuccessfulReview(Intervals intervals, TheSchedule<T> theSchedule, Review<T> review) {
        Integer nextInterval = intervals.getNext(review.getInterval());

        review.setInterval(nextInterval);
        review.setDue(DateTime.now().plus(review.getInterval() * SECONDS_TO_MILLIS));

        theSchedule.update(review);
    }
}
