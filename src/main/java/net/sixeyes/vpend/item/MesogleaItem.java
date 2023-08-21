package net.sixeyes.vpend.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MesogleaItem extends Item {

    public MesogleaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            user.sendMessage(Text.of("Current Y: ".concat(String.valueOf(user.getPos().getY()))));
            if (user.getPos().getY() < 0) {
                double X = user.getPos().getX();
                double Z = user.getPos().getZ();
                user.teleport(X, 312, Z);
            }
        }
        return super.use(world, user, hand);
    }
}
