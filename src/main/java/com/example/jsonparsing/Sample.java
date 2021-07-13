package com.example.jsonparsing;

public class Sample {
	private String uuid;
	private Color color;
	private Animal[] animals;

	public String getUuid() {
		return this.uuid;
	}
	public Color getColor() {
		return this.color;
	}
	public Animal[] getAnimals() {
		return this.animals;
	}

	static class Color {
		private String id;
		private String name;
		private String hex;

		public String getId() {
			return this.id;
		}
		public String getName() {
			return this.name;
		}
		public String getHex() {
			return this.hex;
		}
	}

	static class Animal {
		private Long id;
		private String name;
		private String type;

		public Long getId() {
			return this.id;
		}
		public String getName() {
			return this.name;
		}
		public String getType() {
			return this.type;
		}
	}
}

