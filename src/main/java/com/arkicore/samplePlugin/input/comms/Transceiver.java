package com.arkicore.samplePlugin.input.comms;

import com.arkicore.samplePlugin.utils.FileLoader;

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
            e.printStackTrace();
        }
    }

    public static String getInbox()
    {
        try
        {
            FileLoader.writeFile("libs/receive.txt", "");
            return FileLoader.readFile("libs/receive.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
