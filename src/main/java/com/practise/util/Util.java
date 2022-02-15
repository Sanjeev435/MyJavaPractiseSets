package com.practise.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.practise.dto.SampleDTO;

public class Util {
	
	
	/**
	 * Compare two elements
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static int compare(Object obj1, Object obj2) {
		if (obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		} else if (obj1 instanceof Integer) {
			return ((Integer) obj1).compareTo((Integer) obj2);
		}else if (obj1 instanceof SampleDTO) {
			return ((SampleDTO) obj1).compareTo((SampleDTO) obj2);
		} else {
			return 0;
		}
	}
	
	public static String getFileContentFromResource(String fileName){

		try {
			ClassLoader classLoader = Util.class.getClassLoader();
	        URL resource = classLoader.getResource(fileName);
	        if (resource == null) {
	            throw new IllegalArgumentException("file not found! " + fileName);
	        } else {

	            // failed if files have whitespaces or special characters
	            //return new File(resource.getFile());

	        	return getFileContents(new File(resource.toURI()));
	        }
		}catch(Exception es) {
			es.printStackTrace();
		}
        
return "";
    }
	
	private static String getFileContents(File file) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(lines != null) {
         return String.join(",", lines);
        }
        
        
        return "";

    }

}
