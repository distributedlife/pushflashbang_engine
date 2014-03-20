package com.distributedlife.pushflashbang.engine.api;

import org.joda.time.DateTime;

public class Review<T> {
    private T item;
    private DateTime due;
    private Integer interval;
    private Integer id;
    private Integer first;

    public Review(Integer id, T item, DateTime due, Integer interval, Integer first) {
        this.id = id;
        this.item = item;
        this.due = due;
        this.interval = interval;
        this.first = first;
    }

    public Review(T item) {
        this.item = item;
        this.due = DateTime.now();
        this.interval = 0;
        this.first = 1;
    }

    public T getItem() {
        return item;
    }

    public DateTime getDue() {
        return due;
    }

    public Integer getInterval() {
        return interval;
    }

    public Integer getId() {
        return id;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void setDue(DateTime due) {
        this.due = due;
    }

    public boolean isFirst() { return first == 1; }
}