package com.example.examplemod.items;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class RegistryItem {

    public static TestItem testItem;

    public static TestSword testSword;

    public static void registration()
    {
        testItem = new TestItem("TestItem", "texture_test", 2, 2, false, 10 , 1, 1);

        testSword = new TestSword("ТestSword", "texture_test", Item.ToolMaterial.IRON);
    }
}
