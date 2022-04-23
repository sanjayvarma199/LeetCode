public class Codec {
    
    int counter;
    Map<String , String> encode_map = new HashMap<>();
    Map<String , String> decode_map = new HashMap<>();
    // Encodes a URL to a shortened URL
    public String encode(String longUrl) {
        counter++;
        String s = String.valueOf(counter);
        if(encode_map.containsKey(longUrl))
        {
            return encode_map.get(longUrl);
        }
        encode_map.put(longUrl , s);
        decode_map.put(s , longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!decode_map.containsKey(shortUrl))
        {
            return "";
        }
        return decode_map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));