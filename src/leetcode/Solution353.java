package leetcode;

import java.util.LinkedList;

/**
 * Design Snake Game.
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution353 {

	public class SnakeGame {

		// A Point (x, y) is located on the board.
		class Point {
			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		int width;
		int height;

		// Positions of the snake from tail to head.
		LinkedList<Point> snakePos = new LinkedList<>();

		LinkedList<Point> foodPos = new LinkedList<>();

		// Use an iterator on food would improve efficiency.
		// int totalFoodNumber;
		// int curFoodNumber;

		int score;

		/**
		 * Initialize your data structure here.
		 * 
		 * @param width
		 *            - screen width
		 * @param height
		 *            - screen height
		 * @param food
		 *            - A list of food positions E.g food = [[1,1], [1,0]] means
		 *            the first food is positioned at [1,1], the second is at
		 *            [1,0].
		 */
		public SnakeGame(int width, int height, int[][] food) {
			this.width = width;
			this.height = height;
			this.score = 0;
			snakePos.add(new Point(0, 0));
			for (int[] f : food) {
				foodPos.add(new Point(f[0], f[1]));
			}
		}

		/**
		 * Moves the snake.
		 * 
		 * @param direction
		 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 * @return The game's score after the move. Return -1 if game over. Game
		 *         over when snake crosses the screen boundary or bites its
		 *         body.
		 */
		public int move(String direction) {
			Point head = snakePos.getLast();

			Point newPoint = new Point(-1, -1);
			switch (direction) {
			case "U":
				newPoint.x = head.x - 1;
				newPoint.y = head.y;
				break;
			case "L":
				newPoint.x = head.x;
				newPoint.y = head.y - 1;
				break;
			case "R":
				newPoint.x = head.x;
				newPoint.y = head.y + 1;
				break;
			case "D":
				newPoint.x = head.x + 1;
				newPoint.y = head.y;
				break;
			default:
				break;
			}

			// Check boundary.
			if (newPoint.x < 0 || newPoint.x >= height || newPoint.y < 0
					|| newPoint.y >= width) {
				return -1;
			}

			// Check food availability.
			if (!foodPos.isEmpty()) {
				Point food = foodPos.getFirst();
				if (food.x == newPoint.x && food.y == newPoint.y) {
					score++;
					snakePos.add(foodPos.removeFirst());
					return score;
				}
			}

			// Check whether the snake bites itself.
			// Possible optimization point.
			snakePos.removeFirst();
			for (Point pos : snakePos) {
				if (pos.x == newPoint.x && pos.y == newPoint.y) {
					return -1;
				}
			}
			snakePos.add(newPoint);
			return score;
		}

		// public boolean hasFood() {
		//
		// }
	}

	/**
	 * Your SnakeGame object will be instantiated and called as such: SnakeGame
	 * obj = new SnakeGame(width, height, food); int param_1 =
	 * obj.move(direction);
	 */

	public static void main(String[] args) {
		Solution353 solution = new Solution353();

		int[][] food = { { 1, 2 }, { 0, 1 } };
		SnakeGame snake = solution.new SnakeGame(3, 2, food);

		System.out.println(snake.move("R"));
		System.out.println(snake.move("D"));
		System.out.println(snake.move("R"));
		System.out.println(snake.move("U"));
		System.out.println(snake.move("L"));
		System.out.println(snake.move("U"));

	}

}
