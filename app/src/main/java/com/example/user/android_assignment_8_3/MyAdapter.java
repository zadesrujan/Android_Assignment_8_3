package com.example.user.android_assignment_8_3;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by User on 03-01-2018.
 */

class MyAdapter extends BaseAdapter{
    //BaseAdapter:Common base class of common implementation for an Adapter that can be used in both ListView (by implementing
    // the specialized ListAdapter interface) and Spinner (by implementing the specialized SpinnerAdapter interface).

    ArrayList<MyClass>list;
    Context context;
    //Context:Interface to global information about an application environment
    MyAdapter(Context context){
        this.context=context;
        list=new ArrayList<MyClass>();
        Resources res=context.getResources();
        //The Android resource system keeps track of all non-code assets associated with an application.
        //arraylist of images
        int[] images={R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.kitkat,R.drawable.jelly,
                R.drawable.icecream,R.drawable.lollipop};
        //Now putting it in main arraylist using for loop
        for(int i=0;i<6;i++){
            MyClass myClass= new MyClass(images[i]);
            list.add(myClass);
            //creating loop for maintainind the images in order
        }

    }
    @Override
    public int getCount() {
        return list.size();
        //to get list size of the image
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }//to set the position

    @Override
    public long getItemId(int position) {
        return position;
    }//to return the id of the image
    class ViewHolder{
        ImageView myimage;

        ViewHolder(View view){
            myimage= (ImageView) view.findViewById(R.id.image);

        }
    }


    //this method is responsible for creating views
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row= view;
        ViewHolder holder=null;
        //A ViewHolder object stores each of the component views inside the tag field of the Layout, so you can
        // immediately access them without the need to look them up repeatedly.
        if(row==null) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            //Instantiates a layout XML file into its corresponding View objects
            row= inflater.inflate(R.layout.view,parent,false);
            // //inflater.inflate is used to create the view from our xml file
            holder =new ViewHolder(row);
            //here holder will holds the  values in the row
            row.setTag(holder);// store the holder with the view.

        }else{
            // we've just avoided calling findViewById() on resource everytime

            // just use the viewHolder

            holder= (ViewHolder) row.getTag();

        }
        //we get the value of list position
        MyClass temp= list.get(position);
        MyClass temp1=list.get(position);
        //if we want to change image from any place in our code where we do not have context to call getResources() method on it.
        // e.g in Adapters. No need to pass context through constructor just for this funcionality
        holder.myimage.setImageResource(temp.versionImage);

        return row;
    }
}


