class Solution {
    public int reverse(int x) {
        int d = 0; long y = 0;
        while(Math.abs(x) > 0) {
            d = x % 10;
            x /= 10;
            y = (y * 10) + (long)d;
        }
        if(y > (int)Math.pow(2, 31) || y < (int)Math.pow(2,31)*(-1)) {
            return 0;
        } else {
            if(x < 0) {
                return (int)y * (-1);
            } else {
                return (int)y;
            }
        }
    }
}
