package com.example.examplemod.items;

public class RegistryItem {

    public static TestItem testItem;

    public static void registration()
    {
        testItem = new TestItem("TestItem", "texture_test", 2, 2, false, 10 , 1, 1);
    }
}
