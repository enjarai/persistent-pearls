package nl.enjarai.persistentpearls;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistentPearls implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("persistent-pearls");
	public static final GameRules.Key<GameRules.BooleanRule> PEARLS_PERSISTENT_GAMERULE =
			GameRuleRegistry.register("persistentPearls", GameRules.Category.UPDATES,
					GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize() {

	}
}