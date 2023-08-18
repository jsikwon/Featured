class MySum implements Runnable {
    int sum;
    public MySum() {
        sum = 0;
    }
//    public void increaseSum() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + " Sum is: " + (++sum));
//    }
    public /*synchronized*/ void increaseSum() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this)
        {
            System.out.println(Thread.currentThread().getName() + " Sum is: " + (++sum));
        }
    }


    @Override
    public void run() {
        increaseSum();
    }
}
    public class SyncSum {

        public static void main(String[] args) {
            MySum myRunnableObject = new MySum();
            for (int i = 0; i < 100; i++) {
                Thread a = new Thread(myRunnableObject);
                a.start();

            }
        }
    }



