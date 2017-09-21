package com.example.heber.abercrombiefitch.mainscreen;

import com.example.heber.abercrombiefitch.data.PromotionList;
import com.example.heber.abercrombiefitch.mainscreen.MainScreenContract;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainScreenPresenter implements MainScreenContract.Presenter {

    Retrofit retrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPromoList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<PromotionList>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<PromotionList> posts) {
                        mView.showPosts(posts);
                    }
                });
    }

    private interface PostService {
        @GET("/codeTest_exploreData.json")
        Observable<List<PromotionList>> getPromoList();
    }
}