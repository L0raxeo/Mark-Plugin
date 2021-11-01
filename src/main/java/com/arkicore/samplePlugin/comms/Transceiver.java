package com.arkicore.samplePlugin.comms;

import com.arkicore.samplePlugin.utils.FileLoader;

import java.io.File;
import java.io.IOException;

public class Transceiver
{

    public static void queueMessage(File file, String data)
    {
        try
        {
            FileLoader.writeFile(file.getPath(), data);
        }
        catch (IOException e)
        {

        }
    }

    public static void queueMessage(String path, String data)
    {
        try
        {
            FileLoader.writeFile(path, data);
        }
        catch (IOException e)
        {

        }
    }

    public static String getInbox()
    {
        try
        {
            return FileLoader.readFile("libs/send.txt");
        }
        catch (IOException e)
        {

        }

        return null;
    }

}
