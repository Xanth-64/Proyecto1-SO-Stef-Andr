
package Interface;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Window2 extends javax.swing.JFrame {

    public static Window1 w1;
    /**
     * Creates new form Window2
     */
    public Window2(Window1 w1) {
        initComponents();
        this.setLocationRelativeTo(null);
        Window2.w1 = w1;
        this.seconds_of_a_day.setText(Float.toString(Window1.seconds_of_a_day));
        this.days_between_shipments.setText(Integer.toString(Window1.days_between_shipments));
        this.maximum_button_capacity.setText(Integer.toString(Window1.maximum_button_capacity));
        this.maximum_joystick_capacity.setText(Integer.toString(Window1.maximum_joystick_capacity));
        this.maximum_screen_capacity.setText(Integer.toString(Window1.maximum_screen_capacity));
        this.maximum_sdreader_capacity.setText(Integer.toString(Window1.maximum_sdreader_capacity));
        this.initial_button_producers.setText(Integer.toString(Window1.initial_button_producers));
        this.initial_joystick_producers.setText(Integer.toString(Window1.initial_joystick_producers));
        this.initial_screen_producers.setText(Integer.toString(Window1.initial_screen_producers));
        this.initial_sdreader_producers.setText(Integer.toString(Window1.initial_sdreader_producers));
        this.max_button_producers.setText(Integer.toString(Window1.max_button_producers));
        this.max_joystick_producers.setText(Integer.toString(Window1.max_joystick_producers));
        this.max_screen_producers.setText(Integer.toString(Window1.max_screen_producers));
        this.max_sdreader_producers.setText(Integer.toString(Window1.max_sdreader_producers));
        this.initial_assemblers.setText(Integer.toString(Window1.initial_assemblers));
        this.max_assemblers.setText(Integer.toString(Window1.max_assemblers));
        Window2.w1.setVisible(false);
        this.setVisible(true);
    }
    
    public boolean isNumeric(String string){
        try {
            Integer.parseInt(string);
            return true;
	}catch (NumberFormatException e){
            return false;
	}
    }
    
    public boolean isNumeric2(String string){
        try {
            Float.parseFloat(string);
            return true;
	}catch (NumberFormatException e){
            return false;
	}
    }
    
    public void write_txt(){
        try {
            String data = "";
            if (    Float.parseFloat(seconds_of_a_day.getText()) >= 1 &&
                    Integer.parseInt(initial_button_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_joystick_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_screen_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_sdreader_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_assemblers.getText()) >= 1 &&
                    Integer.parseInt(days_between_shipments.getText()) >= 6 && 
                    Integer.parseInt(maximum_button_capacity.getText()) >= 5 &&
                    Integer.parseInt(maximum_joystick_capacity.getText()) >= 2 &&
                    Integer.parseInt(maximum_screen_capacity.getText()) >= 2 &&
                    Integer.parseInt(maximum_sdreader_capacity.getText()) >= 1 &&
                    Integer.parseInt(initial_button_producers.getText()) <= Integer.parseInt(max_button_producers.getText()) && 
                    Integer.parseInt(initial_joystick_producers.getText()) <= Integer.parseInt(max_joystick_producers.getText()) &&
                    Integer.parseInt(initial_screen_producers.getText()) <= Integer.parseInt(max_screen_producers.getText()) &&
                    Integer.parseInt(initial_sdreader_producers.getText()) <= Integer.parseInt(max_sdreader_producers.getText()) &&
                    Integer.parseInt(initial_assemblers.getText()) <= Integer.parseInt(max_assemblers.getText())) {
                
                data =   "Time in seconds of a day:" + seconds_of_a_day.getText() + "\n" +
                                "Number of days between shipments:" + days_between_shipments.getText() + "\n" +
                                "Button storage maximum capacity:" + maximum_button_capacity.getText() + "\n" +
                                "Joystick storage maximum capacity:" + maximum_joystick_capacity.getText() + "\n" +
                                "Screen storage maximum capacity:" + maximum_screen_capacity.getText() + "\n" +
                                "SD reader storage maximum capacity:" + maximum_sdreader_capacity.getText() + "\n" +
                                "Initial number of button producers:" + initial_button_producers.getText() + "\n" +
                                "Initial number of joystick producers:" + initial_joystick_producers.getText() + "\n" +
                                "Initial number of screen producers:" + initial_screen_producers.getText() + "\n" +
                                "Initial number of SD reader producers:" + initial_sdreader_producers.getText() + "\n" +
                                "Maximum button producers:" + max_button_producers.getText() + "\n" +
                                "Maximum joystick producers:" + max_joystick_producers.getText() + "\n" +
                                "Maximum screen producers:" + max_screen_producers.getText() + "\n" +
                                "Maximum SD reader producers:" + max_sdreader_producers.getText() + "\n" +
                                "Initial number of assemblers:" + initial_assemblers.getText() + "\n" +
                                "Maximum number of assemblers:" + max_assemblers.getText();
                JOptionPane.showMessageDialog(null, "Save successful! At the next program initialization, the changes will be applied.");
                
            }else{
                data =   "Time in seconds of a day:" + 24 + "\n" +
                                "Number of days between shipments:" + 30 + "\n" +
                                "Button storage maximum capacity:" + 45 + "\n" +
                                "Joystick storage maximum capacity:" + 20 + "\n" +
                                "Screen storage maximum capacity:" + 40 + "\n" +
                                "SD reader storage maximum capacity:" + 15 + "\n" +
                                "Initial number of button producers:" + 1 + "\n" +
                                "Initial number of joystick producers:" + 1 + "\n" +
                                "Initial number of screen producers:" + 1 + "\n" +
                                "Initial number of SD reader producers:" + 1 + "\n" +
                                "Maximum button producers:" + 3 + "\n" +
                                "Maximum joystick producers:" + 4 + "\n" +
                                "Maximum screen producers:" + 5 + "\n" +
                                "Maximum SD reader producers:" + 4 + "\n" +
                                "Initial number of assemblers:" + 1 + "\n" +
                                "Maximum number of assemblers:" + 5;
                JOptionPane.showMessageDialog(null, "Remember that the minimums cannot be greater than the maximums.\n"
                                                            + "The capacity must allow a minimum of 5 buttons, 2 screens, 2 joysticks and 1 SD reader.\n"
                                                            + "In addition, there must be a minimum of 6 days between shipments.\n"
                                                            + "The values ​​will be reset.");
            }
            
            PrintWriter pw = new PrintWriter("test\\nintendo.txt");
            pw.print(data);
            pw.close();
            
            }catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Sorry, there was a save error. The values ​​will be reset.");
                try {
                String data =   "Time in seconds of a day:" + 24 + "\n" +
                                "Number of days between shipments:" + 30 + "\n" +
                                "Button storage maximum capacity:" + 45 + "\n" +
                                "Joystick storage maximum capacity:" + 20 + "\n" +
                                "Screen storage maximum capacity:" + 40 + "\n" +
                                "SD reader storage maximum capacity:" + 15 + "\n" +
                                "Initial number of button producers:" + 1 + "\n" +
                                "Initial number of joystick producers:" + 1 + "\n" +
                                "Initial number of screen producers:" + 1 + "\n" +
                                "Initial number of SD reader producers:" + 1 + "\n" +
                                "Maximum button producers:" + 3 + "\n" +
                                "Maximum joystick producers:" + 4 + "\n" +
                                "Maximum screen producers:" + 5 + "\n" +
                                "Maximum SD reader producers:" + 4 + "\n" +
                                "Initial number of assemblers:" + 1 + "\n" +
                                "Maximum number of assemblers:" + 5;

                PrintWriter pw = new PrintWriter("test\\nintendo.txt");
                pw.print(data);
                pw.close();

                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sorry, there was a save error.");
                }
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
        jLabel1 = new javax.swing.JLabel();
        seconds_of_a_day = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        days_between_shipments = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        maximum_button_capacity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        maximum_joystick_capacity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        maximum_screen_capacity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        maximum_sdreader_capacity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        initial_button_producers = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        initial_joystick_producers = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        initial_screen_producers = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        initial_sdreader_producers = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        max_button_producers = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        max_joystick_producers = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        max_screen_producers = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        max_sdreader_producers = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        initial_assemblers = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        max_assemblers = new javax.swing.JTextField();
        back_button = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Time in seconds of a day:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        seconds_of_a_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seconds_of_a_dayActionPerformed(evt);
            }
        });
        jPanel1.add(seconds_of_a_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Number of days between shipments:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        days_between_shipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days_between_shipmentsActionPerformed(evt);
            }
        });
        jPanel1.add(days_between_shipments, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 50, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Button storage maximum capacity:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        maximum_button_capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximum_button_capacityActionPerformed(evt);
            }
        });
        jPanel1.add(maximum_button_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Joystick storage maximum capacity:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        maximum_joystick_capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximum_joystick_capacityActionPerformed(evt);
            }
        });
        jPanel1.add(maximum_joystick_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 50, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Screen storage maximum capacity:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        maximum_screen_capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximum_screen_capacityActionPerformed(evt);
            }
        });
        jPanel1.add(maximum_screen_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 50, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("SD reader storage maximum capacity:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        maximum_sdreader_capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximum_sdreader_capacityActionPerformed(evt);
            }
        });
        jPanel1.add(maximum_sdreader_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 50, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Initial number of button producers:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        initial_button_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initial_button_producersActionPerformed(evt);
            }
        });
        jPanel1.add(initial_button_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Initial number of joystick producers:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        initial_joystick_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initial_joystick_producersActionPerformed(evt);
            }
        });
        jPanel1.add(initial_joystick_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 50, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Initial number of screen producers:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        initial_screen_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initial_screen_producersActionPerformed(evt);
            }
        });
        jPanel1.add(initial_screen_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 50, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Initial number of SD reader producers:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        initial_sdreader_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initial_sdreader_producersActionPerformed(evt);
            }
        });
        jPanel1.add(initial_sdreader_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 50, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Maximum button producers:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        max_button_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                max_button_producersActionPerformed(evt);
            }
        });
        jPanel1.add(max_button_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 50, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Maximum joystick producers:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        max_joystick_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                max_joystick_producersActionPerformed(evt);
            }
        });
        jPanel1.add(max_joystick_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 50, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Maximum screen producers:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        max_screen_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                max_screen_producersActionPerformed(evt);
            }
        });
        jPanel1.add(max_screen_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 50, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Maximum SD reader producers:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        max_sdreader_producers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                max_sdreader_producersActionPerformed(evt);
            }
        });
        jPanel1.add(max_sdreader_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 50, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Initial number of assemblers:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        initial_assemblers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initial_assemblersActionPerformed(evt);
            }
        });
        jPanel1.add(initial_assemblers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 50, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Maximum number of assemblers:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        max_assemblers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                max_assemblersActionPerformed(evt);
            }
        });
        jPanel1.add(max_assemblers, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 50, -1));

        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });
        jPanel1.add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/diskette.png"))); // NOI18N
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });
        jPanel1.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background5.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        // TODO add your handling code here:
        if (    isNumeric2(seconds_of_a_day.getText()) && isNumeric(days_between_shipments.getText()) &&
                isNumeric(maximum_button_capacity.getText()) && isNumeric(maximum_joystick_capacity.getText()) &&
                isNumeric(maximum_screen_capacity.getText()) && isNumeric(maximum_sdreader_capacity.getText()) &&
                isNumeric(initial_button_producers.getText()) && isNumeric(initial_joystick_producers.getText()) &&
                isNumeric(initial_screen_producers.getText()) && isNumeric(initial_sdreader_producers.getText()) &&
                isNumeric(max_button_producers.getText()) && isNumeric(max_joystick_producers.getText()) &&
                isNumeric(max_screen_producers.getText()) && isNumeric(max_sdreader_producers.getText()) &&
                isNumeric(initial_assemblers.getText()) && isNumeric(max_assemblers.getText())) {
            
            if (    Float.parseFloat(seconds_of_a_day.getText()) >= 1 && Integer.parseInt(days_between_shipments.getText()) >= 1 &&
                    Integer.parseInt(maximum_button_capacity.getText()) >= 1 && Integer.parseInt(maximum_joystick_capacity.getText()) >= 1 &&
                    Integer.parseInt(maximum_screen_capacity.getText()) >= 1 && Integer.parseInt(maximum_sdreader_capacity.getText()) >= 1 &&
                    Integer.parseInt(initial_button_producers.getText()) >= 1 && Integer.parseInt(initial_joystick_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_screen_producers.getText()) >= 1 && Integer.parseInt(initial_sdreader_producers.getText()) >= 1 &&
                    Integer.parseInt(max_button_producers.getText()) >= 1 && Integer.parseInt(max_joystick_producers.getText()) >= 1 &&
                    Integer.parseInt(max_screen_producers.getText()) >= 1 && Integer.parseInt(max_sdreader_producers.getText()) >= 1 &&
                    Integer.parseInt(initial_assemblers.getText()) >= 1 && Integer.parseInt(max_assemblers.getText()) >= 1) {
                
                write_txt();
                w1.setVisible(true);
                this.dispose();
                
            }else{
                JOptionPane.showMessageDialog(this, "Please review the information you entered. They must be integers greater than 0.");
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Please review the information you entered. They must be integers greater than 0.");
        }
    }//GEN-LAST:event_save_buttonMouseClicked

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        // TODO add your handling code here:
        w1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void seconds_of_a_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seconds_of_a_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seconds_of_a_dayActionPerformed

    private void days_between_shipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days_between_shipmentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_days_between_shipmentsActionPerformed

    private void maximum_button_capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximum_button_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maximum_button_capacityActionPerformed

    private void maximum_joystick_capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximum_joystick_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maximum_joystick_capacityActionPerformed

    private void maximum_screen_capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximum_screen_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maximum_screen_capacityActionPerformed

    private void maximum_sdreader_capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximum_sdreader_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maximum_sdreader_capacityActionPerformed

    private void initial_button_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initial_button_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initial_button_producersActionPerformed

    private void initial_joystick_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initial_joystick_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initial_joystick_producersActionPerformed

    private void initial_screen_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initial_screen_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initial_screen_producersActionPerformed

    private void initial_sdreader_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initial_sdreader_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initial_sdreader_producersActionPerformed

    private void max_button_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_max_button_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_max_button_producersActionPerformed

    private void max_joystick_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_max_joystick_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_max_joystick_producersActionPerformed

    private void max_screen_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_max_screen_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_max_screen_producersActionPerformed

    private void max_sdreader_producersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_max_sdreader_producersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_max_sdreader_producersActionPerformed

    private void initial_assemblersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initial_assemblersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initial_assemblersActionPerformed

    private void max_assemblersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_max_assemblersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_max_assemblersActionPerformed

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
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window2(w1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel back_button;
    private javax.swing.JTextField days_between_shipments;
    private javax.swing.JTextField initial_assemblers;
    private javax.swing.JTextField initial_button_producers;
    private javax.swing.JTextField initial_joystick_producers;
    private javax.swing.JTextField initial_screen_producers;
    private javax.swing.JTextField initial_sdreader_producers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField max_assemblers;
    private javax.swing.JTextField max_button_producers;
    private javax.swing.JTextField max_joystick_producers;
    private javax.swing.JTextField max_screen_producers;
    private javax.swing.JTextField max_sdreader_producers;
    private javax.swing.JTextField maximum_button_capacity;
    private javax.swing.JTextField maximum_joystick_capacity;
    private javax.swing.JTextField maximum_screen_capacity;
    private javax.swing.JTextField maximum_sdreader_capacity;
    private javax.swing.JLabel save_button;
    private javax.swing.JTextField seconds_of_a_day;
    // End of variables declaration//GEN-END:variables
}
