package com.arkicore.samplePlugin.init;

import com.arkicore.samplePlugin.Reference;
import com.arkicore.samplePlugin.input.comms.Transceiver;
import com.arkicore.samplePlugin.utils.FileLoader;
import com.arkicore.samplePlugin.utils.Registry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ProgramStructure implements Registry
{

    @Override
    public void preInit()
    {
        Files.exists(Paths.get("libs"));
        {
            // Creates new directory if plugins directory doesn't exist
            boolean wasSuccessful = new File("libs").mkdirs();

            if (wasSuccessful)
            {
                System.out.println("[Sample Plugin] pre-init/INFO [com.arkicore.samplePlugin.init]: successfully created libs directory");
            }
        }
    }

    @Override
    public void init() throws IOException
    {
        if (!Files.exists(Paths.get("libs/info.txt")))
        {
            FileLoader.writeFile("libs/info.txt", Reference.NAME.info, Reference.ID.info, Reference.VERSION.info);
        }

        if (!Files.exists(Paths.get("libs/send.txt")))
        {
            FileLoader.writeFile("libs/send.txt");
        }

        if (!Files.exists(Paths.get("libs/receive.txt")))
        {
            FileLoader.writeFile("libs/receive.txt");
        }
    }

    @Override
    public void postInit()
    {
        boolean receivedPing = false;

        while (!receivedPing)
        {
            if (Objects.equals(Transceiver.getInbox(), "[.d/ping_for_" + Reference.ID.info + "]"))
            {
                Transceiver.queueMessage("[.d/ping_received_for_" + Reference.ID.info + "]");
                receivedPing = true;
            }
        }
    }
}
