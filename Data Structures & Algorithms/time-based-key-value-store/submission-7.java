class TimeMap {

    private Map<String, List<TimeMapValue>> timemap;

    class TimeMapValue{
        public String value;
        public int timestamp;

        TimeMapValue(String value, int timestamp){
            this.value = value;
            this.timestamp =  timestamp;
        }

    }

    public TimeMap() {
        timemap = new HashMap<>();  
    }
    
    public void set(String key, String value, int timestamp) {
        timemap.putIfAbsent(key, new ArrayList<>()); // create a new entry
        timemap.get(key).add(new TimeMapValue(value,timestamp)); // update existing entry
    }
    
    public String get(String key, int timestamp) {

        List<TimeMapValue> valueTimeList = timemap.get(key);

        if(valueTimeList==null) return ""; //key does not exists in List<Value,TimeStamp>

        int start = 0;
        int end = valueTimeList.size() - 1;

        String largestValue = "";
    
        while(start <= end){
            
            int mid = start + ( end - start + 1)/2;

            TimeMapValue midValueTime = valueTimeList.get(mid); // TimeMapValue at index "mid"

            if(midValueTime.timestamp <= timestamp){
                largestValue = midValueTime.value;
                start = mid+1; // move to the next towards "end"
            }else if(midValueTime.timestamp > timestamp){
                end = mid - 1; // move to left towards "start"
            }
        }
        return largestValue;
    }   
}
