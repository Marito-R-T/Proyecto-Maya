package api.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.database.UsuarioDb;
import modelos.objetos.Usuario;
import principal.menuPrincipal.MenuPrincipal;

public class Login extends javax.swing.JFrame {

    private FondoPanel fondoPanel = new FondoPanel();
    private SingUp singUp = new SingUp(this);
    private UsuarioDb usuarioDb = new UsuarioDb();
    private MenuPrincipal menu;
    public static ArchivoLogin archivoLogin = new ArchivoLogin();
    public static Usuario usuarioLogueado = null;

    public Login() {
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
        panelSesion.setBackground(new Color(255, 255, 255, 100));

        ImageIcon imIcon = new ImageIcon("src/api/login/imagenes/icono.png");
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(labelIcono.getWidth(), labelIcono.getHeight(), Image.SCALE_DEFAULT));
        labelIcono.setIcon(icono);

        ImageIcon imIconExit = new ImageIcon("src/api/login/imagenes/salir.png");
        Icon iconoExit = new ImageIcon(imIconExit.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_DEFAULT));
        botonSalir.setIcon(iconoExit);
    }

    //logue al usuario
    public void loguear() {
        try {
            CifradoPasswords cifrado = new CifradoPasswords();
            
            usuarioLogueado = usuarioDb.validacionUsuario(textFieldCorreo.getText(), passFieldContrasenia.getText());
            String password = cifrado.descifra(usuarioLogueado.getPassword().getBytes());

            if (usuarioLogueado != null) {
                if (password.equals(passFieldContrasenia.getText())) {
                    System.out.println("Se logueo xD");
                    recordarSesion(usuarioLogueado);
                    menu = new MenuPrincipal(usuarioLogueado);
                    menu.setVisible(true);
                    this.setVisible(false);
                } else {
                    System.out.println("NO Se logueo xD");
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            } else {
                System.out.println("NO Se logueo xD");
                JOptionPane.showMessageDialog(null, "El Correo o Contraseña son Incorrectos");
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void recordarSesion(Usuario usuarioGuardar) {
        if (checkBoxRecordar.isSelected()) {
            archivoLogin.escribirArchivo(new UsuarioLogueo(usuarioGuardar.getEmail(), usuarioGuardar.getPassword()));
        } else {
            archivoLogin.escribirArchivo(null);
        }
    }

    private void verificarCampos() {
        if (!textFieldCorreo.getText().isEmpty() && !passFieldContrasenia.getText().isEmpty()) {
            loguear();
        } else {
            JOptionPane.showMessageDialog(null, "Uno de los campos deben de ser LLenados\n(Todos los campos son obligatorios)*");
        }
    }

    public void iniciar() {
        archivoLogin.verificarExitenciaArchivo();
        UsuarioLogueo usuarioLogueo = archivoLogin.leerLogueo();

        if (usuarioLogueo != null) {
            Usuario usuario = usuarioDb.validacionUsuario(usuarioLogueo.getCorreo(), usuarioLogueo.getContrasenia());
            if (usuario != null) {
                System.out.println("Se logueo xD");
                menu = new MenuPrincipal(usuario);
                menu.setVisible(true);
                this.setVisible(false);
            } else {
                System.out.println("NO Se logueo xD");
                this.setVisible(true);
            }
        } else {
            this.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new FondoPanel();
        botonSalir = new javax.swing.JButton();
        panelSesion = new javax.swing.JPanel();
        textFieldCorreo = new javax.swing.JTextField();
        passFieldContrasenia = new javax.swing.JPasswordField();
        checkBoxRecordar = new javax.swing.JCheckBox();
        botonSingIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonSingUp = new javax.swing.JButton();
        labelIcono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirbuttonExitActionPerformed(evt);
            }
        });

        textFieldCorreo.setBackground(new java.awt.Color(216, 221, 239));
        textFieldCorreo.setForeground(new java.awt.Color(60, 21, 59));
        textFieldCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 24), new java.awt.Color(60, 21, 59)));
        textFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCorreojTextField2ActionPerformed(evt);
            }
        });

        passFieldContrasenia.setBackground(new java.awt.Color(216, 221, 239));
        passFieldContrasenia.setForeground(new java.awt.Color(60, 21, 59));
        passFieldContrasenia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster", 1, 24), new java.awt.Color(60, 21, 59)));
        passFieldContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldContraseniaActionPerformed(evt);
            }
        });
        passFieldContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passFieldContraseniaKeyReleased(evt);
            }
        });

        checkBoxRecordar.setBackground(new java.awt.Color(216, 221, 239));
        checkBoxRecordar.setFont(new java.awt.Font("Jenna Sue", 1, 12)); // NOI18N
        checkBoxRecordar.setForeground(new java.awt.Color(60, 21, 59));
        checkBoxRecordar.setText("No cerrar sesion");
        checkBoxRecordar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRecordarActionPerformed(evt);
            }
        });

        botonSingIn.setBackground(new java.awt.Color(45, 201, 151));
        botonSingIn.setFont(new java.awt.Font("Jenna Sue", 1, 18)); // NOI18N
        botonSingIn.setForeground(new java.awt.Color(115, 111, 114));
        botonSingIn.setText("Ingresar");
        botonSingIn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSingIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSingInActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(244, 96, 54));

        botonSingUp.setBackground(new java.awt.Color(115, 111, 114));
        botonSingUp.setFont(new java.awt.Font("Jenna Sue", 1, 18)); // NOI18N
        botonSingUp.setForeground(new java.awt.Color(45, 201, 151));
        botonSingUp.setText("Registrarse");
        botonSingUp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(255, 255, 0)));
        botonSingUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSingUpActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(60, 21, 59));
        jLabel2.setText("BIENVENIDO");

        javax.swing.GroupLayout panelSesionLayout = new javax.swing.GroupLayout(panelSesion);
        panelSesion.setLayout(panelSesionLayout);
        panelSesionLayout.setHorizontalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelSesionLayout.createSequentialGroup()
                            .addComponent(checkBoxRecordar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionLayout.createSequentialGroup()
                        .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(114, 114, 114))))
        );
        panelSesionLayout.setVerticalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(passFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(checkBoxRecordar)
                .addGap(2, 2, 2)
                .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel1.setFont(new java.awt.Font("Jenna Sue", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 21, 59));
        jLabel1.setText("Salir");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirbuttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirbuttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirbuttonExitActionPerformed

    private void textFieldCorreojTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCorreojTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCorreojTextField2ActionPerformed

    private void checkBoxRecordarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRecordarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxRecordarActionPerformed

    private void passFieldContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldContraseniaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //LOGUEAR
            botonSingIn.doClick();
        }
    }//GEN-LAST:event_passFieldContraseniaKeyReleased

    private void botonSingUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSingUpActionPerformed
        singUp.limpiar();
        singUp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonSingUpActionPerformed

    private void botonSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSingInActionPerformed
        verificarCampos();
    }//GEN-LAST:event_botonSingInActionPerformed

    private void passFieldContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldContraseniaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSingIn;
    private javax.swing.JButton botonSingUp;
    private javax.swing.JCheckBox checkBoxRecordar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelIcono;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelSesion;
    public javax.swing.JPasswordField passFieldContrasenia;
    private javax.swing.JTextField textFieldCorreo;
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
