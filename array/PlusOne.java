package leetcode;

public class PlusOne
{
	/**
	 * 两种方法
	 */
	public int[] plusOne1(int[] digits)
	{
		if (digits == null || digits.length == 0)
			return digits;
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--)
		{
			int temp = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			digits[i] = temp;
			if (carry == 0)
				return digits;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
	
    public int[] plusOne2(int[] digits) {
        if(digits == null || digits.length == 0)
            return digits;
        int i;
        for(i = 0; i < digits.length;i++)
        {
            if(digits[i] != 9)
                break;
        }
        if(i == digits.length)
        {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int j = 1; j <= digits.length; j++)
            {
                res[j] = 0;
            }
            return res;
        }
        digits[digits.length-1] = digits[digits.length-1] + 1;
        int p = 0,temp;
        for(i = digits.length-1;i>=0;i--)
        {
            temp = digits[i] + p;
            digits[i] = temp%10;
            p = temp/10;
            if(p == 0)
                break;
        }
        return digits;
    }
	
}
