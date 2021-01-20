package lesson7_Core;

public class MyTest {

    @BeforeSuite
     public void before() {
        System.out.println("Это метод Before");
    }

    @Test(prioritet = 10)
    public void test1()  {
        System.out.println("Это метод test1");
    }

    @Test(prioritet = 1)
    public void test2() {
        System.out.println("Это метод test2");
    }

    @Test
    public void test3() {
        System.out.println("Это метод test3");
    }

    @AfterSuite
    public void after() {
        System.out.println("Это метод After");
    }

}
