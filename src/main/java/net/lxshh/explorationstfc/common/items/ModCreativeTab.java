package net.lxshh.explorationstfc.common.items;

import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.common.blocks.soil.SandBlockType;
import net.dries007.tfc.common.blocks.soil.SoilBlockType;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.lxshh.explorationstfc.ExplorationsTFC;
import net.lxshh.explorationstfc.common.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExplorationsTFC.MODID);

    public static final RegistryObject<CreativeModeTab> EXPLORATIONS_TFC = CREATIVE_MODE_TABS.register("explorations_tfc",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRACKED_IDOL.get()))
                    .title(Component.translatable("creativetab.explorations_tfc"))
                    .displayItems(((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.WEATHERED_COPPER_DAGGER.get());
                        pOutput.accept(ModItems.WEATHERED_COPPER_AXE.get());
                        pOutput.accept(ModItems.WEATHERED_COPPER_SPEAR.get());
                        pOutput.accept(ModItems.WEATHERED_COPPER_SCYTHE.get());
                        pOutput.accept(ModItems.RUSTY_IRON_SWORD.get());
                        pOutput.accept(ModItems.BEAR_RELIC.get());
                        pOutput.accept(ModItems.PENGUIN_RELIC.get());
                        pOutput.accept(ModItems.GOLDEN_DEER_RELIC.get());
                        pOutput.accept(ModItems.GOLDEN_DUCK_RELIC.get());
                        pOutput.accept(ModItems.CRACKED_IDOL.get());
                        pOutput.accept(ModItems.METALLIC_SCRAP.get());
                        pOutput.accept(ModItems.BENT_GEAR.get());
                        pOutput.accept(ModItems.LUCKY_ROCK.get());

                        pOutput.accept(ModBlocks.CRACKED_BRICKS.get());
                        pOutput.accept(ModBlocks.CRACKED_FIRE_BRICKS.get());
                        pOutput.accept(ModBlocks.RUSTY_ANVIL.get());
                        pOutput.accept(ModBlocks.BROKEN_COPPER_LAMP.get());
                        pOutput.accept(ModBlocks.BROKEN_IRON_LAMP.get());
                        pOutput.accept(ModBlocks.WEATHERED_BED.get());
                        pOutput.accept(ModBlocks.GOLDEN_GOBLET.get());

                        pOutput.accept(ModBlocks.CRUMBLING_WATTLE.get());
                        for (DyeColor color : DyeColor.values()) {
                            pOutput.accept(ModBlocks.CRUMBLING_STAINED_WATTLE.get(color).get());
                            pOutput.accept(ModBlocks.CLAY_POT.get(color).get());
                            pOutput.accept(ModBlocks.CLAY_POT_FARMING.get(color).get());
                            pOutput.accept(ModBlocks.CLAY_POT_ORE.get(color).get());
                        }
                        for (Wood wood: Wood.values()) {
                            pOutput.accept(ModBlocks.WEATHERED_LOG.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_STRIPPED_LOG.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_PLANK.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_STAIRS.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_SLAB.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_DOOR.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_TRAPDOOR.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_FENCE.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_FENCE_GATE.get(wood).get());
                            pOutput.accept(ModBlocks.WEATHERED_CHEST.get(wood).get());
                            pOutput.accept(ModBlocks.BROKEN_TOOL_RACK.get(wood).get());
                        }
                        for (SandBlockType sand: SandBlockType.values()) {
                            pOutput.accept(ModBlocks.SUSPICIOUS_SAND.get(sand).get());
                        }
                        for (Rock rock: Rock.values()) {
                            pOutput.accept(ModBlocks.SUSPICIOUS_GRAVEL.get(rock).get());
                        }
                        for (SoilBlockType.Variant soil: SoilBlockType.Variant.values()) {
                            pOutput.accept(ModBlocks.SUSPICIOUS_DIRT.get(soil).get());
                        }
                        pOutput.accept(ModBlocks.CLAY_PITCHER.get());
                    }))
                    .build());


}
