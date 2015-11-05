/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creategraphfromr;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


/**
 *
 * @author kanis_000
 */
public class CreateGraphFromR {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
            //Reading file created from R Script in repository https://bitbucket.org/kanishkasthana/mouseneuronproject
            //Input mouse single cell neuronal gene expression data comes from: http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSE60361
            List <String>rows=readLinesFromFile("graph_output.csv");
            
            //Creating Edges and Nodes in Gaussian Graph
            List nodesAndEdges=getNodesAndEdges(rows);
        
            node[] nodes=(node[])nodesAndEdges.get(0);
            List <edge> edges=(List<edge>)nodesAndEdges.get(1);
            
            //Reading File of Mapped Go terms generated from http://go.princeton.edu/cgi-bin/GOTermMapper using all genes from expression Data matrix
            List <String>mappedGoTermLines=readLinesFromFile("5246_slimTerms.txt");
            
            List<goTerm> goTerms=getGenesAssociatedWithEachGoTerm(mappedGoTermLines);
            
            //TO Do: change the usage of index numbers to gene Names? Do I really need to do this? No not freaking really don't do this shit.
            //What else? Make a method to filter out the nodes and edges for the specific goTerm that you are intersted in. Also make a GUI for filtering out
            //the goTerms dude. That would be really cool if you can manage to get that shit done dude. Cool man cool. This is freaking awesome and amazing dude.
            //I'm getting an adrenaline rush from my current state of mind dude. It might get derailed in the future as more information becomes available because
            //generally nothing working according to plan my friend. Damn it will be so easy for me to be mentally destabilized if that freaking happens dude. I need to collect 
            //more freaking information about what people are doing and come up with more freaking ideas dude. This I think is really freaking important dude.
            //I am really freaking confident about this, I am running on autonomous mode. Cool man you can do this work more man, socialize more. learn more. Learn as much as possible dude
            //You can do this motherfucker. You can do this shit. Comeon Keep working more and more and keep doing more and more and more.
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
    
    public static List<goTerm> getGenesAssociatedWithEachGoTerm(List <String> lines){
        List<goTerm> goTerms= new ArrayList<goTerm>();
        List<Integer> goTermStartPositions=new ArrayList<Integer>();
        
        //Getting goTerms and the line numbers at which they occur
        for(int i=0;i<lines.size();i++){
            Pattern pattern = Pattern.compile("^TERM\\s");
            Matcher matcher=pattern.matcher(lines.get(i));
            if(matcher.find()){
                String goTermName=lines.get(i).substring(matcher.end());
                goTermStartPositions.add(i);
                goTerm term=new goTerm(goTermName);
                goTerms.add(term);
            }
        }
        
        //Getting Gene Names associated with each goTerm
        int count=0;
        for(int linePosition:goTermStartPositions){
            String annotatedGenes=lines.get(linePosition+4);
            Pattern pattern=Pattern.compile("^ANNOTATED_GENES\\s:\\s");
            Matcher matcher=pattern.matcher(annotatedGenes);
            if(matcher.find()){
                StringTokenizer genes=new StringTokenizer(annotatedGenes.substring(matcher.end()),",");
                while(genes.hasMoreTokens()){
                    String geneName=genes.nextToken().trim();
                    if(!geneName.contains("none"))
                        goTerms.get(count).addGeneName(geneName);
                }
                count++;
            }
        }
        
        if(count!=goTerms.size()){
            System.out.println("ERROR! Annotated Genes list not found for all GoTerms!");
            throw new Error();
        }
        return goTerms;
    }
    


}


