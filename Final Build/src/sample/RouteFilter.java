
        package sample;

        import java.awt.*;
        import java.awt.image.BufferedImage;

public class RouteFilter {

    public RouteFilter() {
    }

    public BufferedImage applyToImage(BufferedImage image) {
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.BLACK);

        //1-3
        //1-5
        graphics.drawLine(265, 24, 390, 94);
        graphics.drawLine(265, 24, 250, 104);

        //2-2
        graphics.drawLine(472, 49, 390, 94);

        //3-4
        //3-9
        //3-8
        graphics.drawLine(390, 94, 514, 90);
        graphics.drawLine(390, 94, 472, 215);
        graphics.drawLine(390, 94, 250, 192);

        //5-8
        graphics.drawLine(250, 104, 250, 192);

        //6-9
        graphics.drawLine(536, 144, 472, 215);

        //7-11
        graphics.drawLine(127, 170, 140, 251);

        //8-7
        //8-13
        graphics.drawLine(250, 192, 127, 170);
        graphics.drawLine(250, 192, 178, 308);

        //10-9
        //10-8
        //10-14
        graphics.drawLine(347, 223, 472, 215);
        graphics.drawLine(347, 223, 250, 192);
        graphics.drawLine(347, 223, 463, 253);

        //11-12
        //11-13
        graphics.drawLine(140, 251, 48, 286);
        graphics.drawLine(140, 251, 178, 308);

        //13-15
        //13-19
        //13-17
        graphics.drawLine(178, 308, 405, 313);
        graphics.drawLine(178, 308, 131, 373);
        graphics.drawLine(178, 308, 321, 410);

        //14-15
        graphics.drawLine(463, 253, 405, 313);

        //15-17
        //15-21
        graphics.drawLine(405, 313,   321, 410);
        graphics.drawLine(405, 313,  462, 390);

        //17-21
        //17-23
        //17-25
        graphics.drawLine(321, 410,   462, 390);
        graphics.drawLine(321, 410,   172, 475);
        graphics.drawLine(321, 410,   354, 517);

        //19-18
        //19-20
        //19-23
        graphics.drawLine(131, 373,   68, 353);
        graphics.drawLine(131, 373,   90, 413);
        graphics.drawLine(131, 373,   172, 475);

        //20-18
        graphics.drawLine(90, 413,   68, 353);

        //21-16
        //21-22
        graphics.drawLine(462, 390,   513, 311);
        graphics.drawLine(462, 390,   459, 452);

        //22-27
        //22-26
        graphics.drawLine(459, 452,   533, 471);
        graphics.drawLine(459, 452,   412, 496);

        //26-25
        //26-28
        graphics.drawLine(412, 496, 354 , 517);
        graphics.drawLine(412, 496, 486, 525);

        //27-28
        graphics.drawLine(533, 471,   486, 525);

        //24-23
        //24-25
        graphics.drawLine(263, 529,   172, 475);
        graphics.drawLine(263, 529,   354, 517);

        //24-30
        //24-33
        //24-31
        graphics.drawLine(263, 529,   61, 579);
        graphics.drawLine(263, 529,   182, 600);
        graphics.drawLine(263, 529,   336, 573);

        //29-23
        //29-30
        graphics.drawLine(66, 510,   172, 475);
        graphics.drawLine(66, 510,   61, 579);

        //32-33
        //32-30
        graphics.drawLine(130, 636,   182, 600);
        graphics.drawLine(130, 636,   61, 579);

        //31-35
        //31-36
        //31-37
        graphics.drawLine(336, 573,   293, 635);
        graphics.drawLine(336, 573,   376, 636);
        graphics.drawLine(336, 573,   422, 593);

        //34-33
        //34-35
        graphics.drawLine(238, 634,   182, 600);
        graphics.drawLine(238, 634,   293, 635);

        //38-36
        //38-39
        graphics.drawLine(427, 661,   376, 636);
        graphics.drawLine(427, 661,   500, 650);

        //40-39
        //40-37
        graphics.drawLine(507, 593,   500, 650);
        graphics.drawLine(507, 593,   422, 593);

        return image;
    }
}
