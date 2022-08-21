package com.example.examplemod;

import com.example.examplemod.blocks.RegistryBlock;
import com.example.examplemod.items.RegistryItem;
import com.example.examplemod.tile.TileEntityTestBlock;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

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
        GameRegistry.registerTileEntity(TileEntityTestBlock.class, "TileEntityTestBlock");
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

}