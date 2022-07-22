package com.daxtor134.mcbetterbiomes;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Mod(MCBetterBiomes.MOD_ID)
public class MCBetterBiomes
{
	public static final String MOD_ID = "mcbetterbiomes";
	private static final Logger LOGGER = LogUtils.getLogger();

	public MCBetterBiomes()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::onSetup);
		modEventBus.addListener(this::onClientSetup);
		modEventBus.addListener(this::enqueueIMC);
		modEventBus.addListener(this::processIMC);

		ModObjectUtils.registerObjects(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void onSetup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("Initialized MCBetterBiomes");
	}

	private void onClientSetup(final FMLClientSetupEvent event)
	{
		LOGGER.info("Initialized MCBetterBiomes client");
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		// Some example code to dispatch IMC to another mod
		InterModComms.sendTo(MCBetterBiomes.MOD_ID, "helloworldmsg", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event)
	{
		LOGGER.info("Got IMC {}", event.getIMCStream()
				.map(m->m.messageSupplier().get()).
				collect(Collectors.toList()));
	}
}
