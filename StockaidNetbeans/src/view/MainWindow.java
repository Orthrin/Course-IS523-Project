package view;

import domain.Store;
import javax.swing.*;
import java.awt.Toolkit;
import javax.sql.rowset.spi.SyncProvider;

public class MainWindow extends javax.swing.JFrame {

    // Instatantiation
    Store inventory;
    DefaultListModel catalogModel = new DefaultListModel();
    
    private JLabel secondEntry;
    private JLabel thirdEntry;
    
    boolean isManagingProducts = false;
    boolean isManagingSuppliers = false;
    
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
        minimumStockLevelSC = new javax.swing.JLabel();
        minimumStockLevelIF = new javax.swing.JTextField();
        maximumStockLevelSC = new javax.swing.JLabel();
        maximumStockLevelIF = new javax.swing.JTextField();
        currentStockLevelIF = new javax.swing.JTextField();
        currentStockLevelSC = new javax.swing.JLabel();
        idSC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("icon2.png")));

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

        minimumStockLevelSC.setText("Minimum Stock Level");

        minimumStockLevelIF.setText("enter minimum stock level");
        minimumStockLevelIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumStockLevelIFActionPerformed(evt);
            }
        });

        maximumStockLevelSC.setText("Maximum  Stock Level");

        maximumStockLevelIF.setText("enter maximum stock level");

        currentStockLevelIF.setText("enter current stock level");

        currentStockLevelSC.setText("Current Stock Level");

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
                                    .addComponent(minimumStockLevelIF, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(maximumStockLevelSC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maximumStockLevelIF, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(currentStockLevelIF, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(currentStockLevelSC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(minimumStockLevelSC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(minimumStockLevelSC, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(minimumStockLevelIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(maximumStockLevelSC, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(maximumStockLevelIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(currentStockLevelSC, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(currentStockLevelIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                minimumStockLevelSC.setText("Minimum Stock Level");
                minimumStockLevelIF.setText("enter minimum stock level");
                
                maximumStockLevelSC.setText("Maximum Stock Level");
                maximumStockLevelIF.setText("enter maximum stock level");
                
                currentStockLevelSC.setText("Current Stock Level");
                currentStockLevelIF.setText("enter current stock level");
                
                
                jLabel2.setVisible(true);
                descriptionIA.setVisible(true);
                jLabel2.setText("Description");
                descriptionIA.setText("enter description about product");
                
                maximumStockLevelSC.setVisible(true);
                maximumStockLevelIF.setVisible(true);
                
                currentStockLevelSC.setVisible(true);
                currentStockLevelIF.setVisible(true);
                break;
            case "Supplier":
                minimumStockLevelSC.setText("Product ID");
                minimumStockLevelIF.setText("enter Product ID");
                
                jLabel2.setVisible(true);
                descriptionIA.setVisible(true);
                jLabel2.setText("Name");
                descriptionIA.setText("enter name of the Supplier");
                
                maximumStockLevelSC.setVisible(false);
                maximumStockLevelIF.setVisible(false);
                
                currentStockLevelSC.setVisible(false);
                currentStockLevelIF.setVisible(false);
                break;
            case "Order":
                minimumStockLevelSC.setText("Supplier ID");
                minimumStockLevelIF.setText("enter Supplier ID");
                
                maximumStockLevelSC.setText("Quantity");
                maximumStockLevelIF.setText("enter quantity");
                
                currentStockLevelSC.setText("Order Date");
                currentStockLevelIF.setText("enter order date");
                
                jLabel2.setVisible(false);
                descriptionIA.setVisible(false);
                
                maximumStockLevelSC.setVisible(true);
                maximumStockLevelIF.setVisible(true);
                
                currentStockLevelSC.setVisible(true);
                currentStockLevelIF.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public void presentProductDetails(String id, String desc, int min, int max, int current) {
        commandSC.setText("Selected Item: " + id);
        idSC.setText("" + id);
        descriptionIA.setText(desc);
        minimumStockLevelIF.setText("" + min);
        maximumStockLevelIF.setText("" + max);
        currentStockLevelIF.setText("" + current);
    }
    
        public void presentSupplierDetails(String id, String name, String productId) {
        commandSC.setText("Selected Supplier: " + id);
        idSC.setText("" + id);
        descriptionIA.setText(name);
        minimumStockLevelIF.setText("" + productId);
    }

    private void manageProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductActionPerformed
        //manageOrdersIU.setEnabled(true);
        // Delegate
        updateUIFields("Product");
        isManagingProducts = true;
        inventory.manageProducts();
    }//GEN-LAST:event_manageProductActionPerformed

    private void manageSuppliersIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSuppliersIUActionPerformed
        updateUIFields("Supplier");
        isManagingSuppliers = true;
        inventory.manageSuppliers();
    }//GEN-LAST:event_manageSuppliersIUActionPerformed

    private void deleteIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIUActionPerformed
        String item = catalogIC.getSelectedValue();
        inventory.productDeleteItem(item);
    }//GEN-LAST:event_deleteIUActionPerformed

    private void updateIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIUActionPerformed
        String a = idSC.getText();
        String b = descriptionIA.getText();
        String c = minimumStockLevelIF.getText();
        String d = maximumStockLevelIF.getText();
        String e = currentStockLevelIF.getText();
        inventory.productUpdateItem(a,b,c,d,e);
    }//GEN-LAST:event_updateIUActionPerformed

    private void createIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createIUActionPerformed
        String b = descriptionIA.getText();
        String c = minimumStockLevelIF.getText();
        String d = maximumStockLevelIF.getText();
        String e = currentStockLevelIF.getText();
        inventory.productAddItem(b,c,d,e);
    }//GEN-LAST:event_createIUActionPerformed

    private void getIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIUActionPerformed
        int items[] = catalogIC.getSelectedIndices();
        int index = catalogIC.getSelectedIndex() + 1;
        if (isManagingProducts) {
            inventory.productGetDetails(items, index);
        }
        else if (isManagingSuppliers) {
            inventory.supplierGetDetails(items, index);
        }
    }//GEN-LAST:event_getIUActionPerformed

    private void minimumStockLevelIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumStockLevelIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimumStockLevelIFActionPerformed

    private void manageOrdersIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrdersIUActionPerformed
        updateUIFields("Order");
    }//GEN-LAST:event_manageOrdersIUActionPerformed

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
    private javax.swing.JTextField currentStockLevelIF;
    private javax.swing.JLabel currentStockLevelSC;
    private javax.swing.JButton deleteIU;
    private javax.swing.JTextArea descriptionIA;
    private javax.swing.JButton getIU;
    private javax.swing.JLabel idSC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton manageOrdersIU;
    private javax.swing.JButton manageProductsIU;
    private javax.swing.JButton manageSuppliersIU;
    private javax.swing.JTextField maximumStockLevelIF;
    private javax.swing.JLabel maximumStockLevelSC;
    private javax.swing.JTextField minimumStockLevelIF;
    private javax.swing.JLabel minimumStockLevelSC;
    private javax.swing.JButton updateIU;
    // End of variables declaration//GEN-END:variables
}
