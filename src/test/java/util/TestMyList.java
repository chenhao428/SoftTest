package util;

public class TestMyList {
    public static void main(String[]args) {
        TestMyList myTest = new TestMyList();
        System.out.println("testgetX():");
        myTest.testgetX();
        System.out.println("testAdd():");
        myTest.testAdd();
        System.out.println("testscalarMultiply():");
        myTest.testscalarMultiply();
    }

    public void testgetX() {
        MyList list = new MyList(2.0,3.0,4.0);
        double x;
        x = list.getX();
        if(x == 2)
        {
            System.out.println("x = "+x);
        }
        else
        {
            System.out.println("错误！");
        }

    }

    public void testAdd() {
        MyList list1 = new MyList(2.0,3.0,4.0);
        MyList list2 = new MyList(3.0,4.0,5.0);
        list2 = list2.add(list1);
        double x,y,z;
        x = list2.getX();
        y = list2.getY();
        z = list2.getZ();
        if(x == 5 && y == 7 && z == 9)
        {
            System.out.println("x = "+x+"\n"+"y = "+y+"\n"+"z = "+z);
        }
        else if(x != 5)
        {
            System.out.println("x计算错误！");
        }
        else if(y != 7)
        {
            System.out.println("y计算错误！");
        }
        else if(z != 9)
        {
            System.out.println("z计算错误！");
        }

    }

    public void testscalarMultiply() {
        MyList list = new MyList(2.0,3.0,4.0);
        list = list.scalarMultiply(2.0);
        double x,y,z;
        x = list.getX();
        y = list.getY();
        z = list.getZ();
        if(x == 4 && y == 6 && z == 8)
        {
            System.out.println("x = "+x+"\n"+"y = "+y+"\n"+"z = "+z);
        }
        else if(x != 4)
        {
            System.out.println("x计算错误！");
        }
        else if(y != 6)
        {
            System.out.println("y计算错误！");
        }
        else if(z != 8)
        {
            System.out.println("z计算错误！");
        }
    }
}
