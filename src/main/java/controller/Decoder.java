/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ImageData;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.math.BigInteger;

/**
 *
 * @author Yaumil
 */
public class Decoder {
    BufferedImage citra, stego_image_rsa,stego_image_rsacrt;
    BufferedImage stego_image;
    BinaryConverter bc;
    private String stop;
    private String temp;
    private String temp_msg;
    private char character;
    private long duration;
    private long start;
    private long finish;
    private int[][] R;
    private int[][] G;
    private int[][] B;
    private int i;
    private int j;
    private int k;
    private int x;
    private int y;
    private int decimal;
    private int index_warna;
    String channel;
    String secret_message;
    String binary_secret_message;
    String msg_sisa;
    double time_decoding;
    int[][] matrix = new int [3][3];
    int widthrsa, heightrsa,widthcrt,heightcrt;
    int type;
    int index;
    int width;
    int height;
    String[][] SR,SG,SB;
    String cipher_text="";
    String plain_text="";
    BigInteger cipher_decimal;
    
    public void setStegoImageRSA(BufferedImage stego_image_rsa){
        this.stego_image_rsa = stego_image_rsa;
    }
    
     private BufferedImage cloneImageRSA(BufferedImage stego_image_rsa){
        this.stego_image_rsa = stego_image_rsa;
        ColorModel cm = stego_image_rsa.getColorModel();
        WritableRaster raster = stego_image_rsa.copyData(null);
        return new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);
    }
    public void DecoderRSA(int panjangcRSA,int[] x){
        int panjangpesan = panjangcRSA;
        secret_message = "";
        binary_secret_message = "";
        msg_sisa = "";
        stego_image_rsa = cloneImageRSA(stego_image_rsa);
        width = stego_image_rsa.getWidth();
        height = stego_image_rsa.getHeight();
        
        R = new int [width][height];
        G = new int [width][height];
        B = new int [width][height];
        
        SR= new String[width][height];
        SG= new String[width][height];
        SB= new String[width][height];
        
        for (i = 0; i<(width); i++) {
            for (j = 0; j < (height) ; j++) {

                        Color c = new Color(stego_image_rsa.getRGB(i,j));
                        //System.out.println("RGB I="+i+" J="+j+"=" +stego_image.getRGB(i, j));
                        R[i][j] = c.getRed();
                        SR[i][j] = Integer.toBinaryString(R[i][j]);
                        while(SR[i][j].length() !=8){
                            SR[i][j] = "0"+SR[i][j];
                        }
                        
                        G[i][j] = c.getGreen();
                        SG[i][j] = Integer.toBinaryString(G[i][j]);
                        while(SG[i][j].length() !=8){
                            SG[i][j] = "0"+SG[i][j];
                        }
                        
                        B[i][j] = c.getBlue();
                        SB[i][j] = Integer.toBinaryString(B[i][j]);
                        while(SB[i][j].length() !=8){
                            SB[i][j] = "0"+SB[i][j];
                        }                       
                }
        }
        
        for(int i=0;i<width;i++){
            for(j=0;j<height;j++){
                System.out.println("R:"+SR[i][j]);
                System.out.println("G:"+SG[i][j]);
                System.out.println("B:"+SB[i][j]);
                
            }
        }
      String[] bitstego= new String[panjangpesan];
      System.out.println("Panjang Pesan="+panjangpesan);
      
      for(int var = 0;var<panjangpesan;var++){
          System.out.println("awkarin");
          for(i=0;i<width;i++){
              for(j = 0;j<height;j++){
                  System.out.println(var);
                  if(var>=panjangpesan){
                      break;
                  }
                  bitstego[var] = SR[i][j];
                  var++;
                  System.out.println("kontol"+var);
                  if(var>=panjangpesan){
                      break;
                  }
                  
                  bitstego[var] = SG[i][j];
                  var++;
                  System.out.println("mmek"+var);
                  if(var>=panjangpesan){
                      break;
                  }
                  
                  bitstego[var] = SB[i][j];
                  var++;
                  System.out.println("yesus"+var);
              }
          }
      }
      
      for(int an=0;an<panjangpesan;an++){
          System.out.println("Bit stego ke "+an+" = "+bitstego[an]); 
      }
      
      for(int i = 0 ; i<x.length ; i++){
          System.out.println("X["+i+"] = "+x[i]);
      }
      char temp;
      int[] index = new int[x.length];
      for(int i = 0 ; i <x.length;i++){
        if(x[i]==1){
                index[i] = 7;
            }
            else if(x[i]==2){
                index[i] = 6;
            }
      }
      int indexer=1;
      int delimiter =0;
      for(int i = 0 ; i< bitstego.length;i++){
          System.out.println("indexer = "+indexer);
          temp = bitstego[i].charAt(index[indexer]);
          cipher_text = cipher_text + temp;
          delimiter++;
          if((delimiter % 3) == 0){
            indexer++;
          }
      }
      cipher_decimal = new BigInteger(cipher_text,2);
        
      
      
      
        
    }
    public BigInteger get_cipherdecimal(){
        return this.cipher_decimal;
    }
    
    public void Decoder(){
        
    }
    
}
