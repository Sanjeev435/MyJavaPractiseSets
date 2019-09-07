package com.practise.test;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Test5 {



    // Complete the secureChannel function below.
    private static String secureChannel(int operation, String message, String key) {
            StringBuilder sb = new StringBuilder();
           try{
               if("".equals(message)){
                 throw new Exception("Error in message");
               }
            if(operation == 1){
                String[] keys = key.split("");
                String[] messageSplits = message.split("");

                for(int i=0; i < keys.length; i++){
                        Integer keyValue = Integer.parseInt(keys[i]);
                        for(int k=keyValue; k > 0; k-- ){
                            if(i < messageSplits.length){
                                sb.append(messageSplits[i]);
                            }
                    }
                }

                if(keys.length < messageSplits.length){
                    int count = keys.length;
                   while(count > messageSplits.length){
                       sb.append(messageSplits[count]);
                    count++;
                   }
                }              

            }else if(operation == 2){
                String[] keys = key.split("");
                String[] messageSplits = message.split("");

                int tempIndex = 0;
                for(int i=0; i < keys.length; i++){
                        Integer keyValue = Integer.parseInt(keys[i]);
                        String strOnIndex = messageSplits[tempIndex];
                        for(int k=keyValue; k > 0; k-- ){
                            if(!strOnIndex.equals(messageSplits[tempIndex])){
                                throw new Exception("Error in encoding");
                            }
                            tempIndex++;
                    }
                    sb.append(strOnIndex);
                }

                if(tempIndex < messageSplits.length){
                   while(tempIndex < messageSplits.length){
                       sb.append(messageSplits[tempIndex]);
                    tempIndex++;
                   }
                }

            }}catch(Exception ex){
                    return "-1";
            }

            return sb.toString();

    }

    public static void main(String[] args) throws IOException {
    	System.out.println(secureChannel(1,"Ope", "12345"));
    }
    
}
    