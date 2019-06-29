package mcjty.rftoolspower.setup;


import mcjty.rftoolspower.RFToolsPower;
import mcjty.rftoolspower.blocks.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;

@Mod.EventBusSubscriber(modid = RFToolsPower.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistration {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
//        ModBlocks.initClient();
        ModelLoaderRegistry.registerLoader(new BakedModelLoader());
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> sounds) {
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        for (SideType value : SideType.VALUES) {
            if (value.getSideTexture() != null) {
//                event.getMap().stitch(mc.getResourceManager(), Collections.singleton(new ResourceLocation(value.getSideTexture())), mc.getProfiler());
                for (Tier tier : Tier.VALUES) {
                    ResourceLocation location = new ResourceLocation(value.getSideTexture() + tier.getSuffix());
                    System.out.println("location = " + location);
                    event.getMap().func_215244_a(mc.textureManager, mc.getResourceManager(),
                            location, mc);
                }
            }
            if (value.getUpDownTexture() != null) {
//                event.getMap().stitch(mc.getResourceManager(), Collections.singleton(new ResourceLocation(value.getUpDownTexture())), mc.getProfiler());
                event.getMap().func_215244_a(mc.textureManager, mc.getResourceManager(),
                        new ResourceLocation(value.getUpDownTexture()), mc);
            }
        }
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.CELL1.getRegistryName(), ""), new GenericCellBakedModel(DefaultVertexFormats.BLOCK));
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.CELL1.getRegistryName(), "lower=false,upper=false"), new GenericCellBakedModel(DefaultVertexFormats.BLOCK));
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.CELL1.getRegistryName(), "lower=false,upper=true"), new GenericCellBakedModel(DefaultVertexFormats.BLOCK));
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.CELL1.getRegistryName(), "lower=true,upper=false"), new GenericCellBakedModel(DefaultVertexFormats.BLOCK));
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.CELL1.getRegistryName(), "lower=true,upper=true"), new GenericCellBakedModel(DefaultVertexFormats.BLOCK));
    }
}
