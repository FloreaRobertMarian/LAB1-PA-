
package lab1.pkg2;
import java.io.*;
import java.util.Scanner;
import java.math.BigInteger; 
import java.util.*;

public class LAB12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Hello World!");
       String[] array =new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
      int n = (int) (Math.random() * 1_000_000);
      n=n*3;
      int a=  Integer.parseInt("10101",2);
      int b= Integer.parseInt("FF",16);
      y=a+b+n;
      y=y*6;
      System.out.println("Willy-nilly,this semestre I will learn");
      for(int i=0; i<array.lenght ;i++)
          System.out.println(array[i]+" ");
    }
    int n;
     Scanner k = new Scanner(System.in);
     n= k.nextInt();
     int  mat [][]= new int[n][n];
     for(int i=0;i<n;i++)
         for(int j=0;j<n;j++){
             Random c= new Random();
             mat[i][j]=c.nextInt(1);
         }
    
}
