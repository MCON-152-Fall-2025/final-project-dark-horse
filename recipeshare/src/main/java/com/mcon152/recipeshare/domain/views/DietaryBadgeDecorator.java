package com.mcon152.recipeshare.domain.views;
import com.mcon152.recipeshare.domain.Recipe;
import com.mcon152.recipeshare.domain.VegetarianRecipe;
import com.mcon152.recipeshare.domain.DairyRecipe;

public class DietaryBadgeDecorator implements RecipeView {
    private final RecipeView wrappedView;

    public DietaryBadgeDecorator(RecipeView wrappedView) {
        this.wrappedView = wrappedView;
    }

    @Override public Recipe getRecipe() {
        return wrappedView.getRecipe();
    }

    @Override public String getDisplayName() {
        String name = wrappedView.getDisplayName();
        Recipe recipe = wrappedView.getRecipe();
        if (recipe instanceof VegetarianRecipe) {
            return name + " [Vegetarian]";
        }
        if (recipe instanceof DairyRecipe) {
            return name + " [Dairy]";
        }
        return name;
    }

    @Override public String getDescription() {
        return wrappedView.getDescription();
    }

    @Override public String getIngredients() {
        return wrappedView.getIngredients();
    }
}