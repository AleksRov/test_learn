package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;


public class TestItem extends ItemFood {

    public TestItem(String name, String texture, int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat, int duration, int amplifier, float effectProbability)
    {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat);

        this.setPotionEffect(Potion.wither.getId(), duration, amplifier, effectProbability);

        this.setUnlocalizedName(name);
        this.setTextureName(ExampleMod.MODID + ":" + texture);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        //регистрация после найстроки
        GameRegistry.registerItem(this, name);
    }
}
