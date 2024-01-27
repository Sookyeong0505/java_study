package thread;

public class Ex13_2 {
    static long startTime = 0;
    public static void main(String[] args) {
        
        ThreadEx11_1 t1 = new ThreadEx11_1();
        Runnable r = new ThreadEx11_2();
        Thread t2 = new Thread(r) ;

        t1.start();
        t2.start();
        startTime= System.currentTimeMillis();

        try {
            t1.join(); // main 스레드가 t1의 작업이 끝날 때까지 기다린다.
            t2.join();
        } catch (Exception e) {}
        
        System.out.println("소요시간: " + (System.currentTimeMillis() - startTime));
    }

}
class ThreadEx11_1 extends Thread {
    public void run() {
        for (int i=0; i<300; i++) {
            System.out.printf("%s", new String("-"));
        }
    }
}

class ThreadEx11_2 implements Runnable {
    public void run() { 
        for (int i=0; i<300; i++) {
            System.out.printf("%s", new String("|"));
        }
    }
}
