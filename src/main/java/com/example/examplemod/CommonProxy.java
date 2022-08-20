package com.example.examplemod;

import com.example.examplemod.blocks.RegistryBlock;
import com.example.examplemod.items.RegistryItem;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Регистрация блоков, для того чтобы реализовывать и на клиенте и на сервере.
 */
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryItem.registration();
        RegistryBlock.registration();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

}