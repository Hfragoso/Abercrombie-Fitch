package com.example.heber.abercrombiefitch.mainscreen;

import com.example.heber.abercrombiefitch.data.PromotionList;

import java.util.List;

public interface MainScreenContract {
    interface View {
        void showPosts(List<PromotionList> promos);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}