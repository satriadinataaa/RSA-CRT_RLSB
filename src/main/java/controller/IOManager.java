/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ImageData;
import entity.TextData;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Farid
 */
public class IOManager {
    ImageData coverimage, stegoimage;
    TextData secretmsg;
    String text;
    String file_name;
    File file;
    BufferedImage image;
    long file_size;
    int jumlah_bits;
    int jumlah_char;
    
    public void inputCoverImage(File file) throws IOException {
        this.file = file;
        file_name = file.getName();
        file_size = file.length()/1024;
        coverimage = new ImageData();
        image = ImageIO.read(file);
        coverimage.setImage(image);
    }
    
    public void inputStegoImage(File file) throws IOException {
        this.file = file;
        file_name = file.getName();
        file_size = file.length()/1024;
        stegoimage = new ImageData();
        image = ImageIO.read(file);
        stegoimage.setImage(image);
    }
    
    public BufferedImage getCoverImage(){
        image = coverimage.getImage();
        return image;
    }
    
    public BufferedImage getStegoImage(){
        image = stegoimage.getImage();
        return image;
    }
    
    public String getFileName(){
        return file_name;
    }
    
    public long getFileSize(){
        return file_size;
    }
    
    public void saveStegoImage(String filename, BufferedImage image) throws IOException {
        this.image = image;
        file = new File(filename);
        ImageIO.write(image,"png",file);
        stegoimage = new ImageData();
        stegoimage.setImage(image);
    }
    
    public void inputSecretMessage(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        text = br.readLine();
        secretmsg = new TextData();
        secretmsg.setText(text);
    }
    
    public String getSecretMessage(){
        text = secretmsg.getText();
        return text;
    }
    
    public int getJumlahChar(){
        jumlah_char = text.length() + 1;
        return jumlah_char;
    }
    
    public int getJumlahBits(){
        jumlah_bits = jumlah_char*8;
        return jumlah_bits;
    }
}
