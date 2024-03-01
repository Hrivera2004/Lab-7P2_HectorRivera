/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7.p2_hectorrivera;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hriverav
 */
public class AdminTXT {
    private File fileTXT = null;
    private ArrayList<Producto> productos = new ArrayList();

    public AdminTXT() {
    }
    
    public AdminTXT(String filepath) {
        fileTXT= new File(filepath);
    }

    public File getFileTXT() {
        return fileTXT;
    }

    public void setFileTXT(File fileTXT) {
        this.fileTXT = fileTXT;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void addProductos(Producto productos) {
        this.productos.add(productos);
    }

    @Override
    public String toString() {
        return "AdminTXT{" + "fileTXT=" + fileTXT + ", productos=" + productos + '}';
    }
    
    public void addtoFile(){
        FileWriter fw = null;
        BufferedWriter  bw = null;
        try {
            fw = new FileWriter(fileTXT,false);
            bw = new BufferedWriter(fw);
            
            for (int i = 0; i < productos.size(); i++) {
                bw.write(productos.get(i).toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void readFile(){
        productos = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(fileTXT);
            while (sc.hasNextLine()) {                
                String line =sc.nextLine();
                String[] split = line.split(",");
                productos.add(new Producto( Integer.parseInt(split[0]) , split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5])));
            }
        } catch (Exception e) {
        }
    }
    
}
