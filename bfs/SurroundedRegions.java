package leetcode;

import java.util.LinkedList;

public class SurroundedRegions
{
	/**
	 * 矩阵四边的‘O’肯定不被‘X’包围 分别从上 下 左 右 BFS将边上的‘O’--》‘#’ 
	 * 扫描矩阵 将‘O‘ --》 ’X‘ 再将 ’#‘ -- 》’O‘；
	 * 也可以使用DFS 使用DFS超时
	 */
	public  void solve(char[][] board)
	{
		if (board == null || board.length <= 1 || board[0].length <= 1)
			return;
		for (int i = 0; i < board[0].length; i++)
		{
			bfs(board, 0, i);
			bfs(board, board.length - 1, i);
		}
		for (int i = 0; i < board.length; i++)
		{
			bfs(board, i, 0);
			bfs(board, i, board[0].length - 1);
		}
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
	}

	public  void bfs(char[][] board, int i, int j)
	{
		if (board[i][j] != 'O')
			return;
		board[i][j] = '#';
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int code = i * board[0].length + j;
		queue.offer(code);
		while (!queue.isEmpty())
		{
			code = queue.poll();
			int row = code / board[0].length;
			int col = code % board[0].length;
			if (row > 0 && board[row - 1][col] == 'O')
			{
				queue.offer((row - 1) * board[0].length + col);
				board[row - 1][col] = '#';
			}
			if (row < board.length - 1 && board[row + 1][col] == 'O')
			{
				queue.offer((row + 1) * board[0].length + col);
				board[row + 1][col] = '#';
			}
			if (col > 0 && board[row][col - 1] == 'O')
			{
				queue.offer((row) * board[0].length + col - 1);
				board[row][col - 1] = '#';
			}
			if (col < board[0].length - 1 && board[row][col + 1] == 'O')
			{
				queue.offer((row) * board[0].length + col + 1);
				board[row][col + 1] = '#';
			}
		}

	}
}
