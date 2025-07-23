package net.lxshh.explorationstfc.common.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StrawPuppetItem extends Item {
    private static final Component[] MESSAGES = new Component[] {
            Component.literal("You feel uneasy holding this...")
    };

    public StrawPuppetItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide() && pEntity instanceof Player player) {
            boolean isHeld = pIsSelected || player.getOffhandItem() == pStack;

            if (isHeld && pLevel.getRandom().nextInt(1000) == 0) {
                int index = pLevel.getRandom().nextInt(MESSAGES.length);

                player.displayClientMessage(MESSAGES[index], true);
            }
        }
    }
}
