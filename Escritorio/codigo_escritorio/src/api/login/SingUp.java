/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.login;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.database.RolDb;
import modelos.database.UsuarioDb;
import modelos.objetos.Rol;
import modelos.objetos.Usuario;

/**
 *
 * @author LENOVO-PC
 */
public class SingUp extends javax.swing.JFrame {

    private FondoPanel fondoPanel = new FondoPanel();
    private Login login;
    private LinkedList<Rol> listaRoles = new LinkedList<>();
    private UsuarioDb usuarioDb = new UsuarioDb();

    public SingUp(Login login) {
        this.login = login;
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private int buscarRolUsuario() {
        int rol = 0;
        RolDb rolUsar = new RolDb();
        LinkedList<Rol> roles = rolUsar.leerRoles();
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getTipo().equals("user")) {
                rol = roles.get(i).getId();
                break;
            } else {
            }
        }
        return rol;
    }

    private void verificarDatosCorrectos() {

        if (verificarCampos()) { //se modifico el manejo de ROl , pues solo se mandaba un # ahora se obtiene con la base de datos
            if (isContraseniaIgual()) {
                int rolUser = buscarRolUsuario();//buscamos el rol del usuario
        //        Date fecha = new Date(dateChoserFecha.getDate().getYear(), dateChoserFecha.getDate().getMonth(), dateChoserFecha.getDate().getDay());
                Date fecha1 = new Date(dateChoserFecha.getDate().getTime());

                //Aqui se enviaria los datos del Usuario para ser Registrado
                Usuario usuarioNuevo = new Usuario(textFieldUserName.getText(),
                        textFieldContrasenia.getText(),
                        textFieldNombre.getText(),
                        textFieldApellido.getText(),
                        textFieldCorreo.getText(),
                        
                        
                        fecha1,
                        textFieldTelefono.getText(),
                        
                        rolUser);
                //se enviaria este -> usuarioNuevo,
                System.out.println(fecha1);
                usuarioDb.crearUsuario(usuarioNuevo);

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no COINCIDEN");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben de ser LLenados\n(Todos los campos son obligatorios)*");
        }
    }

    //limpia cada uno de los campos
    public void limpiar() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldCorreo.setText("");
        textFieldUserName.setText("");
        textFieldConfirme.setText("");
        textFieldContrasenia.setText("");
        dateChoserFecha.setDate(null);

    }

    //este se encargar de ver si estan llenos los campos y si no correctos
    private boolean verificarCampos() {
        boolean datosLlenos = (!textFieldNombre.getText().isEmpty() && !textFieldNombre.getText().equals(""))
                && (!textFieldApellido.getText().isEmpty() && !textFieldApellido.getText().equals(""))
                && (!textFieldCorreo.getText().isEmpty() && !textFieldCorreo.getText().equals(""))
                && (!textFieldUserName.getText().isEmpty() && !textFieldUserName.getText().equals(""))
                && (!textFieldContrasenia.getText().isEmpty() && !textFieldContrasenia.getText().equals(""))
                && (!textFieldConfirme.getText().isEmpty() && !textFieldConfirme.getText().equals(""))
                && (dateChoserFecha.getDate() != null && !dateChoserFecha.getDate().equals(""))
                && (!textFieldTelefono.getText().isEmpty() && !textFieldTelefono.getText().equals(""));
        if (datosLlenos) {
            return true;
        }

        return false;
    }

    //verifica que ambas contrasenias sean iguales
    private boolean isContraseniaIgual() {
        String contrasenia1 = textFieldContrasenia.getText();
        String contrasenia2 = textFieldConfirme.getText();
        if (contrasenia1.equals(contrasenia2)) {
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateChoserFecha = new com.toedter.calendar.JDateChooser();
        textFieldNombre = new javax.swing.JTextField();
        textFieldApellido = new javax.swing.JTextField();
        textFieldUserName = new javax.swing.JTextField();
        textFieldCorreo = new javax.swing.JTextField();
        textFieldTelefono = new javax.swing.JTextField();
        textFieldContrasenia = new javax.swing.JPasswordField();
        textFieldConfirme = new javax.swing.JPasswordField();
        botonRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        botonRegresar.setBackground(new java.awt.Color(45, 201, 151));
        botonRegresar.setFont(new java.awt.Font("Jenna Sue", 1, 18)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegresar.setText("Regresar <--");
        botonRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarbuttonExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Jenna Sue", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Crea una Cuenta!");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        dateChoserFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(204, 102, 255))); // NOI18N

        textFieldNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(204, 102, 255))); // NOI18N
        textFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreActionPerformed(evt);
            }
        });

        textFieldApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(102, 102, 255))); // NOI18N
        textFieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldApellidoActionPerformed(evt);
            }
        });

        textFieldUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UserName", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(102, 102, 255))); // NOI18N
        textFieldUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUserNameActionPerformed(evt);
            }
        });

        textFieldCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(204, 102, 255))); // NOI18N
        textFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCorreoActionPerformed(evt);
            }
        });

        textFieldTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(102, 102, 255))); // NOI18N
        textFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTelefonoActionPerformed(evt);
            }
        });
        textFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldTelefonoKeyTyped(evt);
            }
        });

        textFieldContrasenia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(204, 102, 255))); // NOI18N

        textFieldConfirme.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirmar Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 14), new java.awt.Color(102, 102, 255))); // NOI18N
        textFieldConfirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldConfirmeActionPerformed(evt);
            }
        });

        botonRegistrarse.setBackground(new java.awt.Color(45, 201, 151));
        botonRegistrarse.setFont(new java.awt.Font("Jenna Sue", 1, 18)); // NOI18N
        botonRegistrarse.setForeground(new java.awt.Color(0, 0, 0));
        botonRegistrarse.setText("--> Registrarse <--");
        botonRegistrarse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(51, 255, 0)));
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldTelefono)
                        .addComponent(dateChoserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChoserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarbuttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarbuttonExitActionPerformed
        login.setVisible(true);
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarbuttonExitActionPerformed

    private void textFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCorreoActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        verificarDatosCorrectos();
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    private void textFieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldApellidoActionPerformed

    private void textFieldConfirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldConfirmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldConfirmeActionPerformed

    private void textFieldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUserNameActionPerformed

    private void textFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreActionPerformed

    private void textFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTelefonoActionPerformed

    private void textFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldTelefonoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if ((caracter < '0')
                || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_textFieldTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton botonRegresar;
    private com.toedter.calendar.JDateChooser dateChoserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldApellido;
    private javax.swing.JPasswordField textFieldConfirme;
    private javax.swing.JPasswordField textFieldContrasenia;
    private javax.swing.JTextField textFieldCorreo;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldTelefono;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("imagenes/tikal.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}
