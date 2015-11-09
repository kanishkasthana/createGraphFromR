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
public class goTerm {
    public static List<goTerm> allGoTerms=new ArrayList<goTerm>();
    public static List<String> goTermNames=new ArrayList<String>();
    public static HashMap<String,goTerm> goTermDict=new HashMap<String,goTerm>();
    List <node>nodes=new ArrayList<node>();
    List <String>geneNames=new ArrayList<String>();
    String goTermName;
        
    public goTerm(String goTermName){
        this.goTermName=goTermName;
        allGoTerms.add(this);
        goTermDict.put(goTermName, this);
        goTermNames.add(goTermName);
    }
    
    public List<node> getNodes(){
        return nodes;
    }
    
    public String getName(){
        return goTermName;
    }
    
    public List<String> getGeneNames(){
        return geneNames;
    }
    
    public void addGeneName(String geneName){
        geneNames.add(geneName);
        nodes.add(node.getNode(geneName));
    }
    
    public static goTerm getGoTerm(String goTermName){
        return goTermDict.get(goTermName);
    }
    
}
