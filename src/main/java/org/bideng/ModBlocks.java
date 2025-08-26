package org.bideng;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.bideng.block.ClassroomChair;
import org.bideng.block.ClassroomTable;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CLASSROOM_TABLE = register("classroom_table", ClassroomTable::new, ClassroomTable.Settings.create().strength(0.5f).sounds(BlockSoundGroup.STONE));
    public static final Block CLASSROOM_CHAIR = register("classroom_chair", ClassroomChair::new, ClassroomChair.Settings.create().strength(0.5f).sounds(BlockSoundGroup.STONE));

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(WenboThings.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = registers(registryKey, factory, settings);
        Items.register(block);
        return block;
    }
    private static Block registers(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public static void init() {}
}
