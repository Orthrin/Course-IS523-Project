/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kutay
 */
public class Store {
    
    public static final String fileName = "product.txt";
    ProductCatalog catalog;
    
    // Constructor
    public Store() {
        catalog = new ProductCatalog();
    }
    
    // Command Functions
    public void loadMap(String a, String b, String c, String d, String e) {
        catalog.createItem(a, b, c, d, e);
    }
    
    // Query Functions
    public String getWriteData() {
        return catalog.getSaveData();    
    }
}
