package com.example.jehad.jobfinder.ui.main.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.example.jehad.jobfinder.base.BaseRecyclerViewAdapter;
import com.example.jehad.jobfinder.base.BaseViewHolder;
import com.example.jehad.jobfinder.data.model.job.BaseJob;
import com.example.jehad.jobfinder.data.model.provider.BaseProvider;
import com.example.jehad.jobfinder.data.rest.base.ProviderStrategies;
import com.example.jehad.jobfinder.callback.OnItemClickListener;
import com.example.jehad.jobfinder.ui.main.viewholder.GitHubViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * THe responsible Adapter on {@link android.support.v7.widget.RecyclerView} of Jobs List
 */
public class JobsAdapter extends BaseRecyclerViewAdapter {

    private OnItemClickListener onItemClickListener;

    public JobsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Using reflection API here to create a new instance dynamically
     * No problem about the slowing of Reflection API because the {@link #onCreateViewHolder(ViewGroup, int)} will implement a few times
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseProvider baseProvider = ProviderStrategies.getProvider(ProviderStrategies.ProviderType.values()[viewType]);
        try {
            Constructor<?> constructor = baseProvider.getBaseViewHolder().getConstructor(ViewGroup.class, OnItemClickListener.class);
            return (BaseViewHolder) constructor.newInstance(parent, onItemClickListener);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new GitHubViewHolder(parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(objectList.get(position));
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return ((BaseJob) objectList.get(position)).getProviderType().ordinal();
    }
}
