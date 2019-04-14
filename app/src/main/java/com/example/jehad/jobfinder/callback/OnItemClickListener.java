package com.example.jehad.jobfinder.callback;

import android.view.View;

public interface OnItemClickListener<T> {
    void onClick(View view, int position, T t);
}
