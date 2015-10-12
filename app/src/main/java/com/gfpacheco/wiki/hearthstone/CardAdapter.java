package com.gfpacheco.wiki.hearthstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<Card> mCards;

    public CardAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Card> data) {
        mCards = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCards == null ? 0 : mCards.size();
    }

    @Override
    public Card getItem(int position) {
        return mCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_card, parent, false);
            viewHolder = new CardViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder) convertView.getTag();
        }

        Card card = getItem(position);

        Picasso.with(mContext).load(card.img).into(viewHolder.imageViewView);
        viewHolder.nameView.setText(card.name);

        return convertView;
    }

    private class CardViewHolder {
        private final ImageView imageViewView;
        private final TextView nameView;

        public CardViewHolder(View convertView) {
            imageViewView = (ImageView) convertView.findViewById(R.id.image_view_cover);
            nameView = (TextView) convertView.findViewById(R.id.text_view_name);
        }
    }
}
