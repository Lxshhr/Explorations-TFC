package net.lxshh.explorationstfc.common.blockentitites;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

import static net.dries007.tfc.common.fluids.Alcohol.BEER;

public class PitcherBlockEntity extends BlockEntity {
    private final FluidTank fluidTank = new FluidTank(1000);

    public PitcherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CLAY_PITCHER.get(), pPos, pBlockState);
    }
    // Even more scuffed, but works :)
    public static final Map<Fluid, Integer> FLUIDS = Map.of(
            Fluids.WATER, 50,
            TFCBlocks.SALT_WATER.get().getFluid(), 30,
            TFCBlocks.ALCOHOLS.get(BEER).get().getFluid(), 10
    );
    // This looks so scuffed
    public void randomizeFluidContent() {
        int weight = FLUIDS.values().stream().mapToInt(i -> i).sum();
        Random random = new Random();
        Fluid randomFluid = Fluids.EMPTY;
        int i = 0;
        for (Map.Entry<Fluid, Integer> entry : FLUIDS.entrySet()) {
            i += entry.getValue();
            if (random.nextInt(weight) < i) {
                randomFluid = entry.getKey();
                break;
            }
        }
        int minAmount = 230;
        int randomAmount = minAmount + random.nextInt(651);
        fluidTank.setFluid(new FluidStack(randomFluid, randomAmount));
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction side) {
        if (capability == ForgeCapabilities.FLUID_HANDLER) {
            return LazyOptional.of(() -> fluidTank).cast();
        }
        return super.getCapability(capability, side);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("FluidTank", fluidTank.writeToNBT(new CompoundTag()));
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        fluidTank.readFromNBT(tag.getCompound("FluidTank"));
    }


}
