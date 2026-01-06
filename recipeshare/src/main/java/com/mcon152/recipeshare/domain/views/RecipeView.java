package com.mcon152.recipeshare.domain.views;

import com.mcon152.recipeshare.domain.Recipe;

public interface RecipeView {


    Recipe getRecipe();

    String getDisplayName();

    String getDescription();

    String getIngredients();
}
