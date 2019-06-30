package mcjty.rftoolspower.blocks;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public final class ModBlocks {

    @ObjectHolder("rftoolspower:celltextures")
    public static Block CELL_TEXTURES;

    @ObjectHolder("rftoolspower:cell1")
    public static PowerCellBlock CELL1;

    @ObjectHolder("rftoolspower:cell2")
    public static PowerCellBlock CELL2;

    @ObjectHolder("rftoolspower:cell3")
    public static PowerCellBlock CELL3;

    @ObjectHolder("rftoolspower:information_screen")
    public static InformationScreenBlock INFORMATION_SCREEN;

    @ObjectHolder("rftoolspower:cell1")
    public static TileEntityType<?> TYPE_CELL1;

    @ObjectHolder("rftoolspower:cell2")
    public static TileEntityType<?> TYPE_CELL2;

    @ObjectHolder("rftoolspower:cell3")
    public static TileEntityType<?> TYPE_CELL3;

    @ObjectHolder("rftoolspower:information_screen")
    public static TileEntityType<?> TYPE_INFORMATION_SCREEN;

    public static void initClient() {
        InformationScreenRenderer.register();
    }
}
