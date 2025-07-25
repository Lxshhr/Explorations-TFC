package net.lxshh.explorationstfc.common.blocks;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.wood.TFCChestBlock;
import net.lxshh.explorationstfc.common.blockentitites.ModBlockEntities;

public class WeatheredChestBlock extends TFCChestBlock {

    public WeatheredChestBlock(ExtendedProperties properties, String textureLocation) {
        super(properties, textureLocation, ModBlockEntities.WEATHERED_CHEST::get);
    }

}
