class Solution {
    int dirx[]={1,-1,0,0};
    int diry[]={0,0,1,-1};
     boolean ok(char [][]nums,int i,int j,int r,int c ,int index, String word){
        if(index==word.length()-1)return true;
        char original=nums[i][j];
        nums[i][j]='#';
        for(int x=0;x<4;x++){
            int nx=i+dirx[x];
            int ny=j+diry[x];
            if(nx>=0&&ny>=0&&nx<r&&ny<c&&nums[nx][ny]==word.charAt(index+1)&&nums[nx][ny]!='#'){
                if(ok(nums,nx,ny,r,c,index+1,word))
                    return true;
            }
        }
        nums[i][j]=original;
        return false;
    }
    public boolean exist(char[][] nums, String word) {
        int r=nums.length;
        int c=nums[0].length;
        int index=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(nums[i][j]==word.charAt(index)){
                    if(ok(nums,i,j,r,c,index,word))return true;
                }
            }
        }
        return false;
        

    }
}
