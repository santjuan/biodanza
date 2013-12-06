package biodanza.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

import biodanza.modelo.ClaseBiodanza;

public class PanoramicaClaseG extends javax.swing.JDialog
{

    private static final long serialVersionUID = 7704233742789373911L;

    public class TextAreaRenderer extends JTextArea implements TableCellRenderer
    {

        private static final long serialVersionUID = -7717000023102435972L;

        public TextAreaRenderer()
        {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus,
            int row, int column)
        {
            setFont(new Font("Arial", Font.PLAIN, 16));
            setText((String) obj);
            JScrollPane jsp = new JScrollPane(this);
            jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            return jsp;
        }
    }

    /** Creates new form PanoramicaClaseG */
    public PanoramicaClaseG(java.awt.Frame parent, boolean modal, ClaseBiodanza clase)
    {
        super(parent, modal);
        Object[][] cl = new Object[clase.darTamano()][3];
        for(int i = 0; i < clase.darTamano(); i++)
        {
            cl[i][0] = clase.darEjercicio(i).getNombre();
            cl[i][1] = clase.darEjercicio(i).getObjetivo();
            try
            {
                cl[i][2] = clase.darEjercicio(i).getCancion() == null ? "" : clase.darEjercicio(i).getCancion()
                    .getAlbum().padre.nombre
                    + " - "
                    + clase.darEjercicio(i).getCancion().getAlbum().nombre
                    + " - "
                    + clase.darEjercicio(i).getCancion().getNombre();
            }
            catch(Exception e)
            {
                cl[i][2] = "";
            }
        }
        initComponents1(cl);
        jTable1.setRowHeight(200);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        try
        {
            if(JOptionPane.showConfirmDialog(this, "Desea imprimir la clase?", "Imprimir clase",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                jTable1.print(JTable.PrintMode.FIT_WIDTH, null, null, true, null, false);
        }
        catch(Exception e)
        {
            throw(new RuntimeException(e));
        }
    }

    private void initComponents1(Object[][] clase)
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(clase, new String[] { "Ejercicio", "Descripcion",
            "Cancion" })
        {
            /**
			 * 
			 */
            private static final long serialVersionUID = 1290911193965740028L;
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.Object.class };
            boolean[] canEdit = new boolean[] { false, false, false };

            @SuppressWarnings("rawtypes")
            public Class getColumnClass(int columnIndex)
            {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(450);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap()));

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
            { null, null, null } }, new String[] { "Ejercicio", "Descripcion", "Cancion" })
        {
            /**
			 * 
			 */
            private static final long serialVersionUID = 1290911193965740028L;
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.Object.class };
            boolean[] canEdit = new boolean[] { false, false, false };

            @SuppressWarnings("rawtypes")
            public Class getColumnClass(int columnIndex)
            {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(450);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
