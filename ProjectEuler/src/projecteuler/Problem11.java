package projecteuler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20x20 grid? The first problem
 * is how to initialize this huge array, perhaps doing it manually is a waste of
 * time and a source of possible bugs...
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem11 {

	static int[][] grid;

	/**
	 * 
	 */
	public static void main(String[] args) {
		initializeGrid();
	}

	public static void initializeGrid() {
		grid = new int[20][20];
		Document doc = null;
		try {
			doc = Jsoup.connect("http://projecteuler.net/problem=11").get();
			Element divProblemContent = doc.select("div.problem_content")
					.first();
			Elements parsInProblemContent = divProblemContent
					.getElementsByTag("p");
			Element gridParagraph = parsInProblemContent.get(1);
			String gridText = gridParagraph.text();
			String[] numbers = gridText.split(" ");
			int numbersIndex = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					grid[i][j] = Integer.parseInt(numbers[numbersIndex]);
					numbersIndex++;
				}
			}

			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
