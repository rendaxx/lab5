package com.rendaxx;

import com.rendaxx.exceptions.NoFileException;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.IO.interrogators.Interrogator;

import java.io.IOException;
/**
 * Interface for server.
 */
public interface CollectionServer {
    void addElement() throws IOException, WrongInputException;
    void collectionInfo();
    void collectionShow();
    void updateElement(Long id) throws WrongInputException, IOException;
    void removeElementById(Long id) throws WrongInputException;
    void clearCollection();
    void addIfMin() throws IOException, WrongInputException;
    void removeGreater() throws IOException, WrongInputException;
    void removeLower() throws IOException, WrongInputException;
    void sumOfAnnual();
    void filterStartsWithName(String name);
    void printsAscending();
    void save() throws NoFileException;
    void load() throws NoFileException;
    void setInterrogator(Interrogator i);
    void deleteInvalidElements();
}
