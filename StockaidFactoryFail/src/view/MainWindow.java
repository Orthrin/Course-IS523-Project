package view;

import domain.Store;
import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import javax.sql.rowset.spi.SyncProvider;

public class MainWindow extends javax.swing.JFrame {

    // Instatantiation
    Store inventory;
    DefaultListModel catalogModel = new DefaultListModel();
    DefaultComboBoxModel cBModel1= new DefaultComboBoxModel();
    DefaultComboBoxModel cBModel2= new DefaultComboBoxModel();

    boolean isManagingProducts = false;
    boolean isManagingSuppliers = false;

    int managementMode = 1;

    // Constructor
    public MainWindow(Store inventory) {
        initComponents();
        this.inventory = inventory;
        this.catalogIC.setModel(catalogModel);
        this.productCB.setModel(cBModel1);
        this.supplierCB.setModel(cBModel2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authenticationSU = new javax.swing.JLabel();
        manageOrdersIU = new javax.swing.JButton();
        manageSuppliersIU = new javax.swing.JButton();
        manageProductsIU = new javax.swing.JButton();
        createIU = new javax.swing.JButton();
        deleteIU = new javax.swing.JButton();
        updateIU = new javax.swing.JButton();
        commandSC = new javax.swing.JLabel();
        catalogPanel = new javax.swing.JScrollPane();
        catalogIC = new javax.swing.JList<>();
        idSC = new javax.swing.JLabel();
        idOC = new javax.swing.JLabel();
        productOC = new javax.swing.JLabel();
        productCB = new javax.swing.JComboBox<>();
        supplierOC = new javax.swing.JLabel();
        supplierCB = new javax.swing.JComboBox<>();
        inputFieldText1 = new javax.swing.JLabel();
        inputField1Panel = new javax.swing.JScrollPane();
        inputField1 = new javax.swing.JTextArea();
        inputFieldText2 = new javax.swing.JLabel();
        inputField2 = new javax.swing.JTextField();
        inputFieldText3 = new javax.swing.JLabel();
        inputField3 = new javax.swing.JTextField();
        inputFieldText4 = new javax.swing.JLabel();
        inputField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        authenticationSU.setText("Login Identification Text");

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

        createIU.setText("Add");
        createIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createIUActionPerformed(evt);
            }
        });

        deleteIU.setText("Delete");
        deleteIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIUActionPerformed(evt);
            }
        });

        updateIU.setText("Update");
        updateIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIUActionPerformed(evt);
            }
        });

        commandSC.setText("Please select an item");

        catalogIC.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        catalogIC.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                catalogICValueChanged(evt);
            }
        });
        catalogPanel.setViewportView(catalogIC);

        idSC.setText("ID :");

        idOC.setText("0");

        productOC.setText("Corresponding Product ID");

        productCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCBActionPerformed(evt);
            }
        });

        supplierOC.setText("Corresponding Supplier ID");

        supplierCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierCBActionPerformed(evt);
            }
        });

        inputFieldText1.setText("Description");

        inputField1.setColumns(20);
        inputField1.setRows(5);
        inputField1.setText("enter description about product\n");
        inputField1Panel.setViewportView(inputField1);

        inputFieldText2.setText("Minimum Stock Level");

        inputField2.setText("enter minimum stock level");
        inputField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputField2ActionPerformed(evt);
            }
        });

        inputFieldText3.setText("Maximum  Stock Level");

        inputField3.setText("enter maximum stock level");

        inputFieldText4.setText("Current Stock Level");

        inputField4.setText("enter current stock level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageOrdersIU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageSuppliersIU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageProductsIU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commandSC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authenticationSU, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createIU, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteIU, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(catalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputFieldText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputField1Panel)
                            .addComponent(inputField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputFieldText3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputFieldText4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputField4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idSC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idOC, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(updateIU, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(productCB, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplierCB, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productOC)
                                    .addComponent(supplierOC)
                                    .addComponent(inputFieldText2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(authenticationSU)
                    .addComponent(commandSC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idOC, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idSC, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productOC)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(productCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(supplierOC)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(supplierCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputFieldText2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(inputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputFieldText3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputFieldText4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputFieldText1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputField1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(catalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageProductsIU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageSuppliersIU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageOrdersIU)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateIU)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createIU)
                            .addComponent(deleteIU))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Command Functions
    public void inform(String info) {
        commandSC.setText(info);
    }

    public void clearLog() {
        inputField1.setText("");
    }

    public void addLog(String log) {
        inputField1.append(log + "\n");
    }

    public void addItemToCatalog(String item) {
        catalogModel.addElement(item);
    }
    
    public void addItemToCB1(String item) {
        cBModel1.addElement(item);
    }
    
    public void CB1Cleanse() {
        try {
        if (inputField2.getText() != "enter product ID") {
            productCB.setSelectedIndex(Integer.parseInt(inputField2.getText())-1); //.setText("Select Product");
        } else {
            productCB.setSelectedIndex(0);
        }
        } catch(NumberFormatException ex) {}
    }
    
    public void addItemToCB2(String item) {
        cBModel2.addElement(item);
    }

    public void purgeCatalog() {
        catalogModel.removeAllElements();
        cBModel1.removeAllElements();
        cBModel2.removeAllElements();
    }

    public void updateUIFields(String uiType) {
        switch (uiType) {
            case "Product":
                idSC.setText("Product ID:");
                productOC.setVisible(false);
                supplierOC.setVisible(false);
                productCB.setVisible(false);
                supplierCB.setVisible(false);

                inputFieldText1.setVisible(true);
                inputField1.setVisible(true);
                inputFieldText1.setText("Description");
                inputField1.setText("enter description about product");

                inputFieldText2.setText("Minimum Stock Level");
                inputField2.setText("enter minimum stock level");

                inputFieldText3.setVisible(true);
                inputField3.setVisible(true);
                inputFieldText3.setText("Maximum Stock Level");
                inputField3.setText("enter maximum stock level");

                inputFieldText4.setVisible(true);
                inputField4.setVisible(true);
                inputFieldText4.setText("Current Stock Level");
                inputField4.setText("enter current stock level");
                break;
            case "Supplier":
                idSC.setText("Supplier ID:");
                productOC.setVisible(true);
                supplierOC.setVisible(false);
                productCB.setVisible(true);
                supplierCB.setVisible(false);

                inputFieldText1.setVisible(true);
                inputField1.setVisible(true);
                inputFieldText1.setText("Name");
                inputField1.setText("enter name of the Supplier");

                inputFieldText2.setVisible(false);
                inputField2.setVisible(false);
                inputFieldText2.setText("Product ID:");
                inputField2.setText("enter Product ID");

                inputFieldText3.setVisible(false);
                inputField3.setVisible(false);

                inputFieldText4.setVisible(false);
                inputField4.setVisible(false);
                break;
            case "Order":
                idSC.setText("Order ID:");
                productOC.setVisible(true);
                supplierOC.setVisible(true);
                productCB.setVisible(true);
                supplierCB.setVisible(true);

                inputFieldText1.setVisible(false);
                inputField1.setVisible(false);

                inputFieldText2.setText("Supplier ID");
                inputField2.setText("enter Supplier ID");

                inputFieldText3.setText("Quantity");
                inputField3.setText("enter quantity");

                inputFieldText3.setVisible(true);
                inputField3.setVisible(true);

                inputFieldText4.setText("Order Date");
                inputField4.setText("enter order date");

                inputFieldText4.setVisible(true);
                inputField4.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void displayItemDetails(int guide, String a, String b, String c, String d, String e) {
        switch (guide) {
            case 1:
                idOC.setText("" + a);
                inputField1.setText(b);
                inputField2.setText("" + c);
                inputField3.setText("" + d);
                inputField4.setText("" + e);
                break;
            case 2:
                idOC.setText("" + c);
                productOC.setText("Product ID: " + a);
                inputField1.setText(b);
                inputField2.setText("" + a);
                productCB.setSelectedIndex(Integer.parseInt(a)-1);
                break;

            case 3:
                idOC.setText("" + a);
                inputField2.setText("" + c);
                inputField3.setText("" + b);
                inputField4.setText("" + d);
                break;
        }
    }
        // INPUT UNITS

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
        String item = idOC.getText();
        inventory.deleteItem(managementMode, item);

    }//GEN-LAST:event_deleteIUActionPerformed

    private void updateIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIUActionPerformed

        String a, b, c, d, e = "";

        a = idOC.getText();
        b = inputField1.getText();
        c = inputField2.getText();
        d = inputField3.getText();
        e = inputField4.getText();
        
        switch (managementMode) {
            case 2:
                c = "" + (productCB.getSelectedIndex() + 1);
                inputField2.setText(c);
                productCB.setSelectedIndex(Integer.parseInt(c) - 1);
                d = "";
                e = "";
                break;
            case 3:
                break;

        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e);

        inventory.updateItem(managementMode, a, b, c, d, e);
    }//GEN-LAST:event_updateIUActionPerformed

    public void orderShowMax(int max) {
        inputFieldText3.setText("Quantity [max= " + max + "]");
    }

    public void indicateLow(String item) {
//        catalogIC.setSelectedIndex(catalogIC.getLastVisibleIndex());
//        catalogIC.setSelectionBackground(Color.red);
    }

    private void createIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createIUActionPerformed

        String b = inputField1.getText();
        String c = inputField2.getText();
        String d = inputField3.getText();
        String e = inputField4.getText();

        inventory.addItem(managementMode, b, c, d, e);
    }//GEN-LAST:event_createIUActionPerformed

    private void inputField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputField2ActionPerformed

    private void catalogICValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_catalogICValueChanged
        int items[] = catalogIC.getSelectedIndices();
        int index = catalogIC.getSelectedIndex() + 1;
        inventory.getDetails(managementMode, items, index);
    }//GEN-LAST:event_catalogICValueChanged

    private void supplierCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierCBActionPerformed

    }//GEN-LAST:event_supplierCBActionPerformed

    private void productCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCBActionPerformed
        productOC.setText("Product ID: " + (productCB.getSelectedIndex()+1));
        if(managementMode == 3 ){
            inventory.getOrderSuppliers(managementMode, productCB.getSelectedIndex()+1);
        }
    }//GEN-LAST:event_productCBActionPerformed

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
    private javax.swing.JLabel authenticationSU;
    private javax.swing.JList<String> catalogIC;
    private javax.swing.JScrollPane catalogPanel;
    private javax.swing.JLabel commandSC;
    private javax.swing.JButton createIU;
    private javax.swing.JButton deleteIU;
    private javax.swing.JLabel idOC;
    private javax.swing.JLabel idSC;
    private javax.swing.JTextArea inputField1;
    private javax.swing.JScrollPane inputField1Panel;
    private javax.swing.JTextField inputField2;
    private javax.swing.JTextField inputField3;
    private javax.swing.JTextField inputField4;
    private javax.swing.JLabel inputFieldText1;
    private javax.swing.JLabel inputFieldText2;
    private javax.swing.JLabel inputFieldText3;
    private javax.swing.JLabel inputFieldText4;
    private javax.swing.JButton manageOrdersIU;
    private javax.swing.JButton manageProductsIU;
    private javax.swing.JButton manageSuppliersIU;
    private javax.swing.JComboBox<String> productCB;
    private javax.swing.JLabel productOC;
    private javax.swing.JComboBox<String> supplierCB;
    private javax.swing.JLabel supplierOC;
    private javax.swing.JButton updateIU;
    // End of variables declaration//GEN-END:variables

}
