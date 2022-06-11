package com.practise.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.practise.dto.SampleDTO;

public class Util {
	
	
	/**
	 * Compare two elements
	 * 
	 * @param obj1 first {@code Object} for comparison.
	 * @param obj2 second {@code Object} for comparison.
	 * @return the value {@code 0} if this {@code Object} is equal to the argument
	 *         {@code Object}; a value less than {@code 0} if this {@code Object} is
	 *         numerically less than the argument {@code Object}; and a value
	 *         greater than {@code 0} if this {@code Object} is numerically greater
	 *         than the argument {@code Object}.
	 */
	public static int compare(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return 0;
		} else if (obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		} else if (obj1 instanceof Integer) {
			return ((Integer) obj1).compareTo((Integer) obj2);
		} else if (obj1 instanceof SampleDTO) {
			return ((SampleDTO) obj1).compareTo((SampleDTO) obj2);
		} else {
			 throw new RuntimeException("Unsupported class for Util#comapre");
		}
	}
	
	/**
	 * Read data from file for long test cases data
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String getFileContentFromResource(String fileName) throws Exception {
		try {
			ClassLoader classLoader = Util.class.getClassLoader();
			URL resource = classLoader.getResource(fileName);
			if (resource == null) {
				throw new IllegalArgumentException("file not found! " + fileName);
			} else {
				// failed if files have white spaces or special characters
				// return new File(resource.getFile());

				return getFileContents(new File(resource.toURI()));
			}
		} catch (Exception es) {
			throw new Exception(fileName, es);
		}
	}
	
	private static String getFileContents(File file) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (lines != null) {
			return String.join(",", lines);
		}

		return "";
	}

}
