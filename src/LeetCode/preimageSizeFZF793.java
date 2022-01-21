package LeetCode;



public class preimageSizeFZF793 {
    public int preimageSizeFZF(int k) {
        long lo = k, hi = Long.MAX_VALUE;
        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;
            if(trailingZeros(mid) < k){
                lo = mid + 1;
            }else if(trailingZeros(mid) > k){
                hi = mid - 1;
            }else if(trailingZeros(mid) == k){
                return 5;
            }
        }
        return 0;
    }



    long left_round(int target){
        long left = 0, right = Long.MAX_VALUE;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(trailingZeros(mid) > target){
                System.out.println(trailingZeros(mid));
                right = mid - 1;
            }else if(trailingZeros(mid) < target){
                left = mid + 1;
            }else if(trailingZeros(mid) == target){
                right = mid - 1;
            }
        }
        if(!(trailingZeros(left) == target))
            return -1;
        return left;
    }
    long right_round(int target){
        long left = 0, right = Long.MAX_VALUE;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(trailingZeros(mid) > target){
                right = mid - 1;
            }else if(trailingZeros(mid) < target){
                left = mid + 1;
            }else if(trailingZeros(mid) == target){
                left = mid + 1;
            }
        }
        if(!(trailingZeros(right) == target))
            return -1;
        return right;
    }

    public long trailingZeros(long n){
        long res = 0;
        long division = 5;
        while(division <= n){
            res += n / division;
            division *= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new preimageSizeFZF793().preimageSizeFZF(79));
    }
}
