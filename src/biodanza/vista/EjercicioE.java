package biodanza.vista;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biodanza.modelo.Biodanza;
import biodanza.modelo.Cancion;
import biodanza.modelo.Ejercicio;

public class EjercicioE extends javax.swing.JDialog implements DialogCaller
{

    private static final long serialVersionUID = -3720803445054976634L;

    Ejercicio e; // After modification
    Cancion c;
    boolean cerroBien = false;
    DialogCaller dc = null;

    /** Creates new form NewJDialog */
    public EjercicioE(java.awt.Frame parent, boolean modal, Ejercicio inst, DialogCaller d)
    {
        super(parent, modal);
        initComponents();
        e = inst;
        this.c = null;
        dc = d;
        txtName.setText(e.getNombre());
        txtObj.setText(e.getObjetivo());
        c = e.getCancion();
        if(c != null)
            cmdSong.setText(c.getNombre());
        txtName.updateUI();
        txtObj.updateUI();
        cmdSong.updateUI();
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent ev)
            {
                int res = JOptionPane.showConfirmDialog(EjercicioE.this, "Desea guardar los cambios?", "Guardar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(res == JOptionPane.YES_OPTION)
                {
                    updateMem();
                    dc.setAnswer(DialogCaller.OK, e);
                }
                else
                    dc.setAnswer(DialogCaller.CANCEL, null);
            }
        });
    }

    void bind()
    {
        txtName.setText(e.getNombre());
        txtObj.setText(e.getObjetivo());
        c = e.getCancion();
        if(c != null)
            cmdSong.setText(c.getNombre());
    }

    void updateMem()
    {
        e.setNombre(txtName.getText().toUpperCase());
        e.setObjetivo(txtObj.getText());
        e.setCancion(c);
    }

    void setCaller(DialogCaller dc)
    {
        this.dc = dc;
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

        txtName = new javax.swing.JTextField();
        cmdSong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObj = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdSong1 = new javax.swing.JButton();
        cmdSong2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtName.setText("Caminar alegre");

        cmdSong.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cmdSong.setText("Agregar cancion");
        cmdSong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdSong.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdSongActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtObj.setColumns(15);
        txtObj.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtObj.setLineWrap(true);
        txtObj.setRows(5);
        txtObj
            .setText("Tomados de las manos sintiendo la presencia de nuestros compañeros \ncerramos\nlos ojos.\n Y nos movemos suavemente al ritmo de la música. \n\n\n\nSintiendo la música vamos construyendo vínculos  nutriéndonos desde el dialogo de \nnuestros gestos el dialogo de la mirada  de la sonrisa.\ncddfs\ndsf\n\ndsf\nsfd\nsdf\n");
        txtObj.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtObj);

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        cmdCancel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cmdCancel.setText("Cancelar");
        cmdCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdSong1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cmdSong1.setText("Usar plantilla");
        cmdSong1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdSong1ActionPerformed(evt);
            }
        });

        cmdSong2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cmdSong2.setText("Agregar plantilla");
        cmdSong2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdSong2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout
                .createSequentialGroup()
                .addContainerGap()
                .addGroup(
                    layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(
                            layout
                                .createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 216,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                            layout
                                .createSequentialGroup()
                                .addGroup(
                                    layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmdSong, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(36, 36, 36)
                                .addGroup(
                                    layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmdSong1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdSong2, javax.swing.GroupLayout.DEFAULT_SIZE, 202,
                                            Short.MAX_VALUE)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout
                .createSequentialGroup()
                .addContainerGap()
                .addGroup(
                    layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                            layout
                                .createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSong))
                        .addGroup(
                            layout.createSequentialGroup().addComponent(cmdSong1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSong2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(
                    layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSongActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_cmdSongActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                AgregarCancionG ac = new AgregarCancionG(new javax.swing.JFrame(), true, EjercicioE.this, c,
                    e == null ? "" : e.getEtiqueta());
                ac.setVisible(true);
            }
        });
    }// GEN-LAST:event_cmdSongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton2ActionPerformed
     // boton OK
        boolean nuevo = e.getNombre().equals("Nuevo");
        updateMem();
        if(nuevo)
        {
            Vector<String> categorias = new Vector<String>();
            for(String et : Biodanza.darEtiquetas())
            {
                if(et.trim().startsWith("IBFT"))
                    categorias.add(et);
            }
            Collections.sort(categorias, new Comparator<String>()
            {
                public int compare(String o1, String o2)
                {
                    o1 = o1.trim();
                    o2 = o2.trim();
                    o1 = o1.replace("IBFT", "");
                    o2 = o2.replace("IBFT", "");
                    int uno = new Scanner(o1).nextInt();
                    int dos = new Scanner(o2).nextInt();
                    return uno - dos;
                }
            });
            Object cat = JOptionPane.showInputDialog(this,
                "Seleccione la categoria a la que pertenece este nuevo ejercicio", "Seleccionar categoria",
                JOptionPane.PLAIN_MESSAGE, null, categorias.toArray(), categorias.toArray()[0]);
            if(cat != null)
            {
                String catS = (String) cat;
                String etiqueta = catS.substring(0, 7).replace("IBFT", "IBF").trim() + " "
                    + e.getNombre().toUpperCase();
                Ejercicio n = (Ejercicio) e.clone();
                if(etiqueta != null && !etiqueta.trim().isEmpty())
                {
                    n.setEtiqueta(etiqueta);
                    e.setEtiqueta(etiqueta);
                    biodanza.modelo.Biodanza.plantillas.add(n);
                }
            }
        }
        if(dc != null)
        {
            dc.setAnswer(DialogCaller.OK, e);
            if(e.getEtiqueta() != null && !e.getEtiqueta().trim().isEmpty())
            {
                String etiqueta = e.getEtiqueta();
                Ejercicio plantilla = null;
                for(Ejercicio e : Biodanza.plantillas)
                    if(e.getEtiqueta().equals(etiqueta))
                        plantilla = e;
                if(plantilla != null
                    && !plantilla.getObjetivo().equals(e.getObjetivo())
                    && JOptionPane.showConfirmDialog(this,
                        "Desea establecer esta descripcion como la descripcion por defecto de la plantilla: "
                            + plantilla.getNombre() + "?", "Cambiar descripcion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    plantilla.setObjetivo(e.getObjetivo());
                if(e.getCancion() != null && !Arrays.asList(e.getCancion().getEtiquetas()).contains(e.getEtiqueta()))
                    e.getCancion().agregarEtiqueta(e.getEtiqueta());
            }
            setVisible(false);
        }
    }// GEN-LAST:event_jButton2ActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_cmdCancelActionPerformed
        if(dc != null)
        {
            dc.setAnswer(DialogCaller.CANCEL, null);
            setVisible(false);
        }
    }// GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSong1ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_cmdSong1ActionPerformed
        if(biodanza.modelo.Biodanza.plantillas != null && biodanza.modelo.Biodanza.plantillas.isEmpty())
            return;
        Vector<String> categorias = new Vector<String>();
        categorias.add("todas");
        for(Ejercicio ej : biodanza.modelo.Biodanza.plantillas)
        {
            String p = ej.getEtiqueta() == null || ej.getEtiqueta().trim().isEmpty() ? ej.toString() : ej.getEtiqueta();
            if(p.trim().startsWith("IBFT"))
                categorias.add(p);
        }
        Object cat = JOptionPane.showInputDialog(this, "Seleccione la categoria", "Seleccionar categoria",
            JOptionPane.PLAIN_MESSAGE, null, categorias.toArray(), categorias.toArray()[0]);
        if(cat == null)
            return;
        String catS = (String) cat;
        if(catS.equals("todas"))
        {
            Object[] ps = biodanza.modelo.Biodanza.plantillas.toArray();
            Arrays.sort(ps, new Comparator<Object>()
            {

                public int compare(Object o1, Object o2)
                {
                    Ejercicio p1 = (Ejercicio) o1;
                    Ejercicio p2 = (Ejercicio) o2;
                    return p1.getNombre().toLowerCase().compareTo(p2.getNombre().toLowerCase());
                }

            });
            Object aUsarO = JOptionPane.showInputDialog(this, "Seleccione la plantilla", "Seleccionar plantilla",
                JOptionPane.PLAIN_MESSAGE, null, ps, ps[0]);
            if(aUsarO == null)
                return;
            e = (Ejercicio) aUsarO;
            e = (Ejercicio) e.clone();
            bind();
        }
        else
        {
            Vector<Ejercicio> escogidas = new Vector<Ejercicio>();
            Ejercicio a = new Ejercicio("", "");
            for(Ejercicio ej : biodanza.modelo.Biodanza.plantillas)
            {
                String p = ej.getEtiqueta() == null || ej.getEtiqueta().trim().isEmpty() ? ej.toString() : ej
                    .getEtiqueta();
                if(p.trim().startsWith("IBF " + categorias.indexOf(catS) + " "))
                    escogidas.add(ej);
            }
            while(escogidas.size() < 25)
                escogidas.add(a);
            Object[] ps = escogidas.toArray();
            Arrays.sort(ps, new Comparator<Object>()
            {

                public int compare(Object o1, Object o2)
                {
                    Ejercicio p1 = (Ejercicio) o1;
                    Ejercicio p2 = (Ejercicio) o2;
                    if(p1.getNombre().equals(""))
                        return 1;
                    if(p2.getNombre().equals(""))
                        return -1;
                    return p1.getNombre().toLowerCase().compareTo(p2.getNombre().toLowerCase());
                }

            });
            Object aUsarO = JOptionPane.showInputDialog(this, "Seleccione la plantilla", "Seleccionar plantilla",
                JOptionPane.PLAIN_MESSAGE, null, ps, ps[0]);
            if(aUsarO == null || ((Ejercicio) aUsarO).getNombre().isEmpty())
                return;
            e = (Ejercicio) aUsarO;
            e = (Ejercicio) e.clone();
            bind();
        }
    }// GEN-LAST:event_cmdSong1ActionPerformed

    private void cmdSong2ActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_cmdSong2ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Seguro desea agregar este ejercicio como plantilla?",
            "Agregar plantilla", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            updateMem();
            String etiqueta = BiodanzaG.escogerEtiquetaNueva(this, e.getNombre());
            Ejercicio nuevo = (Ejercicio) e.clone();
            if(etiqueta != null && !etiqueta.trim().isEmpty())
            {
                nuevo.setEtiqueta(etiqueta);
                e.setEtiqueta(etiqueta);
                nuevo.setNombre(nuevo.getNombre().toUpperCase());
                biodanza.modelo.Biodanza.plantillas.add(nuevo);
            }
        }
        else if(JOptionPane.showConfirmDialog(this, "Desea eliminar una plantilla?", "Eliminar plantilla",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            if(biodanza.modelo.Biodanza.plantillas != null && biodanza.modelo.Biodanza.plantillas.isEmpty())
                return;
            Object aUsarO = JOptionPane.showInputDialog(this, "Seleccione la plantilla", "Seleccionar plantilla",
                JOptionPane.PLAIN_MESSAGE, null, biodanza.modelo.Biodanza.plantillas.toArray(),
                biodanza.modelo.Biodanza.plantillas.toArray()[0]);
            if(aUsarO == null)
                return;
            Ejercicio este = (Ejercicio) aUsarO;
            biodanza.modelo.Biodanza.plantillas.remove(este);
            if(este.getEtiqueta() != null && !este.getEtiqueta().trim().isEmpty())
                biodanza.modelo.Biodanza.recalcularEtiqueta(este.getEtiqueta());
        }
    }// GEN-LAST:event_cmdSong2ActionPerformed

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[])
    {
        EjercicioE frm = new EjercicioE(new JFrame(), true, new Ejercicio("", ""), null);
        frm.setSize(500, 500);
        frm.setVisible(true);
    }

    public void setAnswer(int button, Object answer)
    {
        if(button == DialogCaller.OK)
        {
            c = (Cancion) answer;
            cmdSong.setText(c.toString());
        }
        // bind();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdSong;
    private javax.swing.JButton cmdSong1;
    private javax.swing.JButton cmdSong2;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtObj;
    // End of variables declaration//GEN-END:variables
}