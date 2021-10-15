package com.yieldstreet.home.challenge.util;

import java.io.File;
import java.io.IOException;

public class FileManagementUtils {

	
	public static File findOrCreateFile(String path, String filename) throws IOException {
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
		File target = new File(path + "\\" + filename);
		target.createNewFile();
		target.setWritable(true);
		
		return target;
	}
	
	public static boolean checkFileExists(String fullpath) {
		File target = new File(fullpath);
		return target.exists();
	}
	
	public static boolean deleteFile(String fullpath) {
		File target = new File(fullpath);
		return target.delete();
	}
}
