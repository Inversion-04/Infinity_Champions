public class Median_Of_Two_Sorted_Arrays {
    // brute force 
    // TC : O(n+m)
    // SC : O(n+m)
    public double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[]sorted = new int[n+m];

        int i = 0;
        int j = 0;

        int k = 0;

        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                sorted[k++] = nums1[i++];
            }else{
                sorted[k++] = nums2[j++];
            }
        }

        while(i<n)sorted[k++] = nums1[i++];
        while(j<m)sorted[k++] = nums2[j++];

        int len = sorted.length;


        if(sorted.length%2!=0){
            return sorted[len/2];
        }
        return (sorted[(len/2)-1] + sorted[len/2])/2.0;
    }
    // optimized
    // TC : O(log(min(n1,n2)))
    // SC : O(1)
    public double findMedianSortedArraysOptimized(int[]nums1,int[]nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2)return findMedianSortedArraysOptimized(nums2,nums1);

        int left = (n1 + n2 + 1)/2;

        int n = n1 + n2;

        int low = 0;
        int high = n1;

        while(low<=high){

            int mid1 = low + (high-low)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1<n1) r1 = nums1[mid1];
            if(mid2<n2) r2 = nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                if(n%2!=0){
                    return Math.max(l1,l2);
                }
                return (double)(((Math.max(l1,l2) + Math.min(r1,r2)))/2.0);
            }
            else if(l1>r2){
                high = mid1 -1;
            }else{
                low = mid1+1;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        Median_Of_Two_Sorted_Arrays obj = new Median_Of_Two_Sorted_Arrays();

        int[]nums1 = {1,3};
        int[]nums2 = {2};

        System.out.println("Brute: " + obj.findMedianSortedArraysBrute(nums1, nums2));
        System.out.println("Optimized: " + obj.findMedianSortedArraysOptimized(nums1, nums2));
    }
}
