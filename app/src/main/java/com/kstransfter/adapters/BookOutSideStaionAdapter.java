package com.kstransfter.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kstransfter.R;
import com.kstransfter.interfaces.RvListeners;

import java.util.ArrayList;

public class BookOutSideStaionAdapter extends RecyclerView.Adapter<BookOutSideStaionAdapter.BookHolder> {

    private Context context;
    private ArrayList<String> bookingHistory;
    private LayoutInflater layoutInflater;
    private RvListeners rvListeners;

    public BookOutSideStaionAdapter(Context context, ArrayList<String> bookingHistory, RvListeners rvListeners) {
        this.context = context;
        this.bookingHistory = bookingHistory;
        this.rvListeners = rvListeners;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookHolder(layoutInflater.inflate(R.layout.item_book_out_station, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {

        holder.llItem.setOnClickListener(v -> {

        });

    }

    @Override
    public int getItemCount() {
        return bookingHistory.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {
        private LinearLayout llItem;

        public BookHolder(View view) {
            super(view);
            llItem = view.findViewById(R.id.llItem);
        }
    }


}