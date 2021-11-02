package com.arkicore.samplePlugin.comms;

import com.arkicore.samplePlugin.utils.FileLoader;

import java.io.File;
import java.io.IOException;

public class Transceiver
{

    public static void queueMessage(String data)
    {
        try
        {
            FileLoader.writeFile("libs/send.txt", data);
        }
        catch (IOException e)
        {

        }
    }

    public static String getInbox()
    {
        try
        {
            return FileLoader.readFile("libs/receive.txt");
        }
        catch (IOException e)
        {

        }

        return null;
    }

}
