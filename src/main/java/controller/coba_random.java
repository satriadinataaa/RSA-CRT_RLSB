/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author farid
 */
public class coba_random {
  
    public static BigInteger GeneratePrime(int input_rand){
        int N = input_rand;
        SecureRandom random = new SecureRandom();
        BigInteger prime = BigInteger.probablePrime(N,random);
        return prime;
    }
   
    public static BigInteger random(int input_rand){
    BigInteger p = GeneratePrime(input_rand);
        return p;
    }
    
     public static void main(String args[]) {
         System.out.println(random(7));
     };


    
}
