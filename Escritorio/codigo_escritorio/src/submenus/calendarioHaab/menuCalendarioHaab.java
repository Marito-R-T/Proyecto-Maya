/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submenus.calendarioHaab;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelos.database.FechaHaabDb;
import modelos.database.InfoHaab;
import modelos.database.InformacionDb;
import modelos.database.Utilidades;
import modelos.database.WinalDb;
import modelos.objetos.FechaHaab;
import modelos.objetos.Informacion2;
import modelos.objetos.Winal;
import submenus.nahuales.panelNahuales;

/**
 *
 * @author Esmeralda
 */
public class menuCalendarioHaab extends javax.swing.JPanel {

    private Date fecha = Utilidades.LocalDateToDate(LocalDate.now());
    FechaHaabDb acceso = new FechaHaabDb();

    private int index = 0;
    public static ArrayList<InformacionHaab> informacion;
    
    
    private WinalDb winalDb = new WinalDb();
    private ArrayList<Winal> listWinales = null;

    private int indice = 0;

    /**
     * Creates new form calendarioHaab
     */
    public menuCalendarioHaab() {
        initComponents();

        
        listWinales = (ArrayList<Winal>) winalDb.getWinales();
        
        //fondo de pantalla
        Imagen img = new Imagen();
        this.add(img);
        this.repaint();

        InformacionDb accesoInf = new InformacionDb();
        boxDate.setDate(fecha);

        //PENDIENTE TRABAJAR ESTO:
        // escribirFecha();
        btnAtras.setEnabled(false);
        obtenerInfo();
        agregarPrimerHecho();

        ImageIcon imA = new ImageIcon("src/submenus/lineaDeTiempo/imagenesLineaTiempoMaya/adelante.png");
        Icon iconA = new ImageIcon(imA.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        btnAdelante.setIcon(iconA);

        ImageIcon imgAt = new ImageIcon("src/submenus/lineaDeTiempo/imagenesLineaTiempoMaya/atras.png");
        Icon iconAt = new ImageIcon(imgAt.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        btnAtras.setIcon(iconAt);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boxDate = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtMesHaab = new javax.swing.JLabel();
        lblWinal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSignificado = new javax.swing.JTextArea();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Jenna Sue", 1, 36), new java.awt.Color(204, 0, 51))); // NOI18N
        jPanel1.setOpaque(false);

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setFont(new java.awt.Font("Lobster", 1, 14)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnAdelante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel4.setBackground(new java.awt.Color(221, 221, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Mes"));

        txtMesHaab.setText(".");

        lblWinal.setText(" ");

        txtSignificado.setColumns(20);
        txtSignificado.setRows(5);
        jScrollPane1.setViewportView(txtSignificado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtMesHaab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblWinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 29, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMesHaab)
                .addGap(12, 12, 12)
                .addComponent(lblWinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Winal");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!boxDate.isValid() || boxDate.getDate() == null) {
            System.out.println("fecha invalida en calendario haab");
        } else {
            fecha = boxDate.getDate();
            calcularFecha();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        index++;
        panelInfo.removeAll();
        if (informacion.size() > index) {
            panelInfo.add(informacion.get(index));
            informacion.get(index).setVisible(true);
            panelInfo.validate();
            panelInfo.repaint();
            if (index == informacion.size() - 1) {
                btnAdelante.setEnabled(false);
            } else {
                btnAdelante.setEnabled(true);
            }
            btnAtras.setEnabled(true);
        }
    }//GEN-LAST:event_btnAdelanteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        index--;
        panelInfo.removeAll();
        panelInfo.add(informacion.get(index));
        informacion.get(index).setVisible(true);
        panelInfo.validate();
        panelInfo.repaint();
        if (index == 0) {
            btnAtras.setEnabled(false);
        } else {
            btnAtras.setEnabled(true);
        }
        btnAdelante.setEnabled(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    public final void escribirFecha() {
        FechaHaab fechaActual = acceso.getFechaEspecifica(Utilidades.DateToLocalDate(fecha));
        txtMesHaab.setText(fechaActual.getWinal().getNombre());
        fechaActual.getWinal().getImagen().colocarImagen(lblWinal, 135, 135);
    }

    public void fechaSiguiente() {
        LocalDate temp = Utilidades.DateToLocalDate(fecha);
        temp = temp.plusDays(2);
        System.out.println("antes: " + fecha.toString());
        fecha = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        boxDate.setDate(fecha);
        escribirFecha();
    }

    public void fechaAnterior() {
        LocalDate temp = Utilidades.DateToLocalDate(fecha);
        temp = temp.minusDays(0);
        System.out.println("antes: " + fecha.toString());
        fecha = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        boxDate.setDate(fecha);
        escribirFecha();
    }

    public void mesSiguiente() {
        LocalDate temp = Utilidades.DateToLocalDate(fecha);
        if (temp.getDayOfYear() > 360) {
            temp = LocalDate.of(temp.getYear() + 1, Month.JANUARY, temp.getDayOfYear() - 360);
        } else if (temp.getDayOfYear() > 345) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 31);
        } else {
            temp = temp.plusDays(21);
        }
        System.out.println("antes: " + fecha.toString());
        fecha = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        boxDate.setDate(fecha);
        escribirFecha();
    }

    public void mesAnterior() {
        LocalDate temp = Utilidades.DateToLocalDate(fecha);
        if (temp.getDayOfYear() <= 5) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 26 + temp.getDayOfYear());
        } else if (temp.getDayOfYear() <= 20) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 31);
        } else {
            temp = temp.minusDays(19);
        }
        System.out.println("antes: " + fecha.toString());
        fecha = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        boxDate.setDate(fecha);
        escribirFecha();
    }

    //Colocando informacion
    public static final void obtenerInfo() {
        InfoHaab datoHaab = new InfoHaab();
        ArrayList<Informacion2> arrayInfo = datoHaab.leerHechosHistoricos();
        informacion = new ArrayList<>();
        for (int i = 0; i < arrayInfo.size(); i++) {
            informacion.add(new InformacionHaab(arrayInfo.get(i)));
        }
    }

    private void agregarPrimerHecho() {
        if (informacion.size() > 0) {
            panelInfo.add(informacion.get(0));
            informacion.get(0).setVisible(true);
            panelInfo.validate();
            panelInfo.repaint();
        }
    }

    //calculo de fecha para winal
    private void calcularFecha() {
        int numWinal = winal(timeHaab(boxDate.getCalendar().getTime().getTime()));
        indice = numWinal;
        pintarWinales();

    }

    public int winal(int cont) {
        int contador = cont;
        int contWinal = 0;
        if (contador < 0) {
            while (contador != 0) {
                if (contWinal == 18) {
                    contWinal = 0;
                } else {
                    contWinal++;
                }
                contador++;
            }
            return contWinal;
        }
        while (contador != 0) {
            if (contWinal == 0) {
                contWinal = 18;
            } else {
                contWinal--;
            }
            contador--;
        }
        return contWinal;
    }

    public int timeHaab(long date) {
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

    private Icon getIconWinal(Winal winal){
        ImageIcon imIcon = new ImageIcon(winal.getImagen().getDirEscritorio());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public void pintarWinales() {
        if (indice == 0) {
            lblWinal.setIcon(getIconWinal(listWinales.get(indice)));
        } else if (indice == listWinales.size() - 1) {
            lblWinal.setIcon(getIconWinal(listWinales.get(indice)));
        } else {
            lblWinal.setIcon(getIconWinal(listWinales.get(indice)));
        }
        txtMesHaab.setText(listWinales.get(indice).getIdDesk() + ". " + listWinales.get(indice).getNombre());
        txtSignificado.setText(listWinales.get(indice).getSignificado());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser boxDate;
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWinal;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel txtMesHaab;
    private javax.swing.JTextArea txtSignificado;
    // End of variables declaration//GEN-END:variables
}
