package net.countercraft.movecraft.processing.tasks.translation.validators;

import net.countercraft.movecraft.MovecraftLocation;
import net.countercraft.movecraft.craft.CraftType;
import net.countercraft.movecraft.localisation.I18nSupport;
import net.countercraft.movecraft.processing.MovecraftWorld;
import net.countercraft.movecraft.processing.functions.Result;
import net.countercraft.movecraft.processing.functions.TetradicPredicate;
import net.countercraft.movecraft.util.hitboxes.HitBox;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MaxHeightValidator implements TetradicPredicate<MovecraftLocation, MovecraftWorld, HitBox, CraftType> {
    @Override
    @Contract(pure = true)
    public @NotNull Result validate(@NotNull MovecraftLocation translation, @NotNull MovecraftWorld world, @NotNull HitBox hitBox, @NotNull CraftType type){
        if (translation.getY() > 0 && hitBox.getMaxY() > type.getMaxHeightLimit(world) && type.getCollisionExplosion() <= 0f) {
            return Result.failWithMessage(I18nSupport.getInternationalisedString("Translation - Failed Craft hit height limit"));
        }
        return Result.succeed();
    }
}
