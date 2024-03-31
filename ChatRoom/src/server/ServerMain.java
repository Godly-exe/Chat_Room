/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package server;

import client.FormatTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import temp.ObjectSend;

/**
 *
 * @author lpphu
 */
public class ServerMain extends javax.swing.JFrame {

    static int totalUser = 0, totalUserOnl = 0;
    static boolean isStop = false;
    ServerSocket server;
    Socket socket;
    BufferedReader is;
    BufferedWriter os;
    int id;
    List<ServerThread> listTh;
    static List<User> listUser;
    ArrayList<String> listSendCode;
    Timer timer;
    cipher c = new cipher();
    Thread sThread;

    /**
     * Creates new form ServerMain
     */
    public ServerMain() throws Exception {
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        totaluseronl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totaluser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        broadcast = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(880, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(880, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Broadcast:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 100, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 247, 490, 330));

        log.setColumns(20);
        log.setRows(5);
        jScrollPane2.setViewportView(log);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 370, 320));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-checklist-20.png"))); // NOI18N
        jLabel4.setText("DANH SÁCH USER");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 180, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("IP:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 30, 40));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 160, 30));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 180, 30));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 70, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SERVER");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        totaluseronl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        totaluseronl.setText("USER ONLINE: 0");
        jPanel2.add(totaluseronl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("STATUS: OFF");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        totaluser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        totaluser.setText("TỔNG USER: 0");
        jPanel2.add(totaluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 180));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-hand-with-pen-20.png"))); // NOI18N
        jLabel7.setText("LOGS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 180, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("PORT:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 60, 40));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 300, 90));

        broadcast.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        broadcast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-customer-support-20.png"))); // NOI18N
        broadcast.setText("Broadcast");
        broadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                broadcastActionPerformed(evt);
            }
        });
        jPanel1.add(broadcast, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-do-not-disturb-20.png"))); // NOI18N
        jButton4.setText("Block");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 100, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        sThread = new Thread() {
            //boolean isStop=false;
            //super.run();
            public void run() {
                try {
                    loadUserOnl();
                    jTextField3.setText(Inet4Address.getLocalHost().getHostAddress());
                    jTextField2.setText("9999");
                    jLabel8.setText("STATUS: ON");
                    setIPServer();
                    listTh = new ArrayList<>();
                    listSendCode = new ArrayList<>();
                    server = new ServerSocket(9999);
                    timer = new Timer();
                    c = new cipher();
                    while (!isStop) {
                        System.out.println(isStop);
                        socket = server.accept();
                        ServerThread a = new ServerThread(socket, null);
                        listTh.add(a);
                        new Thread(a).start();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        };
        sThread.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() > -1) {
            try {
                if (JOptionPane.showConfirmDialog(this, "Block User?", "WARNING",
                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                                {

                MyDBConnection con = new MyDBConnection();
                String query = "UPDATE `user` SET `user_status`=3 where `user_id`='" + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() + "'";
                con.executeUpdate(query);
                con.close();
                
                if(Handler.serverThreadBus.getEmailList().contains(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()))
                {
                ObjectSend obj = new ObjectSend("ban");
                Handler.serverThreadBus.sendOneUser(obj, jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                }
                loadUserOnl();                }
            } catch (Exception e) {
                e.printStackTrace();
                //send("login-fail");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chon user can block");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void broadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_broadcastActionPerformed
        // TODO add your handling code here:
        String mess = jTextArea2.getText();
        ObjectSend obj = new ObjectSend("server_broadcast", ObjectSend.getCurrentTime() +" - SERVER: "+ mess);
        Handler.serverThreadBus.sendAll(obj);
    }//GEN-LAST:event_broadcastActionPerformed

    public static void loadUserOnl() {
        try
        {
        MyDBConnection con = new MyDBConnection();
        listUser = new ArrayList();
        try {
            String query = "select * from user";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getString("user_id"), rs.getString("user_password"), rs.getString("user_email"), rs.getString("user_birthday"),
                        rs.getString("user_phone"), rs.getString("user_gender"), rs.getString("user_createday"), rs.getString("user_name"), rs.getString("user_status"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        FormatTable a = new FormatTable();
        a.formatTablenoIcon(jTable1);
        String[] header = {"ID", "Name", "Email", "Status"};
        DefaultTableModel model = new DefaultTableModel(header, 0) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jTable1.setSelectionMode(SINGLE_SELECTION);
        jTable1.setModel(model);
        totalUser = listUser.size();
        totaluser.setText("TỔNG USER : " + totalUser);
        for (User user : listUser) {
            String status;
            if (user.getStatus().equals("1")) {
                status = "Online";
            } else if (user.getStatus().equals("2")) {
                status = "Offline";
            } else {
                status = "Block";
            }
            Object[] data = {user.getId(), user.getName(), user.getEmail(), status};
            model.addRow(data);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        con.close();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setIPServer()
    {
        try
        {
            Socket socket = new Socket("youtube.com", 80);
        String localIP = socket.getLocalAddress().toString().substring(1);
        String api = "https://api-generator.retool.com/CYBXDG/data/1";
        String data = "{\"ip\":\"" + localIP + "\"}";
        Jsoup.connect(api).ignoreContentType(true).ignoreHttpErrors(true)
                .header("Content-Type", "application/json").requestBody(data)
                .method(Connection.Method.PUT)
                .execute();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    class ServerThread implements Runnable {

        private Socket socket;
        private BufferedReader is;
        private BufferedWriter os;
        private boolean isClosed;
        private String key, msg, username;
        

        public ServerThread(Socket socket, String username) {
            this.socket = socket;
            this.username = username;
            isClosed = false;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Socket getSocket() {
            return socket;
        }

        public void setSocket(Socket socket) {
            this.socket = socket;
        }

        public BufferedReader getIs() {
            return is;
        }

        public void setIs(BufferedReader is) {
            this.is = is;
        }

        public BufferedWriter getOs() {
            return os;
        }

        public void setOs(BufferedWriter os) {
            this.os = os;
        }

        public boolean isIsClosed() {
            return isClosed;
        }

        public void setIsClosed(boolean isClosed) {
            this.isClosed = isClosed;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public void run() {
            try {
                System.out.println("Khời động luông mới thành công" + socket);
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.key = generateCode(9);
                send(key);
                while (!isStop) {
                    msg = c.decrypt(is.readLine(), key);
                    String[] temp = msg.split("-");
                    if (temp[0].equals("login")) {//login
                        MyDBConnection con = new MyDBConnection();
                        try {
                            String query = "SELECT * FROM `user` WHERE user_email='" + temp[1] + "' and user_password='" + md5(temp[2]) + "'";
                            ResultSet rs = con.executeQuery(query);
                            if (rs.next()) {
                                //System.out.println(rs.getInt("user_status"));
                                if(rs.getInt("user_status") != 3)
                                {
                                if(checkExistEmail(temp[1]))
                                {
                                    ObjectSend obj = new ObjectSend("login_duplicate");
                                    Handler.serverThreadBus.sendOneUser(obj, temp[1]);
                                }
                                String query2 = "UPDATE `user` SET `user_status`=1 WHERE user_email='" + temp[1] + "'";
                                con.executeUpdate(query2);
                                send(c.encrypt("login-sucess", key));
                                //send("login-sucess");
                                Handler handler = new Handler(socket, temp[1], key);
                                Thread th = new Thread(handler);
                                th.start();
                                System.out.println("ok");
                                con.close();
                                updateTotalUserOnl(true);
                                this.setUsername(temp[1]);
                                wirteLog(ObjectSend.getCurrentTime() + ": " + temp[1] + " đã login");
                                loadUserOnl();
                                break;
                                } else {
                                    send(c.encrypt("block", key));
                                }
                            }
                            else {
                                send(c.encrypt("login-fail", key));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            
                            //send("login-fail");
                        }
                    } else if (temp[0].equals("signup")) {//signup
                        if (checkCodeOTP(temp[3], temp[4])) {
                            try {

                                MyDBConnection con = new MyDBConnection();
                                String query = "INSERT INTO `user`(`user_email`, `user_password`, `user_name` ,`user_createday`,`user_status`) "
                                        + "VALUES ('" + temp[3] + "','" + md5(temp[2]) + "','" + temp[1] + "','" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "',0)";
                                con.executeUpdate(query);
                                con.close();
                                removeEmail(temp[3]);
                                //send("signup-success");
                                send(c.encrypt("signup-success", key));
                                wirteLog(ObjectSend.getCurrentTime() + ": " + temp[3] + " đã đăng ký");
                                updateTotalUser();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            //send("signup-fail");
                            send(c.encrypt("signup-fail", key));
                        }
                    } else if (temp[0].equals("sendcode")) { //code otp
                        if (!checkEmail(temp[1])) {
                            if (checkCode(temp[1])) {
                                //send("send-fail");
                                send(c.encrypt("send-fail", key));
                            } else {
                                Calendar time = Calendar.getInstance();
                                time.add(Calendar.MINUTE, 10);
                                String code = generateCode(9);
                                listSendCode.add(temp[1] + "-" + code);
                                timer.schedule(new freeEmail(), time.getTime());
                                //send("send-success");
                                send(c.encrypt("send-success", key));
                                new Email().sendMail(temp[1], code);
                            }
                        } else {
                            //send("sendmail-fail");
                            send(c.encrypt("sendmail-fail", key));
                        }
                    } else if (temp[0].equals("logut")) {
                        updateTotalUserOnl(false);
                    } else if (msg.equals("backlogin")) {
                        updateTotalUserOnl(false);
                        //send("login");
                        send(c.encrypt("login", key));
                    }
                }
            } catch (IOException e) {
                isStop = true;
                //ServerMain.updateTotalUserOnl(false);
                if (this.username != null) {
                    wirteLog(ObjectSend.getCurrentTime() + ": " + this.username + " đã logout");
                }
            }
        }

        void send(String message) throws IOException {
            os.write(message);
            os.newLine();
            os.flush();
        }

        void stop() {
            isClosed = true;
        }
    }

    String md5(String msg) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] mdByte = md.digest(msg.getBytes());
        BigInteger no = new BigInteger(1, mdByte);
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    public boolean checkExistEmail(String email)
    {
        boolean check = false;
        ArrayList<String> arr = Handler.serverThreadBus.getEmailList();
        for(String mail : arr)
        {
            if(mail.equals(email))
            {
                check = true;
                break;
            }
        }
        return check;
    }

    boolean checkEmail(String email) {
        try {
            MyDBConnection con = new MyDBConnection();
            String query = "select * from user where user_email='" + email + "'";
            ResultSet rs = con.executeQuery(query);
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    boolean checkCode(String email) {
        if (listSendCode.size() == 0) {
            return false;
        } else {
            for (String s : listSendCode) {
                String temp[] = s.split("-");
                if (temp[0].equals(email)) {
                    return true;
                }
            }
            return false;
        }
    }

    boolean checkCodeOTP(String email, String OTP) {
        if (listSendCode.size() == 0) {
            return false;
        } else {
            for (String s : listSendCode) {
                String temp[] = s.split("-");
                if (temp[0].equals(email) && temp[1].equals(OTP)) {
                    return true;
                }
            }
            return false;
        }
    }

    String generateCode(int chuso) {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chuso; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    static int randomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    class freeEmail extends TimerTask {

        @Override
        public void run() {
            listSendCode.remove(0);
        }

    }

    void removeEmail(String email) {
        for (String s : listSendCode) {
            String temp[] = s.split("-");
            if (temp[0].equals(email)) {
                listSendCode.remove(s);
                break;
            }
        }
    }

    public static void wirteLog(String msg) {
        try {
            log.setText(log.getText() + msg + "\n");
            FileWriter fw = new FileWriter("src\\server\\logs.txt", true);
            fw.write(msg + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void updateTotalUser() {
        totalUser += 1;
        totaluser.setText("TỔNG USER: " + totalUser);
    }

    public static void updateTotalUserOnl(boolean status) {
        if (status) {
            totalUserOnl += 1;
            totaluseronl.setText("USER ONLINE: " + totalUserOnl);
        } else {
//            if(totalUserOnl >0)
//            {
            totalUserOnl -= 1;
            totaluseronl.setText("USER ONLINE: " + totalUserOnl);
//            }
        }
    }

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
            java.util.logging.Logger.getLogger(ServerMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ServerMain().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton broadcast;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private static javax.swing.JTextArea log;
    public static javax.swing.JLabel totaluser;
    private static javax.swing.JLabel totaluseronl;
    // End of variables declaration//GEN-END:variables

}
