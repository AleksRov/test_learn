package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class TestSword extends ItemSword {

    public TestSword(String name, String texture, ToolMaterial material) {
        super(material);

        this.setTextureName(ExampleMod.MODID + ":" + texture);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setMaxStackSize(1);

        GameRegistry.registerItem(this, name);
    }
}
