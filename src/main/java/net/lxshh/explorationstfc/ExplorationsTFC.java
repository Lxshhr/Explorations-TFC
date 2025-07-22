package net.lxshh.explorationstfc;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExplorationsTFC.MODID)
public class ExplorationsTFC
{
    public static final String MODID = "explorationstfc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExplorationsTFC()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}