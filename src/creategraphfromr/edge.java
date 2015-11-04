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
public class edge {
    public static List <edge> alledges=new ArrayList<edge>();
    node parent;
    node child;
    double weight;
    
    public edge(node parent,node child, double weight){
        this.parent=parent;
        this.child=child;
        this.weight=weight;
        this.parent.addChild(child);
        this.child.addParent(parent);
        this.parent.addEdge(this);
        this.child.addEdge(this);
        this.alledges.add(this);
        //Painting Nodes to show they have been already used to form an edge
        this.parent.paint();
        this.child.paint();
    }
    
    public node getParent(){
        return parent;
    }
    
    public node getChild(){
        return child;
    }
    
    public double getWeight(){
        return weight;
    }
    
}
