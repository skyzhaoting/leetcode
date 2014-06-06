package leetcode;

public class RotateImage
{
	/**
	 *图像顺时针旋转90，不占用内存，先分为 N/2 层 每层分别旋转
	 *保存上的值 左到上，下到左，右到下，上到右
	 *想像4维的情形
	 */
	public static void rotateImage(int[][] matrix)
	{
		if(matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		for (int i = 0; i < n/2; i++)
		{
			for (int j = i; j < n-1-i; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
}
