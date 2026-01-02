package com.mcon152.recipeshare.domain;

import com.mcon152.recipeshare.domain.views.BasicRecipeView;
import com.mcon152.recipeshare.domain.views.DietaryBadgeDecorator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietaryBadgeTest {

    static DairyRecipe dairyRecipe;
    static VegetarianRecipe vegetarianRecipe;
    static DessertRecipe dessertRecipe;
    @BeforeAll
    static void generateValues(){
        dairyRecipe = new DairyRecipe(
                1L,
                "Baked Ziti Alfredo",
                "Creamy baked pasta dish.",
                "Ziti pasta, ricotta, mozzarella, parmesan, cream, butter",
                "Mix cooked pasta with sauce and cheese, then bake until golden.",
                4
        );
        vegetarianRecipe = new VegetarianRecipe(2L,
                "Vegetable Stir Fry",
                "Quick vegetarian stir-fry with fresh vegetables.",
                "Broccoli, bell peppers, carrots, soy sauce, garlic, olive oil",
                "Stir-fry vegetables over high heat and season to taste.",
                3
        );
        dessertRecipe = new DessertRecipe(3L,
                "Chocolate Lava Cake",
                "Warm chocolate cake with a molten center.",
                "Dark chocolate, butter, eggs, sugar, flour",
                "Bake briefly so the center stays soft and gooey.",
                2
        );
    }
    @Test
    void testGetters(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(dairyRecipe);
        DietaryBadgeDecorator dietaryBadgeDecorator = new DietaryBadgeDecorator(basicRecipeView);
        assertEquals(dairyRecipe, dietaryBadgeDecorator.getRecipe());
        assertEquals("Ziti pasta, ricotta, mozzarella, parmesan, cream, butter",dietaryBadgeDecorator.getIngredients());
        assertEquals("Creamy baked pasta dish.", dietaryBadgeDecorator.getDescription());
    }
    @Test
    void testDairyDietaryBadge(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(dairyRecipe);
        DietaryBadgeDecorator dietaryBadgeDecorator = new DietaryBadgeDecorator(basicRecipeView);
        assertEquals(dairyRecipe.getTitle() + " [Dairy]", dietaryBadgeDecorator.getDisplayName());
    }

    @Test
    void testVegetarianDietaryBadge(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(vegetarianRecipe);
        DietaryBadgeDecorator dietaryBadgeDecorator = new DietaryBadgeDecorator(basicRecipeView);
        assertEquals(vegetarianRecipe.getTitle() + " [Vegetarian]", dietaryBadgeDecorator.getDisplayName());
    }

    @Test
    void testNonVeganAndNonDairyDietaryBadge(){
        BasicRecipeView basicRecipeView = new BasicRecipeView(dessertRecipe);
        DietaryBadgeDecorator dietaryBadgeDecorator = new DietaryBadgeDecorator(basicRecipeView);
        assertEquals(dessertRecipe.getTitle(), dietaryBadgeDecorator.getDisplayName());
    }


}
