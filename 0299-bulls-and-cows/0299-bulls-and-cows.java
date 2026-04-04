class Solution {
    public String getHint(String secret, String guess) {
        int[] arr1=new int[10];
        int[] arr2=new int[10];
        int x=0, y=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                x++;
            }
            else{
                if(arr2[secret.charAt(i)-'0']>0){
                    arr2[secret.charAt(i)-'0']--;
                    y++;
                }
                else{
                    arr1[secret.charAt(i)-'0']++;
                }
                if(arr1[guess.charAt(i)-'0']>0){
                    arr1[guess.charAt(i)-'0']--;
                    y++;
                }
                else{
                    
                    arr2[guess.charAt(i)-'0']++;
                }
            }
        }

        return x+"A"+y+"B";
    }
}