package com.example.examplemod.blocks;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.tile.TileEntityTestBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockSign;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

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
        if (!world.isRemote) {
            if (player.capabilities.isCreativeMode) {
                TileEntitySign tileEntity = (TileEntitySign)world.getTileEntity(x, y, z);
                //   tileEntity.markDirty();
                System.out.println(tileEntity);
                player.func_146100_a(tileEntity);
            }
        } else if (!player.capabilities.isCreativeMode) {
            TileEntitySign tileEntity = (TileEntitySign)world.getTileEntity(x, y, z);

            String string = "";

            for (String text : tileEntity.signText) {
                string+= " " + text;
            }

            StringSelection stringSelection = new StringSelection(string);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            player.addChatMessage(new ChatComponentText(string));
        }
        // world.createExplosion(player, x, y, z, 1, true);

        return true;
    }

    // Присвоить тиле

    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return true;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySign();
    }
}
