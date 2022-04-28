import java.awt.*;

public class test {
    public static void main(String[] args){

        Draw tool = new Draw();
        tool.enableDoubleBuffering();
        tool.setCanvasSize(1000,600);
        tool.clear(Color.BLACK);
        double x = 0.5;
        tool.picture(0.23,0.7, "img/us.png", 0.4,0.4);
        tool.picture(0.8,0.7, "img/russia.png", 0.4,0.4);
//        for (int i = 0; i<=3000; i++){
//            tool.clear(Color.BLACK);
//            tool.setPenColor(Color.WHITE);
//            tool.circle(x,0.5,0.25);
//            x += 0.0002;
//            if (x>1) x = 0;
//
//        }

        tool.show();




    }
}
