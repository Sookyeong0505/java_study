package thread;

import javax.swing.JOptionPane;

// interrupt() 예제
// 대기상태인 스레드를 실행대기 상태로 만든다
// state : WAITING -> RUNNABLE
public class Ex13_6 {
    public static void main(String[] args) {
        ThreadTest6 t1 = new ThreadTest6();
        t1.start();
        
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 "+input +"입니다.");
        
        t1.interrupt(); // fasle -> true
        System.out.println("is interrupted: " + t1.isInterrupted());
        // interrupt()를 호출하면 isInterrupted가 true가 된다.
        System.out.println("is interrupted: " + t1.isInterrupted()); // true
    }
}

class ThreadTest6 extends Thread{
    @Override
    public void run() {
        int i = 10;
        System.out.println(isInterrupted()); // false
        while (i !=0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x=0; x<2500000000L; x++) ;
        }
       System.out.print("카운트 종료");
    }

    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}

