package tatastrive.application.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    Development development_frag;
    Design design_frag;
    Markting markting_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //constructor all class

        development_frag = new Development();
        design_frag = new Design();
        markting_frag = new Markting();

        BottomNavigationView nav = findViewById( R.id.nav );
        final FrameLayout content = findViewById(R.id.content_layout);

        change_Fragment( development_frag );

        nav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.development:
                        change_Fragment(development_frag);
                        cusdialog( menuItem.getIcon(), menuItem.getTitle() );
                        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animaion);
                        content.startAnimation(animation);

                        break;
                    case R.id.design:
                        change_Fragment(design_frag);
                        cusdialog( menuItem.getIcon(), menuItem.getTitle() );
                        Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animaion);
                        content.startAnimation(animation1);

                        break;
                    case R.id.markting:
                        change_Fragment(markting_frag);
                        cusdialog( menuItem.getIcon(), menuItem.getTitle() );
                        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animaion);
                        content.startAnimation(animation2);

                        break;
                }
                return false;
            }
        } );
    }

    private void change_Fragment(Fragment development_frag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.content_layout, development_frag );
        fragmentTransaction.commit();
    }

    private void cusdialog(Drawable icon, CharSequence title) {

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setIcon( icon );
        builder.setTitle( title );
        builder.setMessage( "Selected :: " + title );
        builder.setCancelable( false );
        builder.setPositiveButton( "Like", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( context, "Like It!!", Toast.LENGTH_SHORT ).show();
            }
        } );

        builder.setNegativeButton( "Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        } );
        builder.show();
    }
}
