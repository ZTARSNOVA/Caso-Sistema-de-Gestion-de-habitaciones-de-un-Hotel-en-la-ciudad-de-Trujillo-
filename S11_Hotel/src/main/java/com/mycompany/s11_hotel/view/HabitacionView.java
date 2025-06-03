package com.mycompany.s11_hotel.view;

import com.mycompany.s11_hotel.controller.HabitacionController;
import com.mycompany.s11_hotel.model.Habitacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class HabitacionView extends JFrame {

    private HabitacionController controller;

    private JTextField txtID, txtNumero, txtTipo, txtPrecio, txtHoras;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnCalcularCosto, btnListar;
    private JTable tablaHabitaciones;
    private DefaultTableModel modeloTabla;
    private JTextArea txtAreaResultado;

    public HabitacionView() {
        controller = new HabitacionController();

        setTitle("Gestion de Habitaciones");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos de Habitacion"));

        panelFormulario.add(new JLabel("ID:"));
        txtID = new JTextField();
        txtID.setEditable(false);
        panelFormulario.add(txtID);

        panelFormulario.add(new JLabel("Numero:"));
        txtNumero = new JTextField();
        panelFormulario.add(txtNumero);

        panelFormulario.add(new JLabel("Tipo (doble, deluxe, suite):"));
        txtTipo = new JTextField();
        panelFormulario.add(txtTipo);

        panelFormulario.add(new JLabel("Precio Base:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Horas Alquiler:"));
        txtHoras = new JTextField();
        panelFormulario.add(txtHoras);

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnCalcularCosto = new JButton("Calcular Costo");
        btnListar = new JButton("Listar Todas");

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCalcularCosto);
        panelBotones.add(btnListar);

        txtAreaResultado = new JTextArea(6, 30);
        txtAreaResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtAreaResultado);

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Numero", "Tipo", "Precio"});
        tablaHabitaciones = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaHabitaciones);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(scrollTabla, BorderLayout.SOUTH);
        panelPrincipal.add(scrollResultado, BorderLayout.EAST);

        add(panelPrincipal);

        // Eventos
        btnAgregar.addActionListener(e -> agregarHabitacion());
        btnActualizar.addActionListener(e -> actualizarHabitacion());
        btnEliminar.addActionListener(e -> eliminarHabitacion());
        btnCalcularCosto.addActionListener(e -> calcularCosto());
        btnListar.addActionListener(e -> listarHabitaciones());

        tablaHabitaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaHabitaciones.getSelectedRow();
                if (fila >= 0) {
                    txtID.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtNumero.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtTipo.setText(modeloTabla.getValueAt(fila, 2).toString());
                    txtPrecio.setText(modeloTabla.getValueAt(fila, 3).toString());
                }
            }
        });
    }

    private void agregarHabitacion() {
        try {
            String numero = txtNumero.getText().trim();
            String tipo = txtTipo.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            if (controller.agregarHabitacion(numero, tipo, precio)) {
                JOptionPane.showMessageDialog(this, "Habitacion agregada con exito");
                limpiarCampos();
                listarHabitaciones();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Precio minimo es 50", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarHabitacion() {
        try {
            int id = Integer.parseInt(txtID.getText().trim());
            String numero = txtNumero.getText().trim();
            String tipo = txtTipo.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            controller.actualizarHabitacion(id, numero, tipo, precio);
            JOptionPane.showMessageDialog(this, "Habitacion actualizada");
            limpiarCampos();
            listarHabitaciones();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Seleccione una habitacion de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarHabitacion() {
        try {
            int id = Integer.parseInt(txtID.getText().trim());
            controller.eliminarHabitacion(id);
            JOptionPane.showMessageDialog(this, "Habitacion eliminada");
            limpiarCampos();
            listarHabitaciones();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Seleccione una habitacion de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularCosto() {
        try {
            String tipo = txtTipo.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int horas = Integer.parseInt(txtHoras.getText().trim());

            double costo = controller.calcularCostoAlquiler(tipo, precio, horas);

            txtAreaResultado.setText("Costo por " + horas + " horas para habitacion tipo " + tipo + " es: S/ " + String.format("%.2f", costo));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores validos para precio y horas", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarHabitaciones() {
        List<Habitacion> lista = controller.listarHabitaciones();
        modeloTabla.setRowCount(0);
        for (Habitacion h : lista) {
            Object[] fila = {h.getHabitacionID(), h.getNumero(), h.getTipo(), h.getPrecio()};
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
        txtID.setText("");
        txtNumero.setText("");
        txtTipo.setText("");
        txtPrecio.setText("");
        txtHoras.setText("");
        txtAreaResultado.setText("");
    }
}
