package Interfaz;

import javax.swing.*;

import Modelo.Algoritmo;
import Modelo.LecturaDatos;
import Modelo.Nodo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class vPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Algoritmo algoritmo;
	private vSolucion solucion;
	
	public vPrincipal(){
	    initGUI();
	}
	
	public void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JButton cargarAtrib = new JButton("Cargar Atributos");
		JButton cargarEjemp = new JButton("Cargar Ejemplos");
		JButton botonCalcular = new JButton("Calcular");
		JLabel solLabel = new JLabel("Solucion: ");
		JTextField solTB = new JTextField();
		algoritmo = new Algoritmo();
		cargarAtrib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(new File("./resources/examples/").getAbsolutePath()));
				
				int op = fc.showOpenDialog(fc);
				if(op == fc.APPROVE_OPTION) {
					try {
						File fichero = fc.getSelectedFile();
						ArrayList<String> atributos = LecturaDatos.readAtributos(fichero);
						//System.out.println(atributos);
						algoritmo.setAtributos(atributos);
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS ATRIBUTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		cargarEjemp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(new File("./resources/examples/").getAbsolutePath()));
				
				int op = fc.showOpenDialog(fc);
				if(op == fc.APPROVE_OPTION) {
					try {
						File fichero = fc.getSelectedFile();
						ArrayList<ArrayList<String>> ejemplos = LecturaDatos.readEjemplos(fichero);
						//System.out.println(ejemplos);
						algoritmo.setEjemplos(ejemplos);
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS EJEMPLOS", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		botonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Nodo nodo = new Nodo();
				Nodo sol;
				algoritmo.setPosiblesValoresClase();
				sol = algoritmo.ID3(algoritmo.getAtributos(), algoritmo.getEjemplos());
				solucion = new vSolucion(sol);
			}
		});
		
		mainPanel.setLayout(new GridLayout(1,2));
		mainPanel.add(cargarAtrib);
		mainPanel.add(cargarEjemp);
		mainPanel.add(botonCalcular);
		//mainPanel.add(solLabel);
		//mainPanel.add(solTB);
		
		this.setTitle("ID3");
		this.setResizable(false);
		this.setMinimumSize(new Dimension(900,300));
		this.setLocationRelativeTo(null);
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPrincipal frame = new vPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
