package drive.app.ken.socialable;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;


public class Welcome extends Activity {

    private GestureDetector mDetector;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = 0;
        setContentView(R.layout.activity_welcome);
        Fragment firstFragment = new WelcomeFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, firstFragment, "Welcome");
        ft.commit();
        Log.i(null, "First fragment");


        mDetector = new GestureDetector(this, new swipeWelcome());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }








    public class swipeWelcome extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {



            if (velocityX<0){
                if (page == 0 ){
                    page =1 ;

                    Fragment secondFragment = getFragmentManager().findFragmentByTag("Welcome2");
                    if (secondFragment ==null)
                        secondFragment = new WelcomeFragment2();
                    FragmentTransaction ft = getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right).replace(R.id.fragment_container, secondFragment, "Welcome2");

                    ft.commit();

                    Log.i(null, "p1");
                }
            }
            else{
                if (page ==1){
                    page =0;
                    Fragment firstFragment = getFragmentManager().findFragmentByTag("Welcome");
                    if (firstFragment ==null)
                        firstFragment = new WelcomeFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left).replace(R.id.fragment_container, firstFragment, "Welcome");

                    ft.commit();


                    Log.i(null,"p0");
                }
            }

            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }
}
