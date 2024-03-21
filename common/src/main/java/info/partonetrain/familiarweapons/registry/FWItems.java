package info.partonetrain.familiarweapons.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.item.AnkhShieldItem;
import info.partonetrain.familiarweapons.item.ElegantReaperScytheItem;
import info.partonetrain.familiarweapons.item.LightArrowItem;
import info.partonetrain.familiarweapons.item.PlasmaSwordItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

public class FWItems {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FamiliarWeapons.MOD_ID, Registries.ITEM);

        static final public Item.Properties FW_DEFAULT_PROPERTIES = new Item.Properties().rarity(Rarity.RARE).durability(1562).arch$tab(FamiliarWeapons.MAIN_TAB);
        static final public Item.Properties FW_STACKABLE_PROPERTIES = new Item.Properties().stacksTo(64).arch$tab(FamiliarWeapons.MAIN_TAB);
        static final public Item.Properties FW_NETHERITE_PROPERTIES = new Item.Properties().rarity(Rarity.RARE).durability(2031).fireResistant().arch$tab(FamiliarWeapons.MAIN_TAB);

        public static final RegistrySupplier<Item> ANKH_SHIELD = ITEMS.register("ankh_shield", () -> new AnkhShieldItem(FW_DEFAULT_PROPERTIES));
        public static final RegistrySupplier<Item> ELEGANT_REAPER_SCYTHE = ITEMS.register("elegant_reaper_scythe", () -> new ElegantReaperScytheItem(Tiers.NETHERITE, 7, -3.2f, FW_NETHERITE_PROPERTIES));
        public static final RegistrySupplier<Item> PLASMA_SWORD = ITEMS.register("plasma_sword", () -> new PlasmaSwordItem(Tiers.DIAMOND, 3, -2.4f, FW_DEFAULT_PROPERTIES));
        public static final RegistrySupplier<Item> LIGHT_ARROW = ITEMS.register("light_arrow", () -> new LightArrowItem(FW_STACKABLE_PROPERTIES));



}
