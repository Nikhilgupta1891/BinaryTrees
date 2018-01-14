public class Arrays {

	public static void main(String[] args) {

		// You have to mention the size fo the array.
		// Here, size is 6.
		// All elements of the array are initialized with 0.
		int[] arr = new int[6];

		for (int i = 0; i < 5; i++) {
			arr[i] = i * 2;
		}

		for (int i : arr)
			System.out.print(i + " ");
		
		System.out.println();

		// Pass by value example.
		Name aName = new Name("Max");
		// we pass the object to foo
		passByValueExample(aName);
		// aName variable is still pointing to the "Max" Name when foo(...) returns
		System.out.println(aName.getName().equals("Max")); // true, java passes by value
		System.out.println(aName.getName().equals("Fifi")); // false
	}

	public static class Name {
		String name;

		public Name(String name) {
			this.name = name;
		}

		String getName() {
			return name;
		}
	}

	public static void passByValueExample(Name d) {
		d.getName().equals("Max"); // true
		// change d inside of foo() to point to a new Name instance "Fifi"
		d = new Name("Fifi");
		d.getName().equals("Fifi"); // true
	}
}