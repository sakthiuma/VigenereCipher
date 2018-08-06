/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere;

/**
 *
 * @author Sakthi
 */
import java.util.*;

public class Vigenere {

    public static String text,key;
    public static int[][] keyMatrix=new int[26][26];
    public static StringBuilder cipherText=new StringBuilder();
    public static StringBuilder plainText=new StringBuilder();
    
    public static void vigenereEncrypt(String text,String key)
    {
        int i,j=0,text_index,key_index,result;
        
        for(i=0;i<text.length();i++)
        {
            text_index=((int)text.charAt(i))%97;
            key_index=((int)key.charAt(j))%97;
            //System.out.println("text_index::"+text_index+"key_index::"+key_index+"key_matrix::"+(char)keyMatrix[text_index][key_index]);
            //System.out.print((char)keyMatrix[text_index][key_index]);
            result=keyMatrix[text_index][key_index]+97;
            cipherText.append((char)result);
            if(j==key.length()-1)
                j=0;
            else
                j++;
        }
        System.out.println(cipherText.toString());
    }
    
    public static void vigenereDecrypt(String cipherText,String key)
    {
        int i,j=0,cipher_index,key_index,result,k;
        for(i=0;i<cipherText.length();i++)
        {
            cipher_index=((int)cipherText.charAt(i))%97;
            key_index=((int)key.charAt(j))%97;
            for(k=0;k<26;k++)
            {
                if(keyMatrix[key_index][k]==cipher_index)
                {
                    result=k+97;
                    plainText.append((char)result);
                }
            }
            if(j==key.length()-1)
                j=0;
            else
                j++;
        }
        System.out.println(plainText.toString());
    }
    public static void generateKeyMatrix()
    {
        int i,j;
        for(i=0;i<26;i++)
        {
           
            for(j=0;j<26;j++)
            {
                if(i+j<26)
                    keyMatrix[i][j]=i+j;
                else
                    keyMatrix[i][j]=(i+j)%26;        
            }
        }
        
        for(i=0;i<26;i++)
        {
            for(j=0;j<26;j++)
            {
                System.out.print(keyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
        int choice;
        System.out.println("Enter 1.Encryption\n 2.Decryption");
        choice=s.nextInt();
        System.out.println("Enter the test for applying vigenere cipher");
        text=s.next();
        System.out.println("Enter the key string");
        key=s.next();
        generateKeyMatrix();
        switch(choice)
        {
            case 1:
                vigenereEncrypt(text,key);
                break;
            case 2:
                vigenereDecrypt(text,key);
                break;
                
        }
    }
}
