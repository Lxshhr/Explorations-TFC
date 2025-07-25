package net.lxshh.explorationstfc.common.items;

import net.lxshh.explorationstfc.ExplorationsTFC;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExplorationsTFC.MODID);

    public static final RegistryObject<Item> WEATHERED_COPPER_DAGGER = register("weathered_copper_dagger", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_AXE = register("weathered_copper_axe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_SPEAR = register("weathered_copper_spear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_SCYTHE = register("weathered_copper_scythe", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUSTY_IRON_SWORD = register("rusty_iron_sword", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BEAR_RELIC = register("bear_relic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_RELIC = register("penguin_relic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_DEER_RELIC = register("gold_deer_relic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_DUCK_RELIC = register("gold_duck_relic", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRACKED_IDOL = register("cracked_idol", () -> new CrackedDolItem(new Item.Properties()));

    public static final RegistryObject<Item> METALLIC_SCRAP = register("metallic_scrap", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BENT_GEAR = register("cracked_gear", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUCKY_ROCK = register("lucky_rock", () -> new TooltipItem(new Item.Properties(), "Just a Lucky Rock!"));

    // public static final RegistryObject<Item> CHIPPED_CROWN = register("chipped_crown");
    // public static final RegistryObject<Item> DUSTY_LOCKET = register("chipped_necklace");
    // public static final RegistryObject<Item> AMULET = register("amulet");

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name.toLowerCase(Locale.ROOT), item);
    }

}
