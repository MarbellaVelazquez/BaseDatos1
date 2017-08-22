/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo;

/**
 *
 * @author Alumno
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaBD extends JFrame implements ActionListener{
    
        
    private JTextField nombre, app, apm, escuela;
    private JButton resultado;
    private JLabel titulo, nombreTxt, appTxt, apmTxt, escuelaTxt;
    
    public VentanaBD(){
        configurarVentana();
        iniciarComponentes();
    }
        private void configurarVentana (){
        
        setTitle("Datos Persona");
        setSize(650,510);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color (220, 216, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private void iniciarComponentes(){

        /*
            *Texto mostrado en la pantalla
            */
        
        titulo = new JLabel("Datos Persona: Ingresa todos los datos");
        titulo.setBounds(50,40,500,30);
        titulo.setFont (new Font("Verdana", Font.BOLD,18));
        add(titulo);
        titulo.setVisible(true);
        
        nombreTxt = new JLabel("Nombre:");
        nombreTxt.setBounds(40,120,200,30);
        add(nombreTxt);
        nombreTxt.setVisible(true);

        appTxt = new JLabel("Apellido Paterno: ");
        appTxt.setBounds(40,160,200,30);
        add(appTxt);
        appTxt.setVisible(true);
        
        apmTxt = new JLabel("Apellido Materno: ");
        apmTxt.setBounds(40,200,200,30);
        add(apmTxt);
        apmTxt.setVisible(true);
        
        escuelaTxt = new JLabel("Escuela: ");
        escuelaTxt.setBounds(40,240,200,30);
        add(escuelaTxt);
        escuelaTxt.setVisible(true);
        
        
        /*
        *Cuadros de texto para ingresar la información 
        */
        nombre = new JTextField();
        nombre.setBounds(150, 120, 100, 20);
        add(nombre);
        nombre.setVisible(true);  

        app = new JTextField();
        app.setBounds(150, 160, 100, 20);
        add(app);
        app.setVisible(true); 
        
        apm = new JTextField();
        apm.setBounds(150, 200, 250, 20);
        add(apm);
        apm.setVisible(true); 
        
        escuela = new JTextField();
        escuela.setBounds(150, 240, 250, 20);
        add(escuela);
        escuela.setVisible(true); 
    
        
        
        //buttons              
        
        resultado = new JButton("Guardar");
        resultado.setBounds(350, 340, 100, 50);
        add(resultado);
        resultado.addActionListener(this);
        resultado.setVisible(true);         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==resultado){
                String no=nombre.getText();
                String ap=app.getText();
                String am=apm.getText();
                String esc=escuela.getText();
                ConnectionMySQL obj = new ConnectionMySQL();
                obj.getConexion();
                obj.SubirDatos(no, ap, am, esc);
                JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
            }    
    }  
}
