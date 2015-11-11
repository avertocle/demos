package vds.binarytree;

import java.awt.Point;

public class GridPoint<T> {
	private Point point;
	private T data;

	public GridPoint(Point point, T data) {
		super();
		this.point = point;
		this.data = data;
	}

	public Point getPoint() {
		return point;
	}

	public T getData() {
		return data;
	}

}
