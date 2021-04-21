package demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        fare();
        seeHouse();
        heTong();
        host.rent();
    }

    //  看房
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }

    //  收中介费
    public void fare(){
        System.out.println("收中介费");
    }

    //  签合同
    public void heTong(){
        System.out.println("签租赁合同");
    }
}