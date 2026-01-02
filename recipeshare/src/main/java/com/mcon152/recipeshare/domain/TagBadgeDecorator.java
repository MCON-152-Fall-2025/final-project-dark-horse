package com.mcon152.recipeshare.domain;

import com.mcon152.recipeshare.domain.views.RecipeView;

import java.util.*;

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
        if(tags == null || tags.isEmpty()){
            return "";
        }
        List<Tag> sortedTags = new ArrayList<>(tags);
        Collections.sort(sortedTags);

        for(Tag tag: sortedTags){
            badges.append("[").append(tag.getName()).append("]");
        }
        return badges.toString();
    }
}
