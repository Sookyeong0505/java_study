package thread;

// 데몬 스레드
public class Ex13_4 implements Runnable{
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new Ex13_4());
        t.setDaemon(true);
        t.start();

        for (int i=1; i<=10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);

            // 5초부터 자동 저장 시작
            if(i==5) autoSave = true;
        }

        System.out.println("프로그램을 종료합니다.");

    }

    // 데몬스레드의 run()
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3*1000); // 3초마다
            } catch (InterruptedException e) {}

        // autoSave의 값이 true이면 autoSave() 호출
        if(autoSave) autoSave();
        }
    }
    
    public void autoSave(){
        System.out.println("작업파일이 저장되었습니다.");
    }
}
