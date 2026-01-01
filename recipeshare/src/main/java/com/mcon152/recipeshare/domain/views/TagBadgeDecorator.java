package com.mcon152.recipeshare.domain.views;

import com.mcon152.recipeshare.domain.Recipe;
import com.mcon152.recipeshare.domain.Tag;

import java.util.Set;

public class TagBadgeDecorator implements RecipeView{

    private RecipeView wrappedView;

    public TagBadgeDecorator(RecipeView wrappedView){
        this.wrappedView = wrappedView;
    }

    @Override
    public Recipe getRecipe() {
        return wrappedView.getRecipe();
    }

    @Override
    public String getDisplayName() {
        return wrappedView.getDisplayName();
    }

    @Override
    public String getDescription() {
        return wrappedView.getDescription();
    }

    @Override
    public String getIngredients() {
        return wrappedView.getIngredients();
    }

    public String getTagBadges(){
        StringBuilder badges = new StringBuilder();
        Set<Tag> tags = wrappedView.getRecipe().getTags();
        if(tags == null){
            return "";
        }
        for(Tag tag: tags){
            badges.append("[").append(tag).append("]");
        }
        return badges.toString();
    }
}
