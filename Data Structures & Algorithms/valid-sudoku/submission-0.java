class Solution {
    public boolean isValidSudoku(char[][] nums) {
        
        // all rows should be unique
        for(int i=0;i<9;i++){
            HashMap<Character,Integer>mp=new HashMap<>();
            for(int j=0;j<9;j++){
                if(nums[i][j]=='.')continue;
                else if(mp.containsKey(nums[i][j]))return false;
                mp.put(nums[i][j],mp.getOrDefault(nums[i][j],0)+1);
            }
        }

        // all cols should be unique
        for(int i=0;i<9;i++){
            HashMap<Character,Integer>mp=new HashMap<>();
            for(int j=0;j<9;j++){
                if(nums[j][i]=='.')continue;
                else if(mp.containsKey(nums[j][i]))return false;
                mp.put(nums[j][i],mp.getOrDefault(nums[j][i],0)+1);
            }
        }

        // check grid wise 

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashMap<Character,Integer>mp=new HashMap<>();
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(nums[k][l]=='.')continue;
                        else if(mp.containsKey(nums[k][l]))return false;
                        mp.put(nums[k][l],mp.getOrDefault(nums[k][l],0)+1);
                    }
                }
            }
        }
        return true;
    }
}
