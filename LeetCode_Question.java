class LeetCode_Question29 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        else if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        else if(divisor == 1) return dividend;
        boolean isNegative = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        dividend = (dividend < 0)? -dividend : dividend;
        divisor = (divisor < 0) ?  -divisor : divisor;
        int sum, result = 0;
        while(true){
            int d1 = divisor;
            sum = 0;
            if(dividend - d1 == 0) {sum += 1; result += sum; break;}
            if(dividend - d1 < 0) break;
            while(dividend - (d1 << 1) > 0){
                d1 <<= 1;
                sum += 1;
            }
            result += (1 << sum);
            dividend = dividend - d1;
        }
        return isNegative ? -result : result;
    }
}