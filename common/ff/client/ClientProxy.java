package ff.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import ff.CommonProxy;
import ff.entity.EntityBaitedHook;
import ff.render.RenderBaitedHook;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBaitedHook.class, new RenderBaitedHook());
    }
}
