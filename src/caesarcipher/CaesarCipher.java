/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;

import java.util.Scanner;

/**
 *
 * @author Moyo
 */
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner hertha = new Scanner(System.in);
        
        System.out.println("Enter the word you want to encrypt");
        String text = hertha.next();
        System.out.println("The word you entered is :"+text);
        
        if(text.length()-1 <2){
            
           System.out.println("The cipher text of "+text+" using ceasar cipher is "+text);
        }
        else{
        String cipher = encript(text, 3);
        
        System.out.println("The cipher text of "+text+" using ceasar cipher is "+cipher);
        }
    }
    
   // cipher fuction which receices 2 parameters the plain text and the key but in 
    //this case the key is 0 3 1 for first letter , latter at the middle and the last letter
    // respectively 
    public static String encript(String plainText ,int shift){
        
        if(shift>26){           //checking to make sure the shift key is less than the alphabetical letters
            shift = shift%26;
        }
        else if(shift<0){       //checking to see if the shift key is a negative number 
            
            shift = (shift%26)+26;   
        }
        
        String cipherText ="" ;        //variable for containing  the semi ciphered text
        String fullcipheredText ="";     //variable to contain fully ciphered text
        
         //int length = plainText.length();
         char firstLetter = plainText.charAt(0);    //variable to contain the first letter  of each plain text
            
         int lastLatter = plainText.charAt(plainText.length()-1); //variable to contain the last letter of the plain text
         
         String subPlainTextString = plainText.substring(1,plainText.length()-1); //variable to contain the substring between the firs letter and the last letter
         
         int length = subPlainTextString.length(); //getting the length of the sub plain text string 
        
        for (int i = 0; i < length; i++) {
            
            char ch = subPlainTextString.charAt(i);      //getting the characters of the plain text
            char lastCharacter ;
            
            if(Character.isLetter(ch)){                   // checking to see if the character in the plain text is a letter for sure
                
               
               if(Character.isLowerCase(ch)) {             //checking to see if the character is a  lower case  letter
                   
                  char c =(char)(ch+shift);                //Shifting the characters on the middle by  a given key but in this case  its 3
                  lastCharacter = (char)(lastLatter+1);
                  
                  if(c>'z'){                                 //checking to see if the values is less than the code of small z
                      cipherText +=(char)(ch-(26-shift));     //shifting the character to the beginning of the alphabet 
                                                              //lets say if the character is y it becomes b
                  }
                  
                  
                  else{
                      lastCharacter = (char)(lastLatter+1);
                      cipherText +=c;
                      fullcipheredText = firstLetter + cipherText + lastCharacter;   //concatinating the characters
                  }
               }
               
               
               else if(Character.isUpperCase(ch)){                         //checking to if the character is a upper case 
                   
                    char c =(char)(ch+shift); 
                    lastCharacter = (char)(lastLatter+1);
                    
                  if(c>'Z'){
                      
                      cipherText +=(char)(ch-(26-shift));
                  }
                  
                  
                  else{
                      cipherText +=c;
                      lastCharacter = (char)(lastLatter+1);
                      fullcipheredText = firstLetter + cipherText + lastLatter;
                  }
                }
            }
            
            else if(Character.isDigit(ch)){
                char c =(char)(ch+shift); 
                cipherText +=c;
                lastCharacter = (char)(lastLatter+9);
                fullcipheredText = firstLetter+cipherText;
            }
            else{
                cipherText += ch;
                fullcipheredText = firstLetter+cipherText+lastLatter;
            }
            
        }
        return fullcipheredText;
    }

    
}
