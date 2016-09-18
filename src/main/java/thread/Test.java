package thread;

/**
 * Created by Guoqing on 2016/8/31.
 */
public class Test {

    public int num;

    public static void main(String[] args) {

        final Test t = new Test();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (t) {
                    while (t.num < 3) {
                        System.out.println(Thread.currentThread().getName() + ": " + t.num);
                        t.num++;
                    }

                    t.notifyAll();

                    try {
                        t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    while (t.num < 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + t.num);
                        t.num++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (t) {
                    while (t.num < 7) {
                        System.out.println(Thread.currentThread().getName() + ": " + t.num);
                        t.num++;
                    }

                    t.notifyAll();
                }
            }
        });


        thread1.start();
        thread2.start();
    }
}
