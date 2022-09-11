package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TestSword extends ItemSword {

    public TestSword(String name, String texture, ToolMaterial material) {
        super(material);

        this.setTextureName(ExampleMod.MODID + ":" + texture);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setMaxStackSize(1);

        GameRegistry.registerItem(this, name);
    }

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);

        EntityLivingBase el = (EntityLivingBase)par3Entity;
        el.addPotionEffect(new PotionEffect(1, 40, 0));
    }
}
