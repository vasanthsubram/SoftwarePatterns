package patterns.creational.builder.pizzaDemo.concreteBuilders;

import patterns.creational.builder.pizzaDemo.PizzaBuilder;

/** "ConcreteBuilder" */

public class HawaiianPizzaBuilder extends PizzaBuilder {

	public void buildDough() {
		pizza.setDough("thick crust");
	}

	public void buildSauce() {
		pizza.setSauce("mild");
	}

	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}

