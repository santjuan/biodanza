package biodanza.vista;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import biodanza.modelo.Biodanza;
import biodanza.modelo.ClaseBiodanza;
import biodanza.modelo.Main;
import biodanza.modelo.Paquete;
import biodanza.modelo.Persistencia;

public class BiodanzaG extends javax.swing.JDialog
{

    private static final long serialVersionUID = 8520763637501416130L;

    /** Creates new form BiodanzaG */
    public BiodanzaG(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        jTree1.setModel(new TreeModel()
        {

            public Object getRoot()
            {
                return "Biodanza";
            }

            public Object getChild(Object parent, int index)
            {
                if(parent instanceof String)
                    return biodanza.modelo.Biodanza.darPaquete(index);
                else if(parent instanceof Paquete)
                    return ((Paquete) parent).darClase(index);
                else
                    return null;
            }

            public int getChildCount(Object parent)
            {
                if(parent instanceof String)
                    return biodanza.modelo.Biodanza.darTamano();
                else if(parent instanceof Paquete)
                    return ((Paquete) parent).darTamano();
                else
                    return 0;
            }

            public boolean isLeaf(Object node)
            {
                return getChildCount(node) == 0;
            }

            public void valueForPathChanged(TreePath path, Object newValue)
            {
            }

            public int getIndexOfChild(Object parent, Object child)
            {
                if(parent instanceof String)
                    return biodanza.modelo.Biodanza.darIndex(child);
                else if(parent instanceof Paquete)
                    return ((Paquete) parent).darIndex(child);
                else
                    return 0;
            }

            public void addTreeModelListener(TreeModelListener l)
            {
            }

            public void removeTreeModelListener(TreeModelListener l)
            {
            }
        });
        MouseListener ml = new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                int selRow = jTree1.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = jTree1.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1)
                {
                    if(e.getClickCount() == 2)
                    {
                        final Object o = selPath.getLastPathComponent();
                        if(o instanceof ClaseBiodanza)
                        {
                            java.awt.EventQueue.invokeLater(new Runnable()
                            {
                                public void run()
                                {
                                    final ClaseBiodanzaG dialog = new ClaseBiodanzaG(new javax.swing.JFrame(), true,
                                        ((ClaseBiodanza) o));
                                    dialog.addWindowListener(new java.awt.event.WindowAdapter()
                                    {
                                        @Override
                                        public void windowClosing(java.awt.event.WindowEvent e)
                                        {
                                            ((ClaseBiodanza) o).cambiarDescripcion(dialog.jTextArea2.getText());
                                        }
                                    });
                                    dialog.setVisible(true);
                                }
                            });
                        }
                    }
                }
            }
        };
        jTree1.addMouseListener(ml);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTree1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(jTree1);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Agregar paquete");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setText("Agregar clase");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setText("Copiar");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biodanza/imagenes/logotipo_biodanza.gif"))); // NOI18N

        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setText("Escuchar canciones");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap())
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout
                .createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton4)
                        .addComponent(jButton3).addComponent(jButton2).addComponent(jButton1))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton1ActionPerformed
        String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nombre del paquete", "Agregar paquete",
            JOptionPane.QUESTION_MESSAGE);
        if(nuevo == null || nuevo.length() == 0)
            return;
        biodanza.modelo.Biodanza.agregarPaquete(new Paquete(nuevo));
        jTree1.updateUI();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton2ActionPerformed
        Object[] paquetes = biodanza.modelo.Biodanza.darPaquetes();
        Paquete paquete = (Paquete) JOptionPane.showInputDialog(this, "Seleccione el paquete", "Seleccionar paquete",
            JOptionPane.PLAIN_MESSAGE, null, paquetes, paquetes[0]);
        String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nombre de la clase", "Agregar clase",
            JOptionPane.QUESTION_MESSAGE);
        paquete.agregarClase(new ClaseBiodanza(nuevo, paquete));
        jTree1.updateUI();
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton3ActionPerformed
        Object o = jTree1.getSelectionPath() == null ? null : jTree1.getSelectionPath().getLastPathComponent();
        if(o == null)
            return;
        if(o instanceof Paquete)
        {
            int res = JOptionPane.showConfirmDialog(this, "Seguro desea borrar el paquete " + o + "?", "Borrar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(res == JOptionPane.YES_OPTION)
            {
                biodanza.modelo.Biodanza.eliminarPaquete((Paquete) o);
                jTree1.updateUI();
            }
        }
        if(o instanceof ClaseBiodanza)
        {
            int res = JOptionPane.showConfirmDialog(this, "Seguro desea borrar la clase " + o + "?", "Borrar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(res == JOptionPane.YES_OPTION)
            {
                biodanza.modelo.Biodanza.eliminarClase(o);
                jTree1.updateUI();
            }
        }
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton4ActionPerformed
        Object[] paquetes = biodanza.modelo.Biodanza.darPaquetes();
        Paquete paquete = (Paquete) JOptionPane.showInputDialog(this, "Seleccione el paquete de origen",
            "Seleccionar paquete", JOptionPane.PLAIN_MESSAGE, null, paquetes, paquetes[0]);
        if(paquete == null)
        {
            class Entry implements Comparable<Entry>
            {
                long time;
                String stringTime;

                Entry(long t)
                {
                    DateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm");
                    time = t;
                    stringTime = format.format(new Date(t));
                }

                @Override
                public int compareTo(Entry o)
                {
                    return Long.valueOf(o.time).compareTo(time);
                }

                @Override
                public String toString()
                {
                    return stringTime;
                }
            }
            ArrayList<Entry> allEntries = new ArrayList<Entry>();
            for(File f : new File(Persistencia.ruta).listFiles())
                allEntries.add(new Entry(Long.parseLong(f.getName().replace(".zip", ""))));
            Collections.sort(allEntries);
            if(!allEntries.isEmpty() && !Main.cargandoAntiguo.get())
            {
                Entry escogida = (Entry) JOptionPane.showInputDialog(null, "Seleccione la fecha", "Cargar de memoria",
                    JOptionPane.PLAIN_MESSAGE, null, allEntries.toArray(), allEntries.toArray()[0]);
                if(escogida != null)
                {
                    long time = escogida.time;
                    setVisible(false);
                    dispose();
                    Main.firstLoad(time);

                }
            }
        }
        else
        {
            Object[] clases = new Object[paquete.darTamano()];
            for(int i = 0; i < paquete.darTamano(); i++)
                clases[i] = paquete.darClase(i);
            ClaseBiodanza clase = (ClaseBiodanza) JOptionPane.showInputDialog(this, "Seleccione la clase de origen",
                "Seleccionar clase", JOptionPane.PLAIN_MESSAGE, null, clases, clases[0]);
            Paquete paqueteD = (Paquete) JOptionPane.showInputDialog(this, "Seleccione el paquete de destino",
                "Seleccionar paquete", JOptionPane.PLAIN_MESSAGE, null, paquetes, paquetes[0]);
            String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva clase", "Agregar clase",
                JOptionPane.QUESTION_MESSAGE);
            ClaseBiodanza copia = (ClaseBiodanza) clase.clone(nuevo);
            paqueteD.agregarClase(copia);
            jTree1.updateUI();
        }
    }// GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton5ActionPerformed
        new AgregarCancionG(null, true, new DialogCaller()
        {
            public void setAnswer(int button, Object answer)
            {
            }
        }, null, "").setVisible(true);
    }// GEN-LAST:event_jButton5ActionPerformed

    static String escogerEtiqueta(Component p)
    {
        String[] etiquetas = Biodanza.darEtiquetas();
        Vector<String> categorias = new Vector<String>();
        categorias.add("todas");
        for(String et : etiquetas)
        {
            if(et.trim().startsWith("IBFT"))
                categorias.add(et);
        }
        Collections.sort(categorias, new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                if(o1.equals("todas"))
                    return -1;
                if(o2.equals("todas"))
                    return 1;
                o1 = o1.trim();
                o2 = o2.trim();
                o1 = o1.replace("IBFT", "");
                o2 = o2.replace("IBFT", "");
                int uno = new Scanner(o1).nextInt();
                int dos = new Scanner(o2).nextInt();
                return uno - dos;
            }
        });
        Object cat = JOptionPane.showInputDialog(p, "Seleccione la categoria", "Seleccionar categoria",
            JOptionPane.PLAIN_MESSAGE, null, categorias.toArray(), categorias.toArray()[0]);
        if(cat == null)
            return escogerEtiquetaNueva(p, null);
        String catS = (String) cat;
        if(catS.equals("todas"))
        {
            Object aUsarO = JOptionPane.showInputDialog(p, "Seleccione la etiqueta", "Seleccionar etiqueta",
                JOptionPane.PLAIN_MESSAGE, null, etiquetas, etiquetas[0]);
            if(aUsarO == null)
                return escogerEtiquetaNueva(p, null);
            return (String) aUsarO;
        }
        else
        {
            Vector<String> escogidas = new Vector<String>();
            for(String et : etiquetas)
            {
                if(et.trim().startsWith(catS.substring(0, 7).replace("IBFT", "IBF")))
                    escogidas.add(et);
            }
            Object aUsarO = JOptionPane.showInputDialog(p, "Seleccione la etiqueta", "Seleccionar etiqueta",
                JOptionPane.PLAIN_MESSAGE, null, escogidas.toArray(), escogidas.toArray()[0]);
            if(aUsarO == null)
                return escogerEtiquetaNueva(p, null);
            return (String) aUsarO;
        }
    }

    static String escogerEtiquetaNueva(Component p, String porDefecto)
    {
        if(JOptionPane.showConfirmDialog(p, "Desea agregar una etiqueta nueva?", "Nueva etiqueta",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return null;
        String[] etiquetas = Biodanza.darEtiquetas();
        Vector<String> categorias = new Vector<String>();
        categorias.add("todas");
        for(String et : etiquetas)
        {
            if(et.trim().startsWith("IBFT"))
                categorias.add(et);
        }
        Collections.sort(categorias, new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                if(o1.equals("todas"))
                    return -1;
                if(o2.equals("todas"))
                    return 1;
                o1 = o1.trim();
                o2 = o2.trim();
                o1 = o1.replace("IBFT", "");
                o2 = o2.replace("IBFT", "");
                int uno = new Scanner(o1).nextInt();
                int dos = new Scanner(o2).nextInt();
                return uno - dos;
            }
        });
        Object cat = JOptionPane.showInputDialog(p, "Seleccione la categoria", "Seleccionar categoria",
            JOptionPane.PLAIN_MESSAGE, null, categorias.toArray(), categorias.toArray()[0]);
        if(cat == null)
            return null;
        String catS = (String) cat;
        String nuevaEtiqueta = (String) (porDefecto == null ? JOptionPane.showInputDialog(p,
            "Ingrese la nueva etiqueta", "Nueva etiqueta", JOptionPane.OK_CANCEL_OPTION) : JOptionPane.showInputDialog(
            p, "Ingrese la nueva etiqueta", "Nueva etiqueta", JOptionPane.OK_CANCEL_OPTION, null, null, porDefecto));
        if(nuevaEtiqueta == null)
            return null;
        if(catS.equals("todas"))
            return nuevaEtiqueta.toUpperCase();
        else
            return catS.substring(0, 7).replace("IBFT", "IBF").trim() + " " + nuevaEtiqueta.toUpperCase();
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                BiodanzaG dialog = new BiodanzaG(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
