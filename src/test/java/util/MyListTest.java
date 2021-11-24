package util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getX() {
        MyList list = new MyList(2.0,3.0,4.0);
        double x;
        x = list.getX();
        assertEquals(2,x,0);
        System.out.println("x = "+x);
    }

    @Test
    public void getY() {
    }

    @Test
    public void getZ() {
    }

    @Test
    public void getNorm() {
    }

    @Test
    public void getAlpha() {
    }

    @Test
    public void getDelta() {
    }

    @Test
    public void add() {
    }

    @Test
    public void testAdd() {
        MyList list1 = new MyList(2.0,3.0,4.0);
        MyList list2 = new MyList(3.0,4.0,5.0);
        list2 = list2.add(list1);
        double x,y,z;
        x = list2.getX();
        y = list2.getY();
        z = list2.getZ();
        assertEquals(5,x,0);
        System.out.println("x = "+x);
        assertEquals(7,y,0);
        System.out.println("y = "+y);
        assertEquals(9,z,0);
        System.out.println("z = "+z);

    }

    @Test
    public void subtract() {
    }

    @Test
    public void testSubtract() {
    }

    @Test
    public void normalize() {
    }

    @Test
    public void orthogonal() {
    }

    @Test
    public void angle() {
    }

    @Test
    public void negate() {
    }

    @Test
    public void scalarMultiply() {
        MyList list = new MyList(2.0,3.0,4.0);
        list = list.scalarMultiply(2.0);
        double x,y,z;
        x = list.getX();
        y = list.getY();
        z = list.getZ();
        assertEquals(4,x,0);
        System.out.println("x = "+x);
        assertEquals(6,y,0);
        System.out.println("y = "+y);
        assertEquals(8,z,0);
        System.out.println("z = "+z);
    }

    @Test
    public void dotProduct() {
    }

    @Test
    public void crossProduct() {
    }
}