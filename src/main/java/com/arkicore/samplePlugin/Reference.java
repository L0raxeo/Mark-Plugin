package com.arkicore.samplePlugin;

public enum Reference
{

    NAME("Sample Plugin"),

    ID("samplePlugin"),

    VERSION("1.0");

    public final String info;

    Reference(String info)
    {
        this.info = info;
    }

}
