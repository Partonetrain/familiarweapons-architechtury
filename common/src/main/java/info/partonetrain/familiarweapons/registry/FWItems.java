package info.partonetrain.familiarweapons.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.item.AnkhShieldItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static info.partonetrain.familiarweapons.FamiliarWeapons.ITEMS;

public class FWItems {

        static final public Item.Properties FW_DEFAULT_PROPERTIES = new Item.Properties().rarity(Rarity.RARE).durability(2031).arch$tab(FamiliarWeapons.MAIN_TAB);

        public static final RegistrySupplier<Item> ANKH_SHIELD = ITEMS.register("ankh_shield", () ->
                new AnkhShieldItem(FW_DEFAULT_PROPERTIES));


}
