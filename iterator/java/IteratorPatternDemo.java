interface Iterator {
	boolean hasNext();
	<T> T next();
}

interface Collection {

	Iterator getIterator();

	Iterator getIteratorReversed();
}

final class NameRepository implements Collection {

	private final String[] langs;

	NameRepository() {
		this.langs = new String[]{"Java", "Kotlin", "C++", "Python", "Rust", "C#", "Ruby", "Pearl", "JS"};
	}

	@Override
	public Iterator getIterator() {
		return new Iterator() {

			private int index;

			@Override
			public boolean hasNext() {
				return index >= 0 && index < langs.length;
			}

			@Override
			public <T> T next() {
				return (T) langs[index++];
			}
		};
	}

	@Override
	public Iterator getIteratorReversed() {
		return new Iterator() {

			private int index = langs.length - 1;
			
			@Override
			public boolean hasNext() {
				return index >= 0 && index < langs.length;
			}

			@Override
			public <T> T next() {
				return (T) langs[index--];
			}
		};
	}
}

final class IteratorPatternDemo {

	public static void print(Iterator iter) {
		while (iter.hasNext())
			System.out.print(iter.<String>next()+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		NameRepository nameRepository = new NameRepository();
		Iterator iter = nameRepository.getIterator();
		print(iter);

		iter = nameRepository.getIteratorReversed();
		print(iter);
	}
}



