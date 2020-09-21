package com.lxf.jdk.foundation.generic;

/**
 * 泛型方法二
 */
public class GenericMethod2 {
    static class Animal{
        @Override
        public String toString() {
            return "Animal{}";
        }
    }
    static class Dog extends Animal{
        @Override
        public String toString() {
            return "Dog{}";
        }
    }
    static class Fruit{
        @Override
        public String toString() {
            return "Fruit{}";
        }
    }

    static class GenericClass<T>{
        /**
         * 并不是泛型方法，属于泛型类的普通方法
         * @param t
         */
        public void show01(T t){
            System.out.println(t.toString());
        }

        /**
         * 泛型方法
         * @param t
         * @param <T>
         */
        public <T> void show02(T t){
            System.out.println(t.toString());
        }

        /**
         * 泛型方法
         * @param k
         * @param <K>
         */
        public <K> void show03(K k){
            System.out.println(k.toString());
        }
    }


    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Fruit fruit = new Fruit();

        //泛型类在初始化时，限定了参数类型
        GenericClass<Animal> genericClass = new GenericClass<>();
        genericClass.show01(animal);
        genericClass.show01(dog);
//        genericClass.show01(fruit);

        //泛型方法的参数，在使用时指定
        genericClass.show02(animal);
        genericClass.show02(dog);
        genericClass.show02(fruit);
        genericClass.<Animal>show03(animal);
//        genericClass.<Dog>show03(animal);
        genericClass.<Dog>show03(dog);
        genericClass.<Animal>show03(dog);
        genericClass.show03(fruit);

    }

}
