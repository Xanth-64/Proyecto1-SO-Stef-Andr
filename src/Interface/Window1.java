
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import Classes.Assembler;
import Classes.ButtProducer;
import Classes.Gerente;
import Classes.Jefe;
import Classes.JoyProducer;
import Classes.Limit;
import Classes.Nodo;
import Classes.RdProducer;
import Classes.ScrProducer;
import Classes.Stack;
import Classes.Storage;
import java.util.concurrent.Semaphore;

public class Window1 extends javax.swing.JFrame {
    
    
    public static volatile int timeInterval;
    public static volatile Limit companyLimit;
    public static volatile Storage companyStorage;
    public static volatile int contador;
    public static volatile Semaphore semaforoContador;
    public static volatile int limiteContador;

    //Block start
    public static boolean flag;
    
    //TXT
    public static int seconds_of_a_day;
    public static int days_between_shipments;
    public static int maximum_button_capacity;
    public static int maximum_joystick_capacity;
    public static int maximum_screen_capacity;
    public static int maximum_sdreader_capacity;
    public static int initial_button_producers;
    public static int initial_joystick_producers;
    public static int initial_screen_producers;
    public static int initial_sdreader_producers;
    public static int max_button_producers;
    public static int max_joystick_producers;
    public static int max_screen_producers;
    public static int max_sdreader_producers;
    public static int initial_assemblers;
    public static int max_assemblers;
    
    //Stacks
    public static Stack buttProducerStack;
    public static Stack joyProducerStack;
    public static Stack rdProducerStack;
    public static Stack scrProducerStack;
    public static Stack assemblerStack;
    
    /**
     * Creates new form Window1
     */
    public Window1() {
        initComponents();
        this.setLocationRelativeTo(null);
        flag = true;
        seconds_of_a_day = 24;
        days_between_shipments = 30;
        maximum_button_capacity = 45;
        maximum_joystick_capacity = 20;
        maximum_screen_capacity = 40;
        maximum_sdreader_capacity = 15;
        initial_button_producers = 1;
        initial_joystick_producers = 1;
        initial_screen_producers = 1;
        initial_sdreader_producers = 1;
        max_button_producers = 3;
        max_joystick_producers = 4;
        max_screen_producers = 5;
        max_sdreader_producers = 4;
        initial_assemblers = 1;
        max_assemblers = 5;
        leer_txt();
        this.setVisible(true);
        
    }
    
    public void leer_txt(){
        String line;
        String txt = "";
        String path = "test\\nintendo.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        txt += line + "\n";
                    }
                }
                
                if (!"".equals(txt)) {
                    String[] txt_split = txt.split("\n");
                    for (int i = 0; i < txt_split.length; i++) {
                        String[] data = txt_split[i].split(":");
                        if (data[0].contains("Time in seconds of a day")) {
                            seconds_of_a_day = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Number of days between shipments")){
                            days_between_shipments = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Button storage maximum capacity")){
                            maximum_button_capacity = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Joystick storage maximum capacity")){
                            maximum_joystick_capacity = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Screen storage maximum capacity")){
                            maximum_screen_capacity = Integer.parseInt(data[1]);
                        }else if(data[0].contains("SD reader storage maximum capacity")){
                            maximum_sdreader_capacity = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Initial number of button producers")){
                            initial_button_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Initial number of joystick producers")){
                            initial_joystick_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Initial number of screen producers")){
                            initial_screen_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Initial number of SD reader producers")){
                            initial_sdreader_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Maximum button producers")){
                            max_button_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Maximum joystick producers")){
                            max_joystick_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Maximum screen producers")){
                            max_screen_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Maximum SD reader producers")){
                            max_sdreader_producers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Initial number of assemblers")){
                            initial_assemblers = Integer.parseInt(data[1]);
                        }else if(data[0].contains("Maximum number of assemblers")){
                            max_assemblers = Integer.parseInt(data[1]);
                        }
                    }
                    if (    seconds_of_a_day >= 1 &&
                            initial_button_producers >= 0 &&
                            initial_joystick_producers >= 0 &&
                            initial_screen_producers >= 0 &&
                            initial_sdreader_producers >= 0 &&
                            initial_assemblers >= 0 &&
                            days_between_shipments >= 6 && 
                            maximum_button_capacity >= 5 &&
                            maximum_joystick_capacity >= 2 &&
                            maximum_screen_capacity >= 2 &&
                            maximum_sdreader_capacity >= 1 &&
                            initial_button_producers <= max_button_producers && 
                            initial_joystick_producers <= max_joystick_producers &&
                            initial_screen_producers <= max_screen_producers &&
                            initial_sdreader_producers <= max_sdreader_producers &&
                            initial_assemblers <= max_assemblers) {
                        
                    }else{
                        seconds_of_a_day = 24;
                        days_between_shipments = 30;
                        maximum_button_capacity = 45;
                        maximum_joystick_capacity = 20;
                        maximum_screen_capacity = 40;
                        maximum_sdreader_capacity = 15;
                        initial_button_producers = 1;
                        initial_joystick_producers = 1;
                        initial_screen_producers = 1;
                        initial_sdreader_producers = 1;
                        max_button_producers = 3;
                        max_joystick_producers = 4;
                        max_screen_producers = 5;
                        max_sdreader_producers = 4;
                        initial_assemblers = 1;
                        max_assemblers = 5;
                        JOptionPane.showMessageDialog(null, "Remember that the minimums cannot be greater than the maximums.\n"
                                                            + "The capacity must allow a minimum of 5 buttons, 2 screens, 2 joysticks and 1 SD reader.\n"
                                                            + "In addition, there must be a minimum of 6 days between shipments.\n"
                                                            + "The values ​​will be reset.");
                    }
                    
                    Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
                    Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
                    Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
                    Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
                    Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
                    Window1.getRemaining_days().setText(Integer.toString(days_between_shipments));
                    
                }
                br.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading the txt. The values ​​will be reset.");
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
            seconds_of_a_day = 24;
            days_between_shipments = 30;
            maximum_button_capacity = 45;
            maximum_joystick_capacity = 20;
            maximum_screen_capacity = 40;
            maximum_sdreader_capacity = 15;
            initial_button_producers = 1;
            initial_joystick_producers = 1;
            initial_screen_producers = 1;
            initial_sdreader_producers = 1;
            max_button_producers = 3;
            max_joystick_producers = 4;
            max_screen_producers = 5;
            max_sdreader_producers = 4;
            initial_assemblers = 1;
            max_assemblers = 5;
            
            Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
            Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
            Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
            Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
            Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
            Window1.getRemaining_days().setText(Integer.toString(days_between_shipments));
            
            PrintWriter pw = new PrintWriter("test\\nintendo.txt");
            pw.print(data);
            pw.close();
            
            }catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Sorry, there was a save error.");
            }
            
            
        }
        
    }
    
    public static javax.swing.JLabel getButtons() {
        return buttons;
    }
    
    public static javax.swing.JLabel getButton_producers() {
        return button_producers;
    }
    
    public static javax.swing.JLabel getJoysticks() {
        return joysticks;
    }
    
    public static javax.swing.JLabel getJoysticks_producers() {
        return joysticks_producers;
    }
    
    public static javax.swing.JLabel getScreens() {
        return screens;
    }
    
    public static javax.swing.JLabel getTouch() {
        return touch;
    }
    
    public static javax.swing.JLabel getScreen_producers() {
        return screen_producers;
    }
    
    public static javax.swing.JLabel getSD_readers() {
        return sd_readers;
    }
    
    public static javax.swing.JLabel getSD_reader_producers() {
        return sd_reader_producers;
    }
    
    public static javax.swing.JLabel getSDXL() {
        return sdxl;
    }
    
    public static javax.swing.JLabel getDays_passed() {
        return days_passed;
    }
    
    public static javax.swing.JLabel getRemaining_days() {
        return remaining_days;
    }

    public static javax.swing.JLabel getAssemblers() {
        return assemblers;
    }

    public static javax.swing.JLabel getBoss_status() {
        return boss_status;
    }

    public static javax.swing.JLabel getManager_status() {
        return manager_status;
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
        ButtonProduction = new javax.swing.JTabbedPane();
        Buttons = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        buttons = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ButtonProducers = new javax.swing.JPanel();
        add_button_producer = new javax.swing.JLabel();
        delete_button_producer = new javax.swing.JLabel();
        button_producers = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        JoystickProduction = new javax.swing.JTabbedPane();
        Joysticks = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        joysticks = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JoystickProducers = new javax.swing.JPanel();
        add_joystick_producer = new javax.swing.JLabel();
        joysticks_producers = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        delete_joystick_producer = new javax.swing.JLabel();
        ScreenProduction = new javax.swing.JTabbedPane();
        Screens = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        screens = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TouchScreens = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        touch = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ScreedProducers = new javax.swing.JPanel();
        add_screen_producer = new javax.swing.JLabel();
        screen_producers = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        delete_screen_producer = new javax.swing.JLabel();
        SDReaderProduction = new javax.swing.JTabbedPane();
        SDReaders = new javax.swing.JPanel();
        sd_readers = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SDRProducers1 = new javax.swing.JPanel();
        add_sdreaders_producer = new javax.swing.JLabel();
        sd_reader_producers = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        delete_sdreaders_producer = new javax.swing.JLabel();
        Employees = new javax.swing.JTabbedPane();
        Assemblers = new javax.swing.JPanel();
        assemblers = new javax.swing.JLabel();
        delete_assembler = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        add_assembler = new javax.swing.JLabel();
        Boss = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        boss_status = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Manager = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        manager_status = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        New15SDXL = new javax.swing.JTabbedPane();
        New = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sdxl = new javax.swing.JLabel();
        GoLive = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        days_passed = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        remaining_days = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_button = new javax.swing.JLabel();
        start_button = new javax.swing.JLabel();
        exit_button = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonProduction.setBackground(new java.awt.Color(255, 255, 255));

        Buttons.setBackground(new java.awt.Color(255, 255, 255));
        Buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Buttons produced:");
        Buttons.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, -1));

        buttons.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttons.setText("0");
        Buttons.add(buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buttons (1).png"))); // NOI18N
        Buttons.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, 80));

        ButtonProduction.addTab("Buttons", Buttons);

        ButtonProducers.setBackground(new java.awt.Color(255, 255, 255));
        ButtonProducers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_button_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        add_button_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_button_producerMouseClicked(evt);
            }
        });
        ButtonProducers.add(add_button_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 40));

        delete_button_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        delete_button_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_button_producerMouseClicked(evt);
            }
        });
        ButtonProducers.add(delete_button_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 40));

        button_producers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_producers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_producers.setText("0");
        ButtonProducers.add(button_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 70));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meowth.png"))); // NOI18N
        ButtonProducers.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 80));

        ButtonProduction.addTab("Producers", ButtonProducers);

        jPanel1.add(ButtonProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 180));
        ButtonProduction.getAccessibleContext().setAccessibleName("ButtonProduction");

        JoystickProduction.setBackground(new java.awt.Color(255, 255, 255));

        Joysticks.setBackground(new java.awt.Color(255, 255, 255));
        Joysticks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Joysticks produced:");
        Joysticks.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, -1, -1));

        joysticks.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        joysticks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joysticks.setText("0");
        Joysticks.add(joysticks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/joystick (1).png"))); // NOI18N
        Joysticks.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 70, 80));

        JoystickProduction.addTab("Joysticks", Joysticks);

        JoystickProducers.setBackground(new java.awt.Color(255, 255, 255));
        JoystickProducers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_joystick_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        add_joystick_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_joystick_producerMouseClicked(evt);
            }
        });
        JoystickProducers.add(add_joystick_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 40));

        joysticks_producers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        joysticks_producers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joysticks_producers.setText("0");
        JoystickProducers.add(joysticks_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 70));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eevee.png"))); // NOI18N
        JoystickProducers.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 80));

        delete_joystick_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        delete_joystick_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_joystick_producerMouseClicked(evt);
            }
        });
        JoystickProducers.add(delete_joystick_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 40));

        JoystickProduction.addTab("Producers", JoystickProducers);

        jPanel1.add(JoystickProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 180, 180));

        ScreenProduction.setBackground(new java.awt.Color(255, 255, 255));

        Screens.setBackground(new java.awt.Color(255, 255, 255));
        Screens.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Screens produced:");
        Screens.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        screens.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        screens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screens.setText("0");
        Screens.add(screens, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tablet.png"))); // NOI18N
        Screens.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 60, 80));

        ScreenProduction.addTab("Screens", Screens);

        TouchScreens.setBackground(new java.awt.Color(255, 255, 255));
        TouchScreens.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Touch screens produced:");
        TouchScreens.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        touch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        touch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        touch.setText("0");
        TouchScreens.add(touch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 60));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mobile-phone (1).png"))); // NOI18N
        TouchScreens.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 60, 80));

        ScreenProduction.addTab("Touch", TouchScreens);

        ScreedProducers.setBackground(new java.awt.Color(255, 255, 255));
        ScreedProducers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_screen_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        add_screen_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_screen_producerMouseClicked(evt);
            }
        });
        ScreedProducers.add(add_screen_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 40));

        screen_producers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        screen_producers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screen_producers.setText("0");
        ScreedProducers.add(screen_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 70));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/charmander.png"))); // NOI18N
        ScreedProducers.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, 80));

        delete_screen_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        delete_screen_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_screen_producerMouseClicked(evt);
            }
        });
        delete_screen_producer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                delete_screen_producerKeyPressed(evt);
            }
        });
        ScreedProducers.add(delete_screen_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 40));

        ScreenProduction.addTab("Producers", ScreedProducers);

        jPanel1.add(ScreenProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 230, 180));

        SDReaderProduction.setBackground(new java.awt.Color(255, 255, 255));

        SDReaders.setBackground(new java.awt.Color(255, 255, 255));
        SDReaders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sd_readers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sd_readers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sd_readers.setText("0");
        SDReaders.add(sd_readers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tarjeta-sd.png"))); // NOI18N
        SDReaders.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 60, 80));

        jLabel9.setText("SD readers produced:");
        SDReaders.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        SDReaderProduction.addTab("SD Readers", SDReaders);

        SDRProducers1.setBackground(new java.awt.Color(255, 255, 255));
        SDRProducers1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_sdreaders_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        add_sdreaders_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_sdreaders_producerMouseClicked(evt);
            }
        });
        SDRProducers1.add(add_sdreaders_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 40));

        sd_reader_producers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sd_reader_producers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sd_reader_producers.setText("0");
        SDRProducers1.add(sd_reader_producers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 70));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/psyduck_1.png"))); // NOI18N
        SDRProducers1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 80));

        delete_sdreaders_producer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        delete_sdreaders_producer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_sdreaders_producerMouseClicked(evt);
            }
        });
        SDRProducers1.add(delete_sdreaders_producer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 40));

        SDReaderProduction.addTab("Producers", SDRProducers1);

        jPanel1.add(SDReaderProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 180, 180));

        Employees.setBackground(new java.awt.Color(255, 255, 255));

        Assemblers.setBackground(new java.awt.Color(255, 255, 255));
        Assemblers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assemblers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        assemblers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblers.setText("0");
        Assemblers.add(assemblers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 70));

        delete_assembler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minus.png"))); // NOI18N
        delete_assembler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_assemblerMouseClicked(evt);
            }
        });
        Assemblers.add(delete_assembler, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teamwork.png"))); // NOI18N
        Assemblers.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, 80));

        add_assembler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        add_assembler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_assemblerMouseClicked(evt);
            }
        });
        Assemblers.add(add_assembler, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 40));

        Employees.addTab("Assemblers", Assemblers);

        Boss.setBackground(new java.awt.Color(255, 255, 255));
        Boss.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/snorlax.png"))); // NOI18N
        Boss.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 70, 80));

        boss_status.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boss_status.setText("Sleeping");
        Boss.add(boss_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel26.setText("State:");
        Boss.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        Employees.addTab("Boss", Boss);

        Manager.setBackground(new java.awt.Color(255, 255, 255));
        Manager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("State:");
        Manager.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        manager_status.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        manager_status.setText("Sleeping");
        Manager.add(manager_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pikachu (1).png"))); // NOI18N
        Manager.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 70, 80));

        Employees.addTab("Manager", Manager);

        jPanel1.add(Employees, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 230, 180));

        New15SDXL.setBackground(new java.awt.Color(255, 255, 255));

        New.setBackground(new java.awt.Color(255, 255, 255));
        New.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("New 15SD XL produced:");
        New.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chico-del-juego (1).png"))); // NOI18N
        New.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 60, 80));

        sdxl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sdxl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sdxl.setText("0");
        New.add(sdxl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 60));

        New15SDXL.addTab("New 15SD XL", New);

        GoLive.setBackground(new java.awt.Color(255, 255, 255));
        GoLive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chronometer.png"))); // NOI18N
        GoLive.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 80));

        days_passed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        days_passed.setText("0");
        GoLive.add(days_passed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel30.setText("Days passed:");
        GoLive.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        remaining_days.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remaining_days.setText("0");
        GoLive.add(remaining_days, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 20, -1));

        jLabel40.setText("Remaining days:");
        GoLive.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        New15SDXL.addTab("Go Live", GoLive);

        jPanel1.add(New15SDXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 180, 180));

        txt_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/txt.png"))); // NOI18N
        txt_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_buttonMouseClicked(evt);
            }
        });
        jPanel1.add(txt_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, -1, 70));

        start_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play.png"))); // NOI18N
        start_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                start_buttonMouseClicked(evt);
            }
        });
        jPanel1.add(start_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, -1, 70));

        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit (1).png"))); // NOI18N
        exit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_buttonMouseClicked(evt);
            }
        });
        jPanel1.add(exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nintendo (5).png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 700, 110));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background3.jpg"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void exit_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_buttonMouseClicked

    private void start_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_buttonMouseClicked
        // TODO add your handling code here:
        if (flag) {
            flag = false;
            timeInterval = (seconds_of_a_day/24)*1000; //timeInterval = (seconds_of_a_day/24)*1000;
            limiteContador = days_between_shipments; //limiteContador = 5;
            semaforoContador = new Semaphore(1,true);
            contador = 0;
            companyLimit = new Limit(maximum_screen_capacity,maximum_button_capacity,maximum_joystick_capacity,maximum_sdreader_capacity); //companyLimit = new Limit(20,20,20,20);
            companyStorage = new Storage(0,0,0,0,0,0);

            Gerente bob = new Gerente();
            Jefe john = new Jefe();

            Thread G1 = new Thread(bob);
            Thread J1 = new Thread(john);

            J1.start();
            G1.start();
            
            buttProducerStack = new Stack();           
            for (int i = 0; i < initial_button_producers; i++) {
                ButtProducer Butt = new ButtProducer();
                Butt.start();
                Nodo ButtNode = new Nodo(Butt);
                buttProducerStack.push(ButtNode);
            }
            joyProducerStack = new Stack();           
            for (int i = 0; i < initial_joystick_producers; i++) {
                JoyProducer Joy = new JoyProducer();
                Joy.start();
                Nodo JoyNode = new Nodo(Joy);
                joyProducerStack.push(JoyNode);
            }
            rdProducerStack = new Stack();           
            for (int i = 0; i < initial_sdreader_producers; i++) {
                RdProducer Rd = new RdProducer();
                Rd.start();
                Nodo RdNode = new Nodo(Rd);
                rdProducerStack.push(RdNode);
            }
            scrProducerStack = new Stack();           
            for (int i = 0; i < initial_screen_producers; i++) {
                ScrProducer Scr = new ScrProducer();
                Scr.start();
                Nodo ScrNode = new Nodo(Scr);
                scrProducerStack.push(ScrNode);
            }
            assemblerStack = new Stack();           
            for (int i = 0; i < initial_assemblers; i++) {
                Assembler Ass = new Assembler();
                Ass.start();
                Nodo AssNode = new Nodo(Ass);
                assemblerStack.push(AssNode);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Production has already started.");
        }
    }//GEN-LAST:event_start_buttonMouseClicked

    private void txt_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buttonMouseClicked
        // TODO add your handling code here:
        Window2 w2 = new Window2(this);
    }//GEN-LAST:event_txt_buttonMouseClicked

    private void add_button_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_button_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(!(initial_button_producers >= max_button_producers)){
                initial_button_producers++;
                Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }else{
            if (!(initial_button_producers >= max_button_producers)) {
                initial_button_producers++;
                Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
                ButtProducer Butt = new ButtProducer();   
                Butt.start();
                Nodo nodo = new Nodo(Butt);
                buttProducerStack.push(nodo);
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }
    }//GEN-LAST:event_add_button_producerMouseClicked

    private void add_screen_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_screen_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(!(initial_screen_producers >= max_screen_producers)){
                initial_screen_producers++;
                Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }else{
            if (!(initial_screen_producers >= max_screen_producers)) {
                initial_screen_producers++;
                Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
                ScrProducer Scr = new ScrProducer();
                Scr.start();
                Nodo nodo = new Nodo(Scr);
                scrProducerStack.push(nodo);
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }
    }//GEN-LAST:event_add_screen_producerMouseClicked

    private void add_sdreaders_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_sdreaders_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(!(initial_sdreader_producers >= max_sdreader_producers)){
                initial_sdreader_producers++;
                Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }else{
            if (!(initial_sdreader_producers >= max_sdreader_producers)) {
                initial_sdreader_producers++;
                Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
                RdProducer Rd = new RdProducer();
                Rd.start();
                Nodo nodo = new Nodo(Rd);
                rdProducerStack.push(nodo);
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }
    }//GEN-LAST:event_add_sdreaders_producerMouseClicked

    private void add_assemblerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_assemblerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(!(initial_assemblers >= max_assemblers)){
                initial_assemblers++;
                Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }else{
            if (!(initial_assemblers >= max_assemblers)) {
                initial_assemblers++;
                Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
                Assembler Ass = new Assembler();
                Ass.start();
                Nodo nodo = new Nodo(Ass);
                assemblerStack.push(nodo);
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }
    }//GEN-LAST:event_add_assemblerMouseClicked

    private void add_joystick_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_joystick_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(!(initial_joystick_producers >= max_joystick_producers)){
                initial_joystick_producers++;
                Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }else{
            if (!(initial_joystick_producers >= max_joystick_producers)) {
                initial_joystick_producers++;
                Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
                JOptionPane.showMessageDialog(this, "Producer added successfully.");
                JoyProducer Joy = new JoyProducer();
                Joy.start();
                Nodo nodo = new Nodo(Joy);
                joyProducerStack.push(nodo);
            }else{
                JOptionPane.showMessageDialog(this, "The limit of producers has been reached.");
            }
        }
    }//GEN-LAST:event_add_joystick_producerMouseClicked

    private void delete_button_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_button_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(initial_button_producers >= 1){
                initial_button_producers--;
                Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }else{
            if(initial_button_producers >= 1){
                initial_button_producers--;
                Window1.getButton_producers().setText(Integer.toString(initial_button_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
                Nodo head = buttProducerStack.getHead();
                if(head.getButt().isCreating()){
                    head.getButt().setExecute(false);
                }
                else{
                    head.getButt().interrupt();
                }
                buttProducerStack.pop();
                
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }
    }//GEN-LAST:event_delete_button_producerMouseClicked

    private void delete_joystick_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_joystick_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(initial_joystick_producers >= 1){
                initial_joystick_producers--;
                Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }else{
            if(initial_joystick_producers >= 1){
                initial_joystick_producers--;
                Window1.getJoysticks_producers().setText(Integer.toString(initial_joystick_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
                Nodo head = joyProducerStack.getHead();
                if(head.getJoy().isCreating()){
                    head.getJoy().setExecute(false);
                }
                else{
                    head.getJoy().interrupt();
                }
                joyProducerStack.pop();
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }
    }//GEN-LAST:event_delete_joystick_producerMouseClicked

    private void delete_screen_producerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_delete_screen_producerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_screen_producerKeyPressed

    private void delete_screen_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_screen_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(initial_screen_producers >= 1){
                initial_screen_producers--;
                Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }else{
            if(initial_screen_producers >= 1){
                initial_screen_producers--;
                Window1.getScreen_producers().setText(Integer.toString(initial_screen_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
                Nodo head = scrProducerStack.getHead();
                if(head.getScr().isCreating()){
                    head.getScr().setExecute(false);
                }
                else{
                    head.getScr().interrupt();
                }
                scrProducerStack.pop();
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }
    }//GEN-LAST:event_delete_screen_producerMouseClicked

    private void delete_assemblerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_assemblerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(initial_assemblers >= 1){
                initial_assemblers--;
                Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }else{
            if(initial_assemblers >= 1){
                initial_assemblers--;
                Window1.getAssemblers().setText(Integer.toString(initial_assemblers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
                Nodo head = assemblerStack.getHead();
                if (head.getAssemble().isAssembled()){
                    head.getAssemble().setExecute(false);
                }
                else{
                    head.getAssemble().interrupt();
                }
                assemblerStack.pop();
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }
    }//GEN-LAST:event_delete_assemblerMouseClicked

    private void delete_sdreaders_producerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_sdreaders_producerMouseClicked
        // TODO add your handling code here:
        if (flag) {
            if(initial_sdreader_producers >= 1){
                initial_sdreader_producers--;
                Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }else{
            if(initial_sdreader_producers >= 1){
                initial_sdreader_producers--;
                Window1.getSD_reader_producers().setText(Integer.toString(initial_sdreader_producers));
                JOptionPane.showMessageDialog(this, "Producer deleted successfully.");
                Nodo head = rdProducerStack.getHead();
                if(head.getRd().isCreating()){
                    head.getRd().setExecute(false);
                }
                else{
                    head.getRd().interrupt();
                }
                rdProducerStack.pop();
            }else{
                JOptionPane.showMessageDialog(this, "There cannot be a negative amount of producers.");
            }
        }
    }//GEN-LAST:event_delete_sdreaders_producerMouseClicked

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
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
  
                new Window1().setVisible(true);
                
 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Assemblers;
    private javax.swing.JLabel Background;
    private javax.swing.JPanel Boss;
    private javax.swing.JPanel ButtonProducers;
    private javax.swing.JTabbedPane ButtonProduction;
    private javax.swing.JPanel Buttons;
    private javax.swing.JTabbedPane Employees;
    private javax.swing.JPanel GoLive;
    private javax.swing.JPanel JoystickProducers;
    private javax.swing.JTabbedPane JoystickProduction;
    private javax.swing.JPanel Joysticks;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Manager;
    private javax.swing.JPanel New;
    private javax.swing.JTabbedPane New15SDXL;
    private javax.swing.JPanel SDRProducers1;
    private javax.swing.JTabbedPane SDReaderProduction;
    private javax.swing.JPanel SDReaders;
    private javax.swing.JPanel ScreedProducers;
    private javax.swing.JTabbedPane ScreenProduction;
    private javax.swing.JPanel Screens;
    private javax.swing.JPanel TouchScreens;
    private javax.swing.JLabel add_assembler;
    private javax.swing.JLabel add_button_producer;
    private javax.swing.JLabel add_joystick_producer;
    private javax.swing.JLabel add_screen_producer;
    private javax.swing.JLabel add_sdreaders_producer;
    protected static volatile javax.swing.JLabel assemblers;
    protected static volatile javax.swing.JLabel boss_status;
    protected static volatile javax.swing.JLabel button_producers;
    protected static volatile javax.swing.JLabel buttons;
    protected static volatile javax.swing.JLabel days_passed;
    private javax.swing.JLabel delete_assembler;
    private javax.swing.JLabel delete_button_producer;
    private javax.swing.JLabel delete_joystick_producer;
    private javax.swing.JLabel delete_screen_producer;
    private javax.swing.JLabel delete_sdreaders_producer;
    private javax.swing.JLabel exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    protected static volatile javax.swing.JLabel joysticks;
    protected static volatile javax.swing.JLabel joysticks_producers;
    protected static volatile javax.swing.JLabel manager_status;
    protected static volatile javax.swing.JLabel remaining_days;
    protected static volatile javax.swing.JLabel screen_producers;
    protected static volatile javax.swing.JLabel screens;
    protected static volatile javax.swing.JLabel sd_reader_producers;
    protected static volatile javax.swing.JLabel sd_readers;
    protected static volatile javax.swing.JLabel sdxl;
    private javax.swing.JLabel start_button;
    protected static volatile javax.swing.JLabel touch;
    private javax.swing.JLabel txt_button;
    // End of variables declaration//GEN-END:variables
}
