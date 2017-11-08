package toast.chenmh.com.toastdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private Button toast1,toast2,toast3,toast4,toast5;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toast1 = (Button) findViewById(R.id.toast1);
        toast2 = (Button) findViewById(R.id.toast2);
        toast3 = (Button) findViewById(R.id.toast3);
        toast4 = (Button) findViewById(R.id.toast4);
        toast5 = (Button) findViewById(R.id.toast5);
        //监听
        toast1.setOnClickListener(new onButtonClick());
        toast2.setOnClickListener(new onButtonClick());
        toast3.setOnClickListener(new onButtonClick());
        toast4.setOnClickListener(new onButtonClick());
        toast5.setOnClickListener(new onButtonClick());
    }
    private class onButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.toast1:
                    Toast.makeText(ToastActivity.this,"原始的Toast",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.toast2:
                    toast = Toast.makeText(ToastActivity.this,"不同位置的Toast",Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER,0,0);//我以弹出中间位置为例
                    toast.setGravity(Gravity.TOP,0,0);//顶部
                    toast.show();//千万别完了show()
                    break;
                case R.id.toast3:
                    //自定义的Toast
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.toast, null);//可以根据view来获取布局中的控件
                    toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.setDuration(Toast.LENGTH_LONG);//显示的时间，稍微长一点
                    toast.setView(view);//把布局添加到Toast上
                    toast.show();
                    break;
                case R.id.toast4:
                    toast = Toast.makeText(getApplicationContext(),"带图的Toast",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0,0);
                    LinearLayout layout=(LinearLayout)toast.getView();//自定义布局
                    ImageView img = new ImageView(getApplicationContext());
                    img.setImageResource(R.mipmap.t01b4091d34c27cd791);//添加图片
                    layout.addView(img,0);
                    toast.show();
                    break;
                case R.id.toast5:
                    LayoutInflater layoutInflater = getLayoutInflater();
                    View inflate = layoutInflater.inflate(R.layout.toast, null);
                    //自定义AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(ToastActivity.this);
                    builder.setView(inflate);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
            }
        }
    }
}
