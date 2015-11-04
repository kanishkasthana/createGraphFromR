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
        
        
            List <String>rows=readLinesFromFile("graph_output.csv");
            
            //Creating Edges and Nodes in graph
            List nodesAndEdges=getNodesAndEdges(rows);
            
            node[] nodes=(node[])nodesAndEdges.get(0);
            List <edge> edges=(List<edge>)nodesAndEdges.get(1);
            
            List <String>mappedGoTermLines=readLinesFromFile("5246_slimTerms.txt");
            
            printGraphIn_UNICET_DL_Format(nodes,edges,"gephi_graph.dl");
            
    }

    public static List<String> readLinesFromFile(String fileName){
        List <String>rows= new <String>ArrayList();
        try 
        {
            System.out.println(System.getProperty("user.dir"));
            File newFile=new File(fileName);
            FileReader fileReader=new FileReader(newFile);
            BufferedReader reader=new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
             rows.add(line);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        System.out.println("Read Lines successfully from file : "+fileName);
        return rows;
    }
    
    public static void printGraphIn_UNICET_DL_Format(node[] nodes, List <edge> edges,String outputFileName){
        int numberOfPaintedNodes=0;
            for(node n:nodes)
                if(n.isPainted())
                    numberOfPaintedNodes++;
            //Printing out file in UCINET DL format for visualization using Gephi
            
        try{
            PrintWriter out= new PrintWriter(new FileWriter(outputFileName));
            out.println("dl");
            out.println("format = edgelist1");
            out.print("n = ");
            out.println(numberOfPaintedNodes);
            out.println("labels embedded:");
            out.println("data:");
            
            for(edge e:edges){
                out.print(e.getParent().getNodeName()+" "+e.getChild().getNodeName()+" ");
                out.println(e.getWeight());
            }
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static List getNodesAndEdges(List<String> rows){
        
        StringTokenizer genes= new StringTokenizer(rows.get(0),",");
        node[] nodes=new node[genes.countTokens()];
        int count=0;
            
        while(genes.hasMoreTokens()){
            String geneName=genes.nextToken();
            node n=new node(geneName);
            nodes[count++]=n;
        }
            
        List <edge>edges=new <edge>ArrayList();
            
        for(int i=1;i<rows.size();i++){
                
            StringTokenizer values=new StringTokenizer(rows.get(i),",");
            int indexNumber=Integer.parseInt(values.nextToken());
            for(int j=0;j<values.countTokens();j++){
                double value=Double.parseDouble(values.nextToken());
                if(value!=0.0){
                    edge e=new edge(nodes[indexNumber],nodes[j],value);
                    edges.add(e);
                }
            }
        }
        
        List nodesAndEdges=new ArrayList();
        nodesAndEdges.add(nodes);
        nodesAndEdges.add(edges);
      
        return nodesAndEdges;
      
    }


}


