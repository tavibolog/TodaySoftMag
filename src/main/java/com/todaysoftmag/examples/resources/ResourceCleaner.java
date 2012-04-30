package com.todaysoftmag.examples.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ResourceCleaner {
    public static void main(String[] args) throws Exception {
        ResourceCleaner rc = new ResourceCleaner();
        rc.clean();
    }

    public void clean() throws Exception {
        List<FileInputStream> list = new ArrayList<FileInputStream>();
        for (int i = 0; i < 1000000; i++) {
            FileInputStream fis = new FileInputStream(new File("README"));
            list.add(fis);
            fis.read();
            System.out.println(i);
        }
    }

}
