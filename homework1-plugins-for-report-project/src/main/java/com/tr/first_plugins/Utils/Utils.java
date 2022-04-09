package com.tr.first_plugins.Utils;

import java.io.File;
import java.util.List;

public class Utils {



    public static List<File> getAllListFile(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if(fList != null)
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getAllListFile(file.getAbsolutePath(), files);
                }
            }
        return files;
    }
}
