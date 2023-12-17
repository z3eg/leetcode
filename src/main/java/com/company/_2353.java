package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

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
    /*class FoodRatings {

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
    }*/

    /*Time Limit Exceeded
4 / 77 testcases passed*/
    /*class FoodRatings {

        class Food {
            String name;
            int rating;

            public Food(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }
        }

        Map<String, List<Food>> map;

        Map<String, String> foodToCategoryMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            map = new HashMap<>();
            foodToCategoryMap = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                foodToCategoryMap.put(foods[i], cuisines[i]);
                List<Food> val = map.get(cuisines[i]);
                if (val == null) {
                    val = new LinkedList<>();
                }
                insort(val, ratings[i],foods[i]); //insertion sort here
                map.put(cuisines[i], val);
            }
        }

        public void changeRating(String food, int newRating) {
            //introduce BS if sequential is not enough
            String cuisine = foodToCategoryMap.get(food);
            List<Food> foods = map.get(cuisine);
            for (int i = 0; i < foods.size(); i++) {
                Food curFood = foods.get(i);
                if (curFood.name.equals(food)) {
                    foods.remove(curFood);
                    break;
                }
            }
            insort(foods, newRating, food);
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).get(0).name;
        }

        private void insort(List<Food> list, int rating, String food) {
            if (list.isEmpty())
                list.add(new Food(food, rating));
            else {
                //introduce BS if sequential is not enough
                int curPos = 0;
                Food cur = list.get(curPos);
                while (cur.rating > rating && curPos < list.size()) {
                    cur = list.get(curPos);
                    curPos++;
                }
                while (cur.rating == rating && cur.name.compareTo(food) < 0) {
                    curPos++;
                }
                list.add(curPos, new Food(food, rating));
            }
        }
    }*/

    /*Wrong Answer
    42 / 77 testcases passed*/
    class FoodRatings {

        class Food {
            String name;
            int rating;

            public Food(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }
        }

        Map<String, List<Food>> map;

        Map<String, String> foodToCategoryMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            map = new HashMap<>();
            foodToCategoryMap = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                foodToCategoryMap.put(foods[i], cuisines[i]);
                List<Food> val = map.get(cuisines[i]);
                if (val == null) {
                    val = new LinkedList<>();
                }
                insort(val, ratings[i],foods[i]); //insertion sort here
                map.put(cuisines[i], val);
            }
        }

        public void changeRating(String food, int newRating) {
            //introduce BS if sequential is not enough
            String cuisine = foodToCategoryMap.get(food);
            List<Food> foods = map.get(cuisine);
            for (int i = 0; i < foods.size(); i++) {
                Food curFood = foods.get(i);
                if (curFood.name.equals(food)) {
                    foods.remove(curFood);
                    break;
                }
            }
            insort(foods, newRating, food);
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).get(0).name;
        }

        private void insort(List<Food> list, int rating, String food) {
            if (list.isEmpty())
                list.add(new Food(food, rating));
            else {
                //introduce BS if sequential is not enough
                int curPos = 0;
                Food cur = list.get(curPos);
                while (cur.rating > rating && curPos < list.size()) {
                    cur = list.get(curPos);
                    curPos++;
                }
                while (cur.rating == rating && cur.name.compareTo(food) < 0) {
                    cur = list.get(curPos);
                    curPos++;
                }
                list.add(curPos, new Food(food, rating));
            }
        }
    }

    @Test
    public void test() {
        FoodRatings fr;
        fr = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        assertEquals("kimchi", fr.highestRated("korean"));
        assertEquals("ramen", fr.highestRated("japanese"));
        fr.changeRating("sushi",16);
        assertEquals("sushi", fr.highestRated("japanese"));
        fr.changeRating("ramen",16);
        assertEquals("ramen", fr.highestRated("japanese"));
        fr = new FoodRatings(new String[]{"mxmauspoh","pgtdjqyl","hcfnzpnqf"},
                new String[]{"qgjuq","qgjuq","qgjuq"}, new int[]{12,7,6});
        assertEquals("mxmauspoh", fr.highestRated("qgjuq"));
        assertEquals("mxmauspoh", fr.highestRated("qgjuq"));
        fr.changeRating("hcfnzpnqf",2);
        fr.changeRating("pgtdjqyl",12);
        fr.changeRating("hcfnzpnqf",6);
//        fr = new FoodRatings(new String[]{}, new String[]{}, new int[]{});
//        fr.changeRating("sushi",16);
//        assertEquals("", fr.highestRated("korean"));
    }

}
