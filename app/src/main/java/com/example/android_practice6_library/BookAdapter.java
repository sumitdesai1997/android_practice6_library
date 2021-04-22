package com.example.android_practice6_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    ArrayList<Book> bookList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public BookAdapter(Context context, ArrayList<Book> bookList){
        this.bookList = bookList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.booklist,null);
            viewHolder = new ViewHolder();

            viewHolder.lvBookAuthor = convertView.findViewById(R.id.lvBookAuthor);
            viewHolder.lvBookTitle = convertView.findViewById(R.id.lvBookTitle);
            viewHolder.lvBookISBN = convertView.findViewById(R.id.lvBookISBN);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.lvBookTitle.setText(bookList.get(position).getTitle());
        viewHolder.lvBookAuthor.setText(bookList.get(position).getAuthor());
        viewHolder.lvBookISBN.setText(String.valueOf(bookList.get(position).getISBN()));

        return convertView;
    }

    private class ViewHolder{
        TextView lvBookTitle;
        TextView lvBookAuthor;
        TextView lvBookISBN;
    }
}
