package com.cui.mrr.view;


public interface BaseContract {

    interface BaseView {

        /**
         * 程序错误返回
         *
         * @param error
         */
        void refreshError(String error);

    }

    interface BasePresenter {
    }
}
