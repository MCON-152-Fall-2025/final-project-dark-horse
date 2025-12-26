package com.mcon152.recipeshare.domain.views;

import com.mcon152.recipeshare.domain.Recipe;

import java.util.List;

public class DietaryBadgeDecorator implements RecipeView {
    private final RecipeView wrappedView;
    public DietaryBadgeDecorator(RecipeView wrappedView, Recipe recipe) {
        this.wrappedView = wrappedView;
    }

    @Override public Recipe getRecipe() {
        return wrapped.getRecipe();
    }

    @Override public String getDisplayName() {
        String name = wrapped.getDisplayName();
        Recipe recipe = wrapped.getRecipe();
        if (recipe instanceof Vegetarian) {
            return name + " [Vegetarian]";
        }
        if (recipe instanceof Dairy) {
            return name + " [Dairy]";
        }
        return name;
    }

    @Override public String getDescription() {
        return wrapped.getDescription();
    }

    @Override public String getIngredients() {
        return wrapped.getIngredients();
    }

}