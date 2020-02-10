public class AngleClock5313{
    public static void main(String[] args) {
        
    }

    public double angleClock(int hour, int minutes) {
        double m=minutes/60.0 * 360;
        double h=((hour/12.0)*360)%360 + 30*minutes/60.0;
        return Math.min(Math.abs(m-h),360-Math.abs(m-h));
    }
}