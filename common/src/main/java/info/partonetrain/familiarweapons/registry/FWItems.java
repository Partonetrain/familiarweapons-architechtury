package info.partonetrain.familiarweapons.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.item.AnkhShieldItem;
import info.partonetrain.familiarweapons.item.ElegantReaperScytheItem;
import info.partonetrain.familiarweapons.item.EliteSwordItem;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class FWItems {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FamiliarWeapons.MOD_ID, Registries.ITEM);

        static final public Item.Properties FW_DEFAULT_PROPERTIES = new Item.Properties().rarity(Rarity.RARE).durability(1562).arch$tab(FamiliarWeapons.MAIN_TAB);
        static final public Item.Properties FW_NETHERITE_PROPERTIES = new Item.Properties().rarity(Rarity.RARE).durability(2031).fireResistant().arch$tab(FamiliarWeapons.MAIN_TAB);

        public static final RegistrySupplier<Item> ANKH_SHIELD = ITEMS.register("ankh_shield", () -> new AnkhShieldItem(FW_DEFAULT_PROPERTIES));
        public static final RegistrySupplier<Item> ELEGANT_REAPER_SCYTHE = ITEMS.register("elegant_reaper_scythe", () -> new ElegantReaperScytheItem(Tiers.NETHERITE, 7, -3.2f, FW_NETHERITE_PROPERTIES));
        public static final RegistrySupplier<Item> ELITE_SWORD = ITEMS.register("elite_sword", () -> new EliteSwordItem(Tiers.DIAMOND, 3, -1.8f, FW_DEFAULT_PROPERTIES));


}
