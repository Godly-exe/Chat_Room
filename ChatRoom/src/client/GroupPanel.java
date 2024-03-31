/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package client;

import static client.ChatPanel.chatPanel;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import temp.FriendMenu;
import temp.GroupDTO;
import temp.ObjectSend;

/**
 *
 * @author lpphu
 */
public class GroupPanel extends javax.swing.JPanel implements MouseListener{
    
    public static ArrayList<GroupDTO> arrayGroup = new ArrayList<>();
    private ArrayList<FriendMenu> navObj = new ArrayList<>();
    /**
     * Creates new form ChatPanel
     */
    public GroupPanel() {
        initComponents();
        leftmenu();
//        navObj.get(0).doActive();
        //user_emailLB.setText(OverrallFrame.userEmail);
        //active
        if(!GroupChatPanel.currentGroupId.equals(""))
        {
            for(FriendMenu a : navObj)
            {
                //System.out.println(a.getCurrent() + ":" + SingleChatPanel.currentEmail);
                if(a.getCurrent().equals(GroupChatPanel.currentGroupId))
                {
                    a.doActive();
                    break;
                }
            }
        }
        groupPanel.setPreferredSize(new Dimension(220, arrayGroup.size()*55));
    }
    
    private void leftmenu() {
        if(!arrayGroup.isEmpty())
        {
        for(int i = 0; i< arrayGroup.size(); i++)
        {  
            navObj.add(new FriendMenu(arrayGroup.get(i).getGroup_name(), new Dimension(220, 50), "icons8-management-20.png",
            Integer.toString(arrayGroup.get(i).getGroup_id()), arrayGroup.get(i).getGroup_name(), Integer.toString(arrayGroup.get(i).getGroup_id())));
            navObj.get(i).addMouseListener(this);
            //duyet mang menu
            for (FriendMenu n : navObj) 
            {
                groupPanel.add(n);//add vao thanh menu
            }
            groupPanel.repaint();
            groupPanel.revalidate();
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
        jPanel2 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        user_emailLB = new javax.swing.JLabel();
        addGroup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupPanel = new javax.swing.JPanel();
        chatPanel = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(51, 204, 255));

        user_emailLB.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        user_emailLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_emailLB.setText("GROUP LIST");

        addGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-20.png"))); // NOI18N
        addGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_emailLB, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_emailLB, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(addGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        groupPanel.setBackground(new java.awt.Color(0, 102, 153));
        jScrollPane1.setViewportView(groupPanel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 560));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        chatPanel.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel1.add(chatPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 580, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupActionPerformed
        // TODO add your handling code here:
        AddGroupDialog a = new AddGroupDialog();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
    }//GEN-LAST:event_addGroupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroup;
    public static javax.swing.JPanel chatPanel;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel user_emailLB;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i< navObj.size(); i++)
            {
                FriendMenu item = navObj.get(i);
                if(e.getSource().equals(item))
                    {
                        item.doActive(); // Active NavItem đc chọn 
                        ObjectSend obj = new ObjectSend("get_group_chat_panel", item.getChatId(), item.getTarget());
                        OverrallFrame.write(obj);
                    }
                else
                    {
                        item.noActive();
                    }
            }
    }
    public static void loadChat()
    {       
        chatPanel.removeAll();
        JPanel p = new GroupChatPanel();  
        p.setSize(500,600);
        chatPanel.add(p);
        chatPanel.repaint();
        chatPanel.revalidate();
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
