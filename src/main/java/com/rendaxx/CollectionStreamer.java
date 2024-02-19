package com.rendaxx;

import com.rendaxx.exceptions.NoFileException;

import java.util.Collection;

public interface CollectionStreamer<T extends Collection<?>> {
    void saveToFile(T collection) throws NoFileException;
    T readFromFile() throws NoFileException;
}
