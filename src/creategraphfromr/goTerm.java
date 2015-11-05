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
    List <node>nodes=new ArrayList<node>();
    String goTermName;
        
    public goTerm(String goTermName){
        this.goTermName=goTermName;
        allGoTerms.add(this);
    }
    
    public List<node> getNodes(){
        return nodes;
    }
    
}
