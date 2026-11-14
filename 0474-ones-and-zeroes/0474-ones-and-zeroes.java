class Solution {
    int[] az;
    int[] aone;
    private int solve(Integer[][][] dp, String[] strs, int m, int n, int index){
        if(index==strs.length){
            return 0;
        }

        if(dp[index][m][n]!=null) return dp[index][m][n];
        int skip=solve(dp, strs, m, n, index+1);
        int take=0;
        int i=index;
        //  for(int i=index;i<strs.length;i++){
            String s=strs[i];
            int zer=az[i], ones=aone[i];   

            if(m-zer>=0 && n-ones>=0){
                take=1+solve(dp, strs, m-zer, n-ones, i+1);
            }
        //  }
        return dp[index][m][n]=Math.max(skip, take);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        // Collections.sort(strs, (a,b)-> {a.length()-b.length()});
        az=new int[strs.length];
        aone=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            int a=0, b=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0'){
                    a++;
                }
                else{
                    b++;
                }
            }
            // strs[i]=a+"0"+b+"1";
            az[i]=a;
            aone[i]=b;
            // System.out.println(a+" "+ b);
        }

        Integer[][][] dp=new Integer[strs.length][m+1][n+1];
        // Arrays.fill(dp, -1);

        return solve(dp, strs, m, n, 0);
    }
}