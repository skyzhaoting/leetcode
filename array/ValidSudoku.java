package leetcode;

public class ValidSudoku
{
	/**
	 * 暴力
	 */
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length !=9 || board[0].length != 9)
            return false;
        for(int i = 0; i < 9; i++)
        {
            boolean[] valid = new boolean[10];
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    if(valid[(int)(board[i][j] - '0')])
                        return false;
                    valid[(int)(board[i][j] - '0')] = true;
                }
            }
        }
        for(int j = 0; j < 9; j++)
        {
            boolean[] valid = new boolean[10];
            for(int i = 0; i < 9; i++)
            {
                if(board[i][j] != '.')
                {
                    if(valid[(int)(board[i][j] - '0')])
                        return false;
                    valid[(int)(board[i][j] - '0')] = true;
                }
            }
        }
        for(int block = 0; block < 9; block++)
        {
            boolean[] valid = new boolean[10];
            for(int i = block/3*3; i < block/3*3+3; i++)
            {
                for(int j = block%3*3; j < block%3*3+3; j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(valid[(int)(board[i][j] - '0')])
                            return false;
                        valid[(int)(board[i][j] - '0')] = true;
                    }
                }
            }
        }
        return true;
    }
}
