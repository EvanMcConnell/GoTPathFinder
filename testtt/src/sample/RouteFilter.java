package sample;

import java.awt.image.BufferedImage;

public class RouteFilter {

    public RouteFilter() {
    }

    public BufferedImage applyToImage(BufferedImage image) {

        //1-3
        //1-5
        image.getGraphics().drawLine(265, 24, 390, 94);
        image.getGraphics().drawLine(265, 24, 250, 104);

        //2-2
        image.getGraphics().drawLine(472, 49, 390, 94);

        //3-4
        //3-9
        //3-8
        image.getGraphics().drawLine(390, 94, 514, 90);
        image.getGraphics().drawLine(390, 94, 472, 215);
        image.getGraphics().drawLine(390, 94, 250, 192);

        //5-8
        image.getGraphics().drawLine(250, 104, 250, 192);

        //6-9
        image.getGraphics().drawLine(536, 144, 472, 215);

        //7-11
        image.getGraphics().drawLine(127, 170, 140, 251);

        //8-7
        //8-13
        image.getGraphics().drawLine(250, 192, 127, 170);
        image.getGraphics().drawLine(250, 192, 178, 308);

        //10-9
        //10-8
        //10-14
        image.getGraphics().drawLine(347, 223, 472, 215);
        image.getGraphics().drawLine(347, 223, 250, 192);
        image.getGraphics().drawLine(347, 223, 463, 253);

        //11-12
        //11-13
        image.getGraphics().drawLine(140, 251, 48, 286);
        image.getGraphics().drawLine(140, 251, 178, 308);

        //13-15
        //13-19
        //13-17
        image.getGraphics().drawLine(178, 308, 405, 313);
        image.getGraphics().drawLine(178, 308, 131, 373);
        image.getGraphics().drawLine(178, 308, 321, 410);

        //14-15
        image.getGraphics().drawLine(463, 253, 405, 313);

        //15-17
        //15-21
        image.getGraphics().drawLine(405, 313,   321, 410);
        image.getGraphics().drawLine(405, 313,  462, 390);

        //17-21
        //17-23
        //17-25
        image.getGraphics().drawLine(321, 410,   462, 390);
        image.getGraphics().drawLine(321, 410,   172, 475);
        image.getGraphics().drawLine(321, 410,   354, 517);

        //19-18
        //19-20
        //19-23
        image.getGraphics().drawLine(131, 373,   68, 353);
        image.getGraphics().drawLine(131, 373,   90, 413);
        image.getGraphics().drawLine(131, 373,   172, 475);

        //20-18
        image.getGraphics().drawLine(90, 413,   68, 353);

        //21-16
        //21-22
        image.getGraphics().drawLine(462, 390,   513, 311);
        image.getGraphics().drawLine(462, 390,   459, 452);

        //22-27
        //22-26
        image.getGraphics().drawLine(459, 452,   533, 471);
        image.getGraphics().drawLine(459, 452,   412, 496);

        //26-25
        //26-28
        image.getGraphics().drawLine(412, 496, 354 , 517);
        image.getGraphics().drawLine(412, 496, 486, 525);

        //27-28
        image.getGraphics().drawLine(533, 471,   486, 525);

        //24-23
        //24-25
        image.getGraphics().drawLine(263, 529,   172, 475);
        image.getGraphics().drawLine(263, 529,   354, 517);

        //24-30
        //24-33
        //24-31
        image.getGraphics().drawLine(263, 529,   61, 579);
        image.getGraphics().drawLine(263, 529,   182, 600);
        image.getGraphics().drawLine(263, 529,   336, 573);

        //29-23
        //29-30
        image.getGraphics().drawLine(66, 510,   172, 475);
        image.getGraphics().drawLine(66, 510,   61, 579);

        //32-33
        //32-30
        image.getGraphics().drawLine(130, 636,   182, 600);
        image.getGraphics().drawLine(130, 636,   61, 579);

        //31-35
        //31-36
        //31-37
        image.getGraphics().drawLine(336, 573,   293, 635);
        image.getGraphics().drawLine(336, 573,   376, 636);
        image.getGraphics().drawLine(336, 573,   422, 593);

        //34-33
        //34-35
        image.getGraphics().drawLine(238, 634,   182, 600);
        image.getGraphics().drawLine(238, 634,   293, 635);

        //38-36
        //38-39
        image.getGraphics().drawLine(427, 661,   376, 636);
        image.getGraphics().drawLine(427, 661,   500, 650);

        //40-39
        //40-37
        image.getGraphics().drawLine(507, 593,   500, 650);
        image.getGraphics().drawLine(507, 593,   422, 593);

        return image;
    }
}