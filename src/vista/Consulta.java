/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;


/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    public JLabel lblNombre, lblClasificacion, lblDirector, lblPais,lblAnio,lblProyeccion;
    public JTextField nombre, director, pais, anio;
    public JComboBox clasificacion;
    
    ButtonGroup proyeccion = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    public JButton buscar, eliminar, insertar, actualizar;
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNombre);
        container.add(lblClasificacion);
        container.add(lblDirector);
        container.add(lblPais);
        container.add(lblAnio);
        container.add(lblProyeccion);
        container.add(nombre);
        container.add(director);
        container.add(pais);
        container.add(anio);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(table);
        setSize(1000,1000);
        eventos();
        
    }
    
    public final void agregarLabels(){
        lblNombre =  new JLabel("Nombre");
        lblClasificacion = new JLabel("Clasificacion"); ///MARCA
        lblDirector = new JLabel("Director");
        lblPais = new JLabel("Pais");
        lblAnio = new JLabel("Anio");
        lblProyeccion = new JLabel("En proyeccion");
        lblNombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblClasificacion.setBounds(10, 60, ANCHOC, ALTOC);
        lblDirector.setBounds(10, 100, ANCHOC, ALTOC);
        lblProyeccion.setBounds(10, 140, ANCHOC, ALTOC);
        lblAnio.setBounds(10, 180, ANCHOC, ALTOC);
        lblPais.setBounds(10, 220, ANCHOC, ALTOC);
        
        
        
    }
    
    public final void formulario(){
        nombre= new JTextField();
        clasificacion = new JComboBox();
        director = new JTextField();
        pais= new JTextField();
        anio= new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar=new JButton("Buscar");
        insertar=new JButton("insertar");
        eliminar=new JButton("eliminar");
        actualizar=new JButton("actualizar");
        buscar=new JButton("buscar");
        
        table = new JPanel();
        
        clasificacion.addItem("G");
        clasificacion.addItem("PG");
        clasificacion.addItem("14A");
        clasificacion.addItem("18A");
        clasificacion.addItem("R");
        clasificacion.addItem("A");
        
        proyeccion = new ButtonGroup();
        proyeccion.add(si);
        proyeccion.add(no);
        
        nombre.setBounds(140, 10, ANCHOC, ALTOC);
        clasificacion.setBounds(140, 60, ANCHOC, ALTOC);
        director.setBounds(140, 100, ANCHOC, ALTOC);
        //proyeccion.setBounds(140, 100, ANCHOC, ALTOC);
        anio.setBounds(140, 180, ANCHOC, ALTOC);
        pais.setBounds(140, 220, ANCHOC, ALTOC);
        si.setBounds(140, 140, 50, ALTOC);
        no.setBounds(210, 140, 50, ALTOC);
        
        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 420, ANCHOC, ALTOC);
        actualizar.setBounds(150, 420, ANCHOC, ALTOC);
        eliminar.setBounds(300, 420, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 500, 500, 200);
        table.add(new JScrollPane(resultados));
    }
    
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        tm.addColumn("Nombre");
        tm.addColumn("Director");
        tm.addColumn("Pais");
        tm.addColumn("Clasificacion");
        tm.addColumn("Anio");
        tm.addColumn("En proyeccion");
        
        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();
        
        for(Filtro fi : filtros){
            tm.addRow(new Object[]{fi.getNombre(), fi.getDirector(), fi.getPais(), fi.getClasificacion(), fi.getAnio(),fi.getProyeccion()});
        }
        resultados.setModel(tm);
    }
    
    public void eventos(){
        insertar.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(Integer.parseInt(anio.getText()), nombre.getText(),clasificacion.getSelectedItem().toString(),pais.getText(),director.getText(),true);
                if(no.isSelected()){f.setProyeccion(false);}
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema");
                }
            }
        });
        
        actualizar.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(Integer.parseInt(anio.getText()), nombre.getText(),clasificacion.getSelectedItem().toString(),pais.getText(),director.getText(),true);
                if(no.isSelected()){f.setProyeccion(false);}
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema");
                }
            }
        });
        
        eliminar.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                if(fd.delete(nombre.getText())){
                    JOptionPane.showMessageDialog(null, "eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema");
                }
            }
        });
        
        buscar.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = fd.read(nombre.getText());
                if(f==null){
                    JOptionPane.showMessageDialog(null, "no encontrado");
                    
                }else{
                    nombre.setText(f.getNombre());
                    director.setText(f.getDirector());
                    pais.setText(f.getPais());
                    anio.setText(Integer.toString(f.getAnio()));
                    clasificacion.setSelectedItem(f.getClasificacion());
                }if(f.getProyeccion()){
                    si.setSelected(true);
                }else{
                    no.setSelected(true);
                }
            }
        });
        
        /*limpiar.addActionListener(new ActionListener(){
          

            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });*/
        
    }
    
    public void limpiarCampos(){
        nombre.setText("");
        clasificacion.setSelectedItem("A14");
        anio.setText("");
        director.setText("");
        pais.setText("");
        
    }
}