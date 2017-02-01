package net.spellcraftgaming.rpghud.settings;

import net.minecraft.client.resources.I18n;
import static net.spellcraftgaming.rpghud.settings.EnumOptionsMod.EnumOptionType.*;

public enum EnumOptionsMod {

	BUTTON_TOOLTIP_ENABLED(BOOLEAN, "name.button_tooltip", I18n.format("tooltip.button_tooltip", new Object[0])), 
	SHOW_ARMOR(BOOLEAN, "name.show_armor", I18n.format("tooltip.show_armor", new Object[0])), 
	SHOW_ITEMDURABILITY(BOOLEAN, "name.item_durability", I18n.format("tooltip.item_durability", new Object[0])), 
	SHOW_ITEMCOUNT(BOOLEAN, "name.item_count", I18n.format("tooltip.item_count", new Object[0])), 
	SHOW_ARROWCOUNT(BOOLEAN, "name.arrow_count", I18n.format("tooltip.arrow_count", new Object[0])), 
	SHOW_NUMBERS_HEALTH(BOOLEAN, "name.show_numbers_health", I18n.format("tooltip.numbers_health", new Object[0])), 
	SHOW_NUMBERS_STAMINA(BOOLEAN, "name.show_numbers_stamina", I18n.format("tooltip.numbers_stamina", new Object[0])), 
	SHOW_NUMBERS_EXPERIENCE(BOOLEAN, "name.show_numbers_exp", I18n.format("tooltip.numbers_exp", new Object[0])), 
	ENABLE_CLOCK(BOOLEAN, "name.enable_clock", I18n.format("tooltip.enable_clock", new Object[0])), 
	ENABLE_IMMERSIVE_CLOCK(BOOLEAN, "name.enable_immersive_clock", I18n.format("tooltip.enable_immersive_clock", new Object[0])), 
	ENABLE_TIMECOLOR(BOOLEAN, "name.enable_timecolor", I18n.format("tooltip.enable_timecolor", new Object[0])), 
	RENDER_PLAYER_FACE(BOOLEAN, "name.player_face", I18n.format("tooltip.player_face", new Object[0])), 
	HUD_TYPE(STRING, "name.hud_type", I18n.format("tooltip.hud_type", new Object[0])), 
	COLOR_HEALTH(INTEGER, "name.color_health", I18n.format("tooltip.color_health", new Object[0])), 
	COLOR_STAMINA(INTEGER, "name.color_stamina", I18n.format("tooltip.color_stamina", new Object[0])), 
	COLOR_AIR(INTEGER, "name.color_air", I18n.format("tooltip.color_air", new Object[0])), 
	COLOR_EXPERIENCE(INTEGER, "name.color_exp", I18n.format("tooltip.color_exp", new Object[0])), 
	COLOR_JUMPBAR(INTEGER, "name.color_jumpbar", I18n.format("tooltip.color_jumpbar", new Object[0])), 
	SHOW_HUNGERPREVIEW(BOOLEAN, "name.show_hungerpreview", I18n.format("tooltip.show_hungerpreview", new Object[0])), 
	CLOCK_TIME_FORMAT(INTEGER, "name.time_format", I18n.format("tooltip.clock_time_format", new Object[0])), 
	REDUCE_SIZE(BOOLEAN, "name.reduce_size", I18n.format("tooltip.reduce_size", new Object[0]));

	public enum EnumOptionType {
		INTEGER, BOOLEAN, STRING;
	}

	/** The name of the setting */
	private final String enumName;
	/** The description of this setting */
	private final String tooltip;
	/** The type of the setting */
	private final EnumOptionType type;

	public static EnumOptionsMod getEnumOptions(int par0) {
		EnumOptionsMod[] aenumoptions = values();
		int j = aenumoptions.length;
		for (int k = 0; k < j; k++) {
			EnumOptionsMod enumoptions = aenumoptions[k];
			if (enumoptions.returnEnumOrdinal() == par0) {
				return enumoptions;
			}
		}
		return null;
	}

	/**
	 * Function to get the setting with a specified ordinal
	 * 
	 * @param the
	 *            ordinal
	 * @return the setting
	 */
	private EnumOptionsMod(EnumOptionType type, String name, String tooltip) {
		this.type = type;
		this.enumName = name;
		this.tooltip = tooltip;
	}

	/** Returns the ordinal of this setting */
	public int returnEnumOrdinal() {
		return ordinal();
	}

	/** Returns the name of this setting */
	public String getName() {
		return this.enumName;
	}

	/** Returns the description of this setting */
	public String getTooltip() {
		return this.tooltip;
	}

	/** Returns the type of this setting */
	public EnumOptionType getType() {
		return this.type;
	}

	/** Checks whether this setting of the type BOOLEAN or not */
	public boolean isBoolean() {
		return this.type == BOOLEAN ? true : false;
	}
}