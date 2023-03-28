package paquete;

import java.awt.EventQueue;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;

public class Principal {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(23, 265, 362, -226);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Pokedex");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 25, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBounds(10, 50, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(195, 25, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_1.setBounds(179, 50, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(20, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Altura");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(195, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_2.setBounds(10, 106, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_3.setBounds(179, 106, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo 1");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(350, 25, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tipo 2");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(450, 25, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Acero", "Agua", "Bicho", "Dragon", "Electrico", "Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca", "Siniestro", "Tierra", "Veneno", "Volador"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setBounds(334, 50, 62, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "No tiene", "Acero", "Agua", "Bicho", "Dragon", "Electrico", "Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca", "Siniestro", "Tierra", "Veneno", "Volador"}));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_1.setBounds(430, 49, 82, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Lugar");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(450, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setBounds(430, 107, 89, 45);
		frame.getContentPane().add(textArea);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Equipo");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(310, 105, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
					String ruta = "C:\\Users\\amedina\\Desktop\\hola.txt";
	        		File archivo = new File(ruta);
	        		BufferedWriter bw;

			        if(archivo.exists()) {
			            System.out.print("El archivo de texto ya estaba creado.");
			            bw = new BufferedWriter(new FileWriter(archivo));
			            bw.write("El archivo de texto ya estaba creado.");
			        }
			        else {
			            System.out.print("Acabo de crear el archivo de texto.");
			            bw = new BufferedWriter(new FileWriter(archivo));
			            bw.write("Voy a escribir todo otra vez");
			        }
			        
			        bw.close();
				*/
				
        		//String ruta = new File("").getAbsolutePath();
        		String ruta_dinamica = System.getProperty("user.dir") + "\\Informacion";
        		
        		
				//JOptionPane.showMessageDialog(null, "Ruta: " + ruta + "\\Informacion");
				//JOptionPane.showMessageDialog(null, "Ruta: " + ruta_dinamica);
				System.out.println("Ruta: " + ruta_dinamica);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(310, 196, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				String Pokedex = textField.getText();
				String Nombre = textField_1.getText();
				String Peso = textField_2.getText();
				String Altura = textField_3.getText();
				String Tipo_1 = comboBox.getSelectedItem().toString();
				String Tipo_2 = comboBox_1.getSelectedItem().toString();
				
				
				if(Pokedex.equals("")) {
					JOptionPane.showMessageDialog(null, "El Campo de pokedex esta vacio");
				}
				else if (Nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo de nombre esta vacio");
				}
				else if (Peso.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo de peso esta vacio");
				}
				else if (Altura.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo de altura esta vacio");
				}
				else if(isNumeric(Pokedex) == false) {
					JOptionPane.showMessageDialog(null, "El valor de pokedex no es un numero");
				}
				else if(isNumeric(Peso) == false) {
					JOptionPane.showMessageDialog(null, "El valor de peso no es un numero");
				}
				else if(isNumeric(Altura) == false) {
					JOptionPane.showMessageDialog(null, "El valor de Altura no es un numero");
				}
				else {
					Integer numero = Integer.parseInt(Pokedex);
					Double weight = Double.parseDouble(Peso);
					Double height = Double.parseDouble(Altura);
					//Nombre, Tipo_1, Tipo_2, numero, weight, height
					
					
						
					try {
						writeToFile(numero, weight, height, Nombre, Tipo_1, Tipo_2);
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
					
        		
        	
        		
        		
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(430, 196, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(32, 228, 117, 26);
		frame.getContentPane().add(mnNewMenu);
	}
	
	public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
	
	
	public void writeToFile(int numero, double weight, double height, String Nombre, String Tipo_1, String Tipo_2) throws IOException {
    	
		//Guardar datos en archivo de texto
		//String ruta = new File("").getAbsolutePath();
		//JOptionPane.showMessageDialog(null, "Ruta: " + ruta + "\\Informacion");
		//JOptionPane.showMessageDialog(null, "Ruta: " + ruta_dinamica);
		
		String ruta_dinamica = System.getProperty("user.dir") + "\\Informacion";
		System.out.println("Ruta: " + ruta_dinamica);
		File archivo = new File(ruta_dinamica);
		BufferedWriter bw;

        if(archivo.exists()) {
            System.out.println("El archivo de texto ya estaba creado.");
            bw = new BufferedWriter(new FileWriter(archivo));
           
            bw.write(numero + "," + weight + "," + height + "," + Nombre + "," + Tipo_1 + "," + Tipo_2);
        }
        else {
            System.out.print("Acabo de crear el archivo de texto.");
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(numero + "," + weight + "," + height + "," + Nombre + "," + Tipo_1 + "," + Tipo_2);
        }
        
        bw.close();
        JOptionPane.showMessageDialog(null, "Pokémon registrado!");
    }
	
	
}
