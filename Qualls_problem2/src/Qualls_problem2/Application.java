package Qualls_problem2;

public class Application {
	public static void main(String[] args) {
		DuplicateCounter dr = new DuplicateCounter();
		dr.count("problem2.txt");
		dr.write("unique_words_counts.txt");
	}
}
