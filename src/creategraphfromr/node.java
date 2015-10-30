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
    public static List<node> allnodes=new <node>ArrayList();
    String nodeName;
    List <edge>edges=new <edge>ArrayList();
    List <node>parents=new <node>ArrayList();
    List <node>children=new <node>ArrayList();
    
    public node(String value){
        this.nodeName=value;
        allnodes.add(this);
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
    
}
