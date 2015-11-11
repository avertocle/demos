package vds.utils;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class GraphicUtils {

	public static void drawLabledCircle(Graphics2D g, Point p, String data, int radius) {
		int diameter = radius * 2;
		int margin = Math.max(5, radius / 10);
		g.drawOval(p.x, p.y, diameter, diameter);
		Point center = new Point(p.x + radius, p.y + radius);
		int string_x = center.x - margin - (margin * (data.length() - 1));
		int string_y = center.y + 2 * margin;
		Font stringFont = new Font(g.getFont().getName(), Font.PLAIN, radius);
		g.setFont(stringFont);
		g.drawString(data, string_x, string_y);
	}

	public static void drawLineConnectingCircles(Graphics2D g, Point origin1, Point origin2, int radius) {
		g.drawLine(origin1.x + radius, origin1.y + radius * 2, origin2.x + radius, origin2.y);
	}

}
