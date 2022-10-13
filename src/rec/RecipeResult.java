package rec;

public class RecipeResult extends Recipe implements Comparable<RecipeResult> {
	private int matching;
	
	public RecipeResult(String name, String description, String time, ArrayList<String> ingredients, ArrayList<String> steps) {
		super(name, description, time, ingredients, steps);
		// TODO Auto-generated constructor stub
	}
	
	public RecipeResult(Recipe recipe, int matching) {
		super(recipe.getName(), recipe.getDescription(), recipe.getTime(), recipe.getIngredients(), recipe.getSteps());
		// TODO Auto-generated constructor stub
		this.setMatching(matching);
	}
	
    public int compareTo(RecipeResult compareRecipe) {
        int compareMatch = ((RecipeResult)compareRecipe).getMatching();
        return this.matching -compareMatch;
    }

	public int getMatching() {
		return matching;
	}

	public void setMatching(int matching) {
		this.matching = matching;
	}
}
