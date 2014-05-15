package leetcode;

import java.util.HashMap;

public class MaxPointsonaLine
{
	public int maxPoints(Point[] points)
	{
		if (points.length == 0)
			return 0;
		if (points.length <= 2)
			return points.length;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0, dup, vertical;
		double k;
		for (int i = 0; i < points.length; i++)
		{
			map.clear();
			dup = 1;
			vertical = 0;
			for (int j = 0; j < points.length; j++)
			{
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y)
				{
					dup++;
					continue;
				}

				if (points[j].x == points[i].x)
					vertical++;

				else
				{
					k = (double) (points[j].y - points[i].y)
							/ (points[j].x - points[i].x);
					if (map.containsKey(k))
						map.put(k, map.get(k) + 1);
					else
						map.put(k, 1);
				}
			}
			for (Integer val : map.values())
			{
				if (val > vertical)
					vertical = val;
			}

			vertical = vertical + dup;
			if (vertical > max)
				max = vertical;
		}
		return max;
}
}
