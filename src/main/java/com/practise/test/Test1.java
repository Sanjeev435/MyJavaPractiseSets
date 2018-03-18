package com.practise.test;
import java.io.*;
import java.util.*;
public class Test1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Something : "); 
      //  int n = sc.nextInt();
    //    System.out.println("htte"+n);
        int firstCity = sc.nextInt();
        int secondCity = sc.nextInt();
       /* for(int t = 0; t < n; t++) {
            firstCity = sc.nextInt();
            System.out.println("ggggg"+firstCity);
            secondCity = sc.nextInt();
            System.out.println("ffff"+secondCity);
        }*/
        
       // int firstCityPoplntion = 0;
     //   int scndCityPoplntion = 0;
        int firstCityPoplntion = Integer.parseInt(sc.nextLine());
        /*for(int t = 0; t < k; t++) {
            firstCityPoplntion = sc.nextInt();
        }*/
        int scndCityPoplntion  = Integer.parseInt(sc.nextLine());
        /*for(int t = 0; t < m; t++) {
            scndCityPoplntion = sc.nextInt();
        }*/
        
        int firstCityDivision = firstCityPoplntion/firstCity;
        int scondCityDivision = scndCityPoplntion/secondCity;
        
        if(firstCityDivision>scondCityDivision)System.out.println(firstCityDivision);
        else System.out.println(scondCityDivision);
            
        
    }
}