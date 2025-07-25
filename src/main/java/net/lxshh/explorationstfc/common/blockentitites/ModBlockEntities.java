package net.lxshh.explorationstfc.common.blockentitites;

import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.lxshh.explorationstfc.ExplorationsTFC;
import net.lxshh.explorationstfc.common.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;


import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExplorationsTFC.MODID);

    public static final RegistryObject<BlockEntityType<WeatheredChestBlockEntity>> WEATHERED_CHEST = register("weathered_chest", WeatheredChestBlockEntity::new,
            Stream.of(ModBlocks.WEATHERED_CHEST.values()).<Supplier<? extends Block>>flatMap(Helpers::flatten));
    public static final RegistryObject<BlockEntityType<BrokenToolRackBlockEntity>> BROKEN_TOOL_RACK = register("broken_tool_rack", BrokenToolRackBlockEntity::new,
            Stream.of(ModBlocks.BROKEN_TOOL_RACK.values()).<Supplier<? extends Block>>flatMap(Helpers::flatten));

    public static final RegistryObject<BlockEntityType<PitcherBlockEntity>> CLAY_PITCHER = register("clay_pitcher", PitcherBlockEntity::new, ModBlocks.CLAY_PITCHER);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> factory, Supplier<? extends Block> block)
    {
        return RegistrationHelpers.register(BLOCK_ENTITIES, name, factory, block);
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> factory, Stream<? extends Supplier<? extends Block>> blocks)
    {
        return RegistrationHelpers.register(BLOCK_ENTITIES, name, factory, blocks);
    }
}

