package ua.opnu;

import ua.opnu.java.inheritance.point.Point;

public class Point3D extends Point {
    public int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(Point3D p) {
        super(p);
        this.z = p.z;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void toString(int x, int y, int z) {
        System.out.println("x: " + x + "y: " + y + "z: " + z);
    }

    @Override
    public double distanceFromOrigin() {
        return this.distance(new Point3D());
    }

    public double distance(Point3D p) {
        double xy = super.distance((Point) p);
        int dz = this.z - p.z;
        return Math.sqrt(xy * xy + dz * dz);
    }

    public int getZ() {
        return this.z;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
