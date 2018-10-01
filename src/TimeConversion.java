public class TimeConversion {
    public static void main(String[] args) {
        String s = "11:59:59PM";
        System.out.println(timeConversion(s));
    }

    static String timeConversion(String s) {
        int hours = Integer.parseInt(s.substring(0,2));
        int minutes = Integer.parseInt(s.substring(3,5));
        int seconds = Integer.parseInt(s.substring(6,8));
        boolean isAM = s.substring(8, 10).equals("AM");
        if (isAM && hours == 12) {
            hours = 0;
        }
        if (!isAM && hours != 12) {
            hours += 12;
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
