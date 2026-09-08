class TimeMap {

    private Map<String, List<Pair>> map;

    private class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {

        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        
        //key does not exists in List<Value,TimeStamp>
        if(!map.containsKey(key)) return ""; 

        List<Pair> pairs = map.get(key);

        int start = 0;
        int end = pairs.size() - 1;

        String largetValue = "";

        while( start <= end){

            int mid = start + ( end - start + 1) / 2;

            Pair midPair = pairs.get(mid);

            if(midPair.timestamp == timestamp){
                return midPair.value;
            }else if(midPair.timestamp < timestamp){
                largetValue = midPair.value; // keeping the eye on current lower value
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        return largetValue;
        
    }
}
