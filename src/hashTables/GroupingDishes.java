/*
You are given a list dishes, where each element consists of a list of strings
beginning with the name of the dish,followed by all the ingredients used in preparing it.
You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes
that contain it (if there are at least 2 such dishes).
    Return an array where each element is a list beginning with the ingredient name,
    followed by the names of all the dishes that contain this ingredient.
    The dishes inside each list should be sorted lexicographically,
    and the result array should be sorted lexicographically by the names of the ingredients.
    Example:
    For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
   the output should be:
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]

For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
  the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fri
 */



package hashTables;
import java.util.*;

public class GroupingDishes {
    public String[][] groupingDishes(String[][] dishes) {
        Hashtable<String, ArrayList<String>> dishesHt = new Hashtable<>();
        TreeMap<String,ArrayList<String>> ingredientTmp = new TreeMap<>();

        //filling the hashTable
        String key;
        ArrayList<String> valuesList;
        for(int i=0; i< dishes.length; i++){
            key = dishes[i][0];
            valuesList = new ArrayList<>();
            for(int j = 1; j < dishes[i].length; j++){
                valuesList.add(dishes[i][j]);
            }
            dishesHt.put(key, valuesList);
        }
        //filling TreeMap
        for(Map.Entry<String , ArrayList<String>> e : dishesHt.entrySet()){
            for (String ing: e.getValue()){
                if(!ingredientTmp.containsKey(ing)){
                    ArrayList<String> a = new ArrayList<>();
                    ingredientTmp.put(ing, a);
                }
                ingredientTmp.get(ing).add(e.getKey());
            }
        }

        //preparing the result
        ArrayList<ArrayList<String>> aa = new ArrayList<>();
        for(Map.Entry<String , ArrayList<String>> e : ingredientTmp.entrySet()){
            if(e.getValue().size() > 1){
                ArrayList<String> at = new ArrayList<>();
                Collections.sort(e.getValue());
                at.addAll(e.getValue());
                at.add(0,e.getKey());
                aa.add(at);
            }
        }


        String[][] result  = new String[aa.size()][];
        for(int i=0; i< aa.size(); i++){
            result[i] = new String[aa.get(i).size()];
            for(int j = 0; j < aa.get(i).size(); j++){
                result[i][j] = aa.get(i).get(j);
            }
        }
        return result;
    }

}
