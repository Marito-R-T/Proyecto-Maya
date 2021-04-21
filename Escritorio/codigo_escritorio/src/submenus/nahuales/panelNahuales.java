/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submenus.nahuales;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelos.database.NahualDb;
import modelos.objetos.Nahual;

/**
 *
 * @author Esmeralda
 */
public final class panelNahuales extends javax.swing.JPanel {

    /**
     * Creates new form panelNauales
     */
    private final NahualDb nahualDb = new NahualDb();
    private ArrayList<Nahual> listaNahuales = null;
    private int indice = 0;

    public panelNahuales() {
        initComponents();
        //fondo de pantalla
        Imagen img = new Imagen();
        this.add(img);
        this.repaint();


        //botones
        ImageIcon imIconAnterior = new ImageIcon("./src/gui/imagenes/anterior.png");
        Icon iconoAnterior = new ImageIcon(imIconAnterior.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        botonAnterior.setIcon(iconoAnterior);
        ImageIcon imIconSiguiente = new ImageIcon("./src/gui/imagenes/siguiente.png");
        Icon iconoSiguiente = new ImageIcon(imIconSiguiente.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        botonSiguiente.setIcon(iconoSiguiente);

        listaNahuales = (ArrayList<Nahual>) nahualDb.getNahuales();
        pintar();

    }

    public class Imagen extends javax.swing.JPanel {

        ImageIcon BG = new ImageIcon("src/submenus/perfilUsuario/imagenesPerfilUsuario/fondoPerfil.jpg");

        public Imagen() {
            this.setSize(1300, 650);
        }

        @Override
        public void paint(Graphics grafico) {
            Dimension height = getSize();

            grafico.drawImage(BG.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    private boolean verificarNahuales() {
        if (listaNahuales != null && listaNahuales.size() > 2) {
            return true;
        }
        return false;
    }

    public int calcularFilas(String texto) {
        int total = (int) texto.length() / 143;
        if (total > 0) {
            total += 1;
            return total;
        }
        return 1;
    }

    private Icon getIconNahual(Nahual nahual, JLabel label) {
        ImageIcon imIcon = new ImageIcon(nahual.getImagen().getDirEscritorio());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        return icono;
    }

    public void pintarNahuales() {
        if (indice == 0) {
            iconoIzquierda.setIcon(getIconNahual(listaNahuales.get(listaNahuales.size() - 1), iconoIzquierda));
            iconoCentral.setIcon(getIconNahual(listaNahuales.get(indice), iconoCentral));
            iconoDerecha.setIcon(getIconNahual(listaNahuales.get(indice + 1), iconoDerecha));
        } else if (indice == listaNahuales.size() - 1) {
            iconoIzquierda.setIcon(getIconNahual(listaNahuales.get(indice - 1), iconoIzquierda));
            iconoCentral.setIcon(getIconNahual(listaNahuales.get(indice), iconoCentral));
            iconoDerecha.setIcon(getIconNahual(listaNahuales.get(0), iconoDerecha));
        } else {
            iconoIzquierda.setIcon(getIconNahual(listaNahuales.get(indice - 1), iconoIzquierda));
            iconoCentral.setIcon(getIconNahual(listaNahuales.get(indice), iconoCentral));
            iconoDerecha.setIcon(getIconNahual(listaNahuales.get(indice + 1), iconoDerecha));
        }
        areaDescripcion.setText(listaNahuales.get(indice).getDescripcion());
        areaSignificado.setText(listaNahuales.get(indice).getSignificado());
        lblNOmbreNahual.setText(listaNahuales.get(indice).getId() + ". " + listaNahuales.get(indice).getNombre());
    }

    private void pintar() {
        if (verificarNahuales()) {
            pintarNahuales();
        }
    }

    private void anterior() {
        if (indice == 0) {
            indice = listaNahuales.size() - 1;
        } else {
            indice--;
        }
    }

    private void siguiente() {
        if (indice == (listaNahuales.size() - 1)) {
            indice = 0;
        } else {
            indice++;
        }
    }

    public int nahual(int cont) {
        //System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = 6;
        if (contador < 0) {
            while (contador != 0) {
                if (contadorNahual == 20) {
                    contadorNahual = 1;
                } else {
                    contadorNahual++;
                }
                contador++;
            }
            return contadorNahual;
        }
        while (contador != 0) {
            if (contadorNahual == 1) {
                contadorNahual = 20;
            } else {
                contadorNahual--;
            }
            contador--;
        }
        return contadorNahual;

    }

    private void calcularFecha() {
        int numNahual = nahual(timeCholqij(boxDate.getCalendar().getTime().getTime()));
        indice = numNahual;
        pintarNahuales();
    }

    public int timeCholqij(long date) {
        try {
            String string = "Nov 15, 2020 00:00:00 AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ROOT);
            Date datePivote = sdf.parse(string);
//            System.out.println("DATE PIVOTE " + datePivote);
            long regresar = TimeUnit.DAYS.convert(datePivote.getTime() - date, TimeUnit.MILLISECONDS);
            return (int) regresar;
        } catch (ParseException ex) {
            Logger.getLogger(panelNahuales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        boxDate = new com.toedter.calendar.JDateChooser();
        btnCalcular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaSignificado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        iconoCentral = new javax.swing.JLabel();
        iconoDerecha = new javax.swing.JLabel();
        iconoIzquierda = new javax.swing.JLabel();
        lblNOmbreNahual = new javax.swing.JLabel();

        botonAnterior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnteriorMouseClicked(evt);
            }
        });

        botonSiguiente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSiguienteMouseClicked(evt);
            }
        });

        boxDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnCalcular.setBackground(new java.awt.Color(255, 255, 204));
        btnCalcular.setText("Calcular Nahual de la Fecha");
        btnCalcular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        areaSignificado.setEditable(false);
        areaSignificado.setColumns(20);
        areaSignificado.setFont(new java.awt.Font("Lobster", 0, 14)); // NOI18N
        areaSignificado.setLineWrap(true);
        areaSignificado.setRows(5);
        areaSignificado.setWrapStyleWord(true);
        areaSignificado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Significado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Jenna Sue", 1, 24), new java.awt.Color(0, 0, 153))); // NOI18N
        jScrollPane2.setViewportView(areaSignificado);

        areaDescripcion.setEditable(false);
        areaDescripcion.setColumns(20);
        areaDescripcion.setFont(new java.awt.Font("Lobster", 0, 14)); // NOI18N
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setRows(5);
        areaDescripcion.setWrapStyleWord(true);
        areaDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Jenna Sue", 1, 24), new java.awt.Color(0, 0, 153))); // NOI18N
        jScrollPane3.setViewportView(areaDescripcion);

        jPanel1.setOpaque(false);

        iconoCentral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        iconoDerecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        iconoIzquierda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNOmbreNahual.setBackground(new java.awt.Color(0, 0, 0));
        lblNOmbreNahual.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblNOmbreNahual.setForeground(new java.awt.Color(255, 255, 255));
        lblNOmbreNahual.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNOmbreNahual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNOmbreNahual.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(iconoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(iconoDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(lblNOmbreNahual, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(iconoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNOmbreNahual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconoDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconoIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSiguienteMouseClicked
        if (verificarNahuales()) {
            siguiente();
            pintarNahuales();
            boxDate.setDate(null);
        }
    }//GEN-LAST:event_botonSiguienteMouseClicked

    private void botonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnteriorMouseClicked
        if (verificarNahuales()) {
            anterior();
            pintarNahuales();
            boxDate.setDate(null);
        }
    }//GEN-LAST:event_botonAnteriorMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
         if (boxDate.getDate() != null) {
            calcularFecha();
        } else {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar o ingresar una fecha");
        }

    }//GEN-LAST:event_btnCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JTextArea areaSignificado;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonSiguiente;
    private com.toedter.calendar.JDateChooser boxDate;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel iconoCentral;
    private javax.swing.JLabel iconoDerecha;
    private javax.swing.JLabel iconoIzquierda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNOmbreNahual;
    // End of variables declaration//GEN-END:variables
}
