/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creategraphfromr;

import java.io.*;
import java.util.*;
import java.lang.*;


/**
 *
 * @author kanis_000
 */
public class CreateGraphFromR {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        try{
            System.out.println(System.getProperty("user.dir"));
            File newFile=new File("graph_output.csv");
            FileReader fileReader=new FileReader(newFile);
            BufferedReader reader=new BufferedReader(fileReader);
            String line = null;
            PrintWriter out= new PrintWriter(new FileWriter("gephi_graph.dl"));
            while ((line = reader.readLine()) != null) {
             System.out.println(line);
            }
            out.close();
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
}
