package com.example.jehad.jobfinder.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jehad.jobfinder.callback.OnItemClickListener;

import butterknife.ButterKnife;

/**
 * The super class for every instance of {@link RecyclerView.ViewHolder} so every viewHolder should be extend from {@link BaseActivity}
 * @param <T>
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {


    /**
     * Using {@link ButterKnife} library to bind the view of XMl with its fields
     * @param parent
     * @param layoutRes
     * @param onItemClickListener
     */
    public BaseViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutRes, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
        setListeners(onItemClickListener);
    }

    /**
     * get the context of the view
     * @return
     */
    public Context getContext() {
        return itemView.getContext();
    }

    /**
     * Set Click listener if u need it
     * @param onItemClickListener
     */
    private void setListeners(final OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(v, getAdapterPosition(), getData());
                }
            });
        }
    }

    /**
     * Get the object item
     * @return
     */
    public abstract T getData();

    /**
     * Set the object item
     * @param t
     */
    public abstract void setData(T t);

}
