import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Vista extends JFrame {
    
    private JTextArea editor;
    private JFileChooser chooser;
    
    public Vista () {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initComponents();
        this.setVisible(true);
    }
    
    private void initComponents () {
        editor = new JTextArea();
        JButton botonGuardar = new JButton("Guardar");
        JButton botonAbrir = new JButton("Abrir");
        JPanel panel = new JPanel();
        
        botonAbrir.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                // El codigo del listener va aqui
                chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(null);
                
                if (decision == JFileChooser.APPROVE_OPTION) {
                    String nombreArchivo = 
                      chooser.getSelectedFile().getAbsolutePath();
                    Modelo modelo = new ModeloArchivo();
                    List<String> contenido = 
                      modelo.leer(nombreArchivo);
                    String texto = "";
                    for (String linea: contenido)
                        texto += (linea + "\n");
                    editor.setText(texto);
                }
            }
        });
        
        botonGuardar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chooser = new JFileChooser();
                int decision = chooser.showSaveDialog(null);
                
                if (decision == JFileChooser.APPROVE_OPTION) {
                    String nombreArchivo =
                      chooser.getSelectedFile().getAbsolutePath();
                    List<String> contenido = List.of(editor.getText());
                    
                    Modelo modelo = new ModeloArchivo();
                    modelo.escribir(nombreArchivo, contenido);
                }
            }
        });
        
        panel.add(botonGuardar);
        panel.add(botonAbrir);
        this.add(panel, BorderLayout.SOUTH);
        this.add(editor);
    }
}