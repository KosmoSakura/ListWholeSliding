package cos.mos.listwholesliding;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CuoWo(View view) {
        showDialog();
    }

    private BottomSheetDialog diaBottom;

    private void showDialog() {
        if (diaBottom == null) {
            View view = View.inflate(this, R.layout.lay_dia, null);
            diaBottom = new BottomSheetDialog(this, R.style.TransparentBottomSheetStyle);
            final ListView listView = view.findViewById(R.id.iamlist);
            IAmAdapter adapter = new IAmAdapter(this,
                1, 2, 1, 3, 5, 4, 6, 7, 89, 45, 56, 13, 47, 563, 12, 21, 2, 1, 3, 5, 4, 6, 7, 89, 45, 56, 13, 47, 563, 12,
                1, 2, 1, 3, 5, 4, 6, 7, 89, 45, 56, 13, 47, 563, 12, 221, 2, 1, 3, 5, 4, 6, 7, 89, 45, 56, 13, 47, 563, 12, 2);
            listView.setAdapter(adapter);
            diaBottom.setContentView(view);
            listView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (listView.canScrollVertically(-1)) {
                        listView.requestDisallowInterceptTouchEvent(true);
                    } else {
                        listView.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
            });
        }
        if (diaBottom.isShowing()) {
            diaBottom.hide();
        } else {
            diaBottom.show();
        }
    }
}
