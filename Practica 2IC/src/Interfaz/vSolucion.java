package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;
import org.jgrapht.*;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.view.mxGraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.model.mxICell;

import Modelo.Nodo;


public class vSolucion extends JFrame{
	private static DefaultDirectedGraph<String, DefaultEdge> arbol;
	private Nodo raiz;
	/*
	public void generarArbol(DefaultDirectedGraph<String, DefaultEdge> arbol) {
		JGraphXAdapter<String, DefaultEdge> adapter = new JGraphXAdapter<>(arbol);
		mxGraphComponent graphComponent = new mxGraphComponent(adapter);
		graphComponent.setPageVisible(true);
		graphComponent.setSize(500, 500);
		
		mxCellRenderer.setDefaultVertexSize(50);
		
		this.getContentPane().add(graphComponent);
		this.setMinimumSize(new Dimension(500,500));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}
	
	public static void agregarNodosAlArbol(Nodo raiz) {

		if(raiz.getHijos() != null) {
			 for (Nodo hijo : raiz.getHijos()) {
			        // Agregar el nodo hijo al árbol
			        if(hijo.isEsAtrib()) {
			        	arbol.addVertex(hijo.getAtributo());
			        	arbol.addEdge(raiz.getAtributo(), hijo.getAtributo());
			        }
			        else if(hijo.isEsHoja()) {
			        	arbol.addVertex(hijo.getClase());
			        	arbol.addEdge(raiz.getAtributo(), hijo.getClase());
			        }	
			        else {
			        	arbol.addVertex(hijo.getValor());
			        	arbol.addEdge(raiz.getAtributo(), hijo.getValor());
			        }
			        // Recursivamente agregar los hijos del nodo hijo
			        agregarNodosAlArbol(hijo);
			    }
		}
	}
	
	

	public vSolucion(Nodo raiz) {
        this.raiz = raiz;
        setLayout(new BorderLayout());
        this.add(buildTreePanel(), BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
    }
	
	*/
	/*
	public vSolucion(Nodo raiz) {
        this.raiz = raiz;
        setLayout(new BorderLayout());
        add(buildTreePanel(), BorderLayout.CENTER);
        this.add(buildTreePanel(), BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
    }
	
	 private JPanel buildTreePanel() {
        JPanel panel = new JPanel();
		mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        addNode(graph, parent, raiz);
        graph.getModel().endUpdate();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        mxOrganicLayout layout = new mxOrganicLayout(graph);
        layout.execute(graph.getDefaultParent());
        panel.add(graphComponent);
        return panel;
	   }
	 
	 private void addNode(mxGraph graph, Object parent, Nodo node) {
		 Object vertex;
		 
		 if(node.isEsAtrib()) {
			 vertex = graph.insertVertex(parent, node.getAtributo(), node.getAtributo(), 0, 0, 80, 30);
		 }
	     else if(node.isEsHoja()) {
	    	vertex = graph.insertVertex(parent, node.getClase(), node.getClase(), 0, 0, 80, 30);
	     }	
		 else {
			 vertex = graph.insertVertex(parent, node.getValor(), node.getValor(), 0, 0, 80, 30);
		 }
	 
        if (!node.isEsHoja()) {
            Object[] childVertices = new Object[node.getHijos().size()];
            for (int i = 0; i < node.getHijos().size(); i++) {
                Nodo child = node.getHijos().get(i);
                Object childVertex;
                if(node.isEsAtrib()) {
                	childVertex = graph.insertVertex(parent, node.getAtributo(), node.getAtributo(), 0, 0, 80, 30);
		   		 }
		   	     else if(node.isEsHoja()) {
		   	    	childVertex = graph.insertVertex(parent, node.getClase(), node.getClase(), 0, 0, 80, 30);
		   	     }	
		   		 else {
		   			childVertex = graph.insertVertex(parent, node.getValor(), node.getValor(), 0, 0, 80, 30);
		   		 }
                
                childVertices[i] = childVertex;
                graph.insertEdge(parent, null, "", vertex, childVertex);
                addNode(graph, parent, child);
            }
            graph.createHierarchy(parent, vertex, childVertices);
        }
	 }
	 */
	/*
    private JPanel buildTreePanel() {
        JPanel treePanel = new JPanel();
        treePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        addNode(treePanel, raiz);
        return treePanel;
    }
    
	private void addNode(JPanel panel, Nodo node) {
		JLabel label;
		
		if(node.isEsAtrib()) {
			 label = new JLabel(node.getAtributo());
        	
        }
        else if(node.isEsHoja()) {
        	label = new JLabel(node.getClase());
        }	
        else {
        	label = new JLabel(node.getValor());
        }
		
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setPreferredSize(new Dimension(80, 30));
        panel.add(label);
       
        if (!node.isEsHoja()) {
            JPanel childPanel = new JPanel();
            childPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
            
            for (Nodo child : node.getHijos()) {
                addNode(childPanel, child);
            }
            
            panel.add(childPanel);
            
        } else {
            label.setOpaque(true);
            label.setBackground(Color.GREEN);
            label.setForeground(Color.WHITE);
        }
    }
    */
	

    public vSolucion(Nodo raiz) {
        this.raiz = raiz;
        setLayout(new BorderLayout());
        add(buildTreePanel(), BorderLayout.CENTER);
    }

    private JPanel buildTreePanel() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        mxICell rootCell = addNode(graph, parent, raiz);
        graph.getModel().endUpdate();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        mxOrganicLayout layout = new mxOrganicLayout(graph);
        layout.setInterRankCellSpacing(100);
        layout.execute(parent);
        return graphComponent;
    }
    
	private mxICell addNode(mxGraph graph, Object parent, DecisionTreeNode node) {
	        mxICell vertex = (mxICell) graph.insertVertex(parent, null, node.getValue(), 0, 0, 80, 30);
	        if (!node.isLeaf()) {
	            mxICell[] childVertices = new mxICell[node.getChildren().size()];
	            for (int i = 0; i < node.getChildren().size(); i++) {
	                DecisionTreeNode child = node.getChildren().get(i);
	                mxICell childVertex = addNode(graph, parent, child);
	                childVertices[i] = childVertex;
	                graph.insertEdge(parent, null, "", vertex, childVertex);
	            }
	            graph.addCells(childVertices);
	            graph.updateCellSize(vertex);
	        }
	        return vertex;
	    }

	    public static void main(String[] args) {
	        DecisionTreeNode rootNode = // obtener la raíz del árbol de alguna manera
	        DecisionTreePanel treePanel = new DecisionTreePanel(rootNode);
	        JFrame frame = new JFrame("Árbol de decisión");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(treePanel);
	        frame.pack();
	        frame.setVisible(true);
	    }
	}
	
}
