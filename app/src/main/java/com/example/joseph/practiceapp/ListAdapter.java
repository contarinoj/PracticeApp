package com.example.joseph.practiceapp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joseph on 2015-09-27.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TestViewHolder>{
    private LayoutInflater inflater;
    private List<Object> list;

    public ListAdapter(Activity activity, List<Object> list){
        inflater = activity.getLayoutInflater();
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(TestViewHolder viewHolder, int i) {
        viewHolder.setContent(list.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        Object thing = list.get(position);
        if( thing instanceof String)
            return R.layout.list_item;
        return R.layout.error_item;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TestViewHolder holder;
        if(i == R.layout.list_item)
            holder = new StringViewHolder(inflater.inflate(i, viewGroup, false));
        else holder = new ErrorViewHolder(inflater.inflate(i, viewGroup, false));
        return holder;
    }

    public abstract class TestViewHolder <T> extends RecyclerView.ViewHolder{
        public TestViewHolder(View itemView)
        {
            super(itemView);
        }

        abstract void setContent(T content);

    }

    public class StringViewHolder extends TestViewHolder<String>{
        private TextView textView;

        public StringViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void setContent(String str){
            textView.setText(str);
        }
    }

    public class ErrorViewHolder extends TestViewHolder<Object>{

        public ErrorViewHolder(View itemView) {
            super(itemView);
        }

        public void setContent(Object whatever){
        }
    }
}
