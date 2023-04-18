package Interfaz;

import javax.swing.*;

import Modelo.Algoritmo;
import Modelo.LecturaDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Algoritmo algoritmo;
	
	public vPrincipal(){
	    initGUI();
	}
	
	public void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JButton cargarAtrib = new JButton("Cargar Atributos");
		JButton cargarEjemp = new JButton("Cargar Ejemplos");
		JButton botonCalcular = new JButton("Calcular");
		JLabel solLabel = new JLabel("Solución: ");
		JTextField solTB = new JTextField();
		
		cargarAtrib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(new File("./resources/examples/").getAbsolutePath()));
				
				int op = fc.showOpenDialog(fc);
				if(op == fc.APPROVE_OPTION) {
					try {
						File fichero = fc.getSelectedFile();
						algoritmo.setAtributos(LecturaDatos.readAtributos(fichero));
						
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
						algoritmo.setEjemplos(LecturaDatos.readEjemplos(fichero));
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS EJEMPLOS", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
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
