package thread;

class Ex13_3 implements Runnable {
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread();
        t.setDaemon(true);
        t.start();
    
    
    }

    @Override
    public void run() {
        while (true) {
            try {
                
            } catch (Exception e) {
                
            }
            
        }
    }

}



