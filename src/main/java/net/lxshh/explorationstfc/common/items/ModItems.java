package net.lxshh.explorationstfc.common.items;

import net.dries007.tfc.common.items.TFCItems;
import net.lxshh.explorationstfc.ExplorationsTFC;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExplorationsTFC.MODID);

    public static final RegistryObject<Item> WEATHERED_COPPER_SWORD = register("weathered_copper_sword", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_AXE = register("weathered_copper_axe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_MACE = register("weathered_copper_mace", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_SPEAR = register("weathered_copper_spear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_PICKAXE = register("weathered_copper_pickaxe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_COPPER_SCYTHE = register("weathered_copper_scythe", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUSTY_IRON_PICKAXE = register("rusty_iron_sword", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BEAR_RELIC = register("bear_figurine", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_RELIC = register("penguin_figurine", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_DEER_RELIC = register("gold_deer_relic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_RABBIT_RELIC = register("gold_rabbit_relic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_DUCK_RELIC = register("gold_duck_relic", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAW_PUPPET = register("straw_puppet", () -> new StrawPuppetItem(new Item.Properties()));

    // public static final RegistryObject<Item> CHIPPED_CROWN = register("chipped_crown");
    // public static final RegistryObject<Item> CHIPPED_NECKLACE = register("chipped_necklace");

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name.toLowerCase(Locale.ROOT), item);
    }
}
