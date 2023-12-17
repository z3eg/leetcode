package com.company;

import java.util.*;

public class _2353 {

    /*class FoodRatings {

        class Food {
            String name;
            String cuisine;
            int rating;

            public Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }

        Set<Food> foodSet;
        Map<String, Food> nameToFoodMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodSet = new TreeSet<>((a,b) -> {
                return a.rating==b.rating?0:(a.rating>b.rating?-1:1);
            });
            nameToFoodMap = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                Food f = new Food(foods[i], cuisines[i], ratings[i]);
                foodSet.add(f);
                nameToFoodMap.put(foods[i],f);
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = nameToFoodMap.get(food);
            foodSet.remove(f);
            f.rating = newRating;
            foodSet.add(f);
        }

        public String highestRated(String cuisine) {
            for (Food next : foodSet) {
                if (cuisine.equals(next.cuisine))
                    return next.name;
            }
            return null;
        }
    }*/


    /*Time Limit Exceeded
73 / 77 testcases passed*/
    class FoodRatings {

        String[] foods;
        String[] cuisines;
        int[] ratings;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;
        }

        public void changeRating(String food, int newRating) {
            for (int i = 0; i < foods.length; i++) {
                if (foods[i].equals(food)) {
                    ratings[i] = newRating;
                    break;
                }
            }
        }

        public String highestRated(String cuisine) {
            int highestRating = 0;
            String highestRatedFood = null;
            for (int i = 0; i < ratings.length; i++) {
                if (cuisines[i].equals(cuisine)) {
                    if (ratings[i] > highestRating) {
                        highestRating = ratings[i];
                        highestRatedFood = foods[i];
                    }
                    else if (ratings[i] == highestRating) {
                        if (highestRatedFood == null || highestRatedFood.compareTo(foods[i]) > 0) {
                            highestRatedFood = foods[i];
                        }
                    }
                }
            }
            return highestRatedFood;
        }
    }

}
