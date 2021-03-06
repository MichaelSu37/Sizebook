package com.example.ysu3_sizebook;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ysu3 on 2/1/17.
 */

/* The code for saveInFile() and loadFromFile() are borrowed from lab
*  TA: ShiDa He
*  2017-02-02
* */

// this class contains methods of loading/saving files
public class FileOperation{
    private BufferedReader in;
    private BufferedWriter out;
    private ArrayList<Record> recordList;

    /**
     * Instantiates a new File operation.
     *
     * @param recordArrayList the record array list
     * @param in              the input buffer reader
     */
    public FileOperation(ArrayList<Record> recordArrayList, BufferedReader in){
        this.in = in;
        recordList = recordArrayList;

    }

    /**
     * Instantiates a new File operation.
     *
     * @param recordArrayList the record array list
     * @param out             the output buffer writer
     */
    public FileOperation(ArrayList<Record> recordArrayList, BufferedWriter out){
        this.out = out;
        recordList = recordArrayList;

    }

    /**
     * Load from file array list.
     *
     * @return the array list
     */
    public ArrayList<Record> loadFromFile() {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Record>>() {
        }.getType();
        recordList = gson.fromJson(in, listType);

        return recordList;
    }


    /**
     * Save in file.
     *
     * @throws IOException the io exception
     */
    public void saveInFile() throws IOException {

        Gson gson = new Gson();
        gson.toJson(recordList, out);
        out.flush();
    }
}
