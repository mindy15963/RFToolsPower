package mcjty.rftoolspower.blocks;

import mcjty.rftoolspower.RFToolsPower;
import net.minecraft.util.IStringSerializable;

import java.util.Arrays;
import java.util.List;

public enum SideType implements IStringSerializable {
    INVISIBLE(null, null, false, false),
    BOTH_OUTPUT(RFToolsPower.MODID + ":block/cellboth_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, true),
    BOTH_INPUT(RFToolsPower.MODID + ":block/cellboth_t", RFToolsPower.MODID + ":block/cellhoriz_t1", true, false),
    BOTH_NONE(RFToolsPower.MODID + ":block/cellboth_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, false),
    UPPER_OUTPUT(RFToolsPower.MODID + ":block/cellupper_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, true),
    UPPER_INPUT(RFToolsPower.MODID + ":block/cellupper_t", RFToolsPower.MODID + ":block/cellhoriz_t1", true, false),
    UPPER_NONE(RFToolsPower.MODID + ":block/cellupper_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, false),
    MIDDLE_OUTPUT(RFToolsPower.MODID + ":block/cellmiddle_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, true),
    MIDDLE_INPUT(RFToolsPower.MODID + ":block/cellmiddle_t", RFToolsPower.MODID + ":block/cellhoriz_t1", true, false),
    MIDDLE_NONE(RFToolsPower.MODID + ":block/cellmiddle_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, false),
    LOWER_OUTPUT(RFToolsPower.MODID + ":block/celllower_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, true),
    LOWER_INPUT(RFToolsPower.MODID + ":block/celllower_t", RFToolsPower.MODID + ":block/cellhoriz_t1", true, false),
    LOWER_NONE(RFToolsPower.MODID + ":block/celllower_t", RFToolsPower.MODID + ":block/cellhoriz_t1", false, false);

    public static final List<SideType> VALUES = Arrays.asList(values());

    private final String sideTexture;
    private final String upDownTexture;
    private final boolean input;
    private final boolean output;

    SideType(String sideTexture, String upDownTexture, boolean input, boolean output) {
        this.sideTexture = sideTexture;
        this.upDownTexture = upDownTexture;
        this.input = input;
        this.output = output;
    }

    public String getSideTexture() {
        return sideTexture;
    }

    public String getUpDownTexture() {
        return upDownTexture;
    }

    public boolean isInput() {
        return input;
    }

    public boolean isOutput() {
        return output;
    }

    @Override
    public String getName() {
        return name().toLowerCase();
    }
}
