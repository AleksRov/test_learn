package com.example.examplemod.items;

public class RegistryItem {

    public static TestItem testItem;

    public static TestBlock testBlock;

    public static void registration()
    {
        testItem = new TestItem("TestItem", "texture_test", 2, 2, false, 10 , 1, 1);

       // testBlock = new TestBlock(com.example.examplemod.blocks.TestBlock, "TestBlock");
    }
}
