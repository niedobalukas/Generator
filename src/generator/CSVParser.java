/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Michal
 */
public class CSVParser{
    private String[] columnNames;
    private File file;
    private FileReader in;
    private FileWriter out;
    
    public CSVParser(String[] columnNames, String filename) throws IOException{
        if (columnNames.length==0) throw new IOException("Zadne atributy.");
        this.file=new File(filename+".csv");
        this.file.createNewFile();
        this.out=new FileWriter(this.file);
        this.in=new FileReader(this.file);
        this.columnNames=columnNames;
        String header="";
        for(String name : columnNames)header+=name+",";
        header=header.substring(0, header.length()-1)+"?"+System.lineSeparator();
        this.out.write(header);
        this.out.flush();
    }
    
    public CSVParser(String filename) throws IOException{
        this.file=new File(filename+".csv");
        this.out=new FileWriter(this.file, true);
        this.in=new FileReader(this.file);
        String header=(new BufferedReader(in)).readLine();
        this.columnNames=header.substring(0, header.length()-1).split(",");
    }
    
    public void append(Object[] row) throws IOException{
        if(row.length!=columnNames.length) throw new IOException("Chybny pocet sloupcu.");
        String stringRow="";
        for(Object attr : row)stringRow+=attr.toString()+",";
        stringRow=stringRow.substring(0, stringRow.length()-1)+System.lineSeparator();
        out.write(stringRow);
        this.out.flush();
    }
    
    public void close() throws IOException{
        this.in.close();
        this.out.close();
    }
}
