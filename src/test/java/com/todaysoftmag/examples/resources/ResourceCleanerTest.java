package com.todaysoftmag.examples.resources;

import java.io.FileNotFoundException;

import org.junit.Test;

public class ResourceCleanerTest {
    ResourceCleaner resourceCleaner = new ResourceCleaner();

    @Test
    public void testOpenFilesWithClosingStreams() throws Exception {
        resourceCleaner.openFiles(10000, true);
    }
    
    @Test
    public void testOpenFilesUsingJdk17() throws Exception {
        resourceCleaner.openFileJdk17(10000);
    }

    @Test(expected = FileNotFoundException.class)
    public void testOpenTooManyOpenFiles() throws Exception {
        resourceCleaner.openFiles(10000, false);
    }  
}
