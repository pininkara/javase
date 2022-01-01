// 2021/12/30 16:20

package com.pininkara.proxy;

import lombok.AllArgsConstructor;

public class staticProxy {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("我爱你")).start();

        new WeddingCompany(new You()).HappyMarry();

        You you=new You();

        WeddingCompany weddingCompany=new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

//真实角色
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("You来结婚");
    }
}

//代理角色
@AllArgsConstructor
class WeddingCompany implements Marry {

    private Marry target;

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这个就是真实对象
        after();
    }

    private void before() {
        System.out.println("结婚后，收拾现场");
    }

    private void after() {
        System.out.println("结婚前，布置现场");
    }
}
