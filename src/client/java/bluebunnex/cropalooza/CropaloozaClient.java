package bluebunnex.cropalooza;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class CropaloozaClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		for (ModCrop crop : ModCrop.getAllInstances())
			BlockRenderLayerMap.INSTANCE.putBlock(crop.cropBlock, RenderLayer.getCutout());
	}
}