package com.erfurt.magicaljewelry.data.recipes;

import com.erfurt.magicaljewelry.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.erfurt.magicaljewelry.util.enums.JewelRarity.*;

public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        upgradeRecipe(consumer, ItemInit.GOLD_AMULET.get());
        upgradeRecipe(consumer, ItemInit.SILVER_AMULET.get());
        upgradeRecipe(consumer, ItemInit.GOLD_RING.get());
        upgradeRecipe(consumer, ItemInit.SILVER_RING.get());
        upgradeRecipe(consumer, ItemInit.GOLD_BRACELET.get());
        upgradeRecipe(consumer, ItemInit.SILVER_BRACELET.get());
    }

    private void upgradeRecipe(Consumer<FinishedRecipe> consumer, Item upgradeableItem)
    {
        JewelUpgradeRecipeBuilder.jewelUpgradeRecipe(upgradeableItem, Items.DIAMOND_BLOCK, UNCOMMON.getName(), RARE.getName()).build(consumer, upgradeableItem.toString());
        JewelUpgradeRecipeBuilder.jewelUpgradeRecipe(upgradeableItem, Items.NETHERITE_INGOT, RARE.getName(), EPIC.getName()).build(consumer, upgradeableItem.toString());
        JewelUpgradeRecipeBuilder.jewelUpgradeRecipe(upgradeableItem, Items.NETHERITE_BLOCK, EPIC.getName(), LEGENDARY.getName()).build(consumer, upgradeableItem.toString());
    }
}