package net.bogans.pepsimod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.bogans.pepsimod.PepsiMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup PEPSI;

    public static void registerItemGroups() {
        PEPSI = FabricItemGroup.builder(new Identifier(PepsiMod.MOD_ID, "pepsi"))
                .displayName(Text.translatable("itemgroup.pepsi"))
                .icon(() -> new ItemStack(ModItems.PEPSIBOTTLE)).build();
    }
}
