/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Vasanth
 */
public class TestThreadMany {
     public static void main (String arg[]) { 
     System.out.print("Enter the number : ");
     
    int n =Integer.parseInt(arg[0]); 
 
    ThreadTest t[]= new ThreadTest[n];
   
    for(int i =1 ; i<=n ; i++){
     t[i] = new ThreadTest ("Thread #"+i ); 
    
     t[i].start();
      try{
    t[i].join();
    }
    catch(InterruptedException e){
    System.out.print(e);
    }
    }
   
   }
  }

class ThreadTest extends Thread { 

  public ThreadTest (String s) { 
    super(s);
  }
 
  @Override
  public void run() { 
    System.out.println("Hello I am "+ getName()); 
  } 
}
