class Solution {
    public String simplifyPath(String path) {

        String[] strs = path.split("/");

        Deque<String> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for(String str: strs){

            if(str.equals("..")){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }else if(!str.isEmpty() && !str.equals(".")){
                deque.addLast(str);
            }

        }

        while(!deque.isEmpty()){
            sb.append("/").append(deque.pollFirst());
        }

        return sb.length()==0 ? "/" : sb.toString();
        
    }
}