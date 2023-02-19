package net.bogans.pepsimod.item;

import net.bogans.pepsimod.PepsiMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PEPSI = registerItem("pepsi",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 250, 0), 1F).build())));
    public static final Item pepsican = registerItem("pepsican",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 0), 1F).build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PepsiMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, PEPSI);
        addToItemGroup(ItemGroups.INGREDIENTS, pepsican);

        addToItemGroup(ModItemGroup.PEPSI, PEPSI);
        addToItemGroup(ModItemGroup.PEPSI, pepsican);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        PepsiMod.LOGGER.info("Registering Mod Items for " + PepsiMod.MOD_ID);

        addItemsToItemGroup();
    }
}
