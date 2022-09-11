package com.example.examplemod.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class TileEntityTestBlock extends TileEntity {
    public String[] signText = new String[]{"", "", "", ""};
    public int lineBeingEdited = -1;
    private boolean field_145916_j = true;
    private EntityPlayer field_145917_k;

    public void TileEntitySign() {
    }

    public void writeToNBT(NBTTagCompound p_writeToNBT_1_) {
        super.writeToNBT(p_writeToNBT_1_);
        p_writeToNBT_1_.setString("Text1", this.signText[0]);
        p_writeToNBT_1_.setString("Text2", this.signText[1]);
        p_writeToNBT_1_.setString("Text3", this.signText[2]);
        p_writeToNBT_1_.setString("Text4", this.signText[3]);
    }

    public void readFromNBT(NBTTagCompound p_readFromNBT_1_) {
        this.field_145916_j = false;
        super.readFromNBT(p_readFromNBT_1_);

        for(int var2 = 0; var2 < 4; ++var2) {
            this.signText[var2] = p_readFromNBT_1_.getString("Text" + (var2 + 1));
            if (this.signText[var2].length() > 15) {
                this.signText[var2] = this.signText[var2].substring(0, 15);
            }
        }

    }

    public Packet getDescriptionPacket() {
        String[] var1 = new String[4];
        System.arraycopy(this.signText, 0, var1, 0, 4);
        return new S33PacketUpdateSign(this.xCoord, this.yCoord, this.zCoord, var1);
    }

    public boolean func_145914_a() {
        return this.field_145916_j;
    }

    @SideOnly(Side.CLIENT)
    public void setEditable(boolean p_setEditable_1_) {
        this.field_145916_j = p_setEditable_1_;
        if (!p_setEditable_1_) {
            this.field_145917_k = null;
        }

    }

    public void func_145912_a(EntityPlayer p_145912_1_) {
        this.field_145917_k = p_145912_1_;
    }

    public EntityPlayer func_145911_b() {
        return this.field_145917_k;
    }
}
