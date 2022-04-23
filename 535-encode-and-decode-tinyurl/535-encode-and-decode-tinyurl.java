public class Codec {
    
    String s = "0123456789abdefghijklmnopqrstuvwxyz";
    Random rand = new Random();
    String key = getRandom();
    
    private String getRandom()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 6 ; i++)
        {
            sb.append(s.charAt(rand.nextInt(35)));
        }
        return sb.toString();
    }
    
    Map<String , String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key))
        {
             key = getRandom();
        }
        map.put(key , longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!map.containsKey(shortUrl))
        {
            return "";
        }
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));