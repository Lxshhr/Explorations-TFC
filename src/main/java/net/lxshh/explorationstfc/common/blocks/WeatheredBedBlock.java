package net.lxshh.explorationstfc.common.blocks;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WeatheredBedBlock extends BedBlock {
    private static final VoxelShape SHAPE = box(0, 0, 0, 16, 9, 16);

    private final ExtendedProperties properties;

    public WeatheredBedBlock(ExtendedProperties pProperties) {
        super(DyeColor.LIGHT_GRAY, pProperties.properties());
        this.properties = pProperties;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            pPlayer.displayClientMessage(Component.literal("This bed is to weathered to sleep on"), false);
        }
        return InteractionResult.SUCCESS;
    }

//    @Override
//    public boolean isBed(BlockState state, BlockGetter level, BlockPos pos, @Nullable Entity player) {
//        return false;
//    }
}
