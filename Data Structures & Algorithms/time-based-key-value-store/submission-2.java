class TimeMap {

    Map<String, List<Pair>> timeMap ;

    private class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {

        timeMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>()); // put if not present

        timeMap.get(key).add(new Pair(value, timestamp)); // present
    }
    
    public String get(String key, int timestamp) {

        if(!timeMap.containsKey(key)) return "";

        List<Pair> list = timeMap.get(key);

        int start = 0;
        int end = list.size() - 1;

        String result = "";

        while( start <= end){

            int mid = start +  ( end - start ) / 2;

            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value; // collect value
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }
        return result;
        
    }
}
