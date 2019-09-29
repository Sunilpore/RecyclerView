package com.customgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    RecyclerView rv;
    ArrayList<String> imgListName;
    CustomGridAdapter mAdapter;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        imgListName = new ArrayList<>();

        setDummyData();


        rv = findViewById(R.id.item_recy_vw);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        rv.setLayoutManager(gridLayoutManager);


        ViewTreeObserver observer = rv.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                //Here we use status as buffer to avoid continous call of recyclerview adapter and recreating its view again
                //Here we can also check recyclerviewHeight. So when actual size change then only it recreating view
                if(!status){


                    //It decide the how many item need to display inside recyclerview
                    //Here we dusplay 2 rows at a time and fix 2.1 for screen adjustment
                    double ROW_COUNT = 2.1;

                    int headerLayoutHeight= (int) (rv.getHeight()/ROW_COUNT);
                    Log.d("lay_ht_tag","rv_height "+rv.getHeight()+" \t new _height:"+headerLayoutHeight);
                    mAdapter = new CustomGridAdapter(mContext,imgListName, headerLayoutHeight);
                    rv.setAdapter(mAdapter);
                    status = !status;
                }

            }
        });

       /* mAdapter = new CustomGridAdapter(mContext,imgListName, 30);
        rv.setAdapter(mAdapter);*/

    }

    private void setDummyData() {

        imgListName.add("ONE");
        imgListName.add("TWO");
        imgListName.add("THREE");
        imgListName.add("FOUR");
        imgListName.add("FIVE");
        imgListName.add("SIX");
        imgListName.add("SEVEN");
        imgListName.add("EIGHT");
    }


}
