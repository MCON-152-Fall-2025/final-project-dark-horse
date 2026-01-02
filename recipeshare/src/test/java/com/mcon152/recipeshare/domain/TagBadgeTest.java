package com.mcon152.recipeshare.domain;

import com.mcon152.recipeshare.domain.views.BasicRecipeView;
import com.mcon152.recipeshare.domain.views.DietaryBadgeDecorator;
import com.mcon152.recipeshare.web.RecipeRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagBadgeTest {
    static Recipe veganRecipe;
    static Recipe shabbatRecipe;
    static Recipe dairyRecipe;

    @BeforeAll
    static void generateValues(){
        veganRecipe = new Recipe(
                1L,
                "Chickpea & Spinach Stew",
                "A hearty vegan stew with warm spices.",
                "Chickpeas, spinach, tomatoes, garlic, cumin, olive oil",
                "Simmer chickpeas with spices and tomatoes, add spinach at the end.",
                4
        ) {
            @Override
            protected Recipe createFromRequestInstance(RecipeRequest req) {
                return null;
            }
        };
        Tag veganTag = new Tag("Vegan", "Vegan ingredients only");

        shabbatRecipe = new Recipe(
                2L,
                "Beef Cholent",
                "Traditional slow-cooked Shabbat stew.",
                "Beef, potatoes, beans, barley, onions, salt, pepper",
                "Combine all ingredients and cook overnight on low heat.",
                6
        ) {
            @Override
            protected Recipe createFromRequestInstance(RecipeRequest req) {
                return null;
            }
        };
        Tag shabbatTag = new Tag("Shabbat", "Recipe for Shabbat");
        shabbatRecipe.addTag(shabbatTag);
        dairyRecipe = new Recipe(
                3L,
                "Baked Ziti Alfredo",
                "Creamy baked pasta dish.",
                "Ziti pasta, ricotta, mozzarella, parmesan, cream, butter",
                "Mix cooked pasta with sauce and cheese, then bake until golden.",
                4
        ) {
            @Override
            protected Recipe createFromRequestInstance(RecipeRequest req) {
                return null;
            }
        };
        Tag pastaTag = new Tag("Pasta", "Pasta Recipe");
        Tag easyTag = new Tag("Easy", "Under 30 Minutes");
        dairyRecipe.addTag(pastaTag);
        dairyRecipe.addTag(easyTag);
    }
    @Test
    void testGetters(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(dairyRecipe);
        TagBadgeDecorator tagBadgeDecorator = new TagBadgeDecorator(basicRecipeView);
        assertEquals(dairyRecipe, tagBadgeDecorator.getRecipe());
        assertEquals(dairyRecipe.getTitle(), tagBadgeDecorator.getDisplayName());
        assertEquals("Ziti pasta, ricotta, mozzarella, parmesan, cream, butter",tagBadgeDecorator.getIngredients());
        assertEquals("Creamy baked pasta dish.", tagBadgeDecorator.getDescription());
    }
    @Test
    void testSingleGetBadges(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(shabbatRecipe);
        TagBadgeDecorator tagBadgeDecorator = new TagBadgeDecorator(basicRecipeView);
        assertEquals("[Shabbat]", tagBadgeDecorator.getTagBadges());
    }

    @Test
    void testMultipleGetBadges(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(dairyRecipe);
        TagBadgeDecorator tagBadgeDecorator = new TagBadgeDecorator(basicRecipeView);
        assertEquals("[Easy][Pasta]", tagBadgeDecorator.getTagBadges());
    }

    @Test
    void testEmptyGetBadges(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(veganRecipe);
        TagBadgeDecorator tagBadgeDecorator = new TagBadgeDecorator(basicRecipeView);
        assertEquals("",tagBadgeDecorator.getTagBadges());
    }
}
