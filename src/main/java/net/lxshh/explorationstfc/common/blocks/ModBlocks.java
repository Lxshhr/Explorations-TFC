package net.lxshh.explorationstfc.common.blocks;

import net.dries007.tfc.common.blocks.ExtendedBlock;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.SandstoneBlockType;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.common.blocks.soil.DirtBlock;
import net.dries007.tfc.common.blocks.soil.SandBlockType;
import net.dries007.tfc.common.blocks.soil.SoilBlockType;
import net.dries007.tfc.common.blocks.wood.*;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistryWood;
import net.lxshh.explorationstfc.ExplorationsTFC;
import net.lxshh.explorationstfc.common.items.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExplorationsTFC.MODID);

    public static final RegistryObject<Block> RUSTY_ANVIL = register("rusty_anvil", () -> new RustyAnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> CRACKED_FIRE_BRICKS = register("cracked_fire_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_BRICKS = register("cracked_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).strength(2.0F, 4.0F)));

    public static final Map<DyeColor, RegistryObject<Block>> LOOT_VESSEL_FARMING = Helpers.mapOfKeys(DyeColor.class, color ->
            register(color.getName() + "_loot_vessel_farm", () -> new LootVesselBlock(BlockBehaviour.Properties.of().mapColor(color.getMapColor()).instabreak().noOcclusion().sound(SoundType.DECORATED_POT))));

    public static final Map<DyeColor, RegistryObject<Block>> LOOT_VESSEL_ORE = Helpers.mapOfKeys(DyeColor.class, color ->
            register(color.getName() + "_loot_vessel_ore", () -> new LootVesselBlock(BlockBehaviour.Properties.of().mapColor(color.getMapColor()).instabreak().noOcclusion().sound(SoundType.DECORATED_POT))));

    public static final Map<DyeColor, RegistryObject<Block>> LOOT_VESSEL = Helpers.mapOfKeys(DyeColor.class, color ->
            register(color.getName() + "_loot_vessel", () -> new LootVesselBlock(BlockBehaviour.Properties.of().mapColor(color.getMapColor()).instabreak().noOcclusion().sound(SoundType.DECORATED_POT))));

    // Large Vessel Block
//    public static final Map<DyeColor, RegistryObject<Block>> LARGE_LOOT_VESSEL = Helpers.mapOfKeys(DyeColor.class, color ->
//            register(color.getName() + "_loot_vessel", () -> new Block(BlockBehaviour.Properties.of().mapColor(color.getMapColor()).strength(1.0F, 1.0F))));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_PLANK = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_plank", () -> new ExtendedBlock(properties(wood).strength(1.5F, 3.0F))));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_STAIRS = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_stairs", () -> new TFCStairBlock(() ->
                    wood.getBlock(Wood.BlockType.PLANKS).get().defaultBlockState(), properties(wood).strength(1.5F, 3.0F))));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_SLAB = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_slab", () -> new TFCSlabBlock(properties(wood).strength(1.5F, 3.0F))));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_DOOR = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_door", () -> new TFCDoorBlock(properties(wood).strength(3.0F).noOcclusion(), wood.getBlockSet())));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_TRAPDOOR = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_trapdoor", () -> new TFCTrapDoorBlock(properties(wood).strength(3.0F), wood.getBlockSet())));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_FENCE = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_fence", () -> new TFCFenceBlock(properties(wood).strength(2.0F, 3.0F))));

    public static final Map<Wood, RegistryObject<Block>> WEATHERED_FENCE_GATE = Helpers.mapOfKeys(Wood.class, wood ->
            register("weathered_" + wood.name().toLowerCase(Locale.ROOT) + "_fence_gate", () -> new TFCFenceGateBlock(properties(wood).strength(2.0F, 3.0F))));

    //Chests, Racks

    public static final Map<SandBlockType, RegistryObject<Block>> SUSPICIOUS_SAND = Helpers.mapOfKeys(SandBlockType.class, type ->
            register("suspicious_sand_" + type.name().toLowerCase(Locale.ROOT), () -> new BrushableBlock(TFCBlocks.SAND.get(type).get(), BlockBehaviour.Properties.of().mapColor(type.getMaterialColor()).strength(0.3F).sound(SoundType.SUSPICIOUS_SAND), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED)));

    public static final Map<Rock, RegistryObject<Block>> SUSPICIOUS_GRAVEL = Helpers.mapOfKeys(Rock.class, type ->
            register("suspicious_gravel_" + type.name().toLowerCase(Locale.ROOT), () -> new BrushableBlock(TFCBlocks.ROCK_BLOCKS.get(type).get(Rock.BlockType.GRAVEL).get(), BlockBehaviour.Properties.of().mapColor(type.color()).strength(0.3F).sound(SoundType.SUSPICIOUS_GRAVEL), SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED)));

    public static final Map<SoilBlockType.Variant, RegistryObject<Block>> SUSPICIOUS_DIRT = Helpers.mapOfKeys(SoilBlockType.Variant.class, type ->
            register("suspicious_dirt_" + type.name().toLowerCase(Locale.ROOT), () -> new BrushableBlock(TFCBlocks.SOIL.get(SoilBlockType.DIRT).get(type).get(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.3F).sound(SoundType.SUSPICIOUS_GRAVEL), SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED)));

    public static final RegistryObject<Block> CRUMBLING_WATTLE = register("crumbling_wattle", () -> new ExtendedBlock(ExtendedProperties.of(MapColor.WOOD).strength(0.2F).sound(SoundType.SCAFFOLDING).flammable(60, 30)));
    public static final Map<DyeColor, RegistryObject<Block>> CRUMBLING_STAINED_WATTLE = Helpers.mapOfKeys(DyeColor.class, color ->
            register("crumbling_wattle_" + color.getName(), () -> new ExtendedBlock(ExtendedProperties.of(MapColor.WOOD).strength(0.2F).sound(SoundType.SCAFFOLDING).flammable(60, 30))));

    public static final RegistryObject<Block> BROKEN_COPPER_LAMP = register("empty_copper_lamp", () -> new EmptyLampBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).mapColor(DyeColor.ORANGE).strength(2, 6).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BROKEN_IRON_LAMP = register("empty_iron_lamp", () -> new EmptyLampBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).mapColor(DyeColor.LIGHT_GRAY).strength(2, 6).pushReaction(PushReaction.DESTROY)));


    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        register(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> register(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static ExtendedProperties properties(RegistryWood wood) {
        return ExtendedProperties.of(wood.woodColor())
                .flammableLikePlanks()
                .sound(SoundType.WOOD)
                .instrument(NoteBlockInstrument.BASS);
    }



}