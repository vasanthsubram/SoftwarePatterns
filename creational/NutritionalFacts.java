package patterns.creational;

/**
 * Instead of having multiple constructors, each taking different sets of arguments, use the builder
 */
public class NutritionalFacts {
  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public static class Builder {
    // Required parameters
    private final int servingSize;
    private final int servings;

    // Optional parameters - initialized to default values
    private int calories = 0;
    private int fat = 0;
    private int carbohydrate = 0;
    private int sodium = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public NutritionalFacts build() {
      return new NutritionalFacts(this);
    }
  }

  private NutritionalFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  @Override
  public String toString() {
    return "NutritionalFacts{" +
          "servingSize=" + servingSize +
          ", servings=" + servings +
          ", calories=" + calories +
          ", fat=" + fat +
          ", sodium=" + sodium +
          ", carbohydrate=" + carbohydrate +
          '}';
  }

  public static void main(String[] args){
    NutritionalFacts cocaCola = new NutritionalFacts.Builder(240, 8).
          calories(100).sodium(35).carbohydrate(27).build(); cocaCola = new NutritionalFacts.Builder(240, 8).
          calories(100).sodium(35).carbohydrate(27).build();

    System.out.println(cocaCola);
  }
}