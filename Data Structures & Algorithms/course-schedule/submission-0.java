class Solution {

    Map<Integer, List<Integer>> reqsPerCourse = new HashMap<>();
    Set<Integer> path = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++){
            reqsPerCourse.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];    
            reqsPerCourse.get(course).add(preReq);    
        }

        //run DFS from every course
        for (int i = 0; i < numCourses; i++){
            // if there was a cycle return false
            if (!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if (path.contains(course)){
            return false;
        }

        // no reqs to check
        if (reqsPerCourse.get(course).isEmpty()){
            return true;
        }

        path.add(course);

        for (int preReq : reqsPerCourse.get(course)){
            if (!dfs(preReq)){
                return false;
            }
        }

        path.remove(course);
        reqsPerCourse.put(course, new ArrayList<>());
        return true;
    }
}
