/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paquete;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author cris-
 */
public class gatoPrincipal extends javax.swing.JFrame {

    private boolean casilla[][] = new boolean[3][3];
    private String turno = "usuario1";
    private int gato[][] = new int [3][3];
    private String usuario1, usuario2;
    
    
    public gatoPrincipal(String usuario1, String usuario2) {
        initComponents();
        setSize(460, 460);
        setLocationRelativeTo(null);
        llenarCasillas();
        
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }
    
    private void llenarCasillas()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casilla[i][j] = true;
                gato[i][j] = 0;
                
            }
            
        }
    }
    
    private void detenerJuego(boolean g1, boolean g2)
    {
        boolean empate = false;
        
        if(g1 == true || g2 == true)
        {
            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++) 
                {
                    casilla[i][j] = false;
                }
            }
        }
        
        else
        {
            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++) 
                {
                    if(casilla[i][j] == true)
                    {
                        empate = true;
                    }
                }
            }
            
            if(empate == false)
            {
                System.out.println("El juego se empató");
                
                reiniciarJuego();
            }
        }
    }
    
 
    private void reiniciarJuego()
    {
        llenarCasillas();
        desdibujar(boton1);
        desdibujar(boton2);
        desdibujar(boton3);
        desdibujar(boton4);
        desdibujar(boton5);
        desdibujar(boton6);
        desdibujar(boton7);
        desdibujar(boton8);
        desdibujar(boton9);
    }
    
    
    
    private void dibujarX(JButton boton)
    {
        boton.setIcon(new ImageIcon(getClass().getResource("/Imaenes/imagenEquis.jpg")));
        
    }
    
    private void dibujarO(JButton boton)
    {
        boton.setIcon(new ImageIcon(getClass().getResource("/Imaenes/imagenCirculo.jpg")));
        
    }
    
    private void desdibujar(JButton boton)
    {
        boton.setIcon(new ImageIcon(getClass().getResource("/Imaenes/imagen.jpg")));
    }
        
    private boolean suma(int u1, int u2)
    {
        boolean ganador = false;
        if(u1 == 3)
        {
            ganador = true;
        }
        
        else
        {
            if(u2 == 18)
            {
                ganador = true;
            }
        }
        
        return ganador;
    }
    
    //Comprobar si hay un ganador
    private boolean tresEnLinea(int i, int j)
    {
        boolean ganador = false;
        int u1 = 0;
        int u2 = 0;
        
        //Comprobacion de si hay tres en linea en horizontal
        if(ganador == false)
        {
            for(int k = 0; k < 3; k++)
            {
                u1 = u1 + gato[i][k];
                u2 = u2 + gato[i][k];
            }
            ganador = suma(u1, u2);
        }
        u1 = 0;
        u2 = 0;
        
        //Comprobacion vertical
        if(ganador == false)
        {
            for(int k = 0; k < 3; k++)
            {
                u1 = u1 + gato[k][j];
                u2 = u2 + gato[k][j];
            }
            System.out.println("");
            ganador = suma(u1, u2);
        }
        u1 = 0;
        u2 = 0;
        
        //comprobacion de la diagonal principal
        if(ganador == false)
        {
            for (int k = 0; k < 3; k++) 
            {
                u1 = u1+gato[k][k];
                u2 = u2+gato[k][k];
            }
            
            ganador = suma(u1, u2);
        }
            
        u1 = 0;
        u2 = 0;
        
        //comprobacion de la diagonal invertida
        if(ganador == false)
        {
            int l = 2;
            for (int k = 0; k < 3; k++) 
            {

                u1 = u1+gato[k][l];
                u2 = u2+gato[k][l];

                l--;
            }
            
            ganador = suma(u1, u2);
        }
        
        
        return ganador;
    }
        
    //Dar el nombre del ganador
    private void comprobarGanador(String turno, int i, int j)
    {
        boolean ganador1 = false;
        boolean ganador2 = false;
        boolean empate;
        
        
        switch(turno)
        {
            case "usuario1":
                casilla[i][j] = false;
                if(tresEnLinea(i, j) == true)
                {
                    System.out.println("El ganador es: "+usuario1);
                    ganador1 = true;
                    detenerJuego(ganador1, ganador2);
                    reiniciarJuego();
                }
                
                else
                {
                    detenerJuego(ganador1, ganador2);
                }

                break;
                
            case "usuario2":
                casilla[i][j] = false;
                if(tresEnLinea(i, j) ==  true)
                {
                    System.out.println("El ganador es: "+usuario2);
                    ganador2 = true;
                    detenerJuego(ganador1, ganador2);
                    reiniciarJuego();
                }
                
                else
                {
                    detenerJuego(ganador1, ganador2);
                }
                
                break;
                
            default:
                break;
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
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new javax.swing.JPanel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        barraJuego = new javax.swing.JMenu();
        menuReinciar = new javax.swing.JMenuItem();
        menuMostrar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        barraAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gato");
        setMaximumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setLayout(new java.awt.GridLayout(3, 3));

        boton1.setBackground(new java.awt.Color(0, 102, 102));
        boton1.setForeground(new java.awt.Color(0, 0, 0));
        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton1.setBorder(null);
        boton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        panel1.add(boton1);

        boton2.setBackground(new java.awt.Color(0, 102, 102));
        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        panel1.add(boton2);

        boton3.setBackground(new java.awt.Color(0, 102, 102));
        boton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        panel1.add(boton3);

        boton4.setBackground(new java.awt.Color(0, 102, 102));
        boton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        panel1.add(boton4);

        boton5.setBackground(new java.awt.Color(0, 102, 102));
        boton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });
        panel1.add(boton5);

        boton6.setBackground(new java.awt.Color(0, 102, 102));
        boton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });
        panel1.add(boton6);

        boton7.setBackground(new java.awt.Color(0, 102, 102));
        boton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });
        panel1.add(boton7);

        boton8.setBackground(new java.awt.Color(0, 102, 102));
        boton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });
        panel1.add(boton8);

        boton9.setBackground(new java.awt.Color(0, 102, 102));
        boton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imaenes/imagen.jpg"))); // NOI18N
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });
        panel1.add(boton9);

        barraJuego.setText("Juego");

        menuReinciar.setText("Comenzar de nuevo");
        barraJuego.add(menuReinciar);

        menuMostrar.setText("Mostrar resultados");
        menuMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMostrarActionPerformed(evt);
            }
        });
        barraJuego.add(menuMostrar);
        barraJuego.add(jSeparator2);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        barraJuego.add(menuSalir);

        barraMenu.add(barraJuego);

        barraAyuda.setText("Ayuda");
        barraMenu.add(barraAyuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        if(casilla[0][0] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton1);
                gato[0][0] = 1;
                comprobarGanador(turno, 0, 0);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton1);
                gato[0][0] = 6;
                comprobarGanador(turno, 0, 0);
                turno = "usuario1";
                
            }   
        }
        
    }//GEN-LAST:event_boton1ActionPerformed

    private void menuMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMostrarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        if(casilla[0][1] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton2);
                gato[0][1] = 1;
                comprobarGanador(turno, 0, 1);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton2);
                gato[0][1] = 6;
                comprobarGanador(turno, 0, 1);
                turno = "usuario1";
                
            }
            
        }
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        if(casilla[0][2] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton3);
                gato[0][2] = 1;
                comprobarGanador(turno, 0, 2);
                turno = "usuario2";
                
                
            }
            
            else
            {
                dibujarO(boton3);
                gato[0][2] = 6;
                comprobarGanador(turno, 0, 2);
                turno = "usuario1";
                
            }
        }
        
        
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        if(casilla[1][0] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton4);
                gato[1][0] = 1;
                comprobarGanador(turno, 1, 0);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton4);
                gato[1][0] = 6;
                comprobarGanador(turno, 1, 0);
                turno = "usuario1";
                
            }
        }
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        if(casilla[1][1] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton5);
                gato[1][1] = 1;
                comprobarGanador(turno, 1, 1);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton5);
                gato[1][1] = 6;
                comprobarGanador(turno, 1, 1);
                turno = "usuario1";
                
            }
        }
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        if(casilla[1][2] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton6);
                gato[1][2] = 1;
                comprobarGanador(turno, 1, 2);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton6);
                gato[1][2] = 6;
                comprobarGanador(turno, 1, 2);
                turno = "usuario1";
            }
        }
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        if(casilla[2][0] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton7);
                gato[2][0] = 1;
                comprobarGanador(turno, 2, 0);
                turno = "usuario2";
                
            }
            
            else
            {
                dibujarO(boton7);
                gato[2][0] = 6;
                comprobarGanador(turno, 2, 0);
                turno = "usuario1";
            }
        }
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        if(casilla[2][1] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton8);
                gato[2][1] = 1;
                comprobarGanador(turno, 2, 1);
                turno = "usuario2";
            }
            
            else
            {
                dibujarO(boton8);
                gato[2][1] = 6;
                comprobarGanador(turno, 2, 1);
                turno = "usuario1";
            }
        }
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        if(casilla[2][2] == true)
        {
            if(turno.equals("usuario1"))
            {
                dibujarX(boton9);
                gato[2][2] = 1;
                comprobarGanador(turno, 2, 2);
                turno = "usuario2";
            }
            
            else
            {
                dibujarO(boton9);
                gato[2][2] = 6;
                comprobarGanador(turno, 2, 2);
                turno = "usuario1";
            }
        }
        
        //obtenerGanador();
    }//GEN-LAST:event_boton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gatoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gatoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gatoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gatoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gatoPrincipal(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu barraAyuda;
    private javax.swing.JMenu barraJuego;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem menuMostrar;
    private javax.swing.JMenuItem menuReinciar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
