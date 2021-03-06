package net.killermapper.galacticores.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.galacticores.GalacticOres;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemIngots extends Item
{

    private String[] type = new String[] {"itemMercurianIngot", "itemPlutoniumIngot", "itemBismuthIngot", "itemCentauriumIngot", "itemIridiumIngot", "itemEuropiumIngot", "itemPalladiumIngot", "itemRhodiumIngot"};
    private IIcon[] IconArray;

    public ItemIngots()
    {
        this.setCreativeTab(GalacticOres.GOTab);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int metadata)
    {
        return metadata;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int metadata = stack.getItemDamage();
        if(metadata > type.length || metadata < 0)
        {
            metadata = 0;
        }
        return super.getUnlocalizedName() + "." + type[metadata];
    }

    public void registerIcons(IIconRegister iconregister)
    {
        IconArray = new IIcon[type.length];
        for(int i = 0; i < type.length; i++)
        {
            IconArray[i] = iconregister.registerIcon(GalacticOres.MODID + ":" + type[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for(int metadata = 0; metadata < type.length; metadata++)
        {
            list.add(new ItemStack(item, 1, metadata));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return metadata < type.length && metadata >= 0 ? IconArray[metadata] : IconArray[0];
    }

}