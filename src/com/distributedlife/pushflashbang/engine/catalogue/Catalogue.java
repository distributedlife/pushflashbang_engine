package com.distributedlife.pushflashbang.engine.catalogue;

import java.util.List;

public class Catalogue<T> {
    private final List<T> items;

    public Catalogue(List<T> items) {
        this.items = items;
    }

    public T getFirst() {
        return items.get(0);
    }

    public T find(Integer hash) {
        for (T candidate: items) {
            if (candidate.hashCode() == hash) {
                return candidate;
            }
        }

        return null;
    }

    public List<T> allTheThings() {
        return items;
    }
}