package by.home.webproject.dao;

import java.io.FileNotFoundException;

public interface Dao {

    String getData(String URL) throws FileNotFoundException;
}
