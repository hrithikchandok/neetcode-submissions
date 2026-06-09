class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        // brute force is O(n2)
        // optimal staircase approach 
        // Since its sorted in rows and cols . 
        // if the elementn is amller then move downwards skip that row 
        // if the element is greater than skip coloum and move 
        // Tc O(m+n);
        // SC o1

        // second approach is to find the row first through bs 
        // then apply bs on the col to find the exact target 
        // logn +log m = log(m*n)
        int row=nums.length;
        int col=nums[0].length;
        int first_row=0;
        int last_row=row-1;
        int first_col=0;
        int last_col=col-1;
        int targetRow=-1;
        while (first_row <= last_row) {
            int mid = first_row + (last_row - first_row) / 2;
            
            // If target is less than the first element of the row, move up
            if (target < nums[mid][0]) {
                last_row = mid - 1;
            } 
            // If target is greater than the last element of the row, move down
            else if (target > nums[mid][col - 1]) {
                first_row = mid + 1;
            } 
            // Target falls within the range of this row
            else {
                targetRow = mid;
                break;
            }
        } 
        if(targetRow==-1){
            // System.out.Println("Row is ",row);
            return false;
        }
        System.out.println(targetRow);
        while(first_col<=last_col){
            int mid=first_col+(last_col-first_col)/2;
            if(nums[targetRow][mid]>target)
            last_col=mid-1;
            else if(nums[targetRow][mid]<target)
            first_col=mid+1;
            else if(nums[targetRow][mid]==target)return true;
            }
            
return false;
        } 
       
    }
