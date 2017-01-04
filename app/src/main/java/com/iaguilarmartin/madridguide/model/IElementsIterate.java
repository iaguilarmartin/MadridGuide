package com.iaguilarmartin.madridguide.model;

import java.util.List;

public interface IElementsIterate<T> {
    public long size();
    public T get(long index);
    public List<T> allElements();
}
