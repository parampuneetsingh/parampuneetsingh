
public class ReverseInteger_7 {

	public int reverse(int x) {
        int flag = x < 0 ? -1 : 1;
        x = x * flag;
        
        int res = 0, temp = 0;
        
        while (x > 0) {
            int t = x%10;
            temp = res * 10 + t ;
            if(temp/10 != res) return 0;
            res = temp;
            x = x/10;
        }
        
        return res * flag;
    }
	
	public static void main(String[] args) {
		//int num = 1534236469; //This number Special case with op 0
		int num = -123;
		ReverseInteger_7 rev = new ReverseInteger_7();
		int resp = rev.reverse(num);
		System.out.println(resp);
	}

}
