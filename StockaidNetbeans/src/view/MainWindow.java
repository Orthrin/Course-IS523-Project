package view;

import domain.Store;
import javax.swing.*;
import java.awt.Toolkit;
import java.util.Date;
import javax.sql.rowset.spi.SyncProvider;

public class MainWindow extends javax.swing.JFrame {

    // Instatantiation
    Store inventory;
    DefaultListModel catalogModel = new DefaultListModel();
    
    private JLabel secondEntry;
    private JLabel thirdEntry;
    
    boolean isManagingProducts = false;
    boolean isManagingSuppliers = false;
    
    int managementMode = 1;
    
    // Constructor
    public MainWindow(Store inventory) {
        initComponents();
        this.inventory = inventory;
        this.catalogIC.setModel(catalogModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createIU = new javax.swing.JButton();
        updateIU = new javax.swing.JButton();
        deleteIU = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        catalogIC = new javax.swing.JList<>();
        authenticatioonSU = new javax.swing.JLabel();
        manageOrdersIU = new javax.swing.JButton();
        manageSuppliersIU = new javax.swing.JButton();
        manageProductsIU = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionIA = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        getIU = new javax.swing.JButton();
        commandSC = new javax.swing.JLabel();
        firstInputText = new javax.swing.JLabel();
        firstInputField = new javax.swing.JTextField();
        secondInputText = new javax.swing.JLabel();
        secondInputField = new javax.swing.JTextField();
        thirdInputField = new javax.swing.JTextField();
        thirdInputText = new javax.swing.JLabel();
        idSC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createIU.setText("+");
        createIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createIUActionPerformed(evt);
            }
        });

        updateIU.setText("Update");
        updateIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIUActionPerformed(evt);
            }
        });

        deleteIU.setText("Delete");
        deleteIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIUActionPerformed(evt);
            }
        });

        catalogIC.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(catalogIC);

        authenticatioonSU.setText("Login Identification Text");

        manageOrdersIU.setText("Manage Orders");
        manageOrdersIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrdersIUActionPerformed(evt);
            }
        });

        manageSuppliersIU.setText("Manage Suppliers");
        manageSuppliersIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSuppliersIUActionPerformed(evt);
            }
        });

        manageProductsIU.setText("Manage Products");
        manageProductsIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductActionPerformed(evt);
            }
        });

        jLabel1.setText("ID :");

        descriptionIA.setColumns(20);
        descriptionIA.setRows(5);
        descriptionIA.setText("enter description about product\n");
        jScrollPane1.setViewportView(descriptionIA);

        jLabel2.setText("Description");

        getIU.setText("Get");
        getIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getIUActionPerformed(evt);
            }
        });

        commandSC.setText("Please select item(s)");

        firstInputText.setText("Minimum Stock Level");

        firstInputField.setText("enter minimum stock level");
        firstInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstInputFieldActionPerformed(evt);
            }
        });

        secondInputText.setText("Maximum  Stock Level");

        secondInputField.setText("enter maximum stock level");

        thirdInputField.setText("enter current stock level");

        thirdInputText.setText("Current Stock Level");

        idSC.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageProductsIU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageOrdersIU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageSuppliersIU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commandSC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authenticatioonSU, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(getIU, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteIU, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(firstInputField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(secondInputText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(secondInputField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(thirdInputField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(thirdInputText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstInputText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idSC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 155, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createIU, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateIU, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(authenticatioonSU)
                    .addComponent(commandSC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idSC))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(firstInputText, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(firstInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(secondInputText, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(secondInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(thirdInputText, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(thirdInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageProductsIU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageSuppliersIU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageOrdersIU)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateIU)
                    .addComponent(createIU)
                    .addComponent(deleteIU)
                    .addComponent(getIU))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Command Functions
    public void inform(String info) {
        commandSC.setText(info);
    }
    
    public void clearLog() {
        descriptionIA.setText("");
    }

    public void addLog(String log) {
        descriptionIA.append(log + "\n");
    }

    public void addCatalog(String item) {
        catalogModel.addElement(item);
    }
    
    public void purgeCatalog() {
        catalogModel.removeAllElements();
    }
    
    public void updateUIFields(String uiType) {
        switch(uiType) {
            case "Product":
                firstInputText.setText("Minimum Stock Level");
                firstInputField.setText("enter minimum stock level");
                
                secondInputText.setText("Maximum Stock Level");
                secondInputField.setText("enter maximum stock level");
                
                thirdInputText.setText("Current Stock Level");
                thirdInputField.setText("enter current stock level");
                
                
                jLabel2.setVisible(true);
                descriptionIA.setVisible(true);
                jLabel2.setText("Description");
                descriptionIA.setText("enter description about product");
                
                secondInputText.setVisible(true);
                secondInputField.setVisible(true);
                
                thirdInputText.setVisible(true);
                thirdInputField.setVisible(true);
                break;
            case "Supplier":
                firstInputText.setText("Product ID");
                firstInputField.setText("enter Product ID");
                
                jLabel2.setVisible(true);
                descriptionIA.setVisible(true);
                jLabel2.setText("Name");
                descriptionIA.setText("enter name of the Supplier");
                
                secondInputText.setVisible(false);
                secondInputField.setVisible(false);
                
                thirdInputText.setVisible(false);
                thirdInputField.setVisible(false);
                break;
            case "Order":
                firstInputText.setText("Supplier ID");
                firstInputField.setText("enter Supplier ID");
                
                secondInputText.setText("Quantity");
                secondInputField.setText("enter quantity");
                
                thirdInputText.setText("Order Date");
                thirdInputField.setText("enter order date");
                
                jLabel2.setVisible(false);
                descriptionIA.setVisible(false);
                
                secondInputText.setVisible(true);
                secondInputField.setVisible(true);
                
                thirdInputText.setVisible(true);
                thirdInputField.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void presentProductDetails(String id, String desc, int min, int max, int current) {
        commandSC.setText("Selected Item: " + id);
        idSC.setText("" + id);
        descriptionIA.setText(desc);
        firstInputField.setText("" + min);
        secondInputField.setText("" + max);
        thirdInputField.setText("" + current);
    }
    
    public void presentSupplierDetails(String id, String name, String productId) {
        commandSC.setText("Selected Supplier: " + id);
        idSC.setText("" + id);
        descriptionIA.setText(name);
        firstInputField.setText("" + productId);
    }
    
    public void presentOrderDetails(String id, int productId, int quantity, String date) {
        commandSC.setText("Selected Order: " + id);
        idSC.setText("" + id);
        firstInputField.setText("" + productId);
        secondInputField.setText("" + quantity);
        thirdInputField.setText("" + date);
    }

    private void manageProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductActionPerformed
        //manageOrdersIU.setEnabled(true);
        // Delegate
        updateUIFields("Product");
        managementMode = 1;
        inventory.manageCatalog(managementMode);
    }//GEN-LAST:event_manageProductActionPerformed

    private void manageSuppliersIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSuppliersIUActionPerformed
        updateUIFields("Supplier");
        managementMode = 2;
        inventory.manageCatalog(managementMode);
    }//GEN-LAST:event_manageSuppliersIUActionPerformed

    private void manageOrdersIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrdersIUActionPerformed
        updateUIFields("Order");
        managementMode = 3;
        inventory.manageCatalog(managementMode);
    }//GEN-LAST:event_manageOrdersIUActionPerformed

    private void deleteIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIUActionPerformed
        String item = catalogIC.getSelectedValue();
        
        inventory.deleteItem(managementMode, item);

    }//GEN-LAST:event_deleteIUActionPerformed

    private void updateIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIUActionPerformed

            String a = idSC.getText();
            String b = descriptionIA.getText();
            String c = firstInputField.getText();
            String d = secondInputField.getText();
            String e = thirdInputField.getText();
         
            inventory.updateItem(managementMode,a,b,c,d,e);
    }//GEN-LAST:event_updateIUActionPerformed

    public void orderShowMax (int max) {
            secondInputText.setText("Quantity [max= " + max + "]");
    }
    
    private void createIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createIUActionPerformed

        String b = descriptionIA.getText();
        String c = firstInputField.getText();
        String d = secondInputField.getText();
        String e = thirdInputField.getText();
        
        inventory.addItem(managementMode,b,c,d,e);    
    }//GEN-LAST:event_createIUActionPerformed

    private void getIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIUActionPerformed
        int items[] = catalogIC.getSelectedIndices();
        int index = catalogIC.getSelectedIndex() + 1;
        inventory.getDetails(managementMode, items, index);
        
    }//GEN-LAST:event_getIUActionPerformed

    private void firstInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstInputFieldActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authenticatioonSU;
    private javax.swing.JList<String> catalogIC;
    private javax.swing.JLabel commandSC;
    private javax.swing.JButton createIU;
    private javax.swing.JButton deleteIU;
    private javax.swing.JTextArea descriptionIA;
    private javax.swing.JTextField firstInputField;
    private javax.swing.JLabel firstInputText;
    private javax.swing.JButton getIU;
    private javax.swing.JLabel idSC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton manageOrdersIU;
    private javax.swing.JButton manageProductsIU;
    private javax.swing.JButton manageSuppliersIU;
    private javax.swing.JTextField secondInputField;
    private javax.swing.JLabel secondInputText;
    private javax.swing.JTextField thirdInputField;
    private javax.swing.JLabel thirdInputText;
    private javax.swing.JButton updateIU;
    // End of variables declaration//GEN-END:variables

}
