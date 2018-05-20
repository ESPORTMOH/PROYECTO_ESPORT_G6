package ModelUML;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pcwin
 */
public class GenerarTablaClasificaciones extends JFrame {

    public GenerarTablaClasificaciones() {
    }

    public void crearTabla(ArrayList<Clasificacion> listaEP) {
       
//Array de ‘String’ con los titulos de las columnas 
        String[] columnNames = {"EQUIPOS", "PUNTOS"};

//Creacion de la tabla 
        //final JTable table = new JTable(data, columnNames);
        //table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        for (int i = 0; i < listaEP.size(); i++) {
            String equipo = listaEP.get(i).getEquipo().getNombre();
            Integer puntos = listaEP.get(i).getPuntos();
       
            Object[] data = {equipo, puntos};

            tableModel.addRow(data);
        }

//Creamos un scrollpanel y se lo agregamos a la tabla 
        JScrollPane scrollpane = new JScrollPane(table);

//Agregamos el scrollpanel al contenedor 
        getContentPane().add(scrollpane, BorderLayout.CENTER);

//manejamos la salida 
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                
            }
        });
    }

}
