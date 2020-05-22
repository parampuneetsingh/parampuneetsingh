import java.util.HashMap;

//https://leetcode.com/problems/encode-and-decode-tinyurl/

public class EncodeandDecodeTinyURL_535 {

	HashMap<String, String> shortUrlMap;
	HashMap<String, String> longUrlMap;

	private String prefix = "http://tinyurl.com/";

	public EncodeandDecodeTinyURL_535() {
		shortUrlMap = new HashMap<String, String>();
		longUrlMap = new HashMap<String, String>();
	}

	public String convertToSixtyTwoBase(int hashKey) {

		StringBuilder sb = new StringBuilder();
		
		if (hashKey < 0) {
			hashKey = hashKey * -1;
		}
		
		while (hashKey > 0) {
			int mod = hashKey % 62;
			if (mod < 10)
				sb.append(mod + '0');
			else if (mod < 36)
				sb.append(mod - 10 + 'a');
			else
				sb.append(mod - 36 + 'A');
			hashKey /= 62;
		}
		
		return sb.toString();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String encodedUrl = prefix + convertToSixtyTwoBase(longUrl.hashCode());

		shortUrlMap.put(encodedUrl, longUrl);

		return encodedUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortUrlMap.get(shortUrl);
	}

	public static void main(String[] args) {
		EncodeandDecodeTinyURL_535 tinyUrl = new EncodeandDecodeTinyURL_535();
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		String shortUrl = tinyUrl.encode(longUrl);
		System.out.println(shortUrl);
		System.out.println(tinyUrl.decode(shortUrl));
	}

}
