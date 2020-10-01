/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Farid
 */
public class BinaryConverter {
    
    String bin;
    StringBuilder binary;
    int dec;
    int i;
    
    public String convertToBiner(int dec){
        binary = new StringBuilder();
        for(i=0; i<8; i++){
            binary.append((dec&128) == 0?0:1);
            dec<<=1;
        }
        bin = binary.toString();
        return bin;
    } 
    
    public int convertToDecimal(String bin){
        dec = Integer.parseInt(bin, 2);
        return dec;
    }
}
