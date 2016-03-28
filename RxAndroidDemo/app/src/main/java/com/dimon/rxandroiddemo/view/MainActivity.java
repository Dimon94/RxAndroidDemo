package com.dimon.rxandroiddemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.dimon.rxandroiddemo.R;
import com.dimon.rxandroiddemo.db.Subject;
import com.dimon.rxandroiddemo.network.HttpMethods;
import com.dimon.rxandroiddemo.network.MovieService;
import com.dimon.rxandroiddemo.subscribers.ProgressSubscriber;
import com.dimon.rxandroiddemo.subscribers.SubscriberOnNextListener;

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

    private MovieService movieService;
    private Subscriber subscriber;
    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subjects) {
                resultTV.setText(subjects.toString());
            }
        };
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie() {
        HttpMethods.getInstance().getTopMovie(
                new ProgressSubscriber(getTopMovieOnNext, MainActivity.this),
                0, 10);
    }
}
