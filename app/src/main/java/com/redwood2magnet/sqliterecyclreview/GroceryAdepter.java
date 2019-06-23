package com.redwood2magnet.sqliterecyclreview;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GroceryAdepter extends RecyclerView.Adapter <GroceryAdepter.GroceryViewHolder>{
    private Context mContext;
    private Cursor mCursor;

    public GroceryAdepter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView countText;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText= itemView.findViewById(R.id.textview_name_item);
            countText=itemView.findViewById(R.id.textview_amount_item);
        }
    }


    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view =inflater.inflate(R.layout.grocery_item,viewGroup,false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder groceryViewHolder, int position) {
        if (!mCursor.moveToPosition(position)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_AMOUNT));
        long id = mCursor.getLong(mCursor.getColumnIndex(GroceryContract.GroceryEntry._ID));

        groceryViewHolder.nameText.setText(name);
        groceryViewHolder.countText.setText(String.valueOf(amount));
        groceryViewHolder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        if(mCursor==null){
            return 0;
        }else {
            return mCursor.getCount();
        }

    }
    public  void  swapCursor(Cursor newCursor){
        if (mCursor !=null){
            mCursor.close();
        }
        mCursor = newCursor;

        if(newCursor !=null){
            notifyDataSetChanged();
        }
    }
}
