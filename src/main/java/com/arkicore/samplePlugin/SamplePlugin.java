package com.arkicore.samplePlugin;

import com.arkicore.samplePlugin.init.ProgramStructure;
import com.arkicore.samplePlugin.utils.Registry;

import java.io.IOException;
import java.util.ArrayList;

public class SamplePlugin
{

    private final ArrayList<Registry> registries = new ArrayList<>();

    public void wake()
    {
        registerRegistries();

        try
        {
            preInit();
            init();
            postInit();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void registerRegistries()
    {
        registries.add(new ProgramStructure());
    }

    private void preInit() throws IOException
    {
        for (Registry r : registries)
        {
            r.preInit();
        }
    }

    private void init() throws IOException
    {
        for (Registry r : registries)
        {
            r.init();
        }
    }

    private void postInit() throws IOException
    {
        for (Registry r : registries)
        {
            r.postInit();
        }
    }

}
