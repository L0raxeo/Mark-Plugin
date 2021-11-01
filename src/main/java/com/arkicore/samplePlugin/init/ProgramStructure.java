package com.arkicore.samplePlugin.init;

import com.arkicore.samplePlugin.utils.Registry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProgramStructure implements Registry
{

    @Override
    public void preInit() throws IOException
    {
        if (!Files.exists(Paths.get("libs")));
        {
            // Creates new directory if plugins directory doesn't exist
            boolean wasSuccessful = new File("plugins").mkdirs();

            if (wasSuccessful)
            {

            }
        }
    }
}
