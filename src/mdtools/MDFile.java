/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdtools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class MDFile {
    public static void writeToFile(File file, String content) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(file);
        pw.print(content);
        pw.close();
    }
    
    public static void writeToFile(String path, String content) throws FileNotFoundException{
        File f = new File(path);
        writeToFile(f, content);
    }
    
    public static void appendToFile(File file, String content) throws IOException{
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(content);
        bw.close();
        fw.close();
    }
    
    public static void appendToFile(String path, String content) throws IOException{
        File f = new File(path);
        appendToFile(f, content);
    }
    
    public static String[] fileToArray(String path) throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list.toArray(new String[0]);
    }
}
