package net.spellcraftgaming.rpghud.gui.hud.element.simple;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.FoodStats;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

public class HudElementFoodSimple extends HudElement {

	public HudElementFoodSimple() {
		super(HudElementType.FOOD, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.playerController.shouldDrawHUD();
	}
	
	@Override
	public void drawElement(AbstractGui gui, MatrixStack ms, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
		FoodStats stats = this.mc.player.getFoodStats();
		int stamina = stats.getFoodLevel();
		int staminaMax = 20;
		int width = 84;
		
		int posX = ((scaledWidth) / 2) + 7 + this.settings.getPositionValue(Settings.hunger_position)[0];
		int posY = scaledHeight - 32 - 8 + this.settings.getPositionValue(Settings.hunger_position)[1];
		
		
		ItemStack itemMain = this.mc.player.getHeldItemMainhand();
		ItemStack itemSec = this.mc.player.getHeldItemOffhand();
		if (stats.needFood() && this.settings.getBoolValue(Settings.show_hunger_preview)) {
			float value = 0;
			if (itemMain != ItemStack.EMPTY && itemMain.getItem().isFood()) {
				value = itemMain.getItem().getFood().getHealing();
			} else if (itemSec != ItemStack.EMPTY && itemMain.getItem().isFood()) {
				value = itemSec.getItem().getFood().getHealing();
			}
			if (value > 0) {
				int bonusHunger = (int) (value + stamina);
				if (bonusHunger > staminaMax)
					bonusHunger = staminaMax;
				int colorPreview = offsetColor(this.settings.getIntValue(Settings.color_food), OFFSET_PREVIEW);
				drawCustomBar(posX, posY, width, 8, bonusHunger / (double) staminaMax * 100.0D, -1, -1, colorPreview, offsetColorPercent(colorPreview, OFFSET_PERCENT), -1);
			}
		}

		if (this.mc.player.isPotionActive(Effects.HUNGER)) {
			drawCustomBar(posX, posY, width, 8, stamina / (double) staminaMax * 100.0D, 0xA0000000, 0xA0000000, this.settings.getIntValue(Settings.color_hunger), offsetColorPercent(this.settings.getIntValue(Settings.color_hunger), OFFSET_PERCENT), 0xA0000000);
		} else {
			drawCustomBar(posX, posY, width, 8, stamina / (double) staminaMax * 100.0D, 0xA0000000, 0xA0000000, this.settings.getIntValue(Settings.color_food), offsetColorPercent(this.settings.getIntValue(Settings.color_food), OFFSET_PERCENT), 0xA0000000);
		}
		String staminaString = this.settings.getBoolValue(Settings.hunger_percentage) ? (int) Math.floor((double) stamina / (double) staminaMax * 100) + "%" : stamina + "/" + staminaMax;
		if (this.settings.getBoolValue(Settings.show_numbers_food)) {
			ms.scale(0.5f, 0.5f, 0.5f);
			AbstractGui.drawCenteredString(ms, this.mc.fontRenderer, staminaString, posX * 2 + width, posY * 2 + 4, -1);
			ms.scale(2f, 2f, 2f);
		}
	}

}
