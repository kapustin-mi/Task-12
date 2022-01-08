package cs.vsu.ru.kapustin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ImageCreation {

    public void drawFigure(int size, int depth, Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size, size);

        int diameter = size/depth;
        Point centre = new Point(size/2, size/2);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centre.getX() - diameter/2, centre.getY() - diameter/2, size/depth, size/depth);

        List<Point> centres = new ArrayList<>();
        centres.add(centre);

        findCentresOfCirclesOfNextLevel(depth, diameter, centres, g2d);
    }

    public void findCentresOfCirclesOfNextLevel(int depth, int diameter, List<Point> centres, Graphics2D g2d) {
        List<Point> newCentres = new ArrayList<>();
        Point firstCenter, secondCenter, thirdCenter, fourthCenter;
        int length = (centres.get(0).getX() - diameter/2)/2;

        for (Point point : centres) {
            firstCenter = new Point(point.getX() - diameter/2 - length, point.getY());
            newCentres.add(firstCenter);

            secondCenter = new Point(point.getX() + diameter / 2 + length, point.getY());
            newCentres.add(secondCenter);

            thirdCenter = new Point(point.getX(), point.getY() - diameter / 2 - length);
            newCentres.add(thirdCenter);

            fourthCenter = new Point(point.getX(), point.getY() + diameter / 2 + length);
            newCentres.add(fourthCenter);

            printCircles(new Point[]{firstCenter, secondCenter, thirdCenter, fourthCenter}, diameter, g2d);
        }

        depth = depth - 1;
        if (depth != 0) {
            findCentresOfCirclesOfNextLevel(depth, (int) (diameter/2.5), newCentres, g2d);
        }
    }

    private void printCircles(Point[] centres, int diameter, Graphics2D g2d) {
        diameter = (int) (diameter/2.5);

        for (Point centre : centres) {
            g2d.drawOval(centre.getX() - diameter / 2, centre.getY() - diameter / 2, diameter, diameter);
        }
    }
}
