package com.example.jehad.jobfinder.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * The super class for every instance of{@link RecyclerView.Adapter} so every activity should be extend from {@link BaseActivity}
 */
public abstract class BaseRecyclerViewAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> objectList = new ArrayList<>();
    protected RecyclerView recyclerView;


    /**
     * Update the list by adding a new items
     *
     * @param objectList
     */
    public void updateList(List<T> objectList) {
        if (!objectList.isEmpty()) {
            this.objectList.addAll(objectList);
            notifyDataSetChanged();
        }
    }

    /**
     * Update the list with a range
     *
     * @param objectList
     */
    public void updateRangeList(ArrayList<T> objectList) {
        if (!objectList.isEmpty()) {
            this.objectList.addAll(objectList);
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    /**
     * Clear the list
     */
    public void clearList() {
        objectList.clear();
        notifyDataSetChanged();
    }


    /**
     * Add one item
     */
    public void addItem(T t) {
        objectList.add(t);
        notifyItemInserted(objectList.indexOf(t));
    }

    /**
     * Replace the current list with a new one
     */
    public void setItems(ArrayList<T> objectList) {
        this.objectList = objectList;
        notifyDataSetChanged();
    }

    /**
     * Add item at a specific position
     */
    public void addItemAtPosition(final T object, final int position) {
        if (position >= 0 && position <= getItemCount()) {
            objectList.add(position, object);
            notifyItemInserted(position);
        }
    }

    /**
     * Remove item at a specific position
     */
    public void removeItem(int position) {
        objectList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * get item object at specific position
     */
    public T getItemAtPosition(int position) {
        return objectList.get(position);
    }

    /**
     * get all items of objects
     */
    public List<T> getAllItems() {
        return objectList;
    }

    /**
     * Replace item with a new one at specific position
     */
    public void updateItemPosition(final T object, final int position) {
        if (position >= 0 && position < getItemCount()) {
            objectList.set(position, object);
            notifyItemChanged(position);
        }
    }

    /**
     * Get the {@link RecyclerView}
     */
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    /**
     * Scroll to specific position
     * @param position
     */
    public void scrollSmoothToPosition(int position) {
        recyclerView.smoothScrollToPosition(position);
    }


    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    @Override
    public abstract int getItemCount();


}
