package com.todaysoftmag.examples.resources;

import java.io.File;
import java.io.FileInputStream;

public class ResourceCleaner {

    public void openFiles(int numberOfFiles, boolean closeStreams) throws Exception{
        for (int i = 0; i < numberOfFiles; i++) {
            if (closeStreams) {
                openClosingStreams();
            }else{
                openWithoutClosingStreams();
            }
        }
    }

    private void openWithoutClosingStreams() throws Exception {
        FileInputStream fis = new FileInputStream(new File("README"));
        // do you file manipulation here
    }

    private void openClosingStreams() throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("README"));
            // do you file manipulation here
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

    }

}
