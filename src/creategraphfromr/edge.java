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
    public static List <edge> alledges=new <edge>ArrayList();
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
