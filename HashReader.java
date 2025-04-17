//Advanced Topics
//Calvin Grabowski
//Period 7

import java.util.*;
import java.io.*;
//import java.scanner

public class HashReader {

   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner line = new Scanner(new File("file.txt"));
      Scanner sc = new Scanner(System.in);
      HashSet<String> text = new HashSet<String>();
      //takes in the file and makes the scanner and hashset 
      
      //this finds the first chapter and skips everything before this
      int breakAfter = 0;
      while(line.hasNext()) {
         if(line.nextLine().equals("CHAPTER 1. Loomings.")) {
            breakAfter++;
         }
         //breakafter is how many times the chapter is going to see before it starts reading the book
         if(breakAfter > 1) {
            break;
         }
      }
      
      //it goes to every word in the book and only takes the alphabetical letters and adds them to the hashset
      while(line.hasNext()) {
         String currentWord = line.next();       
         currentWord = currentWord.replaceAll("[^a-z]","");
         text.add(currentWord);
      }
      
      System.out.println(text);
      
      //this goes until the user doesn't want no more
      while(true) {
         System.out.println("find word or say no more");
         String answer = sc.nextLine();
            
         if(answer.equals("no more")) {
            break;
         }
         else {
            //this finds how long it takes to find if the word is in the book
            long timer = System.currentTimeMillis();
            boolean inBook = false;
            for(String c: text) {
               //this compares every word in the book to the one that the user is trying to find
               if(c.equals(answer)) {
                  System.out.println("yes");
                  inBook = true;
               }
            }
            if(!inBook) 
               System.out.println("no");
            //after the word has been found this says how long it took to find it
            System.out.println("It takes " + (System.currentTimeMillis()-timer) + " milliseconds.");
         }
      
      }
      
   }
   
   



}