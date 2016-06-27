package com.example.andrearodriguez.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.andrearodriguez.bucketdrops.R;
import com.example.andrearodriguez.bucketdrops.beans.Drops;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by andrearodriguez on 6/21/16.
 */
public class AdapterDrops extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SwipeListener{

    public static final int ITEM = 0;
    public static final int FOOTER = 1;

    private LayoutInflater mInflater;
    private RealmResults<Drops> mResults;

    private AddListener mAddListener;

    private Realm mRealm;


    public AdapterDrops (Context context, Realm realm, RealmResults<Drops> results){
        mInflater = LayoutInflater.from(context);
        mRealm = realm;
        update(results);
    }

    public  void setAddListener (AddListener listener){
        mAddListener = listener;
    }

    public void update(RealmResults<Drops> results) {
        mResults = results;
        notifyDataSetChanged();
    }

//    public static ArrayList<String > generateValues(){
//        ArrayList<String> dummyValues = new ArrayList<>();
//        for (int i = 1; i<101; i++){
//            dummyValues.add("Item" + i);
//        }
//        return dummyValues;
//    }


    @Override
    public int getItemViewType(int position) {
        if(mResults==null || position<mResults.size()){
            return ITEM;
        }else{
            return FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==FOOTER){
            View view = mInflater.inflate(R.layout.footer, parent, false);
            return new FooterHolder(view, mAddListener);

        }else {
            View view = mInflater.inflate(R.layout.row_drops, parent, false);
            return new DropHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DropHolder) {
            DropHolder dropHolder = (DropHolder) holder;
            Drops drops = mResults.get(position);
            dropHolder.mTextWhat.setText(drops.getWhat());
        }
    }

    @Override
    public int getItemCount() {
        if(mResults == null || mResults.isEmpty()){
            return 0;
        }
        return mResults.size() + 1;
    }

    @Override
    public void onSwipe(int position) {
        if(position < mResults.size()) {
            mRealm.beginTransaction();
            mResults.get(position).deleteFromRealm();
            mRealm.commitTransaction();
            notifyItemRemoved(position);
        }
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        TextView mTextWhat;

        public DropHolder(View itemView) {

            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
    public static class FooterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button mBtnAdd;
        AddListener mListener;

        public FooterHolder(View itemView) {

            super(itemView);
            mBtnAdd = (Button) itemView.findViewById(R.id.btn_footer);
            mBtnAdd.setOnClickListener(this);
        }

        public FooterHolder(View itemView, AddListener listener) {

            super(itemView);
            mBtnAdd = (Button) itemView.findViewById(R.id.btn_footer);
            mBtnAdd.setOnClickListener(this);
            mListener = listener;
        }

        @Override
        public void onClick(View v) {
            mListener.add();
        }
    }
}
