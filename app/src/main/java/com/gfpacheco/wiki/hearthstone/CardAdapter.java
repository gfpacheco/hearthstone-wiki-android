package com.gfpacheco.wiki.hearthstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final Card[] mCards;

    public CardAdapter(Context context, Card[] cards) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCards = cards;
    }

    @Override
    public int getCount() {
        return mCards.length;
    }

    @Override
    public Object getItem(int position) {
        return mCards[position];
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

        Card card = mCards[position];

        viewHolder.nameView.setText(card.name);

        return convertView;
    }

    private class CardViewHolder {
        private final TextView nameView;

        public CardViewHolder(View convertView) {
            nameView = (TextView) convertView;
        }
    }
}
