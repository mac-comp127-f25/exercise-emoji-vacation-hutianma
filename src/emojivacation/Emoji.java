package emojivacation;

import edu.macalester.graphics.*;

import java.awt.Color;
import java.lang.reflect.RecordComponent;

@SuppressWarnings("WeakerAccess")  // This stops Java from giving you warnings about your code that are not helpful here
public class Emoji{
    private static final Color
        HEAD_COLOR = new Color(0xFFDE30),
        HEAD_OUTLINE_COLOR = new Color(0xAC9620),
        MOUTH_COLOR = new Color(0xE45B5B),
        EYE_COLOR = new Color(0x000000);

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Emojis", 800, 600);

        GraphicsGroup littleSmiley = createCoolFace(100);
        littleSmiley.setPosition(50, 400);
        canvas.add(littleSmiley);

        GraphicsGroup mediumSmiley = createDisappointedFace(200);
        mediumSmiley.setPosition(150, 300);
        canvas.add(mediumSmiley);

        GraphicsGroup bigSmiley = createFrownFace(300);
        bigSmiley.setPosition(350, 200);
        canvas.add(bigSmiley);
    }

    /**
     * Creates a smiley face emoji.
     *
     * @param size The overall width and height of the emoji.
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createSmileyFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        Ellipse leftEye = createEye (0.1 * size);
        Ellipse rightEye = createEye (0.1 * size);
        leftEye.setCenter(size * 0.3, size * 0.35);
        rightEye.setCenter(size * 0.7, size * 0.35);
        group.add(leftEye);
        group.add(rightEye);

        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        return group;
    }

    public static GraphicsGroup createDisappointedFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        Ellipse leftEye = createEye (0.1 * size);
        Ellipse rightEye = createEye (0.1 * size);
        leftEye.setCenter(size * 0.3, size * 0.35);
        rightEye.setCenter(size * 0.7, size * 0.35);
        group.add(leftEye);
        group.add(rightEye);

        Line mouth = createMouth(size);
        group.add(mouth);

        return group;
    }

    public static GraphicsGroup createCoolFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        Rectangle left = createSunglasses(size);
        Rectangle right = createSunglasses(size);
        left.setCenter(size * 0.3, size * 0.35);
        right.setCenter(size * 0.7, size * 0.35);
        Line bridge = new Line (size * 0.3, size * 0.35, size * 0.7, size * 0.35);
        bridge.setStrokeColor(EYE_COLOR);
        bridge.setStrokeWidth(4);
        group.add(left);
        group.add(right);
        group.add(bridge);

        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        return group;
    }

    public static GraphicsGroup createFrownFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        Ellipse leftEye = createEye (0.1 * size);
        Ellipse rightEye = createEye (0.1 * size);
        leftEye.setCenter(size * 0.3, size * 0.35);
        rightEye.setCenter(size * 0.7, size * 0.35);
        group.add(leftEye);
        group.add(rightEye);

        Arc mouth = createFrown(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        return group;
    }

    private static Ellipse createEye(double size) {
        Ellipse eye = new Ellipse(0, 0, size, size);
        eye.setFillColor(EYE_COLOR);
        return eye;
    }

    /**
     * Creates an empty emoji head. The head fits inside the box from (0,0)
     * to (width,height).
     */
    private static Ellipse createHead(double height, double width) {
        Ellipse head = new Ellipse(0, 0, width, height);
        head.setFillColor(HEAD_COLOR);
        head.setStrokeColor(HEAD_OUTLINE_COLOR);
        head.setStrokeWidth(2);
        return head;
    }

    /** 
     * Creates a smile-shaped arc. The arc is measured relative to its “implied ellipse,” which is
     * the shape that would be formed if the arc were extend all the way around. The size of the
     * resulting arc will be smaller than the implied ellipse’s size.
     *
     * @param ellipseWidth  The width of the implied ellipse from which the smile’s arc is cut.
     * @param ellipseHeight The width of the implied ellipse from which the smile’s arc is cut.
     */
    private static Arc createSmile(double ellipseWidth, double ellipseHeight) {
        Arc mouth = new Arc(0, 0, ellipseWidth, ellipseHeight, 200, 140);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }

    private static Arc createFrown (double ellipseWidth, double ellipseHeight) {
        Arc mouth = new Arc(0, 0, ellipseWidth, ellipseHeight, 20, 140);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }

    private static Line createMouth (double size) {
        Line mouth = new Line(size * 0.3, size * 0.7, size * 0.7, size * 0.5);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }

    private static Rectangle createSunglasses (double size) {
        Rectangle sunglasses = new Rectangle(0, 0, size * 0.3, size * 0.2);
        sunglasses.setFillColor(EYE_COLOR);
        return sunglasses;
    }
}

