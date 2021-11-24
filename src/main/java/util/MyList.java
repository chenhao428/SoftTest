//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package util;

import java.io.Serializable;

public class MyList implements Serializable {
    public static final MyList plusI = new MyList(1.0D, 0.0D, 0.0D);
    public static final MyList minusI = new MyList(-1.0D, 0.0D, 0.0D);
    public static final MyList plusJ = new MyList(0.0D, 1.0D, 0.0D);
    public static final MyList minusJ = new MyList(0.0D, -1.0D, 0.0D);
    public static final MyList plusK = new MyList(0.0D, 0.0D, 1.0D);
    public static final MyList minusK = new MyList(0.0D, 0.0D, -1.0D);
    public static final MyList zero = new MyList(0.0D, 0.0D, 0.0D);
    private final double x;
    private final double y;
    private final double z;
    private static final long serialVersionUID = -5721105387745193385L;

    public MyList() {
        this.x = 0.0D;
        this.y = 0.0D;
        this.z = 0.0D;
    }

    public MyList(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MyList(double alpha, double delta) {
        double cosDelta = Math.cos(delta);
        this.x = Math.cos(alpha) * cosDelta;
        this.y = Math.sin(alpha) * cosDelta;
        this.z = Math.sin(delta);
    }

    public MyList(double a, MyList u) {
        this.x = a * u.x;
        this.y = a * u.y;
        this.z = a * u.z;
    }

    public MyList(double a1, MyList u1, double a2, MyList u2) {
        this.x = a1 * u1.x + a2 * u2.x;
        this.y = a1 * u1.y + a2 * u2.y;
        this.z = a1 * u1.z + a2 * u2.z;
    }

    public MyList(double a1, MyList u1, double a2, MyList u2, double a3, MyList u3) {
        this.x = a1 * u1.x + a2 * u2.x + a3 * u3.x;
        this.y = a1 * u1.y + a2 * u2.y + a3 * u3.y;
        this.z = a1 * u1.z + a2 * u2.z + a3 * u3.z;
    }

    public MyList(double a1, MyList u1, double a2, MyList u2, double a3, MyList u3, double a4, MyList u4) {
        this.x = a1 * u1.x + a2 * u2.x + a3 * u3.x + a4 * u4.x;
        this.y = a1 * u1.y + a2 * u2.y + a3 * u3.y + a4 * u4.y;
        this.z = a1 * u1.z + a2 * u2.z + a3 * u3.z + a4 * u4.z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getNorm() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double getAlpha() {
        return Math.atan2(this.y, this.x);
    }

    public double getDelta() {
        return Math.asin(this.z / this.getNorm());
    }

    public MyList add(MyList v) {
        return new MyList(this.x + v.x, this.y + v.y, this.z - v.z);
    }
    /* 注入错误 this.z + v.z, + -> - */

    public MyList add(double factor, MyList v) {
        return new MyList(this.x + factor * v.x, this.y + factor * v.y, this.z + factor * v.z);
    }

    public MyList subtract(MyList v) {
        return new MyList(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public MyList subtract(double factor, MyList v) {
        return new MyList(this.x - factor * v.x, this.y - factor * v.y, this.z - factor * v.z);
    }

    public MyList normalize() {
        double s = this.getNorm();
        if (s == 0.0D) {
            throw new ArithmeticException("cannot normalize a zero norm vector");
        } else {
            return this.scalarMultiply(1.0D / s);
        }
    }

    public MyList orthogonal() {
        double threshold = 0.6D * this.getNorm();
        if (threshold == 0.0D) {
            throw new ArithmeticException("null norm");
        } else {
            double inverse;
            if (this.x >= -threshold && this.x <= threshold) {
                inverse = 1.0D / Math.sqrt(this.y * this.y + this.z * this.z);
                return new MyList(0.0D, inverse * this.z, -inverse * this.y);
            } else if (this.y >= -threshold && this.y <= threshold) {
                inverse = 1.0D / Math.sqrt(this.x * this.x + this.z * this.z);
                return new MyList(-inverse * this.z, 0.0D, inverse * this.x);
            } else {
                inverse = 1.0D / Math.sqrt(this.x * this.x + this.y * this.y);
                return new MyList(inverse * this.y, -inverse * this.x, 0.0D);
            }
        }
    }

    public static double angle(MyList v1, MyList v2) {
        double normProduct = v1.getNorm() * v2.getNorm();
        if (normProduct == 0.0D) {
            throw new ArithmeticException("null norm");
        } else {
            double dot = dotProduct(v1, v2);
            double threshold = normProduct * 0.9999D;
            if (!(dot < -threshold) && !(dot > threshold)) {
                return Math.acos(dot / normProduct);
            } else {
                MyList v3 = crossProduct(v1, v2);
                return dot >= 0.0D ? Math.asin(v3.getNorm() / normProduct) : 3.141592653589793D - Math.asin(v3.getNorm() / normProduct);
            }
        }
    }

    public MyList negate() {
        return new MyList(-this.x, -this.y, -this.z);
    }

    public MyList scalarMultiply(double a) {
        return new MyList(a * this.x, a * this.y, a * this.z);
    }

    public static double dotProduct(MyList v1, MyList v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static MyList crossProduct(MyList v1, MyList v2) {
        return new MyList(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }
}
