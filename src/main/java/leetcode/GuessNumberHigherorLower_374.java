package leetcode;

public class GuessNumberHigherorLower_374 {
    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {
        if(address == null || address.length() == 0) return address;
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()){
            if(ch == '.') sb.append("[.]");
            else sb.append(ch);
        }
        return sb.toString();
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        if(bookings == null || bookings.length == 0 || bookings[0] == null || bookings[0].length == 0) return res;
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            for (int j = start; j <= end ; j++) {
                res[j-1] += bookings[i][3];
            }
        }
        return res;
    }
}
