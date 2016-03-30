package com.dimon.rxandroiddemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.dimon.rxandroiddemo.R;
import com.dimon.rxandroiddemo.network.GanwuService;
import com.dimon.rxandroiddemo.network.HttpMethods;
import com.dimon.rxandroiddemo.network.Item;
import com.dimon.rxandroiddemo.subscribers.ProgressSubscriber;
import com.dimon.rxandroiddemo.subscribers.SubscriberOnNextListener;
import com.socks.library.KLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    private GanwuService ganwuService;
    private Subscriber subscriber;
    private SubscriberOnNextListener getGanWuOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getGanWuOnNext = new SubscriberOnNextListener<List<Item>>() {
            @Override
            public void onNext(List<Item> subjects) {
                KLog.a("onNext里面");
                resultTV.setText(subjects.toString());
            }
        };
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getGanWu();
    }

    //进行网络请求
    private void getGanWu() {
        HttpMethods.getInstance().getGanWu(
                new ProgressSubscriber(getGanWuOnNext, MainActivity.this));
    }
}
