package ru.abramium.nech;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class Nech implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.getBlockState(hitResult.getBlockPos()).getBlock() == Blocks.ENDER_CHEST) {
                player.sendMessage(Text.literal("Ender Chests are disabled!"), true);
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
