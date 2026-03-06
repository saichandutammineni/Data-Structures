class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String, List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int[] frequencyArray=new int[26];
            for(int j=0;j<strs[i].length();j++){
                frequencyArray[strs[i].charAt(j)-'a']++;
            }

            StringBuilder encoded=new StringBuilder();
            for(int j=0;j<26;j++){
                if(frequencyArray[j]!=0){
                    encoded.append(frequencyArray[j]).append(j+'a');
                }
            }
            String encode=encoded.toString();
            if(!hm.containsKey(encode)){
                List<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                hm.put(encode, temp);
            }
            else{
                hm.get(encode).add(strs[i]);
            }
        }

        for(Map.Entry<String, List<String>> entry: hm.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}