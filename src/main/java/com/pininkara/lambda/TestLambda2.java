// 2021/12/31 14:44

package com.pininkara.lambda;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love;

        /*
        //1.lambda表达式简化
        love=(int a)->{
            System.out.println("I love you-->"+a);
        };

        //简化1.参数类型
        love=(a)->{
            System.out.println("I love you-->"+a);
        };
        */

        //简化2.简化括号
        love = a -> System.out.println("I love you-->" + a);


        love.love(520);
    }
}

interface ILove {
    void love(int a);
}
