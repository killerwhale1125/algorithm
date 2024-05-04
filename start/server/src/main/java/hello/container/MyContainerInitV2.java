package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

// 아래 어노테이션을 통하여 Set<Class<?>> c에 AppInit 의 구현체가 딸려옴
@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {
    // ServletContainerInitializer를 구현하게 되면 서블릿 컨테이너가 초기화 될 때 호출된다.
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("MyContainerInitV2.c" + c);
        System.out.println("MyContainerInitV2.ctx" + ctx);

        for (Class<?> appInitClass : c) {
            try {
                // new AppInitV1Servlet() 와 같은 코드이다.
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                appInit.onStartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
