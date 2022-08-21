package com.example.examplemod.blocks;

import net.minecraft.block.material.Material;

public class RegistryBlock {

    public static TestBlock testBlock;

    public static void registration()
    {
        testBlock = new TestBlock("TestBlock", "texture_test", Material.clay);
    }
}
