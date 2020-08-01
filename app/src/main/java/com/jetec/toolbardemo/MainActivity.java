package com.jetec.toolbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
    }
    private void setToolbar() {
        /**初始化Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        /**將Toolbar綁定到setSupportActionBar*/
        setSupportActionBar(toolbar);
        /**設置大標題*/
        getSupportActionBar().setTitle("主標題");
        /**設置大標題字體顏色*/
        toolbar.setTitleTextColor(Color.WHITE);
        /**設置副標題*/
        toolbar.setSubtitle("副標題");
        /**設置副標題字體顏色*/
        toolbar.setSubtitleTextColor(Color.WHITE);
        /**設置標題前方的Icon圖樣*/
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_ios_24));
        /**設置前方Icon與Title之距離為0(預設的很遠...)*/
        toolbar.setContentInsetStartWithNavigation(0);

        /**設置Icon圖樣的點擊事件*/
        toolbar.setNavigationOnClickListener(v->{
            Toast.makeText(this, "結束", Toast.LENGTH_SHORT).show();
        });
//        toolbar.inflateMenu(請自己在menu設置一個xml檔案);
//        如果想使用xml Layout檔案，請去建一個吧～

    }
    /**使選項內Icon與文字並存*/
    private CharSequence menuIconWithText(Drawable r, String title) {
        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
    /**程式中新增MenuItem選項*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**itemId為稍後判斷點擊事件要用的*/
        menu.add(0,0,0,"第一選項");
        menu.add(0,1,1,"第二選項");
        menu.add(0,2,2,"第三選項");
        menu.add(0,3,3,menuIconWithText(getDrawable(R.drawable.ic_baseline_star_24),"帶ICON選項"));
        /**setShowAsAction預設為NEVER
         *MenuItem.SHOW_AS_ACTION_IF_ROOM 為如果Toolbar內還有空間，便會將這個item放到Toolbar內*/
        menu.add(0,4,4,"外部選項").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }
    /**此處為設置點擊事件*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /**取得Item的ItemId，判斷點擊到哪個元件*/
        switch (item.getItemId()){
            case 0:
                Toast.makeText(this, "選一", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "選二", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "選三", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "選帶ICON的Item", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "選在外面的", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}