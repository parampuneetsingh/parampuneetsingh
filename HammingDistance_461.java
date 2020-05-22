
public class HammingDistance_461 {

	public static void main(String[] args) {
		
		int x = 1, y = 4;
		int i = 0, j = 0;
        
        int count = 0;
        
        while (x !=0 || y != 0) {
            i = x & 1;
            j = y & 1;
            
            count = ((i^j) == 1) ? count+1 : count;
            x = x>>1;
            y = y>>1;
        }
        
	}

}
