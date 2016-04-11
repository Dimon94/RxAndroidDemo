package com.dimon.rxandroiddemo.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dimon.rxandroiddemo.R;
import com.dimon.rxandroiddemo.network.GanwuService;
import com.dimon.rxandroiddemo.network.HttpMethods;
import com.dimon.rxandroiddemo.db.entity.Item;
import com.dimon.rxandroiddemo.subscribers.ProgressSubscriber;
import com.dimon.rxandroiddemo.subscribers.SubscriberOnNextListener;
import com.socks.library.KLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.fabBtn)
    FloatingActionButton mFabBtn;
    @Bind(R.id.rv)
    RecyclerView mRecyclerView;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;
    private GanwuService ganwuService;
    private Subscriber subscriber;
    private SubscriberOnNextListener getGanWuOnNext;
    private LinearLayoutManager linearLayoutManager;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //设置Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("RxAndroid");

        mFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "开始下载", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getGanWu();
                            }
                        })
                        .show();
            }
        });

        getGanWuOnNext = new SubscriberOnNextListener<List<Item>>() {
            @Override
            public void onNext(List<Item> subjects) {
                KLog.a("onNext里面" + subjects);
//                resultTV.setText(subjects.toString());
                linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setHasFixedSize(true);
                mAdapter = new MainAdapter(subjects, MainActivity.this);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(mAdapter);
            }
        };
    }


    //进行网络请求
    private void getGanWu() {
        HttpMethods.getInstance().getGanWu(
                new ProgressSubscriber(getGanWuOnNext, MainActivity.this));
    }
}
