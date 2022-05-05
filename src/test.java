import java.awt.*;

public class test {
    public static void main(String[] args){

        Draw tool = new Draw();
        tool.enableDoubleBuffering();
        tool.setCanvasSize(1000,600);
        tool.clear(Color.BLACK);
//        double x = 0.5;
//        double currentX = 0;
//        double currentY = 0;
        tool.picture(0.23,0.7, "img/us.png", 0.4,0.4);
////        tool.picture(0.8,0.7, "img/russia.png", 0.4,0.4);
////        tool.picture(0.5,0.96, "img/usflag.png", 0.1,0.1);
//        tool.setPenColor(Color.WHITE);
//            tool.text(0.5, 0.9, "something");
////        for (int i = 0; i<=3000; i++){
////            tool.picture(currentX, currentY, "img/weapon.png", 0.03,0.05);
//////            tool.clear(Color.BLACK);
//////            tool.setPenColor(Color.WHITE);
//////            tool.circle(x,0.5,0.25);
//////            x += 0.0002;
//////            if (x>1) x = 0;
////            currentX += 0.0002;
////            currentY += 0.0002;
////            tool.show();
////
////        }
//
//
//        tool.show();
////        String input = handleKeyPress(tool);
////        StdOut.println(input);

        StdOut.println(Math.toDegrees(Math.atan2(-1,-1)));




    }
    public static String handleKeyPress(Draw tool) {
        String guess = "";
        char c;
        while (true){
            while (!tool.hasNextKeyTyped()) {
                // Wait for a key to be typed
            }
            c = tool.nextKeyTyped();
            StdOut.print(c);
            guess += c;
            if (c=='\n'){
                StdOut.println("end");
                break;
            }
            while (tool.hasNextKeyTyped()) {
                // Wait for a key to be released
            }
        }

//        if (c == '\b' && guess.length() > 0) {
//            return guess;
//        }
        return guess;
    }
}
