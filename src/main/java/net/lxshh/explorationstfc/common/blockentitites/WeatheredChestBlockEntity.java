package net.lxshh.explorationstfc.common.blockentitites;

import net.dries007.tfc.common.blockentities.TFCChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheredChestBlockEntity extends TFCChestBlockEntity {

    public WeatheredChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WEATHERED_CHEST.get(), pPos, pBlockState);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems) {
    }
}
