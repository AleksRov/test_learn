package com.example.examplemod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class TestBlock extends ItemBlock {

    public TestBlock(Block block, String name)
    {
        super(block);

        //this.setUnlocalizedName(name);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        //регистрация после найстроки
        GameRegistry.registerItem(this, name);
    }
}