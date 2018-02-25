package com.example.android.KARINA_1202150277_MODUL3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;  // //Link list adalah desain tempat penyimpanan data yang terdiri dari node-node (simpul-simpul) yang saling terhubung. Link list dapat diilustrasikan seperti kereta api,
// dimana kereta api terdiri dari gerbong-gerbong yang saling terhubung yang dapat mengangkut penumpang.

public class ListAdapter extends
    RecyclerView.Adapter<ListAdapter.WordViewHolder>   {

    private final LinkedList<String> mTitleList;
    private final LinkedList<String> mSubTitleList;
    private final LinkedList<Integer> mBackgroundList;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, LinkedList<String> TitleList, LinkedList<String> SubTitleList, LinkedList<Integer> BackgroundList) {
        //jembatan yang menyediakan akses ke item data
        mInflater = LayoutInflater.from(context);
        this.mTitleList = TitleList;
        this.mSubTitleList = SubTitleList;
        this.mBackgroundList = BackgroundList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //membuat view baru
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) { //mengambil elemen dari dataset pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        final String mCurrentTitle = mTitleList.get(position);
        final String mCurrentSubTitle = mSubTitleList.get(position);
        final Integer mCurrentBackground = mBackgroundList.get(position);
        holder.titleItemView.setText(mCurrentTitle);
        holder.subtitleItemView.setText(mCurrentSubTitle);
        holder.linearLayout.setBackgroundResource(mCurrentBackground);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Detail.class);
                intent.putExtra("Title",mCurrentTitle);
                intent.putExtra("Background",mCurrentBackground);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder { //menjelaskan tampilan data dan metadata tentang tempatnya dalam RecyclerView.
        public final TextView titleItemView, subtitleItemView; //Setiap view holder menampung satu rangkaian data.
        public final LinearLayout linearLayout;                 //Adapter menambahkan data ke view holder untuk ditampilkan oleh pengelola layout.
        final ListAdapter mAdapter;
        public WordViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            titleItemView = (TextView) itemView.findViewById(R.id.title);
            subtitleItemView = (TextView) itemView.findViewById(R.id.subTitle);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.listBackground);
            this.mAdapter = adapter;
        }
    }
}
