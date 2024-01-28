package thread;

public class Ex13_5 {
    public static void main(String[] args) {
        ThreadTest1 t1 = new ThreadTest1();
        ThreadTest2 t2 = new ThreadTest2();
        t1.start();
        t2.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.print("<main 스레드 종료>");
    }
}

class ThreadTest1 extends Thread{
    @Override
    public void run() {
       for (int i=0; i<300; i++){
        System.out.print("-");
       } 
       System.out.print("t1 종료");
    }
}

class ThreadTest2 extends Thread{
    @Override
    public void run() {
       for (int i=0; i<300; i++){
        System.out.print("|");
       } 
       System.out.print("t2 종료");
    }
}
