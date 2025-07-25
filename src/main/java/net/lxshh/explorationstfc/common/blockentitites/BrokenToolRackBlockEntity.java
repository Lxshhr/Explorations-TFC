package net.lxshh.explorationstfc.common.blockentitites;

import net.dries007.tfc.client.TFCSounds;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blockentities.InventoryBlockEntity;
import net.dries007.tfc.util.Helpers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class BrokenToolRackBlockEntity extends InventoryBlockEntity<ItemStackHandler> {
    private static final Component NAME = Component.translatable("block.explorationstfc.toolrack");

    public BrokenToolRackBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BROKEN_TOOL_RACK.get(), pos, state, defaultInventory(1), NAME);
    }

    public InteractionResult onRightClick(Player player, int slot)
    {
        assert level != null;
        final ItemStack heldItem = player.getMainHandItem();
        final boolean shouldExtract = !inventory.getStackInSlot(slot).isEmpty();
        final boolean shouldInsert = !heldItem.isEmpty() && isItemValid(slot, heldItem);
        if (shouldExtract)
        {
            if (!level.isClientSide)
            {
                ItemHandlerHelper.giveItemToPlayer(player, inventory.extractItem(slot, 1, false), player.getInventory().selected);
            }
            markForBlockUpdate();
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else if (shouldInsert)
        {
            if (!level.isClientSide)
            {
                insertItem(slot, heldItem.split(1));
            }
            markForBlockUpdate();
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack)
    {
        return Helpers.isItem(stack, TFCTags.Items.USABLE_ON_TOOL_RACK);
    }

    @Override
    public int getSlotStackLimit(int slot)
    {
        return 1;
    }

    private void insertItem(int slot, ItemStack stack)
    {
        assert level != null;
        inventory.insertItem(slot, stack, false);
        level.playSound(null, worldPosition, TFCSounds.TOOL_RACK_PLACE.get(), SoundSource.BLOCKS, 1, 1 + ((level.random.nextFloat() - level.random.nextFloat()) / 16));
    }
}
