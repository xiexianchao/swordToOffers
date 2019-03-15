package com.xiechao.swordToOffers.concurrency.threadlocal;

/**
 * @ClassName Test
 * @Author xiechao
 * @Date 2019/3/12
 * @Time 11:58
 * @Description TODO
 */
class User{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class ContentHolder{
    private static ThreadLocal threadLocal = new InheritableThreadLocal();
    static void set(Object object){
        threadLocal.set(object);
    }
   static Object get(){
        return threadLocal.get();
    }
}
public class Test {
    public static void main(String...args) throws InterruptedException {
        ContentHolder.set(new User("xiechao",20));
      //  ContentHolder.set("parent thread");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ContentHolder.get()); //hhhh
                ((User)ContentHolder.get()).setAge(21);
                ((User)ContentHolder.get()).setName("zhangyu");
                //ContentHolder.set("son thread");
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(ContentHolder.get()); //hhh
    }
}
