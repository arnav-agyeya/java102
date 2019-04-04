package com.myapp.patterns;

public  class LunchOrder {
	
	public static class MenuBuilder{
		
		private String paratha,burger,pizza,icecream;
		
		public MenuBuilder paratha(String paratha) {
			this.paratha=paratha;
			return this;
		}
		public MenuBuilder burger(String burger) {
			this.burger=burger;
			return this;
		}
		public MenuBuilder pizza(String pizza) {
			this.pizza=pizza;
			return this;
		}
		public MenuBuilder icecream(String icecream) {
			this.icecream=icecream;
			return this;
		}
		public LunchOrder build() {
			return new LunchOrder(this);
		}
	}
	
	private final String paratha,burger,pizza,icecream;
	
	private LunchOrder(MenuBuilder builder) {
		this.paratha=builder.paratha;
		this.burger=builder.burger;
		this.pizza=builder.pizza;
		this.icecream=builder.icecream;
	}

	public String getParatha() {
		return paratha;
	}

	public String getBurger() {
		return burger;
	}

	public String getPizza() {
		return pizza;
	}

	public String getIcecream() {
		return icecream;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LunchOrder [paratha=");
		builder.append(paratha);
		builder.append(", burger=");
		builder.append(burger);
		builder.append(", pizza=");
		builder.append(pizza);
		builder.append(", icecream=");
		builder.append(icecream);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
