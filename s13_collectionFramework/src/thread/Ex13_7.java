package thread;

/**
 * suspend() & 
 * 
 */
public class Ex13_7 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("8");
        MyThread t2 = new MyThread("88");
        MyThread t3 = new MyThread("888");
        
        t1.start();;
        t2.start();;
        t3.start();;

        try {
            Thread.sleep(1000);
            t1.suspend();
            Thread.sleep(1000);
            t2.suspend();
            Thread.sleep(1000);
            t1.resume();
            Thread.sleep(1000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        } catch (InterruptedException e) {
        }
        System.out.println("main 스레드 종료");
    }// main

}


class MyThread implements Runnable {
    // volatile: 쉽게 변하는
    // cpu가 계산할 때 항상 램 메모리에서 참조하도록 만드는 변수 
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    MyThread(String name){
        th = new Thread(this, name); // thread(Runnable r, String name)
    }

    void start(){
        th.start();
    }

    void stop(){
        stopped= true;
    }

    void suspend() {
        suspended = true;
    }

    void resume() {
        suspended = false;
    }

    @Override
    public void run() {
        while(!stopped){
            if(!suspended){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
        System.out.println(Thread.currentThread().getName()+"종료!");
    } // run()

    
}
