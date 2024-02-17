package com.rendaxx;

import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public interface OrganizationServer {
    void addElement() throws IOException, WrongInputException;
    void collectionInfo();
    void collectionShow();
    void updateElement(Long id) throws WrongInputException, IOException;
    void removeElementById(Long id) throws WrongInputException;
    void clearCollection();
    void addIfMin() throws IOException, WrongInputException;
}
