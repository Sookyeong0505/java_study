package thread;

import javax.swing.JOptionPane;

class Ex13_3 {
    static boolean autoSave = false;
    public static void main(String[] args) {
        Runnable r = new ThreadEX();
        Thread t = new Thread(r);
        t.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.printf("입력하신 값은 %s 입니다.\n", input);
    
    
    }

}


class ThreadEX implements Runnable {
    @Override
    public void run() {
        for (int i=10; i>0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
        
    } // run()
}
