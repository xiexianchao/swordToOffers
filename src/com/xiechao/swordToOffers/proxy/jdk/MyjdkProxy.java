package com.xiechao.swordToOffers.proxy.jdk;

import java.lang.reflect.*;

/**
 * @ClassName MyjdkProxy
 * @Author xiechao
 * @Date 2019/3/31
 * @Time 11:19
 * @Description TODO
 */
public class MyjdkProxy {
    public interface IHello{
        void sayHello();
        void paly();
    }
    static class Hello implements IHello{
        @Override
        public void sayHello() {
            System.out.println("i am target method.");
        }

        @Override
        public void paly() {
            System.out.println("wo paly");
        }
    }
    static class ProxyInvocationHandler implements InvocationHandler{
        private Object object;
        public ProxyInvocationHandler(Object object){
            this.object = object;
        }
        //proxy就是代理对象，method是
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if("sayHello".equals(method.getName())) {
                System.out.println("前置通知");
                Object result = method.invoke(object, args);
                System.out.println("后置通知");
                System.out.println("我想看看你是个什么东西啊 ：" + proxy.getClass().getName());
                return result;
            }else if("toString".equals(method.getName())) {
                System.out.println("拦截到toString()方法");
                Object result = method.invoke(object, args);
               // System.out.println("后置通知");
               // System.out.println("我想看看你是个什么东西啊 ：" + proxy.getClass().getName());
                return result;
            } else{
                return method.invoke(object,args);
            }
        }
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

     /*   Class proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        IHello hello = (IHello)constructor.newInstance(new ProxyInvocationHandler(new Hello()));
        hello.sayHello();*/
        IHello hello = (IHello)Proxy.newProxyInstance(IHello.class.getClassLoader(),new Class[]{IHello.class},
                new ProxyInvocationHandler(new Hello()));
        hello.sayHello();
        hello.paly();
        System.out.println(hello.toString());
    }



}
