package com.mcon152.recipeshare.domain.views;

import com.mcon152.recipeshare.domain.Recipe;

import java.util.List;

public class BasicRecipeView implements RecipeView {

    Recipe recipe;

    public BasicRecipeView(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String getDisplayName() {
        return recipe.getTitle();
    }

    @Override
    public String getDescription() {
        return recipe.getDescription();
    }

    @Override
    public String getIngredients() {
        return recipe.getIngredients();
    }
}
