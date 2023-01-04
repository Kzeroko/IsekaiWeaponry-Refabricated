package net.kzeroko.isekaiweaponryfabric.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.item.weapon.Donner;
import net.kzeroko.isekaiweaponryfabric.item.weapon.Schlag;
import net.minecraft.util.Hand;

public class PacketReg {

    public static void registerMessages() {
        ServerPlayNetworking.registerGlobalReceiver(IsekaiweaponryFabric.DONNER,
                (server, player, serverPlayNetworkHandler, inputPacket, packetSender) -> {
                    if (player.getMainHandStack().getItem() instanceof Donner) {
                        ((Donner) player.getMainHandStack().getItem()).reload(player, Hand.MAIN_HAND);
                    }
                });
        ServerPlayNetworking.registerGlobalReceiver(IsekaiweaponryFabric.SCHLAG,
                (server, player, serverPlayNetworkHandler, inputPacket, packetSender) -> {
                    if (player.getMainHandStack().getItem() instanceof Schlag) {
                        ((Schlag) player.getMainHandStack().getItem()).reload(player, Hand.MAIN_HAND);
                    }
                });
    }
}
