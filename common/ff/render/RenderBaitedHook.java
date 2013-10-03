package ff.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import ff.entity.EntityBaitedHook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class RenderBaitedHook extends Render{
    /**
    * Actually renders the fishing line and hook
    */
    public void doRenderFishHook(EntityBaitedHook par1EntityBaitedHook, double par2, double par4, double par6, float par8, float par9)
    {
    GL11.glPushMatrix();
    GL11.glTranslatef((float)par2, (float)par4, (float)par6);
    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    GL11.glScalef(0.5F, 0.5F, 0.5F);
    byte b0 = 1;
    byte b1 = 2;
    this.loadTexture("/particles.png");//LOAD TEXTURE HERE?
    Tessellator tessellator = Tessellator.instance;
    float f2 = (float)(b0 * 8 + 0) / 128.0F;
    float f3 = (float)(b0 * 8 + 8) / 128.0F;
    float f4 = (float)(b1 * 8 + 0) / 128.0F;
    float f5 = (float)(b1 * 8 + 8) / 128.0F;
    float f6 = 1.0F;
    float f7 = 0.5F;
    float f8 = 0.5F;
    GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 1.0F, 0.0F);
    tessellator.addVertexWithUV((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)f2, (double)f5);
    tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)f3, (double)f5);
    tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f3, (double)f4);
    tessellator.addVertexWithUV((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)f2, (double)f4);
    tessellator.draw();
    GL11.glDisable(GL12.GL_RESCALE_NORMAL);
    GL11.glPopMatrix();

    if (par1EntityBaitedHook.angler != null)
    {
    float f9 = par1EntityBaitedHook.angler.getSwingProgress(par9);
    float f10 = MathHelper.sin(MathHelper.sqrt_float(f9) * (float)Math.PI);
    Vec3 vec3 = par1EntityBaitedHook.worldObj.getWorldVec3Pool().getVecFromPool(-0.5D, 0.03D, 0.8D);
    vec3.rotateAroundX(-(par1EntityBaitedHook.angler.prevRotationPitch + (par1EntityBaitedHook.angler.rotationPitch - par1EntityBaitedHook.angler.prevRotationPitch) * par9) * (float)Math.PI / 180.0F);
    vec3.rotateAroundY(-(par1EntityBaitedHook.angler.prevRotationYaw + (par1EntityBaitedHook.angler.rotationYaw - par1EntityBaitedHook.angler.prevRotationYaw) * par9) * (float)Math.PI / 180.0F);
    vec3.rotateAroundY(f10 * 0.5F);
    vec3.rotateAroundX(-f10 * 0.7F);
    double d3 = par1EntityBaitedHook.angler.prevPosX + (par1EntityBaitedHook.angler.posX - par1EntityBaitedHook.angler.prevPosX) * (double)par9 + vec3.xCoord;
    double d4 = par1EntityBaitedHook.angler.prevPosY + (par1EntityBaitedHook.angler.posY - par1EntityBaitedHook.angler.prevPosY) * (double)par9 + vec3.yCoord;
    double d5 = par1EntityBaitedHook.angler.prevPosZ + (par1EntityBaitedHook.angler.posZ - par1EntityBaitedHook.angler.prevPosZ) * (double)par9 + vec3.zCoord;
    double d6 = par1EntityBaitedHook.angler != Minecraft.getMinecraft().thePlayer ? (double)par1EntityBaitedHook.angler.getEyeHeight() : 0.0D;

    if (this.renderManager.options.thirdPersonView > 0 || par1EntityBaitedHook.angler != Minecraft.getMinecraft().thePlayer)
    {
    float f11 = (par1EntityBaitedHook.angler.prevRenderYawOffset + (par1EntityBaitedHook.angler.renderYawOffset - par1EntityBaitedHook.angler.prevRenderYawOffset) * par9) * (float)Math.PI / 180.0F;
    double d7 = (double)MathHelper.sin(f11);
    double d8 = (double)MathHelper.cos(f11);
    d3 = par1EntityBaitedHook.angler.prevPosX + (par1EntityBaitedHook.angler.posX - par1EntityBaitedHook.angler.prevPosX) * (double)par9 - d8 * 0.35D - d7 * 0.85D;
    d4 = par1EntityBaitedHook.angler.prevPosY + d6 + (par1EntityBaitedHook.angler.posY - par1EntityBaitedHook.angler.prevPosY) * (double)par9 - 0.45D;
    d5 = par1EntityBaitedHook.angler.prevPosZ + (par1EntityBaitedHook.angler.posZ - par1EntityBaitedHook.angler.prevPosZ) * (double)par9 - d7 * 0.35D + d8 * 0.85D;
    }

    double d9 = par1EntityBaitedHook.prevPosX + (par1EntityBaitedHook.posX - par1EntityBaitedHook.prevPosX) * (double)par9;
    double d10 = par1EntityBaitedHook.prevPosY + (par1EntityBaitedHook.posY - par1EntityBaitedHook.prevPosY) * (double)par9 + 0.25D;
    double d11 = par1EntityBaitedHook.prevPosZ + (par1EntityBaitedHook.posZ - par1EntityBaitedHook.prevPosZ) * (double)par9;
    double d12 = (double)((float)(d3 - d9));
    double d13 = (double)((float)(d4 - d10));
    double d14 = (double)((float)(d5 - d11));
    GL11.glDisable(GL11.GL_TEXTURE_2D);
    GL11.glDisable(GL11.GL_LIGHTING);
    tessellator.startDrawing(3);
    tessellator.setColorOpaque_I(0);
    byte b2 = 16;

    for (int i = 0; i <= b2; ++i)
    {
    float f12 = (float)i / (float)b2;
    tessellator.addVertex(par2 + d12 * (double)f12, par4 + d13 * (double)(f12 * f12 + f12) * 0.5D + 0.25D, par6 + d14 * (double)f12);
    }

    tessellator.draw();
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
    }

    /**
    * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
    * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
    * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
    * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
    */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
    this.doRenderFishHook((EntityBaitedHook)par1Entity, par2, par4, par6, par8, par9);
    }
   
}
