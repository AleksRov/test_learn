package com.example.examplemod.blocks;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.tile.TileEntityTestBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestBlock extends BlockContainer {

    public TestBlock(String name, String texture, Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockName(name);
        this.setBlockTextureName(ExampleMod.MODID + ":" + texture);
        this.setHardness(1);

        GameRegistry.registerBlock(this, name);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
       // world.createExplosion(player, x, y, z, 1, true);
        world.getTileEntity(x, y, z).markDirty();
        return true;
    }

    // Присвоить тиле

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityTestBlock();
    }
}
