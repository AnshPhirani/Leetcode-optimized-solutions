class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillId = new HashMap<>();
        for(int i = 0; i < n; i++){
            skillId.put(req_skills[i], i);
        }
        
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        for(int i = 0; i < people.size(); i++){
            int peopleSkills = 0;
            for(String skill : people.get(i))
                peopleSkills |= (1<<skillId.get(skill));
            
            for(int preSkills : new ArrayList<>(dp.keySet())){
                List<Integer> team = dp.get(preSkills);
                
                int updatedSkills = peopleSkills | preSkills;
                
                if(!dp.containsKey(updatedSkills) || team.size() + 1 < dp.get(updatedSkills).size()){
                    List<Integer> updatedTeam = new ArrayList<>(team);
                    updatedTeam.add(i);
                    dp.put(updatedSkills, updatedTeam);
                }
            }    
        }
        
        return dp.get((1<<n)-1).stream().mapToInt(Integer::intValue).toArray();
    }
}