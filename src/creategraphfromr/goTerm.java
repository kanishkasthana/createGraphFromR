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
    List <String>geneNames=new <String>ArrayList();
    String goTermName;
        
    public goTerm(String goTermName){
        this.goTermName=goTermName;
        allGoTerms.add(this);
    }
    
    public List<String> getGeneNames(){
        return geneNames;
    }
    
    public static List<goTerm> getGenesAssociatedWithEachGoTerm(List <String> lines){
        List<goTerm> goTerms= new ArrayList<goTerm>();
        
        return goTerms;
    }
}