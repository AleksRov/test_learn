package com.example.examplemod.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

public class TileEntityTestBlock extends TileEntity {

    boolean test;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        test = nbt.getBoolean("test");

        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("test", test);

        super.writeToNBT(nbt);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!worldObj.isRemote) {
            List<EntityPlayer> list = worldObj.playerEntities;

            for (EntityPlayer player : list) {
                test = player.capabilities.isCreativeMode;

                // Что то обновляет
//                this.worldObj.notifyBlockChange(this.xCoord, this.yCoord, this.zCoord, this.blockType);
                this.markDirty();
            }
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();

        this.writeToNBT(nbt);
        System.out.println("Нечто");
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, -999, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
        System.out.println(test);
    }
}
