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
    //adds Bottle of Pepsi
    public static final Item PEPSIBOTTLE = registerItem("pepsibottle",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 3), 1F).build())));

    //adds Can of Pepsi
    public static final Item PEPSICAN = registerItem("pepsican",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 3), 1F).build())));

   //adds Pepsi
    public static final Item PEPSI = registerItem("pepsi",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 3), 1F).build())));

    //adds Can
    public static final Item CAN = registerItem("can",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 4, 1), 1F).build())));

    //adds Bottle
    public static final Item BOTTLE = registerItem("bottle",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 4, 1), 1F).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PepsiMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {

        //adds items to vanilla groups
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, PEPSIBOTTLE);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, PEPSICAN);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, PEPSI);
        addToItemGroup(ItemGroups.INGREDIENTS, CAN);
        addToItemGroup(ItemGroups.INGREDIENTS, BOTTLE);

        //adds items to pepsi group
        addToItemGroup(ModItemGroup.PEPSI, PEPSIBOTTLE);
        addToItemGroup(ModItemGroup.PEPSI, PEPSICAN);
        addToItemGroup(ModItemGroup.PEPSI, PEPSI);
        addToItemGroup(ModItemGroup.PEPSI, CAN);
        addToItemGroup(ModItemGroup.PEPSI, BOTTLE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        PepsiMod.LOGGER.info("Registering Mod Items for " + PepsiMod.MOD_ID);

        addItemsToItemGroup();
    }
}
