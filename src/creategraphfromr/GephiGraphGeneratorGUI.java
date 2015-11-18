/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creategraphfromr;

/**
 *
 * @author kanis_000
 */
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;
import javax.swing.*;


public class GephiGraphGeneratorGUI extends javax.swing.JFrame {
    
     node[] nodes;
     List <String> rows;
    
    /**
     * Creates new form gephiGraphGeneratorWindow
     */
    public GephiGraphGeneratorGUI() {
            
            initComponents();
            
            //Reading file created from R Script in repository https://bitbucket.org/kanishkasthana/mouseneuronproject
            //Input mouse single cell neuronal gene expression data comes from: http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSE60361
            rows=readLinesFromFile("filtered_graph_output.csv");
            //Creating Nodes in Gaussian Graph
            nodes=getNodes(rows);
            this.setTitle("Gephi Graph Generator (G3): Version 0.2(Alpha) by Kanishk Asthana");
            this.setVisible(true);
            ontology.add(this.jRadioButton1);
            ontology.add(this.jRadioButton2);
            ontology.add(this.jRadioButton3);
            jLabel4.setVisible(true);
    }
    
    public void initializeGraphGeneration(int selection){
        String goTermFileName;
        switch(selection){
            case 1: goTermFileName="5246_slimTerms.txt";
                    break;
            case 2: goTermFileName="31851_slimTerms.txt";
                    break;
            case 3: goTermFileName="31885_slimTerms.txt";
                    break;
            default: goTermFileName="5246_slimTerms.txt";
                
        }
        
            //Reading File of Mapped Go terms generated from http://go.princeton.edu/cgi-bin/GOTermMapper using all genes from expression Data matrix
            List <String>mappedGoTermLines=readLinesFromFile(goTermFileName);
            List<goTerm> goTerms=getGenesAssociatedWithEachGoTerm(mappedGoTermLines);
            DefaultListModel listModel=new DefaultListModel();
            for(String term: goTerm.goTermNames)
                listModel.addElement(term);
            GoTermSelectionList.setModel(listModel);
            generateGraphButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ontology = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        GoTermSelectionList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        generateGraphButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GoTermSelectionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                GoTermSelectionListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(GoTermSelectionList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select Go Terms from List. Press Ctrl to Select Multiple Terms:");

        generateGraphButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        generateGraphButton.setText("Generate Graph File");
        generateGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateGraphButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Select Ontology:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Please wait for a minute when you press the Generate Graph Button. This window will close automatically once the graph is generated.");

        jRadioButton1.setText("Molecular Function");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Biological Process");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Cellular Component");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(590, 590, 590))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(generateGraphButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(163, 163, 163))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateGraphButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateGraphButtonActionPerformed
        List<String> filterByGoTerms=new ArrayList<String>();
        int[] selectedIndexes=GoTermSelectionList.getSelectedIndices();
        for(int index:selectedIndexes)
            filterByGoTerms.add(goTerm.goTermNames.get(index));
        List<node> filteredNodes=getNodesFilteredByGoTerms(filterByGoTerms); 
        List <edge> edges=getFilteredEdges(rows,nodes,filteredNodes);
        printGraphIn_UNICET_DL_Format(nodes,edges,"gephi_graph.dl"); 
        this.dispose();
    }//GEN-LAST:event_generateGraphButtonActionPerformed

    private void GoTermSelectionListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_GoTermSelectionListValueChanged
        generateGraphButton.setEnabled(true);
    }//GEN-LAST:event_GoTermSelectionListValueChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        initializeGraphGeneration(1);
        this.jRadioButton1.setEnabled(false);
        this.jRadioButton2.setEnabled(false);
        this.jRadioButton3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        initializeGraphGeneration(2);
        this.jRadioButton1.setEnabled(false);
        this.jRadioButton2.setEnabled(false);
        this.jRadioButton3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        initializeGraphGeneration(3);
        this.jRadioButton1.setEnabled(false);
        this.jRadioButton2.setEnabled(false);
        this.jRadioButton3.setEnabled(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GephiGraphGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GephiGraphGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GephiGraphGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GephiGraphGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GephiGraphGeneratorGUI().setVisible(true);
            }
        });
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
    
    public static node[] getNodes(List<String> rows){
        StringTokenizer genes= new StringTokenizer(rows.get(0),",");
        node[] nodes=new node[genes.countTokens()];
        int count=0;
            
        while(genes.hasMoreTokens()){
            String geneName=genes.nextToken();
            node n=new node(geneName);
            nodes[count++]=n;
        }
        
        return nodes;
    }
    
    public static List<node> getNodesFilteredByGoTerms(List<String> goTermNames){
        List<node> filteredNodes=new ArrayList<node>();
        List<goTerm> goTerms=new ArrayList<goTerm>();
        
        //Getting GoTerms from GoTermNames
        for(String termName:goTermNames)
            goTerms.add(goTerm.getGoTerm(termName));
        //Populating filteredNodes with a list of all nodes
        filteredNodes.addAll(node.allnodes);
        
        //Taking intersection of nodes represented by all specified goTerm categories in goTermNames
        for(goTerm term:goTerms)
            filteredNodes.retainAll(term.getNodes());
        
        return filteredNodes;
    }
    
    //WARNING: Don't call this method if you are also calling getFilteredEdges because the nodes are painted depending on whether an edge is created or not
    //If you call this method a larger set of nodes is painted. This will create problems when the UNICET DL graph file is generated.
    public static List<edge> getEdges(List<String> rows, node[] nodes){
        List <edge>edges=new ArrayList<edge>();
 
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
        return edges;
    
    }
    
    public static List<edge> getFilteredEdges(List<String> rows, node[] allNodes, List<node> filteredNodes){
        List <edge>edges=new ArrayList<edge>();
        
        for(int i=1;i<rows.size();i++){
            
            StringTokenizer values=new StringTokenizer(rows.get(i),",");
            int indexNumber=Integer.parseInt(values.nextToken());
            for(int j=0;j<values.countTokens();j++){
                double value=Double.parseDouble(values.nextToken());
                node parent=allNodes[indexNumber];
                node child=allNodes[j];
                
                if(value!=0.0 && filteredNodes.contains(child)){
                    edge e=new edge(parent,child,value);
                    edges.add(e);
                }
            }
        }
        return edges;
    }
    
    
    public static List<goTerm> getGenesAssociatedWithEachGoTerm(List <String> lines){
        List<goTerm> goTerms= new ArrayList<goTerm>();
        List<Integer> goTermStartPositions=new ArrayList<Integer>();
        
        //Getting goTerms and the line numbers at which they occur
        for(int i=0;i<lines.size();i++){
            Pattern pattern = Pattern.compile("^1?TERM\\s");
            Matcher matcher=pattern.matcher(lines.get(i));
            if(matcher.find()){
                String goTermName=lines.get(i).substring(matcher.end());
                goTermStartPositions.add(i);
                goTerm term=new goTerm(goTermName.trim());
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
            throw new Error("ERROR! Annotated Genes list not found for all GoTerms!");
        }
        return goTerms;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JList GoTermSelectionList;
    private javax.swing.JButton generateGraphButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup ontology;
    // End of variables declaration//GEN-END:variables
}
