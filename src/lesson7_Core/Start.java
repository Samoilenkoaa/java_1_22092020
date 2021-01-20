package lesson7_Core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Start {
    public static void main(String[] args) {
        start(MyTest.class);
    }

    public static void start(Class testClass) {
        Method[] array = testClass.getMethods();
        Method before = null;
        Method after = null;
        ArrayList<Method> testMethods = new ArrayList<>();
        boolean haveBefore = false;
        boolean haveAfter = false;
        for (Method x : array) {
            if (x.getAnnotation(BeforeSuite.class) != null) {
                if(haveBefore)
                throw new RuntimeException();
                before = x;
                haveBefore = true;
                continue;
            }
            if (x.getAnnotation(AfterSuite.class) != null) {
                if(haveAfter)
                    throw new RuntimeException();
                after = x;
                haveAfter = true;
                continue;
            }
            if (x.getAnnotation(Test.class) != null) {
                testMethods.add(x);
            }
        }
        testMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).prioritet() - o1.getAnnotation(Test.class).prioritet());
        try {
            Object object = testClass.newInstance();
            if(before != null) before.invoke(object);
            for(Method x : testMethods) x.invoke(object);
            if(after != null) after.invoke(object);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

