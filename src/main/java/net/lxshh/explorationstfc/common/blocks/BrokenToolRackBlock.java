package net.lxshh.explorationstfc.common.blocks;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.wood.ToolRackBlock;
import net.lxshh.explorationstfc.common.blockentitites.BrokenToolRackBlockEntity;
import net.lxshh.explorationstfc.common.blockentitites.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BrokenToolRackBlock extends ToolRackBlock {
    public BrokenToolRackBlock(ExtendedProperties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BrokenToolRackBlockEntity toolRack = level.getBlockEntity(pos, ModBlockEntities.BROKEN_TOOL_RACK.get()).orElse(null);
        if (toolRack != null)
        {
            return toolRack.onRightClick(player, getSlotFromPos(state, hit.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ())));
        }
        return InteractionResult.PASS;
    }

    @Override
    public int getSlotFromPos(BlockState state, Vec3 pos) {
        return 0;
    }
}
