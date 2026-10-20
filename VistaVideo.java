import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaVideo extends JFrame {

    JTextField fieldId, fieldTitulo, fieldDuracion;
    JLabel labelId, labelTitulo, labelDuracion;
    JButton botonGuardar, botonVer;

    public VistaVideo () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new FlowLayout());
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        fieldId = new JTextField(50);
        fieldTitulo = new JTextField(50);
        fieldDuracion = new JTextField(50);

        labelId = new JLabel("ID:");
        labelTitulo = new JLabel("Título:");
        labelDuracion = new JLabel("Duración:");

        botonGuardar = new JButton("Guardar");
        botonVer = new JButton("Ver");

        botonGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                String titulo = fieldTitulo.getText();
                int duracion = Integer.parseInt(fieldDuracion.getText());

                new ModeloBD().insertar(titulo, duracion);

                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        });

        botonVer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int id_video = Integer.parseInt(fieldId.getText());

                new ModeloBD().eliminar(id_video);

                JOptionPane.showMessageDialog(null, "Video eliminado");
            }
        });

        this.add(labelId);
        this.add(fieldId);
        this.add(labelTitulo);
        this.add(fieldTitulo);
        this.add(labelDuracion);
        this.add(fieldDuracion);

        this.add(botonGuardar);
        this.add(botonVer);
    }
}