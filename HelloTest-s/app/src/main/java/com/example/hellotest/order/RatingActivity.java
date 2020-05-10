package com.example.hellotest.order;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.hellotest.R;
import com.example.hellotest.utils.Rating;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.util.ArrayList;

public class RatingActivity extends Activity {
    private ImageView curentIv,iv1, iv2, iv3;
    private ArrayList<String> imgUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        iv1 = (ImageView) findViewById(R.id.rating_iv1);
        iv2 = (ImageView) findViewById(R.id.rating_iv2);
        iv3 = (ImageView) findViewById(R.id.rating_iv3);
        Listener();
    }

    private void Listener() {
        setLisiner(iv1);
        setLisiner(iv2);
        setLisiner(iv3);
    }

    private void setLisiner(final ImageView iv) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curentIv=iv;
                File file = new File("/storage/emulated/0/PictureSelector.temp.jpg");
                if (file.exists()){
                    file.delete();
                }
                PictureSelector
                        .create(RatingActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                Log.e("asd",picturePath);
                Glide.with(RatingActivity.this).load(picturePath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(curentIv);
            }
        }
    }


    public void ok_ratin(View view) {
        Rating.length=1;
        Intent rating = new Intent("RATING");
        RatingActivity.this.sendBroadcast(rating);
    }
}
