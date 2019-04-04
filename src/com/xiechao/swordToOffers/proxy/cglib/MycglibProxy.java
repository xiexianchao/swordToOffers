package com.xiechao.swordToOffers.proxy.cglib;

import com.xiechao.swordToOffers.proxy.jdk.MyjdkProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName MycglibProxt
 * @Author xiechao
 * @Date 2019/3/31
 * @Time 12:08
 * @Description TODO
 */
public class MycglibProxy {
    static class Hello{
        public void sayHello(){
            System.out.println(" im am target method");
        }
        public void sayFly(){System.out.println("i am flying");}
    }
    static class HelloMethodIntercetor implements MethodInterceptor {
        private Hello hello;

        public HelloMethodIntercetor(Hello hello) {
            this.hello = hello;
        }

        //o 是生成的代理对象，method是拦截到的方法，objects是方法参数，methodProxy是生成的代理方法
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if("sayHello".equals(method.getName())) {
                System.out.println("前置方法");
                Object result = method.invoke(hello, objects);
                System.out.println("后置方法");
                return result;
            }else if("toString".equals(method.getName())){
                System.out.println("拦截到Object()类中的方法");
                Object result = method.invoke(hello, objects);
                System.out.println("拦截到Object()类中的方法");
                return result;
            }
            else{
                return method.invoke(hello,objects);
            }
        }
    }
    public static void main(String...args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);  //设置父类--可以是类或者接口
        enhancer.setCallback(new HelloMethodIntercetor(new Hello())); //设置真正的回调逻辑

        Hello hello = (Hello) enhancer.create(); //创建代理对象
        hello.sayHello();
        hello.sayFly();
        System.out.println(hello.toString());
    }

}
