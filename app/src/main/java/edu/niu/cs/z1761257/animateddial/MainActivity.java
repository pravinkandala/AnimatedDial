package edu.niu.cs.z1761257.animateddial;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private Thread animationThread;
    private DialView dialView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create DialView object
        dialView = new DialView(this);
        setContentView(dialView);

        animationThread = new Thread(runningAnimation);
        animationThread.start();
    }//end of onCreate

    private Runnable runningAnimation = new Runnable() {

        private static final int DELAY = 200;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//end of while
        }//end of run
    };//end of runningAnimation runnable

    private Handler threadHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                  //  super.handleMessage(msg);
                dialView.update();
                }
            };

            @Override
            protected void onPause()
            {
                super.onPause();
                threadHandler.removeCallbacks(runningAnimation);

            }


}//end of MainActivity
