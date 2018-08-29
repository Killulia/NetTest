package com.bksx.nettest.interfaces;

public interface DownloadListener {
    void onStart();
    void onProgress(int currentLength);
    void onFinish();
    void onFailure();
}
