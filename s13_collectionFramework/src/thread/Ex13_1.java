package thread;

/**
 * Ex13_1
 */
public class Ex13_1 {
    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

        t1.start();
        t2.start();

    }
    
}

/**
 * 방법 1. Thread 클래스를 상속해서 구현
 */
class ThreadEx1_1 extends Thread {
    // 내부에 스레드가 실행할 작업 작성
    public void run() {
        for(int i=0; i <500; i++){
            // System.out.println(this.getName());// 조상인 쓰레드의 getName()을 호출
            System.out.println(0);// 조상인 쓰레드의 getName()을 호출
        }
    }
}

/**
 * 방법 2. Runnable 인터페이스를 구현
 */
class ThreadEx1_2 implements Runnable {
    // 내부에 스레드가 실행할 작업 작성
    public void run() { 
        for(int i=0; i<500; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread 반환
            // System.out.println(Thread.currentThread().getName());
            System.out.println(1);
        }
    }
}