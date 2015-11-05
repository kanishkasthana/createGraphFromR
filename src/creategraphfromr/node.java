/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creategraphfromr;

import java.io.*;
import java.util.*;

/**
 *
 * @author kanis_000
 */
public class node {
    public static List<node> allnodes=new ArrayList<node>();
    public static HashMap<String,node> nodeDict= new HashMap<String,node>();
    String nodeName;
    List <edge>edges=new <edge>ArrayList();
    List <node>parents=new <node>ArrayList();
    List <node>children=new <node>ArrayList();
    boolean painted=false;
    
    public node(String value){
        this.nodeName=value;
        allnodes.add(this);
        nodeDict.put(value, this);
    }
    
    public void addChild(node child){
        children.add(child);
    }
    
    public void addParent(node parent){
        parents.add(parent);
    }
    
    public List<node> getChildren(){
        return this.children;
    }
    
    public List<node> getParents(){
        return this.parents;
    }
    
    public void addEdge(edge newedge){
        this.edges.add(newedge);
    }
    
    public List<edge> getEdges(){
        return edges;
    }
    
    public String getNodeName(){
        return nodeName;
    }
    
    public boolean isPainted(){
        return painted;
    }
    
    public void paint(){
        this.painted=true;
    }
    
    public static HashMap<String,node> getNodeDict(){
        return nodeDict;
    }
    
    public static node getNode(String geneName){
        return nodeDict.get(geneName);
    }
    
}
